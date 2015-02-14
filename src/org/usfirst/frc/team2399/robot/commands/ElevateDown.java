package org.usfirst.frc.team2399.robot.commands;

//EXTENSION OF ELEVATE
//Elevates Down.

public class ElevateDown extends Elevate {
	public ElevateDown() {
		super(-.65);// will likely be a higher percentage
		setInterruptible(false);
	}

}
