/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    
    // Instance fields
    // int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor
    //RobotDrive chassis = new RobotDrive(7, 8, 6, 5);
    CANJaguar frontLeft;
    CANJaguar rearLeft;
    CANJaguar frontRight;
    CANJaguar rearRight;
    
    RobotDrive chassis;
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    Joystick driveyStick = new Joystick(3);
    
    // TODO: connect shooter motor

    public RobotTemplate() throws CANTimeoutException {
        this.frontLeft = new CANJaguar(7);
        this.rearLeft = new CANJaguar(8);
        this.frontRight = new CANJaguar(6);
        this.rearRight = new CANJaguar(5);
        this.chassis = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    }

    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        System.out.println("Hello world.");
        // TODO: write the loop
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        chassis.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            //chassis.tankDrive(leftStick, rightStick);
            //mecanumDrive_Polar(double magnitude, double direction, double rotation)
            //mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle)
            double x = driveyStick.getX();
            x = Math.min(1.0, x);
            x = Math.max(-1.0, x);
            x *= 0.6;
            double y = driveyStick.getY();
            y = Math.min(1.0, y);
            y = Math.max(-1.0, y);
            y *= 0.6;
            double rotation = driveyStick.getTwist();
            rotation = Math.min(1.0, rotation);
            rotation = Math.max(-1.0, rotation);
            rotation *= 0.6;
            
            chassis.mecanumDrive_Cartesian(x, y, rotation, 0);
            //chassis.tankDrive(leftStick, rightStick);
            Timer.delay(0.1);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
