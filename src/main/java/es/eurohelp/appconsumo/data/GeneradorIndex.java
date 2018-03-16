package es.eurohelp.appconsumo.data;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

public class GeneradorIndex {
	Configuration cfg;
	Template template;

	/**
	 * Constructor carga el template que genera el index
	 * 
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */
	public GeneradorIndex()
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		cfg = new Configuration(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setClassForTemplateLoading(GeneradorIndex.class, "/");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public String generarIndex() throws TemplateException, IOException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	public String generarIndex(String tipoConsulta) throws TemplateException, IOException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	public String generarIndex(String tipoConsulta, String segundaElecc) throws TemplateException, IOException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	public String generarIndex(String tipoConsulta, String segundaElecc, String terceraElecc,
			List<String> listaNombreRecursos) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("datosSolicitados", terceraElecc);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	// public String generarIndex(String tipoConsulta, String
	// segundaElecc,String terceraElecc, List<String> listaNombreRecursos, String
	// sede) throws TemplateNotFoundException, MalformedTemplateNameException,
	// ParseException, IOException, TemplateException {
	// Map<String, Object> listaGlobal = new HashMap<String, Object>();
	// listaGlobal.put("tipoConsulta", tipoConsulta);
	// listaGlobal.put("tipoInfoConcreta", segundaElecc);
	// listaGlobal.put("datosSolicitados", terceraElecc);
	// listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
	// listaGlobal.put("nomSede", sede);
	// template = cfg.getTemplate("index.ftl");
	// StringWriter stringWriter = new StringWriter();
	// template.process(listaGlobal, stringWriter);
	// return stringWriter.toString();
	// }

	public String generarIndex(String tipoConsulta, String segundaElecc, String terceraElecc,
			List<String> listaNombreRecursos, String tipoInformacionVentasAutorNombreSeleccionado, List<String> listaSedes)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("datosSolicitados", terceraElecc);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		listaGlobal.put("NombreRecurso", tipoInformacionVentasAutorNombreSeleccionado);
		listaGlobal.put("listaNombreSedes", listaSedes);
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	public String generarIndex(String tipoConsulta, String segundaElecc, String terceraElecc,
			List<String> listaNombreRecursos, String tipoInformacionVentasAutorNombreSeleccionado,
			List<String> listaSedes, String sedeSeleccionada) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("datosSolicitados", terceraElecc);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		listaGlobal.put("NombreRecurso", tipoInformacionVentasAutorNombreSeleccionado);
		listaGlobal.put("listaNombreSedes", listaSedes);
		listaGlobal.put("sedeSeleccionada", sedeSeleccionada);
		template = cfg.getTemplate("index.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}
}