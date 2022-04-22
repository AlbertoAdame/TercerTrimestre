package org.ed.junit.ju07repeattest;


import junit.extensions.ActiveTestSuite;
import junit.extensions.RepeatedTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

public class ValidatorTest extends TestCase {
	
	/**
	 * Constructor necesario para ejecutar los casos de prueba desde el TestSuite
	 */
	public ValidatorTest(String testMethodName) {
		super(testMethodName);
	}


	@Test
	public void testIsNumber( ) {
		Validator validator = new Validator("31337");
		assertTrue("Number validation correct",validator.isNumber());
		
		validator = new Validator("r2d2");
		assertFalse("False number validation correct",validator.isNumber());
	}
	

	@Test
	public void testIsText( ) {
		Validator validator = new Validator("hacker");
		assertTrue("Text validation correct",validator.isText());
		
		validator = new Validator("h4x0r");
		assertFalse("False text validation correct",validator.isText());
	}


	@Test
	public void testIsSomethingElse( ) {
		Validator validator = new Validator("h4x0r");
		assertTrue("Something else validation correct",validator.isSomethingElse());
		
		validator = new Validator("42");
		assertFalse("False something else validation correct",validator.isSomethingElse());
	}

	
	/**
	 * TestSuite permite crear ejecuciones de pruebas más complejas. En este caso se definen pruebas para los 3 casos anteriores,
	 * lanzando N ejecuciones de cada uno de ellos. El número de ejecuciones se indica creando un RepeatedTest e indicando el número de 
	 * ejecuciones
	 */
	@Test
	public static TestSuite suite( ) {
		TestSuite mySuite = new ActiveTestSuite( );
		
		mySuite.addTest(new RepeatedTest(new ValidatorTest("testIsNumber"),500));
		mySuite.addTest(new RepeatedTest(new ValidatorTest("testIsText"),100));
		mySuite.addTest(new RepeatedTest(new ValidatorTest("testIsSomethingElse"),100));
		
		return mySuite;
	}
}