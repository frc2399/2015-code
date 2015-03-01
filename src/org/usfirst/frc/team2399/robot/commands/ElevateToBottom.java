package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

//doubles as a reset button for elevators
public class ElevateToBottom extends ElevateDown {

	public ElevateToBottom(Elevator elevator) {
		super(elevator);
		setInterruptible(true);
	}
	
	protected boolean isFinished() {
		return elevator.hasReachedBottom();
	}

}
