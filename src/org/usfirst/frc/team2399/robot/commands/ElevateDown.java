package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

//EXTENSION OF ELEVATE
//Elevates Down.

public class ElevateDown extends ElevateTwoSpeeds {
	public ElevateDown(Elevator elevator, Button turboButt) {
		super(elevator, turboButt, ElevateTwoSpeeds.DOWN);
		setInterruptible(false);
	}

}
