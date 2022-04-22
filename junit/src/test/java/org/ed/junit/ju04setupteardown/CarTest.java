
package org.ed.junit.ju04setupteardown;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

	private BufferedReader fileReader;
	private Car targetCar;
	private String readedBrand;
	

	/**
	 * 
	 * Método que se ejecuta antes de cada ejecución de test unitario
	 */
	@BeforeEach
	public void setUp() throws Exception {
		fileReader = new BufferedReader(new FileReader(getClass().getResource("brand.txt").getFile()));
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
	 * Método que se ejecuta después de la ejecución de cada test unitario
	 */
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("tearDown> ending test...");	
		fileReader.close();
	
		targetCar = null;
	}


}
