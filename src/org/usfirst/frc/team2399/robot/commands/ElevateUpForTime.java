package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
// applies to AutoTote and DriveAutoZone
public class ElevateUpForTime extends CommandGroup {
	private Elevator elevatorFront = Robot.elevatorFront;
	private Elevator elevatorRear = Robot.elevatorRear;
	
	public ElevateUpForTime(Elevator elevator, int wait) {
		addSequential(new ElevateUp(elevator));
		addSequential(new WaitCommand(wait));
		addSequential(new ElevateNot(elevator));
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
