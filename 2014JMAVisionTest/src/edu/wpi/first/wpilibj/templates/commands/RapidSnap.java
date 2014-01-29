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
public class RapidSnap extends CommandBase {

    final double COLOR_WAIT_DELAY = .100;
    final double COLOR_RAMP_UP_DELAY = .100; // delay to wait before snapping pics after changing color

    Timer stopwatch;

    int currentImage = 0;
    ColorImage[] images;
    CustomNIVision niv;

    boolean finished = false;

    public RapidSnap() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stopwatch = new Timer();
        stopwatch.start();
        vision.turnOff();
        images = new ColorImage[2];
        try {
            for (int i = 0; i < images.length; i++) {
                images[i] = new RGBImage();
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        niv = new CustomNIVision();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("executing...");
        try {
            for (int i = 0; i < images.length; i++) {
                if (i % 2 == 0) {
                    vision.turnOff();
                } else {
                    vision.turnOn();
                }
                stopwatch.delay(.200);
                while (!vision.hasImage()) {
                    System.out.println("waiting for image...");
                    stopwatch.delay(.005);
                }
                System.out.println("has an image");
                images[i] = vision.getImage();
                System.out.println("Got image " + i);
                System.out.println(i + ": " + stopwatch.get());
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        }

        vision.turnOff();
        
        for (int i = 0;
                i < images.length;
                i++) {
            if (images[i] != null) {
                try {
                    vision.saveImage(images[i], "/" + i + ".bmp");
                    images[i].free();                    
                } catch (NIVisionException ex) {
                    ex.printStackTrace();
                }
            }
        }

        finished = true;

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
        return finished;
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
