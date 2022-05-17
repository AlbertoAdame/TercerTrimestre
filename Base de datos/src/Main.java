import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain","dummy", "dummy");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
