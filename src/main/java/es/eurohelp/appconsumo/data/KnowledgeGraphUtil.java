package es.eurohelp.appconsumo.data;

import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.openrdf.model.Model;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.Rio;
import org.openrdf.rio.UnsupportedRDFormatException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class KnowledgeGraphUtil {

	public Model getDataModel(String APIKey, String query, String limit, String language, String dataType) throws IOException, RDFParseException, UnsupportedRDFormatException{
		HttpTransport httpTransport = new NetHttpTransport();
		HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
		JSONParser parser = new JSONParser();
		GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
		url.put("query", query);
		url.put("limit", limit);
		url.put("languages", language);
		url.put("indent", "true");
		url.put("types", dataType);
		url.put("key", APIKey);
		HttpRequest request = requestFactory.buildGetRequest(url);
		HttpResponse httpResponse = request.execute();
		Model model = Rio.parse(httpResponse.getContent(), "", RDFFormat.JSONLD);
		model.setNamespace("kg", "http://g.co/kg" );
		model.setNamespace("goog", "http://schema.googleapis.com/");
		return model;
	}
}
