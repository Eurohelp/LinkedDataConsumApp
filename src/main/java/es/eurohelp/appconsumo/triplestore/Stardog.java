package es.eurohelp.appconsumo.triplestore;

import java.io.IOException;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;

import com.complexible.stardog.api.ConnectionConfiguration;
import com.complexible.stardog.sesame.StardogRepository;


public class Stardog {
	private RepositoryConnection repository;
	private String serverURL;

	/**
	 * @throws RepositoryException
	 * @throws IOException
	 * 
	 */
//	public Stardog() throws IOException  {
//		serverURL = "http://ckan.eurohelp.es:5820";
//		Repository stardogRepository = new StardogRepository(ConnectionConfiguration.to("LODgenAppTurismo")
//				.server(serverURL).credentials(PropertiesManager.getINSTANCE().getProperty("user"),
//						PropertiesManager.getINSTANCE().getProperty("password")));
//		try {
//			stardogRepository.initialize();
//			repository = stardogRepository.getConnection();
//		} catch (RepositoryException e) {
//			e.printStackTrace();
//		}
//	}

}
