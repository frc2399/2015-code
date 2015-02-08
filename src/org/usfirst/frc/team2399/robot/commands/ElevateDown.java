package org.usfirst.frc.team2399.robot.commands;

public class ElevateDown extends Elevate {
	public ElevateDown(){
		super(-.15);
		setInterruptible(false);
	}

}
