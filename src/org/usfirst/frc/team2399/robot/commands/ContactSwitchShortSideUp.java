package org.usfirst.frc.team2399.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

/**
 *
 */
public class ContactSwitchShortSideUp extends CommandGroup {
	
	private Elevator elevatorFront = Robot.elevatorFront;
	private Elevator elevatorRear = Robot.elevatorRear;
	
//	private DigitalInput contactSwitchOne = Robot.contactSwitchOne;
//	private DigitalInput contactSwitchFour = Robot.contactSwitchFour;

	// this will cause the lift to automatically go up when the contact switches
	// 1 and 4 are pressed on the short side of the tote
	// TODO see if this automatically activates in teleop.
//
//	public ContactSwitchShortSideUp() {
//		if (contactSwitchOne.get() == true && contactSwitchFour.get() == true) {
//			addSequential(new ElevateUp(Robot.elevatorFront));
//			addSequential(new WaitCommand(2));
//			addSequential(new ElevateNot(Robot.elevatorFront));
//		}
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
	//}
}
