package es.eurohelp.appconsumo.data;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.jayway.jsonpath.JsonPath;

import es.eurohelp.appconsumo.triplestore.Stardog;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openrdf.model.Model;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.Rio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
			url.put("query", "romeo santos");
			url.put("limit", "100");
			url.put("languages", "es");
			url.put("indent", "true");
			url.put("types", "MusicAlbum");
			url.put("key", properties.get("API_KEY"));
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse httpResponse = request.execute();
			File targetFile = new File("src/main/resources/targetFile.tmp");
			//Model model = Rio.parse(httpResponse.getContent(), "", RDFFormat.JSONLD);
			//model.setNamespace("kg", "http://g.co/kg" );
			//model.setNamespace("goog", "http://schema.googleapis.com/");
			Files.copy(httpResponse.getContent(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//			Stardog stardog = new Stardog();
//			stardog.uploadModel(model, "http://lod.eurohelp.es/graph/books");
//			JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
//			JSONArray elements = (JSONArray) response.get("itemListElement");
//			for (Object element : elements) {
//				System.out.println(JsonPath.read(element, "$.result.@type").toString());
//				System.out.println(JsonPath.read(element, "$.result.description").toString());
//				System.out.println(JsonPath.read(element, "$.result.name").toString());
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
