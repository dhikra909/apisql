import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class api2 {

	private	String cca2 ;
	private	String ccn3;
	private	String occa3;
	private	String cioc ;
	private	String status;
	private	String region ;
	private	String subregion;
	private	String flag ;
	private	String fifa;
	private	String startofweek;
	
	private boolean independent;
	public boolean isIndependent() {
		return independent;
	}
	public void setIndependent(boolean independent) {
		this.independent = independent;
	}
	public boolean isUnMember() {
		return unMember;
	}
	public void setUnMember(boolean unMember) {
		this.unMember = unMember;
	}
	public boolean isLandlocked() {
		return landlocked;
	}
	public void setLandlocked(boolean landlocked) {
		this.landlocked = landlocked;
	}
	public float getAra() {
		return ara;
	}
	public void setAra(float ara) {
		this.ara = ara;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	private boolean unMember;
	private boolean landlocked;
	
	private float ara;
	private Integer population;
	
	private List<String> tld;
	public List<String> getTld() {
		return tld;
	}
	public void setTld(List<String> tld) {
		this.tld = tld;
	}
	public List<String> getCapital() {
		return capital;
	}
	public void setCapital(List<String> capital) {
		this.capital = capital;
	}
	public List<String> getAltSpellings() {
		return altSpellings;
	}
	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}
	public List<String> getTimezones() {
		return timezones;
	}
	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}
	public List<String> getContinents() {
		return continents;
	}
	public void setContinents(List<String> continents) {
		this.continents = continents;
	}
	public List<Double> getLatlng() {
		return latlng;
	}
	public void setLatlng(List<Double> latlng) {
		this.latlng = latlng;
	}
	private List<String> capital;
	private List<String> altSpellings;
	private List<String> timezones;
	private List<String> continents;
	private List<Double> latlng;
	
	
	private Name name ;
	private Currencies currencies;
	public Currencies getCurrencies() {
		return currencies;
	}
	public void setCurrencies(Currencies currencies) {
		this.currencies = currencies;
	}
	public Idd getIdd() {
		return idd;
	}
	public void setIdd(Idd idd) {
		this.idd = idd;
	}
	private Idd idd;
	private Translations translations;
	
	
	
	
	
	
	
	public Translations getTranslations() {
		return translations;
	}
	public void setTranslations(Translations translations) {
		this.translations = translations;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getCca2() {
		return cca2;
	}
	public void setCca2(String cca2) {
		this.cca2 = cca2;
	}
	public String getCcn3() {
		return ccn3;
	}
	public void setCcn3(String ccn3) {
		this.ccn3 = ccn3;
	}
	public String getOcca3() {
		return occa3;
	}
	public void setOcca3(String occa3) {
		this.occa3 = occa3;
	}
	public String getCioc() {
		return cioc;
	}
	public void setCioc(String cioc) {
		this.cioc = cioc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getFifa() {
		return fifa;
	}
	public void setFifa(String fifa) {
		this.fifa = fifa;
	}
	public String getStartofweek() {
		return startofweek;
	}
	public void setStartofweek(String startofweek) {
		this.startofweek = startofweek;
	}

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
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
