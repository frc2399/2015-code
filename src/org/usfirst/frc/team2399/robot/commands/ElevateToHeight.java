package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;



/**
 *
 */
public class ElevateToHeight extends Elevate {
	private double height;

	// this constructor should continue to exist, but we should write another
	// one to allow us to select different elevator speeds.  It can be written
	// just like the others: pass in a LiftSpeeds object and pass it through
	// to the super call to the constructor of ElevateToHeight
    public ElevateToHeight(Elevator elevator, double height) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(elevator, 0); 
    	this.height = height; //the variable height is equal to the parameter height
    }

    // Called just before this Command runs the first time
    
    // This is a problem.  ElevateTwoSpeeds sets its direction at construction
    // time, whereas ElevateToHeight needs to set its direction when the command
    // is started.  This means setting the direction when initialize()
    // is called.  Unfortunately, we don't have a way of changing the direction
    // variable from within a class that extends ElevateTwoSpeeds.  Let's add
    // something to give us access.  Look over in ElevateToHeight now:
    
    // Now that we have a way to set direction, we can write a version of
    // this initialize() method that sets the direction in ElevateTwoSpeeds
    // based on the same logic we're using here: if we're below the position
    // desired, go up, else go down.  isFinished() (below) will take care of
    // ending the command when the elevator hits its desired height.  
    protected void initialize() {
    	double currentPos = elevator.getPositionInches(); //getting the current position
    	if (currentPos < height){
    		speed = .65; 
    	} else { 
    		speed = -.65;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (elevator.isPositionValid() == false){ //if we're at a bad spot then stop moving
    		return true;
    	} if (speed < 0){
    		if (elevator.getPositionInches() <= height){
    			return true; 
    			//if we are moving down and our current position is less then where we want to be then stop
    			}
    	} if (speed > 0){
    		if (elevator.getPositionInches() >= height){
    			return true;
    			//if we are moving up and our current position is more then where we want to be then stop
    		}
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
