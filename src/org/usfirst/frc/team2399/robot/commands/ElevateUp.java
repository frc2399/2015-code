package org.usfirst.frc.team2399.robot.commands;
//EXTENSION OF ELEVATE
public class ElevateUp extends Elevate {

	public ElevateUp() {
		super(.65); //sets the percentage of the motor to whatever is in the () (because i don't feel like spelling that out)
		setInterruptible(false);
	}

}
