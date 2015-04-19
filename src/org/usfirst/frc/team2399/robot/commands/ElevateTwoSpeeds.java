package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.LiftSpeeds;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Button;

public class ElevateTwoSpeeds extends Elevate {
	private boolean direction;
	private Button turboButt;
	private LiftSpeeds liftSpeed;
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;
	
	public ElevateTwoSpeeds(Elevator elevator, Button turboButt, boolean direction) {
		this(elevator, turboButt, direction, LiftSpeeds.defaultSpeeds());
	}

	public ElevateTwoSpeeds(Elevator elevator, Button turboButt, boolean direction, LiftSpeeds speeds) {
		super(elevator, 0);
		this.turboButt = turboButt;
		this.direction = direction;
		liftSpeed = speeds;
	}
	
	public ElevateTwoSpeeds(Elevator elevator, boolean direction, LiftSpeeds speeds){
		super(elevator, 0);
		this.direction = direction;
		liftSpeed = speeds;
		turboButt = null;
	}
	
	public ElevateTwoSpeeds(Elevator elevator, boolean direction){
		this(elevator, direction, LiftSpeeds.defaultSpeeds());
	}

	protected void execute() {
		
		if (turboButt != null && turboButt.get())
		{
			speed = liftSpeed.getTurboSpeed();
		}
		else 
		{
			speed = liftSpeed.getNormalSpeed();
		}
		if (!direction)
		{
			speed = -speed;
		}
		
		super.execute();
	}
	
	protected void setDirection(boolean newDirection){
		direction = newDirection;
	}

}
