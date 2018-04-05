import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.objectweb.asm.util.TraceAnnotationVisitor;
import org.openrdf.model.Model;
import org.openrdf.model.URI;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;

import es.eurohelp.appconsumo.triplestore.Stardog;
import es.eurohelp.appconsumo.triplestore.Transform;

public class SuperMarketDataGenerator {
	String[] sedesSupermercado = { "http://lod.eurohelp.es/sede/Bilbao", "http://lod.eurohelp.es/sede/Donosti",
			"http://lod.eurohelp.es/sede/Alava", "http://lod.eurohelp.es/sede/Madrid",
			"http://lod.eurohelp.es/sede/Barcelona" };
	String predicadoUnidadesVendidas = "http://dbpedia.org/ontology/numberSold";
	String tipoVentas = "http://dbpedia.org/ontology/Sales";
	String predicadoVentaSede = "http://lod.eurohelp.es/resource/sales";
	String predicadoVenta = "http://lod.eurohelp.es/def/sales";
	String predicadoProductoVendido = "http://lod.eurohelp.es/def/product";
	String predicadoSedeTipo = "http://lod.eurohelp.es/def/eurohelp-supermarket-sede";
	String predicadoFecha = "http://purl.org/dc/terms/date";
	String predicadoSchemaNombre = "http://schema.org/name";
	Stardog stardog;

	public SuperMarketDataGenerator() throws IOException {
		stardog = new Stardog();
	}

	public Model generateData(String graph)
			throws RepositoryException, MalformedQueryException, QueryEvaluationException, IOException {
		Transform modelo = new Transform(graph);
		Stardog stardog = new Stardog();
		ArrayList<String> listaResource = (ArrayList<String>) stardog.getResourceList(graph);
		Iterator<String> iterator = listaResource.iterator();
		Random rand = new Random();
		String sede;
		String randomDate;
		String predicadoVentaRecursoFecha;
		int sedeNumber;
		int numVentas;
		int numSedes;
		int cont = 0;
		String resource;
		while (iterator.hasNext()) {
			resource = iterator.next();
			sedeNumber = rand.nextInt(4) + 0;
			numSedes = rand.nextInt(5) + 1;
			numVentas = rand.nextInt(21000) + 5000;
			switch (numSedes) {
			case 1:
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				cont++;

				System.out.println(cont);
				break;
			case 2:
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->2
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(34000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				cont++;
				System.out.println(cont);
				break;
			case 3:
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->2
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(650000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->3
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(98000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				cont++;
				System.out.println(cont);
				break;
			case 4:
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->2
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(760000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->3
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(40000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->4
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(8000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				cont++;
				System.out.println(cont);
				break;
			case 5:
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->2
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(80000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->3
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(8000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->4
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(8000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				// Se reinicializan los randoms para nuevos datos-->5
				sedeNumber = rand.nextInt(4) + 0;
				numSedes = rand.nextInt(5) + 1;
				numVentas = rand.nextInt(60000) + 5000;
				modelo = addResourceTriples(modelo, resource, randomDate(), numVentas, sedesSupermercado[sedeNumber],
						graph);
				cont++;
				System.out.println(cont);
				break;
			}
		}

		return modelo.getModel();
	}

	public Model generateSedesData(String graph) {
		Transform transform = new Transform(graph);
		for (String sede : sedesSupermercado) {
			if (sede.contains("Bilbao")) {

			} else if (sede.contains("Donosti")) {
				transform.addRDFTYPETriple(sede, predicadoSedeTipo);
				transform.addRDFSLABELTriple(sede, "Donosti");
			} else if (sede.contains("Madrid")) {
				transform.addRDFSLABELTriple(sede, "Madrid");
				transform.addRDFTYPETriple(sede, predicadoSedeTipo);
			} else if (sede.contains("Barcelona")) {
				transform.addRDFSLABELTriple(sede, "Barcelona");
				transform.addRDFTYPETriple(sede, predicadoSedeTipo);
			} else if (sede.contains("Alava")) {
				transform.addRDFSLABELTriple(sede, "Alava");
				transform.addRDFTYPETriple(sede, predicadoSedeTipo);
			}
		}
		return transform.getModel();
	}

	private Transform addResourceTriples(Transform transform, String resource, String date, int numVentas, String sede,
			String graph) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		String predicadoVentaRecursoFecha = predicadoVentaSede + "-" + date + "-"
				+ stardog.getResourceName(resource, graph);
		if(resource.equals("http://g.co/kg/g/11dxdznfwj")){
			System.out.println("aqui" + sede);
		}
		// Se añade que la sucursal ha tenido unas ventas de un producto en una
		// determinada fecha
		transform.addTriple(sede, predicadoVenta, predicadoVentaRecursoFecha);
		// La venta de un determinado producto es una venta
		transform.addRDFTYPETriple(predicadoVentaRecursoFecha, tipoVentas);
		// La venta tiene asociado un producto
		transform.addTriple(predicadoVentaRecursoFecha, predicadoProductoVendido, resource);
		// La venta tiene asociada una fecha
		transform.addDataTripleXSDDate(predicadoVentaRecursoFecha, predicadoFecha, date);
		// La venta tiene asociada una cantidad
		transform.addDataTripleXSDInt(predicadoVentaRecursoFecha, predicadoUnidadesVendidas, numVentas);
		return transform;
	}

	private String randomDate() {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(2017, 2018);
		gc.set(gc.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR, dayOfYear);
		Date e = new Date(gc.get(gc.YEAR) - 1900, gc.get(gc.MONTH) - 1, gc.get(gc.DAY_OF_MONTH));
		String newstring = new SimpleDateFormat("yyyy-MM-dd").format(e);
		return newstring;
	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
