import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Update  {
	
	    public static void main(String args[])
	    {
	    	String url = "jdbc:mysql://localhost:3306/my_Dataapi";
			String user = "root";
			String pass = "root";
	        String web_pages = "http://www.marywood.edu";
	        String state_province = "null";
	        String alpha_two_code= "OM";
	        String name= "Marywood University";
	        String country= " United States";
	        String domains= "marywood.edu";
      try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			java.sql.Statement st = con.createStatement();
         
            // Updating database
            String q1 = "UPDATE users set alpha_two_code  = '" + alpha_two_code +
                    "' WHERE id = 2 ";
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
