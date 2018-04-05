import java.io.IOException;
import java.util.List;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.UnsupportedQueryResultFormatException;
import org.openrdf.repository.RepositoryException;

import es.eurohelp.appconsumo.triplestore.Stardog;

public class main {

	public static void main(String[] args) throws IOException, RepositoryException, MalformedQueryException, QueryEvaluationException, TupleQueryResultHandlerException, UnsupportedQueryResultFormatException  {
		Stardog st = new Stardog();
		List<String> listaAutores = st.getDatosNumVentasTotalesEnTodasLasSedesLibro("MedStar I: Médicos de guerra");
		
		for(String stsy : listaAutores){
			System.out.println(stsy);
		}
	}
}