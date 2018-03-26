import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.UnsupportedQueryResultFormatException;
import org.openrdf.repository.RepositoryException;

import es.eurohelp.appconsumo.triplestore.Stardog;
import scala.reflect.internal.Trees.Star;

public class main {

	public static void main(String[] args) throws TupleQueryResultHandlerException, RepositoryException, MalformedQueryException, QueryEvaluationException, UnsupportedQueryResultFormatException, IOException {
		Stardog st = new Stardog();
		List<String> listaAutores = st.getDatosNumVentasTotalesEnSedeConcretaPorAutorySede("Saul Bellow", "Alava");
		for(String stsy : listaAutores){
			System.out.println(stsy);
		}
	}
}