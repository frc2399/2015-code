package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBin extends CommandGroup {
    
    public  AutoBin() {
    	
    	addSequential(new DriveTrainForward(.15, .25, 2));
    	//opposite side of the robot, going forwards to get bin
		addSequential(new ElevateUpForTime(Robot.elevatorRear, 3));
		addSequential(new DriveTrainForward(3.3, -.25, 10));
		//going backwards into the auto zone
		//this program goes the opposite directions as AutoTote because it is a different robot side
		addSequential(new ElevateToBottom(Robot.elevatorFront));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
