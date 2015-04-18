package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

public class ElevateTwoSpeeds extends Elevate {
	private boolean direction;
	private Button turboButt;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	
	public ElevateTwoSpeeds(Elevator elevator, Button turboButt, boolean direction) {
		super(elevator, 0);
		this.turboButt = turboButt;
		this.direction = direction;
	
		// TODO Auto-generated constructor stub
	}

	protected void execute() {
		
		if (turboButt != null && turboButt.get())
		{
			speed = RobotMap.LIFT_TURBO_SPEED;
		}
		else 
		{
			speed = RobotMap.LIFT_DEFAULT_SPEED;
		}
		if (!direction)
		{
			speed = -speed;
		}
		
		super.execute();
	}

}
