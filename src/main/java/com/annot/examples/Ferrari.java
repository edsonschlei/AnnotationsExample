/**
 * 
 */
package com.annot.examples;

/**
 * @author schlei
 *
 */
@Car(brand="ferrari", model="f30")
public class Ferrari {

	@InitialSpeed
	static int minSpeed;
	
	@MaxSpeed(speed=330)
	public int speed() {
		return 300;
	}
}
