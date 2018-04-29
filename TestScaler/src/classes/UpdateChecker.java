package classes;
/*
 * @author Derrick Bush
 * 
 * Idea from https://www.hanselman.com/blog/MakingYourApplicationAutomaticallyUpdateItself.aspx
 * Code fragment from https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 * Code fragment from https://www.codeproject.com/Questions/398241/how-to-open-url-in-java - TorstenH
 * 
 */
//Imports
import java.io.*;
import java.net.*;
import java.awt.Desktop;
import javax.swing.JOptionPane;

public class UpdateChecker {
	//Instance Variables
	private final static String USER_AGENT = "Mozilla/5.0";
	
	//Methods
	public static void sendGet() throws Exception {
		//Change url to the location where you can look for your version number of the application. I use github and store the version number in the README.md
		String url = "https://github.com/derrickbush1999/TestScaler/blob/master/README.md";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//Return weather or not it is present to other location, just set return to int
		//return response.toString().indexOf("Version 0.2");
		
		//Create notification for update needed here, just set return to void
		if (response.toString().indexOf("Version 0.2") == -1) {
			int confirmation = JOptionPane.showConfirmDialog(null, "The current version of the software is out of date. Please go to https://github.com/derrickbush1999/TestScaler to get the new version.");
			if(confirmation == JOptionPane.YES_OPTION) {
				try {
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI oURL = new URI("https://github.com/derrickbush1999/TestScaler");
					  desktop.browse(oURL);
					} catch (Exception e) {
					  e.printStackTrace();
					}
			}
		}
	}
}
