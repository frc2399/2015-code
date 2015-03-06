package org.usfirst.frc.team2399.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto3Tote extends CommandGroup {

	// this is for worst case scenario for if no other robot can pick up
	// anything in autonomous
	public Auto3Tote() {
		addSequential(new GyroReset());

		// TODO elevator reset- make sure it runs to a known position
		// TODO use optical encoder to determine height and distance for more
		// accurate driving

		addSequential(new DriveTrainForward(2.75, .25));
		addSequential(new PickUpTote());

		addSequential(new StrafeRight());
		addSequential(new PutDownTote());

		// go backwards
		// elevator run down
		// go forwards

		addSequential(new PickUpTote());
		addSequential(new StrafeRight());
		addSequential(new PutDownTote());

		// go backwards
		// elevator run down
		// go forwards

		addSequential(new PickUpTote());
		addSequential(new DriveTrainForward(.25, -.25));
		addSequential(new PutDownTote());
		addSequential(new DriveTrainForward(.25, -.25));

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
