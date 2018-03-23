import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<String> listaAutores = (ArrayList<String>) st.getAuthorsNames();
		ArrayList<String> sty= (ArrayList<String>) st.getAllAuthorsByBirthPlace(listaAutores, "España");
		for(String stsy : sty){
			System.out.println(stsy);
		}
	}
}