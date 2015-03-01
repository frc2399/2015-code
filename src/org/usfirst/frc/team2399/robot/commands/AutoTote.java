package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */


// please read the comments below- they explain what's going on in the code
public class AutoTote extends CommandGroup {

	public AutoTote() {
		//check and see if contact switches will work for this
		addSequential(new GyroReset());
		addSequential(new ElevateToBottom(Robot.elevatorFront));
		addSequential(new DriveForward());
		addSequential(new ElevateToBottom(Robot.elevatorFront));
		addSequential(new ElevateToTop(Robot.elevatorFront));
		addSequential(new DriveBackward());
		addSequential(new ElevateToBottom(Robot.elevatorFront));
		addSequential(new DriveBackward());
		

		// TODO add elevator reset
		// TODO add encoders for more accurate driving
		// drive forward
		// pickup tote when contact switches are depressed
		//pickup tote to top of elevator
		// drive backwards
		// put down tote
		// drive backwards

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
