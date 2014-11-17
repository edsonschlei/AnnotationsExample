/**
 * 
 */
package com.annot.examples;

import org.junit.Test;

/**
 * @author schlei
 *
 */
public class LoadAnotationsTest {

	@Test
	public void testLoadCars() {
		LoadAnotations.loadCars();
	}

	@Test
	public void testLoadMaxSpeed() {
		LoadAnotations.loadMaxSpeed();
	}
	
	/**
	 * 
	 */
	@Test
	public void testLoadInitialSpeed() {
		LoadAnotations.loadInitialSpeed();
	}
}
