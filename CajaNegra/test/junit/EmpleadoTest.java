package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.jacaranda.empleado.Empleado;
import com.jacaranda.empleado.EmpleadoException;

public class EmpleadoTest {

	@Test
	public void test01() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",12,'+');
		
		
//		assertTrue("Deber�a darnos P1",
//				target.asignarPrima().equals("P1"));
		
		assertEquals("P1", target.asignarPrima());
	}
	
	@Test
	public void test02() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",12,'-');
		
		
//		assertTrue("Deber�a darnos P1",
//				target.asignarPrima().equals("P2"));
		
		assertEquals("P2", target.asignarPrima());
	}
	
	@Test
	public void test03() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",8,'+');
		
		
//		assertTrue("Deber�a darnos P1",
//				target.asignarPrima().equals("P3"));
		
		assertEquals("P3", target.asignarPrima());
	}
	
	@Test
	public void test04() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",7,'-');
		
		
//		assertTrue("Deber�a darnos P1",
//				target.asignarPrima().equals("P4"));
		
		assertEquals("P4", target.asignarPrima());
	}
	
	@Test
	public void test05(){
		
		
		try {
			Empleado target = new Empleado(-25,"Juan",7,'-');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test06() {

		try {
			Empleado target = new Empleado(2255,"Juan",7,'-');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test07() {

		try {
			Empleado target = new Empleado(25,"DonRamonMontolla",7,'-');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test08() {

		try {
			Empleado target = new Empleado(25,"Juan",-7,'-');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test09() {

		try {
			Empleado target = new Empleado(25,"Juan",1200,'-');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test10() {

		try {
			Empleado target = new Empleado(25,"Juan",12,'(');
			fail("Error.");
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
}
