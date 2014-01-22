/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    
    AxisCamera camera;

    public Solenoid solenoidRed = new Solenoid(1);
    public Solenoid solenoidBlue = new Solenoid(2);
    public Solenoid solenoidGreen = new Solenoid(3);
    public Solenoid solenoidAmber = new Solenoid(4);
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
        
        camera = AxisCamera.getInstance();
        
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
                
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        System.out.println("Execute VisionTest is running.");
        
        solenoidAmber.set(true);
        solenoidRed.set(false);
        solenoidGreen.set(false);
        solenoidBlue.set(false);
        
                // wait until we have a fresh image
        //if( camera.freshImage()){
            //System.out.println("in freshimage");

            //if no delay, then AXIS CAMERA EXCEPTION!!!!
            //only runs first time through execute

            try {
                camera = AxisCamera.getInstance();
                System.out.println("Writing image...");
                ColorImage image = camera.getImage();
                image.write("/newImage.bmp");
                System.out.println("image wrote!");
                image.free();
                
            } catch (AxisCameraException ex) {
                ex.printStackTrace();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
            
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
    public void disabledPeriodic(){
        //disabledPitch.start();
    }
     */ 
     
}
