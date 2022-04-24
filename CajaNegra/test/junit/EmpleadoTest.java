package junit;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jacaranda.empleado.Empleado;
import com.jacaranda.empleado.EmpleadoException;

public class EmpleadoTest {

	@Test
	public void test01() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",12,'+');
		
		
		assertTrue("Debería darnos P1",
				target.asignarPrima().equals("P1"));
	}
	
	@Test
	public void test02() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",12,'-');
		
		
		assertTrue("Debería darnos P1",
				target.asignarPrima().equals("P2"));
	}
	
	@Test
	public void test03() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",8,'+');
		
		
		assertTrue("Debería darnos P1",
				target.asignarPrima().equals("P3"));
	}
	
	@Test
	public void test04() throws EmpleadoException {
		Empleado target = new Empleado(25,"Juan",7,'-');
		
		
		assertTrue("Debería darnos P1",
				target.asignarPrima().equals("P4"));
	}
	
	@Test
	public void test05() throws EmpleadoException {
		
		
		try {
			Empleado target = new Empleado(-25,"Juan",7,'-');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test06() throws EmpleadoException {

		try {
			Empleado target = new Empleado(2255,"Juan",7,'-');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test07() throws EmpleadoException {

		try {
			Empleado target = new Empleado(25,"DonRamonMontolla",7,'-');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test08() throws EmpleadoException {

		try {
			Empleado target = new Empleado(25,"Juan",-7,'-');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test09() throws EmpleadoException {

		try {
			Empleado target = new Empleado(25,"Juan",1200,'-');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
	@Test
	public void test10() throws EmpleadoException {

		try {
			Empleado target = new Empleado(25,"Juan",12,'(');
		} catch (Exception e) {
			System.out.println("Excepcion por negativos tal y como se esperaba: " + e.getMessage());
		}
	}
	
}
