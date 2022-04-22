
package org.ed.junit.ju05setupteardownonce;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {

	private static BufferedReader fileReader;
	private static Car targetCar;
	private static String readedBrand;
	

	/**
	 * 
	 * Método que se ejecuta una única vez antes de ejecutar los test de la clase
	 */
	@BeforeAll
	public static void setUp() throws Exception {
		fileReader = new BufferedReader(new FileReader(CarTest.class.getResource("brand.txt").getFile()));
		readedBrand = fileReader.readLine();
		
		System.out.println("setUp> read brand: " + readedBrand);
		
		targetCar = new Car(readedBrand, Car.DIESEL);
	}
	

	@Test
	public void testMarca() {
		assertEquals("Brand assignment", targetCar.getBrand(), readedBrand);
	}
	

	@Test
	public void testLoad() {
		targetCar.loadTank();
		assertEquals("Desposit load correct", targetCar.getTank(),50.0,0.1);
	}

	@Test
	public void testConsumo() {
		targetCar.loadTank();
		targetCar.drive(10);
		assertEquals("Consumption test", targetCar.getTank(), (50.0 - (10*0.6)), 0.1);
	}
	

	@Test
	public void testEmptyTank() {
		targetCar.loadTank();
		targetCar.drive(500);
		assertEquals("Empty tank test", targetCar.getTank(), 0.0,0.0);
	}
	
	/**
	 * 
	 * Método que se ejecuta una única vez al finalizar todos los test de la clse
	 */
	@AfterAll
	public static void tearDown() throws Exception {
		System.out.println("tearDown> ending test...");	
		fileReader.close();
	
		targetCar = null;
	}


}
