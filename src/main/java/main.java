import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openrdf.model.Model;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.UnsupportedRDFormatException;

import es.eurohelp.appconsumo.data.KnowledgeGraphUtil;
import es.eurohelp.appconsumo.triplestore.Stardog;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException, RDFParseException,
			UnsupportedRDFormatException, RepositoryException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/kgsearch.properties"));

		// Se cargan los datos del grafo de conocimiento de Google
		KnowledgeGraphUtil knowledgeGraph = new KnowledgeGraphUtil();
		String query = (String) properties.get("query");
		Model model = knowledgeGraph.getDataModel((String) properties.get("API_KEY"), query,
				(String) properties.get("limit"), (String) properties.get("language"),
				(String) properties.get("datatype"));

		// Se almacena la información generada
		Stardog stardog = new Stardog();
		stardog.uploadModel(model, "http://lod.eurohelp.es/graph/" + query.replaceAll(" ", "-"));

		// Se reinician properties
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/linksdiscovery.properties"));

		// La información obtenida se enlaza a información existente
		SilkManager silk = new SilkManager();
		model = silk.discoverLinks((String) properties.get("configurationFile"), (String) properties.get("resultFile"));

		// Se almacena la información generada
		stardog.uploadModel(model, "http://lod.eurohelp.es/graph/" + query.replaceAll(" ", "-"));

	}
}
