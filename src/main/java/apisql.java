import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class apisql {

		public static void main(String[] args) throws IOException, InterruptedException {
			String url = "jdbc:mysql://localhost:3306/my_Dataapi";
			String user = "root";
			String pass = "root";
		    HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://universities.hipolabs.com/search?country=United+States")).build();
				
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String uglyJsonString = response.body();
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					JsonParser jp = new JsonParser();
					JsonElement je = jp.parse(uglyJsonString);
					String prettyJsonString = gson.toJson(je);
					System.out.println(prettyJsonString);
					readurl[] apiD = gson.fromJson(prettyJsonString, readurl[].class);
					for (readurl dD : apiD) {
				
						String WebPage = dD.getWeb_pages()[0];
						String state_province = dD.getState_province();
						String alpha_two_code =dD.getAlpha_two_code();
						String name = dD.getName();
						String country = dD.getCountry();
						String domian = dD.getDomains()[0];
						
						String SQLqueryForInserting = "insert into users(Web_pages,State_province, Alpha_two_code,name, country,domains)"
								+ " values('" + WebPage + "' ,'" + state_province + "', '" + alpha_two_code
								+ "','" + name + "' ,' " +country  +  "','" +domian+"')";
						
						System.out.println(SQLqueryForInserting);
						Connection con = null;
						try {
							Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
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
		
	
	
	
	
	
	

