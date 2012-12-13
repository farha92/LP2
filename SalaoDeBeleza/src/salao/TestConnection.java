package salao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestConnection {

	public static void main (String[] args)

	throws Exception {
	    Connection con = DriverManager.getConnection(
	                         "jdbc:postgresql://localhost/SalaodeBeleza",
	                         "postgres",
	                         "senacrs");

	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT *FROM Funcionario where id = 2");

	    while (rs.next()) {
	 
	    	String s = rs.getString("nome");
	        String x = rs.getString("telefone");
	      
	        System.out.print("nome: ");
	        System.out.println(s);
	        System.out.print("fone: ");
	        System.out.println(x);
	    }
}
}    
	