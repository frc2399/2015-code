package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

public class ElevateUpWhenTouchingTote extends ElevateUp {

	public ElevateUpWhenTouchingTote(Elevator elevator) {
		super(elevator);
		// TODO Auto-generated constructor stub
	}
	
	// Called repeatedly when this Command is scheduled to run
	// set the speed to "speed"
	protected void execute() {
		if(elevator.isTouchingTote())
			super.execute();
		else
			elevator.setSpeed(0.0);
	}


}
