package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

//EXTENSION OF ELEVATE
//Elevates Up

public class ElevateUp extends Elevate {

	public ElevateUp(Elevator elevator) {
		super(elevator, .65);
		setInterruptible(false);
	}

}
