package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.commands.ElevateUp;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

public class ElevateToTop extends ElevateUp {
	

	public ElevateToTop(Elevator elevator) {
		super(elevator);
		setInterruptible(true);
	}
	protected boolean isFinished() {
		return elevator.hasReachedTop();
	}
	
}
