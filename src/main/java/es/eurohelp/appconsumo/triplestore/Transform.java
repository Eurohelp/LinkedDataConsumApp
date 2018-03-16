package es.eurohelp.appconsumo.triplestore;

import java.math.BigDecimal;

import org.openrdf.model.Model;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.TreeModel;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;



public class Transform {

	private ValueFactory vf;
	private Model model;
	private String ctxt;

	public Transform(String context) {
		vf = new ValueFactoryImpl();
		model = new TreeModel();
		ctxt = context;
	}

	public String urlify(String st) {
		String result = "";
		result += st.replaceAll("\\(|\\)|\\s|\\/|\\.|:", "-");
		result += st.replaceAll("'", "-");
		return result;
	}

	public void addRDFTYPETriple(String subject, String object) {
		model.add(vf.createURI(subject), RDF.TYPE, vf.createURI(object), vf.createURI(ctxt));
	}

	public void addRDFSLABELTriple(String subject, String label) {
		model.add(vf.createURI(subject), RDFS.LABEL, vf.createLiteral(label), vf.createURI(ctxt));
	}

	public void addDataTripleXSDInt(String subject, String prop, int value) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createLiteral(value), vf.createURI(ctxt));
	}

	public void addDataTripleXSDdouble(String subject, String prop, double value) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createLiteral(value), vf.createURI(ctxt));
	}

	public void addDataTripleXSDdecimal(String subject, String prop, String value) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createLiteral(value), vf.createURI(ctxt));
	}

	public void addDataTripleXSDString(String subject, String prop, String value) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createLiteral(value), vf.createURI(ctxt));
	}

	public void addDataTripleXSDDate(String subject, String prop, String value) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createLiteral( value, vf.createURI("http://www.w3.org/2001/XMLSchema#date")), vf.createURI(ctxt));
	}

	public void addTriple(String subject, String prop, String object) {
		model.add(vf.createURI(subject), vf.createURI(prop), vf.createURI(object), vf.createURI(ctxt));
	}

	public Model getModel() {
		return model;
	}
}