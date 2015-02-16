package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
// applies to AutoTote and DriveAutoZone
public class DriveForwardTote extends CommandGroup {
	private DriveTrain driveTrain = Robot.driveTrain;
	
	public DriveForwardTote() {
		requires(Robot.driveTrain);
		
		addSequential(new DriveTrainForwardTote());
		addSequential(new WaitCommand(2));
		addSequential(new StopDrive());//

		// Add Commands here:
		/*
		 * motorsOn write myself wait given by library motorsOff write myself
		 */
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
