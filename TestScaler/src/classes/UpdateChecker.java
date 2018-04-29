package classes;

/*
 * 
 * Code fragment from https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 * 
 */
import java.io.*;
import java.net.*;

public class UpdateChecker {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static int sendGet() throws Exception {
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

		// print result
		return response.toString().indexOf("Version 0.1");
	}
}
