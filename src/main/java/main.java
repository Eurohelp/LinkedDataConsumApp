import java.io.IOException;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.UnsupportedQueryResultFormatException;
import org.openrdf.repository.RepositoryException;

import es.eurohelp.appconsumo.triplestore.Stardog;

public class main {

	public static void main(String[] args) throws TupleQueryResultHandlerException, RepositoryException, MalformedQueryException, QueryEvaluationException, UnsupportedQueryResultFormatException, IOException {
		Stardog st = new Stardog();
	//	st.getDatosNumVentasTotalesEnSedeConcretaResource("Novelas ejemplares", "Alava");
	}

}
