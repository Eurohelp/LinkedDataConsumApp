import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import org.openrdf.model.Model;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.UnsupportedRDFormatException;

import es.eurohelp.appconsumo.data.KnowledgeGraphUtil;
import es.eurohelp.appconsumo.triplestore.Stardog;

public class main {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, RDFParseException, UnsupportedRDFormatException,
			RepositoryException, MalformedQueryException, QueryEvaluationException, ParseException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/kgsearch-music-album.properties"));
		//
		// // Se cargan los datos del grafo de conocimiento de Google para
		// // conseguir discos
		// KnowledgeGraphUtil knowledgeGraph = new KnowledgeGraphUtil();
		String queryMusicAlbum = (String) properties.get("query");
		// Model modelMusicAlbum = knowledgeGraph.getDataModel((String)
		// properties.get("API_KEY"), queryMusicAlbum,
		// (String) properties.get("limit"), (String)
		// properties.get("language"),
		// (String) properties.get("datatype"));
		// System.err.println("Se empieza a almacenar los datos de los discos");
		// // Se almacena la información generada
		Stardog stardog = new Stardog();
		// stardog.uploadModel(modelMusicAlbum, "http://lod.eurohelp.es/graph/"
		// + queryMusicAlbum.replaceAll(" ", "-"));
		//
		// // Se cargan los datos del grafo de conocimiento de Google para
		// // conseguir libros
		properties.load(new FileInputStream("src/main/resources/kgsearch-books.properties"));
		String queryBooks = (String) properties.get("query");
		// Model modelBooks = knowledgeGraph.getDataModel((String)
		// properties.get("API_KEY"), queryBooks,
		// (String) properties.get("limit"), (String)
		// properties.get("language"),
		// (String) properties.get("datatype"));
		// System.err.println("Se empieza a almacenar los datos de los libros");
		// // Se almacena la información generada
		// stardog.uploadModel(modelBooks, "http://lod.eurohelp.es/graph/" +
		// queryBooks.replaceAll(" ", "-"));
		//
		// // Se reinician properties
		 properties = new Properties();
		 properties.load(new
		 FileInputStream("src/main/resources/linksdiscovery.properties"));
		//
		// System.err.println("Se enlaza la información de los discos a la ya
		// existente");
		// // La información obtenida de discos se enlaza a información
		// existente
	//	 SilkManager silk = new SilkManager();
		// modelMusicAlbum = silk.discoverLinks((String)
		// properties.get("musicAlbumconfigurationFile"),
		// (String) properties.get("musicAlmbumResultFile"));
		//
		// System.err.println("Se enlaza la información de los libros a la ya
		// existente");
		// // La información obtenida de novelas se enlaza a información
		// existente
		// modelBooks = silk.discoverLinks((String)
		// properties.get("booksConfigurationFile"),
		// (String) properties.get("booksResultFile"));
		
		
		// Se obtiene la información de los autores de los libros
//		 Model modelAutoresLibros = silk.discoverLinks((String)
//		 properties.get("autoresConfigurationFile"),
//		 (String) properties.get("autoresResultFile"));
//		stardog.uploadAuthorsModel(modelAutoresLibros,"http://lod.eurohelp.es/graph/" + queryBooks.replaceAll(" ", "-"));
//		
		
		//
		// System.err.println("Se almacena la nueva información");
		// // Se almacena la información generada
		// stardog.uploadModel(modelMusicAlbum, "http://lod.eurohelp.es/graph/"
		// + queryMusicAlbum.replaceAll(" ", "-"));
		// stardog.uploadModel(modelBooks, "http://lod.eurohelp.es/graph/" +
		// queryBooks.replaceAll(" ", "-"));
		//
		// System.err.println("Se empieza a generar datos propios para enlazar
		// con los datos");
		// Se generan enlaces propios del sistema para enlazar a los datos
		// almacenados previamente
		SuperMarketDataGenerator sMarket = new SuperMarketDataGenerator();
//		// Se genera nueva información para los libros
//		Model datosPropios = sMarket.generateData("http://lod.eurohelp.es/graph/" + queryBooks.replaceAll(" ", "-"));
//		System.err.println("Se almacena la nueva información");
//		stardog.uploadModel(datosPropios, "http://lod.eurohelp.es/graph/" + queryBooks.replaceAll(" ", "-"));
//		// Se genera nueva informacion para los discos
//		datosPropios = sMarket.generateData("http://lod.eurohelp.es/graph/" + queryMusicAlbum.replaceAll(" ", "-"));
//		stardog.uploadModel(datosPropios, "http://lod.eurohelp.es/graph/" + queryMusicAlbum.replaceAll(" ", "-"));

		Model sedesLabels = sMarket.generateSedesData("http://lod.eurohelp.es/graph/" + queryBooks.replaceAll(" ", "-"));
		stardog.uploadModel(sedesLabels);

	}
}