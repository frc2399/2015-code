/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
/**
 *
 * @author Lauren
 */
public class VisionTester {
    
    AxisCamera camera;

    
    public void robotInit() {
            
        camera = AxisCamera.getInstance("10.23.99.11");
            
        camera.writeMaxFPS(15);

    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        System.out.println("Execute VisionTest is running.");
        
                // wait until we have a fresh image
        while (!camera.freshImage()) {
            System.out.println("Waiting for fresh image");
            Timer.delay(0.02);
        }
        //if( camera.freshImage()){
            //System.out.println("in freshimage");
            camera.writeResolution(AxisCamera.ResolutionT.k320x240);   //will not work with a lower reolution

            //if no delay, then AXIS CAMERA EXCEPTION!!!!
            //only runs first time through execute

            try {

                System.out.println("Writing image...");
                ColorImage image = camera.getImage();
                image.write("C:/Users/Lauren/Documents/Robotics/images/newImage.bmp");
                System.out.println("image wrote!");
                image.free();
                
            } catch (AxisCameraException ex) {
                ex.printStackTrace();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
            
        //}
        
   
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
  
}