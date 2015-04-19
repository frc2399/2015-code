package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

//EXTENSION OF ELEVATE
//Elevates Up

public class ElevateUp extends ElevateTwoSpeeds {

	public ElevateUp(Elevator elevator, Button turboButt) {
		super(elevator, turboButt, ElevateTwoSpeeds.UP);
		setInterruptible(false);
	}

}
