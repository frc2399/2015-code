/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


/**
 *
 * @author jallen
 * based on https://code.google.com/p/frc2856/source/browse/2012/Robot/ReboundRumbleBot/src/FRC2856/Robot/NewNIVision.java?r=72
 */
public class CustomNIVision{
    private static final TaskExecutor taskExecutor = new TaskExecutor("nivision task");
    
    public CustomNIVision(){
        
    }
    private static final BlockingFunction imaqGetLastErrorFn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqGetLastError");
    static { imaqGetLastErrorFn.setTaskExecutor(taskExecutor);  }

    public static int getLastError(){
        return imaqGetLastErrorFn.call0();
    }
    protected static void assertCleanStatus (int code) throws NIVisionException {
        if (code == 0) {
            throw new NIVisionException(imaqGetLastErrorFn.call0());
        }
    }
    
    //IMAQ_FUNC int IMAQ_STDCALL imaqSubtract(Image* dest, const Image* sourceA, const Image* sourceB);
    private static final BlockingFunction imaqSubtractFn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqSubtract");
    static { imaqSubtractFn.setTaskExecutor(taskExecutor); }

    
    /**
     * Get the subtraction of the two images
     * 
     */
    public static void subtract(Pointer dest, Pointer image1, Pointer image2)  throws NIVisionException{
        try {
            assertCleanStatus(imaqSubtractFn.call3(dest.address().toUWord().toPrimitive(), image1.address().toUWord().toPrimitive(), image2.address().toUWord().toPrimitive()));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //IMAQ_FUNC int   IMAQ_STDCALL imaqDuplicate(Image* dest, const Image* source);
    private static final BlockingFunction imaqDuplicateFn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqDuplicate");
    static { imaqDuplicateFn.setTaskExecutor(taskExecutor); }
    
    public static void duplicate(Pointer dest, Pointer source) throws NIVisionException{
        try {
            assertCleanStatus(imaqDuplicateFn.call2(dest.address().toUWord().toPrimitive(), source.address().toUWord().toPrimitive()));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
    //IMAQ_FUNC int            IMAQ_STDCALL imaqThreshold(Image* dest, const Image* source, float rangeMin, float rangeMax, int useNewValue, float newValue);
    
    private static final BlockingFunction imaqThresholdFn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqThreshold");
    static { imaqThresholdFn.setTaskExecutor(taskExecutor); }

    /**
     * Get the subtraction of the two images
     * 
     */
    public static void threshold(Pointer dest, Pointer source, int rangeMin, int rangeMax)  throws NIVisionException{
        try {
            assertCleanStatus(imaqThresholdFn.call6(dest.address().toUWord().toPrimitive(), source.address().toUWord().toPrimitive(), rangeMin, rangeMax, 1, 255));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private static final BlockingFunction imaqParticleFilter4Fn = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqParticleFilter4");
    
    public static int particleFilter(Pointer dest, Pointer source, CriteriaCollection collection) throws NIVisionException {
        Pointer particleFilterOptions = new Pointer(16);
        particleFilterOptions.setInt(0, 0);
        particleFilterOptions.setInt(4, 0);
        particleFilterOptions.setInt(8, 0);
        particleFilterOptions.setInt(12, 1);
        IntByReference i = new IntByReference(0);
        assertCleanStatus(imaqParticleFilter4Fn.call7(dest.address().toUWord().toPrimitive(),   // dest image
                                                    source.address().toUWord().toPrimitive(),   // source image
                                                    collection.getCriteriaArray().address().toUWord().toPrimitive(),  // array of criteria
                                                    collection.getNumberOfCriteria(),           // number of criteria in the array
                                                    particleFilterOptions.address().toUWord().toPrimitive(),  // particle filter options
                                                    0,                                          // Region of interest
                                                    i.getPointer().address().toUWord().toPrimitive()));  // returned number of particles
        int numberOfParticles = i.getValue();
        i.free();
        particleFilterOptions.free();
        return numberOfParticles;
    }
    
}
