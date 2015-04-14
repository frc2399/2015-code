package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

//EXTENSION OF ELEVATE
//Elevates Down.

public class ElevateDown extends Elevate {
	public ElevateDown(Elevator elevator) {
		super(elevator, -.65);
		setInterruptible(false);
	}

}
