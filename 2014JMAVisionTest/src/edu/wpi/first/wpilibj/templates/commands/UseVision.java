/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.MonoImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.RGBImage;

/**
 *
 * @author jallen
 */
public class UseVision extends CommandBase {
    
    final double COLOR_WAIT_DELAY = .100;
    final double COLOR_RAMP_UP_DELAY = .100; // delay to wait before snapping pics after changing color
    
    Timer stopwatch;
    
    
    int currentImage = 0;
    ColorImage[] images = new ColorImage[3];
    CustomNIVision niv = new CustomNIVision();
    
    public UseVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stopwatch = new Timer();
        vision.turnRed();
        stopwatch.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (stopwatch.get() > COLOR_RAMP_UP_DELAY) {
            try {
                images[currentImage] = vision.getImage();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            } catch (AxisCameraException ex) {
                System.out.println(currentImage + ", ");
                ex.printStackTrace();
                // try again...
                return;
            }
            
            currentImage++;
            if (currentImage == 3) {
                // compute and reset!
                boolean gotAllImages = true;
                for (int i = 0; i < images.length; i++) {
                    if (images[i] == null) {
                        gotAllImages = false;
                        break;
                    }
                }
                if (gotAllImages) {
                    try {
                        System.out.println("Attempting to capture and process...");
                        // ColorImage res = images[2];
                        
                        ColorImage res = new RGBImage();
                        niv.duplicate(res.image, images[2].image);
                        
                        niv.subtract(res.image, images[1].image, images[0].image);
                        
                        MonoImage lum = res.getLuminancePlane();
                        MonoImage thresh = new MonoImage();
                        CustomNIVision.threshold(thresh.image, lum.image, 5, 255);
                        // BinaryImage bin = (BinaryImage) thresh;
                        // MonoImage filtered = new MonoImage();
                        //CustomNIVision.particleFilter(filtered.image, bin.image, )
                        vision.saveImage(images[0], "/r.bmp");
                        vision.saveImage(images[1], "/g.bmp");
                        vision.saveImage(images[2], "/off.bmp");
                        vision.saveImage(res, "/res.bmp");
                        vision.saveImage(lum, "/lum.bmp");
                        vision.saveImage(thresh, "/thresh.bmp");
                        lum.free();
                        thresh.free();
                        // bin.free();
                        cleanupImages();
                        System.out.println("Processing complete!");
                        
                    } catch (NIVisionException ex) {
                        ex.printStackTrace();
                    }
                    
                }
                
                
                cleanupImages();
            }
            
            currentImage %= 3;
            
            switch (currentImage) {
                case 0:
                    vision.turnRed();
                    break;
                case 1:
                    vision.turnGreen();
                    break;
                case 2:
                    vision.turnOff();
                    break;
            }
            stopwatch.reset();
        }
        
    }
    
    protected void cleanupImages() {
        for (int i = 0; i < images.length; i++) {
            if (images[i] != null) {
                try {
                    images[i].free();
                } catch (NIVisionException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        cleanupImages();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        cleanupImages();
    }
}
