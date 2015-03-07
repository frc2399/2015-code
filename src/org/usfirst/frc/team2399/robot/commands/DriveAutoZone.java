package org.usfirst.frc.team2399.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
//THIS IS NEW. YOU SHOULD LOOK AT THE THING
//please read the comments below- they explain what's going on in the code
public class DriveAutoZone extends CommandGroup {
    
    public  DriveAutoZone() {
    	addSequential(new GyroReset());
    	addSequential(new DriveTrainForward(2.75, .25, 7.0, 0));
    	
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
