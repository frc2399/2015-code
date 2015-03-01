package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto3Tote extends CommandGroup {

	// this is for worst case scenario for if no other robot can pick up
	// anything in autonomous
	public Auto3Tote() {
		
		// TODO elevator reset- make sure it runs to a known position
		// TODO use optical encoder to determine height and distance for more
		// accurate driving
		//TODO do we need to create a command to reset encoders or can we put that reset in elevate to bottom?

		addSequential(new GyroReset());
		addSequential(new ElevateToBottom(Robot.elevatorFront));//reset elevator to a known position
		
		addSequential(new DriveForward());
		addSequential(new ElevateUpWhenTouchingTote(Robot.elevatorFront));
		addSequential(new ElevateToTop(Robot.elevatorFront));
		addSequential(new StrafeRight());
		addSequential(new ElevateToBottom(Robot.elevatorFront));

		// go backwards
		// elevator run down
		// go forwards

		addSequential(new PickUpTote());
		addSequential(new StrafeRight());
		addSequential(new ElevateToBottom(Robot.elevatorFront));

		// go backwards
		// elevator run down
		// go forwards

		addSequential(new PickUpTote());
		addSequential(new DriveBackward());
		addSequential(new PutDownTote());
		addSequential(new DriveBackward());
		
		//TODO figure out speeds and time for pick up/put down

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
