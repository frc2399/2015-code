package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */


// please read the comments below- they explain what's going on in the code
public class AutoTote extends CommandGroup {

	public AutoTote() {
		addSequential(new GyroReset());

		// TODO add elevator reset
		// TODO add encoders for more accurate driving

		addSequential(new PickUpTote());
		addSequential(new DriveTrainForward(2.75, .25));
		addSequential(new ElevateToBottom(Robot.elevatorRear));
		addSequential(new DriveTrainForward(.25, 25));
		// drive forward
		// pickup tote
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
