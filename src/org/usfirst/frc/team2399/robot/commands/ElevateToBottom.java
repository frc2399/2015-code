package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

public class ElevateToBottom extends ElevateDown {

	public ElevateToBottom(Elevator elevator, Button turboButt) {
		super(elevator, turboButt);
		setInterruptible(true);
	}
	
	protected boolean isFinished() {
		return elevator.hasReachedBottom();
	}

}
