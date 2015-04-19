package org.usfirst.frc.team2399.robot;

public class LiftSpeeds {
	public static final double LIFT_DEFAULT_SPEED = 0.65;
	public static final double LIFT_TURBO_SPEED = 1.0;
	
	private final double turboSpeed;
	private final double normalSpeed;
	
	private LiftSpeeds(double turbo, double normal) {
		// default constructor
		turboSpeed = turbo;
		normalSpeed = normal;
	}
	public static LiftSpeeds defaultSpeeds(){
		return new LiftSpeeds(LIFT_TURBO_SPEED, LIFT_DEFAULT_SPEED);
	}
	
	public static LiftSpeeds turboOnly(){
		return new LiftSpeeds(LIFT_TURBO_SPEED, LIFT_TURBO_SPEED);
	}
	
	public static LiftSpeeds noTurbo(){
		return new LiftSpeeds(LIFT_DEFAULT_SPEED, LIFT_DEFAULT_SPEED);
	}
	
	public static LiftSpeeds customSpeeds(double turbo, double normal){
		return new LiftSpeeds(turbo, normal);
	}
	public double getTurboSpeed() {
		return turboSpeed;
	}
	public double getNormalSpeed() {
		return normalSpeed;
	}

}
