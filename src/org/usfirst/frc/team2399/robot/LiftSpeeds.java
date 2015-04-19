package org.usfirst.frc.team2399.robot;

public class LiftSpeeds {
	
	// these should really be private, because they should only be used from
	// within the LiftSpeeds class
	public static final double LIFT_DEFAULT_SPEED = 0.65;
	public static final double LIFT_TURBO_SPEED = 1.0;
	
	
	// These are the instance variables of this class.  They are the data that
	// is bundleded within.  They are private because we might later decide to
	// change the way they are represented, and because they are accessed via 
	// methods, we can convert back to the old way inside of the methods.  
	private final double turboSpeed;
	private final double normalSpeed;
	
	
	// This constructor is private, so it can only be called from within this
	// class.  Objects are created and passed out via static factory methods.  
	
	//see: http://jlordiales.me/2012/12/26/static-factory-methods-vs-traditional-constructors/
	private LiftSpeeds(double turbo, double normal) {
		// default constructor
		turboSpeed = turbo;
		normalSpeed = normal;
	}
	
	// static factory methods allow us to have names for our "constructors":
	
	// ... such as "defaultSpeeds"
	public static LiftSpeeds defaultSpeeds(){
		// whats happening here?
		
		// we create an object of LiftSpeeds with both the default normal and
		// default turbo speeds, and return it, rather like a normal constructor
		// would
		return new LiftSpeeds(LIFT_TURBO_SPEED, LIFT_DEFAULT_SPEED);
	}
	
	// ...or "turboOnly"
	public static LiftSpeeds turboOnly(){
		return new LiftSpeeds(LIFT_TURBO_SPEED, LIFT_TURBO_SPEED);
	}
	
	// ...and so on, and so forth
	public static LiftSpeeds noTurbo(){
		return new LiftSpeeds(LIFT_DEFAULT_SPEED, LIFT_DEFAULT_SPEED);
	}
	
	// Oh look, this one is like our regular constructor.  Now, a user could
	// make their own custom speed object, if they wanted to.  
	public static LiftSpeeds customSpeeds(double turbo, double normal){
		return new LiftSpeeds(turbo, normal);
	}
	
	// What if we just wanted to offer a user the ability to set a custom turbo
	// speed, but leave the normal speed at the default?  
	
	// If we were using regular constructors, we could easily do that by simply
	// omitting the second parameter, like:
	//public LiftSpeeds(double turbo) {
	//		turboSpeed = turbo;
	//		normalSpeed = LIFT_DEFAULT_SPEED;
	//}
	
	// This would work just fine.  But, what if we wanted to also offer the user
	// the ability to set just the normal speed, and leave the turbo speed as
	// the default?  We could write it like this:
	
	//public LiftSpeeds(double normal) {
	//		turboSpeed = LIFT_TURBO_SPEED;
	//		normalSpeed = normal;
	//}
	
	// but if we try to have both this and the turbo-only constructor, the
	// compiler will give us an error.  Go ahead, uncomment the lines and try.
	
	
	// Finally, down here, we have the getter methods.  These aren't anything
	// special, but they allow the user to access the values stored within
	// without knowing how those values are stored.  
	
	public double getTurboSpeed() {
		return turboSpeed;
	}
	public double getNormalSpeed() {
		return normalSpeed;
	}

}
