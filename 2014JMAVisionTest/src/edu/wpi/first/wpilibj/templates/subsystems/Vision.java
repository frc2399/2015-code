/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.RapidSnap;

/**
 *
 * @author jallen
 */
public class Vision extends Subsystem {

    Solenoid redLed = new Solenoid(RobotMap.redLedSolenoid);
    Solenoid greenLed = new Solenoid(RobotMap.greenLedSolenoid);
    Solenoid blueLed = new Solenoid(RobotMap.blueLedSolenoid);
    Solenoid amberLed = new Solenoid(RobotMap.amberLedSolenoid);

    AxisCamera camera = AxisCamera.getInstance();
    
    public Vision() {
        camera.writeMaxFPS(30);
    }

    public void setLeds(boolean red, boolean green, boolean blue, boolean amber) {
        setLed(redLed, red);
        setLed(greenLed, green);
        setLed(blueLed, blue);
        setLed(amberLed, amber);
    }

    public void setLed(Solenoid sol, boolean value) {
        sol.set(value);
    }

    public void turnRed() {
        setLeds(true, false, false, false);
    }

    public void turnGreen() {
        setLeds(false, true, false, false);
    }

    public void turnBlue() {
        setLeds(false, false, true, false);
    }

    public void turnAmber() {
        setLeds(false, false, false, true);
    }

    public void turnOff() {
        setLeds(false, false, false, false);
    }
    
    public void turnOn() {
        setLeds(true, true, true, true);
    }
    /**
     * Make sure to call free() when you are done with the image!
     *
     * @return
     */
    public ColorImage getImage() throws NIVisionException, AxisCameraException {
        return camera.getImage();
    }
    
    public boolean hasImage() throws NIVisionException, AxisCameraException {
        return camera.freshImage();
    }
    
    public void saveImage(Image img, String filename) throws NIVisionException {
        img.write(filename);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
