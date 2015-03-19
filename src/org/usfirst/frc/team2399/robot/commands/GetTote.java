package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CANJaguar;

public class GetTote extends Elevate{
	
		private double goTo;
		private boolean positionValid;
		private double lowerLimit;
		private double upperLimit;
		private CANJaguar elevatorMotor;
		
		public GetTote(Elevator elevator) {
			super(elevator, .5); //calls the arguments in because Elevate is the command it is based off of
			//needs the same arguments as Elevate
			this.elevator = elevator; //creating an instance of elevator
			double currentPos = elevator.whereAt(); //where we are at now
			double whereTo = elevator.getPosition() * 1.194 * Math.PI + 20.1;
//where we're at * diameter of encoder shaft * pi * distance from floor (8 in b/c wheel diameter) + height of tote (12.1 in according to AndyMark)
					//0; //how many rotations it will take to get to where we want to go
			//TODO: FIND OUT THE RIGHT NUMBER OF ENCODER ROTATIONS WE NEED TO GO TO GET TO BIN HEIGHT
			goTo = currentPos + whereTo; //the final value of how far we need to go
		}
		private void checkLowerLimit(){
			checkLowerLimit();
		}
		public void hitLimits(double elevatorSpeed){
			checkLowerLimit();
			if(positionValid == true){
				if(elevatorSpeed < 0){
					if(elevator.getPosition() < lowerLimit){
						elevator.setSpeed(0);
					}
				}
				if (elevatorSpeed > 0){
					if(elevator.getPosition() > upperLimit){
						elevator.setSpeed(0);
					}
				}
			}
			elevatorMotor.set(elevatorSpeed);
		}
		
		public boolean isFinished(){
			return elevator.atPos(elevator, goTo); //atPos is the thing that moves the lift
			//will move elevator to the position of goTo which is where we are + where we want to go
		}
	}


