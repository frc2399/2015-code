import re
import pdb

header_file = 'nvision.h'
output_file = "CustomNIVision.java"


c_types = r'int|Image\s*\*'
c_identifiers = r'[A-Za-z0-9_]'
declaration = re.compile(r'IMAQ_FUNC\s+(?P<return_type>%s)\s+IMAQ_STDCALL\s+(?P<function_name>imaq%s+)\((?P<parameters>[^\)]*)\s*\)\s*;' % (c_types, c_identifiers))
parameter = re.compile(r'(?P<flags>(const)*)?\s*(?P<type>%s)\s+(?P<name>%s+)' % (c_types, c_identifiers))

c_to_java_type = {
    'Image*': 'Pointer',
    'int': 'int',
    'float': 'float'
}

java_type_expanded = {
    'Pointer': '%(name)s.address().toWord().toPrimitive()'
}

with open(header_file, 'r') as f:
    code = """
package edu.wpi.first.wpilibj.templates.commands;

import com.sun.cldc.jna.BlockingFunction;
import com.sun.cldc.jna.NativeLibrary;
import com.sun.cldc.jna.Pointer;
import com.sun.cldc.jna.TaskExecutor;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVision;
import com.sun.cldc.jna.ptr.IntByReference;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class CustomNIVision{
    private static final TaskExecutor taskExecutor = new TaskExecutor("nivision task");
    
    private static final BlockingFunction imaqGetLastErrorFn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqGetLastError");
    static { imaqGetLastErrorFn.setTaskExecutor(taskExecutor); }

    public static int getLastError() {
        return imaqGetLastErrorFn.call0();
    }
    
    protected static void assertCleanStatus(int code) throws NIVisionException {
        if (code == 0) {
            throw new NIVisionException(imaqGetLastErrorFn.call0());
        }
    }
    
    // Additional Functions
    
"""
    
    for line in f:
        line = line.strip()
        if line.startswith('//') or line == "":
            # comment - skip it
            continue
        
        # valid line - process it
        res = declaration.match(line)
        if res is None:
            # invalid line
            print 'Skipping invalid line: %s' % line
            continue
        
        locals().update(res.groupdict()) # explodes matches into local variables
        
        parameters = parameters.split(',')
        
        cur_error = False
        for i in range(len(parameters)):
            res = parameter.match(parameters[i].strip())
            if res is None:
                print 'Found an error with parameter %s in line: %s' % (parameters[i], line)
                cur_error = True
                #pdb.set_trace()
                break
            else:
                parameters[i] = res.groupdict()
            
        if cur_error:
            continue
        
        code += """
    private static final BlockingFunction %(function_name)sFn = NativeLibrary.getDefaultInstance().getBlockingFunction("%(function_name)s");
    static { %(function_name)sFn.setTaskExecutor(taskExecutor); }
    
""" % {'function_name': function_name}
        
        java_function_name = function_name[4].lower() + function_name[5:]
        java_parameters = []
        for p in parameters:
            java_p = {
                'decl': "%s %s" % (c_to_java_type[p['type']], p['name']),
                'pass': p['name']
            }
            if p['type'] in java_type_expanded:
                java_p['pass'] = java_type_expanded[p['type']] % {'name': p['name']}
            java_parameters.append(java_p)
        
        function_name = function_name[0].lower() + function_name[1:]
        code += """
    public static void %(java_function_name)s(%(java_decl_parameters)s)  throws NIVisionException{
        try {
            assertCleanStatus(%(function_name)sFn.call%(num_parameters)d(%(java_pass_parameters)s));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
""" % {'java_function_name': java_function_name,
       'java_decl_parameters': ', '.join(p['decl'] for p in java_parameters),
       'function_name': function_name,
       'num_parameters': len(java_parameters),
       'java_pass_parameters': ', '.join(p['pass'] for p in java_parameters)}
       

code += "}"

print "***"


with open(output_file, 'w') as f:
    f.write(code)
