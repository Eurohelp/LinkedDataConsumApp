package es.eurohelp.appconsumo.data;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.jayway.jsonpath.JsonPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.util.Properties;

public class DataGetter {
	public static Properties properties = new Properties();

	public static void main(String[] args) {
		try {
			properties.load(new FileInputStream("src/main/resources/kgsearch.properties"));

			HttpTransport httpTransport = new NetHttpTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			JSONParser parser = new JSONParser();
			GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
			url.put("query", "libros");
			url.put("limit", "50");
			url.put("languages", "es");
			url.put("indent", "true");
			url.put("types", "Book");
			url.put("key", properties.get("API_KEY"));
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse httpResponse = request.execute();
			JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
			JSONArray elements = (JSONArray) response.get("itemListElement");
			for (Object element : elements) {
				System.out.println(JsonPath.read(element, "$.result.@type").toString());
				System.out.println(JsonPath.read(element, "$.result.description").toString());
				System.out.println(JsonPath.read(element, "$.result.name").toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
