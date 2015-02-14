package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ContactSwitchLongSideUp extends CommandGroup {

	// declaring things that we need to use in code below

	private Elevator elevatorFront = Robot.elevatorFront;
	private Elevator elevatorRear = Robot.elevatorRear;

	private DigitalInput contactSwitchOne = Robot.contactSwitchOne;
	private DigitalInput contactSwitchTwo = Robot.contactSwitchTwo;
	private DigitalInput contactSwitchThree = Robot.contactSwitchThree;
	private DigitalInput contactSwitchFour = Robot.contactSwitchFour;

	// TODO Find out the correct combination for Contact Switches that will lift
	// the long side of the tote succesfully.

	public ContactSwitchLongSideUp() {
		/*
		 * if (contactSwitchFoo.get()==true &&contactSwitchFoo.get()== true) {
		 * addSequential(new ElevateUp()); addSequential(new WaitCommand(2));
		 * addSequential(new ElevateNot()); }
		 */

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
