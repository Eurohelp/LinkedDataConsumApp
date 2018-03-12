package es.eurohelp.appconsumo.triplestore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;

import com.complexible.stardog.api.ConnectionConfiguration;
import com.complexible.stardog.sesame.StardogRepository;

public class Stardog {
	public static Properties properties = new Properties();
	private RepositoryConnection repository;
	private String serverURL;

	/**
	 * @throws RepositoryException
	 * @throws IOException
	 * 
	 */
	public Stardog() throws IOException {
		properties.load(new FileInputStream("src/main/resources/triplestore.properties"));
		serverURL = (String) properties.get("sparqlEndpoint");
		Repository stardogRepository = new StardogRepository(
				ConnectionConfiguration.to((String) properties.get("database")).server(serverURL)
						.credentials((String) properties.get("user"), (String) properties.get("password")));
		try {
			stardogRepository.initialize();
			repository = stardogRepository.getConnection();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	public void uploadModel(Model model, String graph) throws RepositoryException {
		Iterator<Statement> iterator = model.iterator();
		while (iterator.hasNext()) {
			Statement statement = iterator.next();
			ValueFactory f = repository.getValueFactory();
			System.out.println(statement.toString());
			URI context2 = f.createURI(graph);
			repository.add(statement, context2);
		}
		repository.commit();
	}
	
	

//	public void uploadRDF(InputStream is, String baseUri, RDFFormat dataFormat)
//			throws RDFParseException, RepositoryException, IOException {
//		repository.add(is, baseUri, dataFormat, (Resource) null);
//	}
}
