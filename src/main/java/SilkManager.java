import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.openrdf.model.Model;
import org.openrdf.query.algebra.In;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.Rio;
import org.openrdf.rio.UnsupportedRDFormatException;

import de.fuberlin.wiwiss.silk.Silk;
import es.eurohelp.appconsumo.triplestore.Stardog;

public class SilkManager {
	public Model discoverLinks(String configurationFile, String resultFile)
			throws RDFParseException, UnsupportedRDFormatException, IOException {
		File file = new File(configurationFile);
		Silk.executeFile(file, null, 8, true);
		InputStream is = SilkManager.class.getResourceAsStream(resultFile);
		Model model = Rio.parse(is, "", RDFFormat.N3);
		return model;
	}
}
