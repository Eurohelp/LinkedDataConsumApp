package es.eurohelp.appconsumo.triplestore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.QueryResultIO;
import org.openrdf.query.resultio.TupleQueryResultFormat;
import org.openrdf.query.resultio.UnsupportedQueryResultFormatException;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sparql.SPARQLRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;

import com.complexible.common.rdf.query.resultio.TextTableQueryResultWriter;
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
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("triplestore.properties");
		properties.load(input);
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
		System.out.println("la que empieza");
		while (iterator.hasNext()) {
			System.out.println("la que no tiene nada que mostrar");
			Statement statement = iterator.next();
			ValueFactory f = repository.getValueFactory();
			System.out.println(statement.toString());
			URI context = f.createURI(graph);
			repository.add(statement, context);
		}
		repository.commit();
	}

	public void uploadModel(Model model) throws RepositoryException {
		Iterator<Statement> iterator = model.iterator();
		System.out.println("la que empieza");
		while (iterator.hasNext()) {
			System.out.println("la que no tiene nada que mostrar");
			Statement statement = iterator.next();
			System.out.println(statement.toString());
			repository.add(statement, statement.getContext());
		}
		repository.commit();
	}

	public void uploadAuthorsModel(Model model, String graph) throws RepositoryException {
		Iterator<Statement> iterator = model.iterator();
		System.out.println("la que empieza");
		while (iterator.hasNext()) {
			System.out.println("la que no tiene nada que mostrar");
			Statement statement = iterator.next();
			ValueFactory f = repository.getValueFactory();
			System.out.println(statement.toString());
			repository.add(statement.getSubject(), f.createURI("http://schema.org/author"), statement.getObject(),
					f.createURI(graph));
		}
		repository.commit();
	}

	public List<String> getDatosNumVentasTotalesEnTodasLasSedesLibro(String resourceName)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaRecursos = new ArrayList<>();
		String result = "";
		String queryText = "SELECT ?labelRecurso (SUM(?numVentas) as ?numTotal) where{ graph<http://lod.eurohelp.es/graph/novelas>{?recursoAutorDbpedia <http://schema.org/author> ?recurso. ?datosVenta <http://lod.eurohelp.es/def/product> ?recurso. ?recurso <http://schema.org/name> ?labelRecurso. ?sede ?seVendio ?datosVenta. ?datosVenta <http://dbpedia.org/ontology/numberSold> ?numVentas.} FILTER (?labelRecurso IN (\""
				+ resourceName + "\"^^xsd:string))}GROUP BY ?labelRecurso ?recurso";
		System.out.println("Query obtiene nombre recurso-->" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			result = queryResults.next().toString();
			result = result.replace("[labelRecurso=\"", "");
			result = result.replace("\"^^<http://www.w3.org/2001/XMLSchema#string>", "");
			result = result.replace("[", "");
			result = result.replace("numTotal=\"", "");
			result = result.replace("\"", "");
			result = result.replace("^^<http://www.w3.org/2001/XMLSchema#integer>]", "");
			String[] resultados = result.split(";");
			listaRecursos = Arrays.asList(resultados);
		}
		System.out.println("El resultado del nombre es -->" + result);
		return listaRecursos;
	}

	public List<String> getDatosNumVentasTotalesEnSedeConcretaLibro(String resourceName, String sede)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException,
			TupleQueryResultHandlerException, UnsupportedQueryResultFormatException, IOException {
		String result = "";
		List<String> listaDatos = new ArrayList<String>();
		String queryText = "SELECT ?recursoExterno ?nombreSede  (SUM(?numVentas) as ?numTotal) where{ graph<http://lod.eurohelp.es/graph/novelas>{?recursoAutorDbpedia <http://schema.org/author> ?recurso. ?datosVenta <http://lod.eurohelp.es/def/product> ?recurso. ?sede ?seVendio ?datosVenta.?sede rdfs:label ?nombreSede. ?datosVenta <http://dbpedia.org/ontology/numberSold> ?numVentas. SERVICE <http://es.dbpedia.org/sparql>{?recursoExterno rdfs:label \""
				+ resourceName + "\"@es. FILTER (?recursoAutorDbpedia=?recursoExterno) }} FILTER (?nombreSede = \""
				+ sede + "\")} GROUP BY ?recursoExterno ?nombreSede";
		System.out.println("Query obtiene nombre recurso-->" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			result = queryResults.next().toString();
			if (!result.contains("numTotal=\"0\"")) {
				System.out.println(result);
				result = result.replace("[recursoExterna=\"", "");
				result = result.replace("\"^^<http://www.w3.org/2001/XMLSchema#string>", "");
				result = result.replace("[", "");
				result = result.replace("nombreSede=\"", "");
				result = result.replace("numTotal=\"", "");
				result = result.replace("\"", "");
				result = result.replace("^^<http://www.w3.org/2001/XMLSchema#integer>]", "");
				String[] resultados = result.split(";");
				listaDatos = Arrays.asList(resultados);
			} else {
				listaDatos = null;
			}
		}
		return listaDatos;
	}

	public List<String> getDatosNumVentasTotalesEnTodasLasSedesByAuthor(String autor)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaRecursos = new ArrayList<>();
		String result = "";
		String queryText = "SELECT ?labelAutor (SUM(?numTotal) as ?ventasTotales) where{ graph<http://lod.eurohelp.es/graph/novelas>{?recursoAutorDbpedia <http://schema.org/author> ?recurso. ?datosVenta <http://lod.eurohelp.es/def/product> ?recurso. ?sede ?seVendio ?datosVenta. ?sede rdfs:label ?nombreSede. ?datosVenta <http://dbpedia.org/ontology/numberSold> ?numVentas. SERVICE <http://es.dbpedia.org/sparql>{?recursoExterno rdfs:label ?labelAutor. FILTER (?recursoAutorDbpedia=?recursoExterno) FILTER (?labelAutor IN (\""+autor+"\"@es))} BIND (SUM(?numVentas) as ?numTotal) }} GROUP BY ?labelAutor ?recursoExterno ?nombreSede";
		System.out.println("Query obtiene nombre recurso-->" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			result = queryResults.next().toString();
			result = result.replace("[labelAutor=\"", "");
			result = result.replace("@es", "");
			result = result.replace("ventasTotales=\"", "");
			result = result.replace("\"", "");
			result = result.replace("^^<http://www.w3.org/2001/XMLSchema#integer>]", "");
			String[] resultados = result.split(";");
			listaRecursos = Arrays.asList(resultados);
		}
		System.out.println("El resultado del nombre es -->" + result);
		return listaRecursos;
	}

	public List<String> getDatosNumVentasTotalesEnSedeConcretaPorAutorySede(String autor, String sede)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaRecursos = new ArrayList<>();
		String result = "";
		String queryText = "SELECT ?labelAutor ?labelSede (SUM(?numTotal) as ?ventasTotales) where{ graph<http://lod.eurohelp.es/graph/novelas>{?recursoAutorDbpedia <http://schema.org/author> ?recurso. ?datosVenta <http://lod.eurohelp.es/def/product> ?recurso. ?recurso <http://schema.org/name> ?labelRecurso. ?sede ?seVendio ?datosVenta.?sede rdfs:label ?labelSede. ?datosVenta <http://dbpedia.org/ontology/numberSold> ?numVentas. SERVICE <http://es.dbpedia.org/sparql>{ ?recursoExterno rdfs:label ?labelAutor FILTER (?recursoAutorDbpedia=?recursoExterno) FILTER (?labelAutor IN (\""+autor+"\"@es)) }FILTER (?labelSede IN (\""+sede+"\")) BIND (SUM(?numVentas) as ?numTotal)}} GROUP BY ?numVentas ?labelAutor ?labelSede";
		System.out.println("Query obtiene nombre recurso-->" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			result = queryResults.next().toString();
			result = result.replace("[labelAutor=\"", "");
			result = result.replace("\"@es", "");
			result = result.replace("[", "");
			result = result.replace("labelSede=\"", "");
			result = result.replace("ventasTotales=\"", "");
			result = result.replace("\"", "");
			result = result.replace("^^<http://www.w3.org/2001/XMLSchema#integer>]", "");
			String[] resultados = result.split(";");
			listaRecursos = Arrays.asList(resultados);
		}
		System.out.println("El resultado del nombre es -->" + result);
		return listaRecursos;
	}

	public List<String> getResourceList(String graph)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {

		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, "SELECT DISTINCT ?s WHERE { GRAPH<"
				+ graph + "> {?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://schema.org/Book>.}}");
		System.out.println(query.toString());
		TupleQueryResult queryResults = query.evaluate();
		List<String> listaLibros = new ArrayList<String>();
		while (queryResults.hasNext()) {
			String result = queryResults.next().toString();
			result = result.replace("[s=", "");
			result = result.replace("]", "");
			listaLibros.add(result);
		}
		return listaLibros;
	}

	public String getResourceName(String resource, String graph)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		String result = "";
		String queryText = "SELECT DISTINCT ?p WHERE { GRAPH<" + graph + "> {<" + resource + ">"
				+ " <http://schema.org/name> ?p.}}";
		System.out.println("Query obtiene nombre recurso-->" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			result = queryResults.next().toString();
			result = result.replace("[p=\"", "");
			result = result.replace("\"^^<http://www.w3.org/2001/XMLSchema#string>]", "");
			result = result.replace(" ", "-");
		}
		System.out.println("El resultado del nombre es -->" + result);
		return result;
	}

	public List<String> getAuthorsNames()
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaRecursosDbpedia = new ArrayList<String>();
		List<String> listaAutores = new ArrayList<String>();
		Repository repo = new SPARQLRepository("http://es.dbpedia.org/sparql");
		repo.initialize();
		RepositoryConnection repoConn = repo.getConnection();
		String queryStardog = "select distinct ?recursoDbpedia where{graph<http://lod.eurohelp.es/graph/novelas>{?recursoDbpedia <http://www.w3.org/2002/07/owl#sameAs> ?recursoPropio.}}";
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryStardog);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			String nombreAutor = queryResults.next().toString();
			nombreAutor = nombreAutor.replace("[recursoDbpedia=", "");
			nombreAutor = nombreAutor.replace("]", "");

			System.out.println(nombreAutor);
			if (!listaRecursosDbpedia.contains(nombreAutor)) {
				listaRecursosDbpedia.add(nombreAutor);
			}
		}
		for (String libro : listaRecursosDbpedia) {
			String queryDbpedia = "SELECT ?nombreAutor where{ ?libro <http://es.dbpedia.org/property/autor> ?autor. ?autor <http://www.w3.org/2000/01/rdf-schema#label> ?nombreAutor. FILTER (?libro = <"
					+ libro + ">)} LIMIT 1";
			TupleQuery tupleQueryStardog = repoConn.prepareTupleQuery(QueryLanguage.SPARQL, queryDbpedia);
			queryResults = tupleQueryStardog.evaluate();

			while (queryResults.hasNext()) {
				String nombreAutor = queryResults.next().toString();
				nombreAutor = nombreAutor.replace("[nombreAutor=\"", "");
				nombreAutor = nombreAutor.replace("\"@es]", "");
				if (!listaAutores.contains(nombreAutor)) {
					listaAutores.add(nombreAutor);
				}
			}
		}
		return listaAutores;
	}

	public List<String> getAllAuthorsByBirthPlace(List<String> listaAutores, String lugarNacimiento)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaAutoresLugarNacimientoConcreto = new ArrayList<String>();
		Repository repo = new SPARQLRepository("http://es.dbpedia.org/sparql");
		repo.initialize();
		RepositoryConnection repoConn = repo.getConnection();
		String nombreAutor = "";
		for (String autor : listaAutores) {
			String queryStardog = "select ?labelAutor where{?autor rdfs:label ?labelAutor. ?autor rdf:type <http://schema.org/Person>. ?autor <http://dbpedia.org/ontology/birthPlace> ?lugarNacimiento. ?lugarNacimiento rdfs:label ?labelLugarNacimiento FILTER (?labelAutor=\""
					+ autor + "\"@es) FILTER (?labelLugarNacimiento = \"" + lugarNacimiento + "\"@es) } LIMIT 1";
			System.out.println(queryStardog);
			TupleQuery query = repoConn.prepareTupleQuery(QueryLanguage.SPARQL, queryStardog);
			TupleQueryResult queryResults = query.evaluate();
			while (queryResults.hasNext()) {
				nombreAutor = queryResults.next().toString();
				nombreAutor = nombreAutor.replace("[labelAutor=\"", "");
				nombreAutor = nombreAutor.replace("\"@es]", "");
				if (!listaAutoresLugarNacimientoConcreto.contains(nombreAutor)) {
					listaAutoresLugarNacimientoConcreto.add(nombreAutor);
				}
			}
		}
		return listaAutoresLugarNacimientoConcreto;
	}

	public List<String> getBooksNames() throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> nombreAutores = new ArrayList<String>();
		String nombreAutor = "";
		String queryText = "select distinct ?nombreLibro where{graph<http://lod.eurohelp.es/graph/novelas>{?s rdf:type <http://schema.org/Book>. ?s <http://schema.org/name> ?nombreLibro}}";
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			nombreAutor = queryResults.next().toString();
			System.out.println(nombreAutor);
			nombreAutor = nombreAutor.replace("[nombreLibro=\"", "");
			nombreAutor = nombreAutor.replace("\"^^<http://www.w3.org/2001/XMLSchema#string>]", "");
			if (!nombreAutores.contains(nombreAutor)) {
				nombreAutores.add(nombreAutor);
			}
		}
		Collections.sort(nombreAutores);
		return nombreAutores;
	}

	public List<String> getBirthPlaces() throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> listaLugaresNacimientoAutores = new ArrayList<String>();
		List<String> listaAutores = new ArrayList<String>();
		Repository repo = new SPARQLRepository("http://dbpedia.org/sparql");
		repo.initialize();
		RepositoryConnection repoConn = repo.getConnection();
		String queryStardog = "select distinct ?s where { graph  <http://lod.eurohelp.es/graph/novelas>{ ?libro ?p ?o . ?s <http://schema.org/author> ?libro.} }";
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryStardog);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			String nombreAutor = queryResults.next().toString();
			nombreAutor = nombreAutor.replace("[s=", "");
			nombreAutor = nombreAutor.replace("]", "");

			System.out.println(nombreAutor);
			if (!listaAutores.contains(nombreAutor)) {
				listaAutores.add(nombreAutor);
			}
		}
		for (String autor : listaAutores) {
			String queryDbpedia = "select ?labelSitio where{<" + autor
					+ "> <http://dbpedia.org/ontology/birthPlace> ?sitio. optional{?sitio ?x <http://schema.org/Country>} . ?sitio <http://www.w3.org/2000/01/rdf-schema#label> ?labelSitio. FILTER (lang(?labelSitio) = 'es')} limit 1";
			TupleQuery tupleQueryStardog = repoConn.prepareTupleQuery(QueryLanguage.SPARQL, queryDbpedia);
			queryResults = tupleQueryStardog.evaluate();

			while (queryResults.hasNext()) {
				String lugarNacimiento = queryResults.next().toString();
				lugarNacimiento = lugarNacimiento.replace("[labelSitio=\"", "");
				lugarNacimiento = lugarNacimiento.replace("\"@es]", "");
				if (!listaLugaresNacimientoAutores.contains(lugarNacimiento)) {
					listaLugaresNacimientoAutores.add(lugarNacimiento);
				}
			}
		}
		return listaLugaresNacimientoAutores;
	}

	public List<String> getAllBookData(String resource)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> descripcionRecurso = new ArrayList<String>();
		String queryText = "select distinct ?nombreLibro ?autor ?descripcion where{graph<http://lod.eurohelp.es/graph/novelas>{?libro rdf:type <http://schema.org/Book>. ?libro <http://schema.org/name> ?nombreLibro. ?libro <http://schema.org/description> ?autor. OPTIONAL{ ?libro <http://schema.googleapis.com/detailedDescription> ?recursoDescripcion. ?recursoDescripcion <http://schema.org/articleBody> ?descripcion.}}FILTER (?nombreLibro IN (\""
				+ resource + "\"))} limit 1 ";
		System.out.println("query total libro" + queryText);
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		String datoRecurso = "";
		while (queryResults.hasNext()) {
			datoRecurso = queryResults.next().toString();
			System.out.println(datoRecurso);
			datoRecurso = datoRecurso.replace("[nombreLibro=\"", "");
			datoRecurso = datoRecurso.replace("\"^^<http://www.w3.org/2001/XMLSchema#string>", "");
			datoRecurso = datoRecurso.replace("descripcion=\"", "");
			datoRecurso = datoRecurso.replace("autor=\"", "");
			datoRecurso = datoRecurso.replace("]", "");
			String[] resultados = datoRecurso.split(";");
			descripcionRecurso.addAll(Arrays.asList(resultados));
		}
		return descripcionRecurso;
	}

	// La query se hace directamente contra la dbpedia
	public List<String> getAllAuthorData(String resource)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		Repository repo = new SPARQLRepository("http://es.dbpedia.org/sparql");
		repo.initialize();
		RepositoryConnection repoConn = repo.getConnection();
		List<String> descripcionRecurso = new ArrayList<String>();
		String queryText = "select distinct ?labelAutor ?resumenAutor where{?autor rdfs:label ?labelAutor. ?autor <http://dbpedia.org/ontology/abstract> ?resumenAutor. FILTER (?labelAutor IN  (\""
				+ resource + "\"@en , \"" + resource + "\"@es))} limit 100";
		TupleQuery query = repoConn.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		String datoRecurso = "";
		while (queryResults.hasNext()) {
			datoRecurso = queryResults.next().toString();
			System.out.println(datoRecurso);
			datoRecurso = datoRecurso.replace("[labelAutor=\"", "");
			datoRecurso = datoRecurso.replace("resumenAutor=\"", "");
			datoRecurso = datoRecurso.replace("@es", "");
			datoRecurso = datoRecurso.replaceAll("\"", "");
			datoRecurso = datoRecurso.replace("]", "");
			String[] resultados = datoRecurso.split(";");
			descripcionRecurso = Arrays.asList(resultados);
		}
		return descripcionRecurso;
	}

	public List<String> getSedesNames() throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		List<String> nombreSedes = new ArrayList<String>();
		String nombreSede = "";
		String queryText = "SELECT ?nombreSede WHERE{graph<http://lod.eurohelp.es/graph/sedes>{ ?sede <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?esSede.?sede <http://www.w3.org/2000/01/rdf-schema#label> ?nombreSede.}}";
		TupleQuery query = repository.prepareTupleQuery(QueryLanguage.SPARQL, queryText);
		TupleQueryResult queryResults = query.evaluate();
		while (queryResults.hasNext()) {
			nombreSede = queryResults.next().toString();
			System.out.println(nombreSede);
			nombreSede = nombreSede.replace("[nombreSede=\"", "");
			nombreSede = nombreSede.replace("\"]", "");
			if (!nombreSedes.contains(nombreSede)) {
				nombreSedes.add(nombreSede);
			}
		}
		Collections.sort(nombreSedes);
		return nombreSedes;
	}
}