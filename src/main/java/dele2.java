import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class dele2 {

	 public static void main(String args[])
	    {
		 String url = "jdbc:mysql://localhost:3306/my_Dataapi";
			String user = "root";
			String pass = "root";
			String cca2 = "GD";
			String region ="omd";
			Integer population =112519;
			String subregion = "Australia and New Zealand";
	        try {
				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection(url, user, pass);
				java.sql.Statement st = con.createStatement();
	                  
	            // Deleting from database
	            String q1 = "DELETE from users2 " +
	            		 "WHERE id = 4 ";
	                     System.out.println(q1);
	            int x = st.executeUpdate(q1);
	             
	            if (x > 0)           
	                System.out.println(" Successfully Updated");           
	            else           
	                System.out.println("ERROR OCCURRED :(");
	             
	            con.close();
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }	
	
	
	
	
	
}
