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

	// Se muestra men� inicial
	public String generarIndex(String tipoConsulta) throws TemplateException, IOException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		System.out.println("En el metodo pone que es" + tipoConsulta);
		listaGlobal.put("tipoConsulta", tipoConsulta);
		template = cfg.getTemplate("index2.ftl");
		template.setOutputEncoding("UTF-8");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	// Si se ha dicho ya el tipo de datos sobre el cual se desea recibir
	// informaci�n
	public String generarIndex(String tipoConsulta, String segundaElecc) throws TemplateException, IOException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	// Si se selecciona libro
	public String generarIndex(String tipoConsulta, String segundaElecc, List<String> listaNombreRecursos)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	// Si se selecciona libro y titulo y sede concreta
	public String generarIndex(String tipoConsulta, String segundaElecc, List<String> listaNombreRecursos,
			String recursoSeleccionado, String tipoSede, List<String> listaSedes) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		listaGlobal.put("NombreRecurso", recursoSeleccionado);
		listaGlobal.put("tipoSede", tipoSede);
		listaGlobal.put("listaNombreSedes", listaSedes);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

//	// Si se selecciona libro y titulo y todas las sedes
//	public String generarIndex(String tipoConsulta, String segundaElecc, List<String> listaNombreRecursos,
//			String recursoSeleccionado, String tipoSede) throws TemplateNotFoundException,
//			MalformedTemplateNameException, ParseException, IOException, TemplateException {
//		Map<String, Object> listaGlobal = new HashMap<String, Object>();
//		listaGlobal.put("tipoConsulta", tipoConsulta);
//		listaGlobal.put("tipoInfoConcreta", segundaElecc);
//		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
//		listaGlobal.put("NombreRecurso", recursoSeleccionado);
//		listaGlobal.put("tipoSede", tipoSede);
//		template = cfg.getTemplate("index2.ftl");
//		StringWriter stringWriter = new StringWriter();
//		template.process(listaGlobal, stringWriter);
//		return stringWriter.toString();
//	}

	//Genera indice para libro a partir de seleccion de nombre o lugar nacimiento
	public String generarIndex(String tipoConsulta, String segundaElecc, String tipoInformacionSolicitada, List<String> listaNombreRecursos) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("tipoDatoRecursoSolicitado", tipoInformacionSolicitada);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}
	
	public String generarIndex(String tipoConsulta, String segundaElecc,String tipoInformacionSolicitada, List<String> listaNombreRecursos, String recursoSeleccionado, List<String> datosGlobales) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("tipoDatoRecursoSolicitado", tipoInformacionSolicitada);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		listaGlobal.put("NombreRecurso", recursoSeleccionado);
		listaGlobal.put("listaDatosTotales", datosGlobales);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}

	public String generarIndex(String tipoConsulta, String segundaElecc,
			List<String> listaNombreRecursos, String recursoSeleccionado, String tipoInformacionSolicitada,
			List<String> listaSedes, String sedeSeleccionada, List<String> datosGlobales) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String, Object> listaGlobal = new HashMap<String, Object>();
		listaGlobal.put("tipoConsulta", tipoConsulta);
		listaGlobal.put("tipoInfoConcreta", segundaElecc);
		listaGlobal.put("tipoDatoRecursoSolicitado", tipoInformacionSolicitada);
		listaGlobal.put("listaNombreRecursos", listaNombreRecursos);
		listaGlobal.put("NombreRecurso", recursoSeleccionado);
		listaGlobal.put("listaNombreSedes", listaSedes);
		listaGlobal.put("sedeSeleccionada", sedeSeleccionada);
		listaGlobal.put("listaDatosTotales", datosGlobales);
		template = cfg.getTemplate("index2.ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(listaGlobal, stringWriter);
		return stringWriter.toString();
	}	
	
}