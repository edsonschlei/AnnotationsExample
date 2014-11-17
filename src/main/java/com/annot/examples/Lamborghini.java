/**
 * 
 */
package com.annot.examples;

/**
 * @author schlei
 *
 */
public class Lamborghini {

	@InitialSpeed(speed=50)
	public static int minSpeed;

	@MaxSpeed(speed = 400)
	public int superSpeed() {
		return 400;
	}
	
}
