package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.commands.ElevateUp;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

public class ElevateToTop extends ElevateUp {
	

	public ElevateToTop(Elevator elevator, Button turboButt) {
		super(elevator, turboButt);
		setInterruptible(true);
	}
	protected boolean isFinished() {
		return elevator.hasReachedTop();
	}
	
}
