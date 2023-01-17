import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class insert2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/my_Dataapi";
		String user = "root";
		String pass = "root";
	    HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create("https://restcountries.com/v3.1/all")).build();
				
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				String uglyJsonString = response.body();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(uglyJsonString);
				String prettyJsonString = gson.toJson(je);
				System.out.println(prettyJsonString);
				api2[] A = gson.fromJson(prettyJsonString, api2[].class);
				for (api2 D : A) {
			
					String cca2 = D.getCca2();
					String region = D.getCcn3();
					Integer population =D.getPopulation();
					String subregion = D.getSubregion();
					
					
					String SQLqueryForInserting = "insert into users2(cca2,region, population,subregion )"
							+ " values('" + cca2 + "' ,'" + region + "', '" + population
							+ "','" + subregion + "')";
					
					System.out.println(SQLqueryForInserting);
					Connection con = null;
					try {
						Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						DriverManager.registerDriver(driver);
						con = DriverManager.getConnection(url, user, pass);
						java.sql.Statement st = con.createStatement();
						// Executing query
						int m = st.executeUpdate(SQLqueryForInserting);
						if (m >= 0)
							System.out.println("inserted successfully : " + SQLqueryForInserting);
						else
							System.out.println("insertion failed");
						// Closing the connections
						con.close();
					} catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
				}
				   
			}
	
	}
	

