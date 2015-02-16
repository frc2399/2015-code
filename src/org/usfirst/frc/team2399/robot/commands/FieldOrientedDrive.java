package org.usfirst.frc.team2399.robot.commands;

public class FieldOrientedDrive extends JoystickDrive {
	
	public FieldOrientedDrive(){
		
	}
	
	protected void drive(double x, double y, double twist){
		driveTrain.driveFieldOriented(x, y, twist);
	}

}
