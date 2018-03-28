package es.eurohelp.appconsumo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.UnsupportedQueryResultFormatException;
import org.openrdf.repository.RepositoryException;

import com.sun.media.sound.PCMtoPCMCodec;

import es.eurohelp.appconsumo.data.GeneradorIndex;
import es.eurohelp.appconsumo.triplestore.Stardog;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class GeneradorIndex
 */
public class ServGeneradorIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> listaNombreAutor = new ArrayList<String>();
	private static List<String> listaNombreLibros = new ArrayList<String>();
	private static List<String> listaSedes = new ArrayList<String>();
	private static List<String> listaLugaresNacimiento = new ArrayList<String>();
	private static List<String> listaAutoresPorLugaresNacimiento = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServGeneradorIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GeneradorIndex generadorIndex = new GeneradorIndex();
		Stardog stardog = new Stardog();
		String tipoConsulta = request.getParameter("tipoInformacion");
		System.out.println(tipoConsulta);
		String tipoRecursoSobreElQueSeSolicitaInformacion = request.getParameter("tipoInformacion-Ventas");
		String tipoInformacionSolicitada = request.getParameter("tipoInformacion-Ventas-Autor-Cantante");
		String tipoSede = request.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede");
		String nombreRecursoSeleccionado = request.getParameter("tipoInformacion-Ventas-Autor-Nombre");
		String nombreSedeSeleccionada = request
				.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede-Sede");
		String autorSeleccionadoPorLugarNac = request
				.getParameter("tipoInformacion-Datos-LugarNac-Autor");

		String responseData = "";
		if (tipoConsulta == null) {// Si es la primera vez que se ejecuta
			try {
				System.out.println(1);
				responseData = generadorIndex.generarIndex("null");
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} else if ((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos"))
				&& tipoRecursoSobreElQueSeSolicitaInformacion == null) {
			try {
				responseData = generadorIndex.generarIndex(tipoConsulta);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} 
		else if ((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos"))
				&& tipoRecursoSobreElQueSeSolicitaInformacion != null && tipoSede==null) {//mirar mirarsawfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfwfdk
			if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoInformacionSolicitada==null){
				try {
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion);
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoInformacionSolicitada!=null && nombreRecursoSeleccionado==null) {
				try {//si se selecciona autor hay que cargar los menus de autor
					if(tipoInformacionSolicitada.equalsIgnoreCase("NacidoEn")){
						listaLugaresNacimiento = stardog.getBirthPlaces();
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, tipoInformacionSolicitada,
								listaLugaresNacimiento);
					}
						else if(tipoInformacionSolicitada.equalsIgnoreCase("Nombre")){
						listaNombreAutor = stardog.getAuthorsNames();
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, tipoInformacionSolicitada,
								listaNombreAutor);
					}
				} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
					e.printStackTrace();
				}
			} 
		else if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoInformacionSolicitada!=null && nombreRecursoSeleccionado!=null){
			try {//si se selecciona autor hay que cargar los menus de autor
				if(tipoInformacionSolicitada.equalsIgnoreCase("NacidoEn")){
					listaNombreAutor = stardog.getAuthorsNames();
					listaAutoresPorLugaresNacimiento= stardog.getAllAuthorsByBirthPlace(listaNombreAutor, nombreRecursoSeleccionado);
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, tipoInformacionSolicitada,
							listaLugaresNacimiento, nombreRecursoSeleccionado, listaAutoresPorLugaresNacimiento);
				}
					else if(tipoInformacionSolicitada.equalsIgnoreCase("Nombre")){
					listaNombreAutor = stardog.getAuthorsNames();
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, tipoInformacionSolicitada,
							listaNombreAutor, nombreRecursoSeleccionado);
				}
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro") && tipoSede==null && nombreRecursoSeleccionado==null) {//Aqui entra si se selecciona libro para que salgan los titulos
				try {
					listaNombreLibros = stardog.getBooksNames();
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							listaNombreLibros);
				} catch (TemplateException | RepositoryException | MalformedQueryException | QueryEvaluationException e) {
					e.printStackTrace();
				}
			}//Si se selecciona ventas o datos y el tipo de datos
		else if(tipoSede==null && tipoConsulta.equalsIgnoreCase("Datos") && nombreRecursoSeleccionado!=null){//Si se selecciona datos y titulo libro
			List<String> datosGlobalesRecurso;
			if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro") ){
			try {
				datosGlobalesRecurso = stardog.getAllBookData(nombreRecursoSeleccionado);
				if(datosGlobalesRecurso.size()>0){
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,tipoInformacionSolicitada, listaNombreLibros, nombreRecursoSeleccionado, datosGlobalesRecurso);
				}
				else{//Si no hay datos de ese libro
					responseData = "No hay datos que recuperar: \n No hay informaci�n sobre ese libro";
				}
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}}
			else if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && autorSeleccionadoPorLugarNac==null){
				try {
					if(tipoInformacionSolicitada.equalsIgnoreCase("Nombre")){
						datosGlobalesRecurso = stardog.getAllAuthorData(nombreRecursoSeleccionado);
					if(datosGlobalesRecurso.size()>0){
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							tipoInformacionSolicitada,
							listaNombreAutor, nombreRecursoSeleccionado, datosGlobalesRecurso);
					}
					else{//Si no hay datos de ese libro
						responseData = "No hay datos que recuperar: \n No se dispone de informaci�n adicional sobre ese autor";
					}}
					else if(tipoInformacionSolicitada.equalsIgnoreCase("NacidoEn")){//?sera aqui
						listaNombreAutor = stardog.getAuthorsNames();
						listaAutoresPorLugaresNacimiento = stardog.getAllAuthorsByBirthPlace(listaNombreAutor, nombreRecursoSeleccionado);
						if(listaAutoresPorLugaresNacimiento.size()>0){
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaLugaresNacimiento, nombreRecursoSeleccionado,tipoInformacionSolicitada, listaAutoresPorLugaresNacimiento);
						}
						else{
							responseData = "No hay datos que recuperar: \n No se dispone de informaci�n de autores nacidos en ese sitio.";
						}
					}
				} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
					e.printStackTrace();
				}	
			}		
			else if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") ){
				try {
					if(tipoInformacionSolicitada.equalsIgnoreCase("Nombre")){
						datosGlobalesRecurso = stardog.getAllAuthorData(nombreRecursoSeleccionado);
					if(datosGlobalesRecurso.size()>0){
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							tipoInformacionSolicitada,
							listaNombreAutor, nombreRecursoSeleccionado, datosGlobalesRecurso);
					}
					else{//Si no hay datos de ese libro
						responseData = "No hay datos que recuperar: \n No se dispone de informaci�n adicional sobre ese autor";
					}}
					else if(tipoInformacionSolicitada.equalsIgnoreCase("NacidoEn") && autorSeleccionadoPorLugarNac!=null){//aquimishel
						datosGlobalesRecurso = stardog.getAllAuthorData(autorSeleccionadoPorLugarNac);
						if(datosGlobalesRecurso.size()>0){
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,  listaLugaresNacimiento, nombreRecursoSeleccionado, tipoInformacionSolicitada, listaNombreAutor, autorSeleccionadoPorLugarNac, datosGlobalesRecurso);
						}
						else{//Si no hay datos de ese libro
							responseData = "No hay datos que recuperar: \n No se dispone de informaci�n adicional sobre ese autor";
						}
						}
				} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
					e.printStackTrace();
				}	
			}	
		}
		} 
		else if ((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos"))
				&& tipoRecursoSobreElQueSeSolicitaInformacion != null
				&& (tipoSede != null || tipoInformacionSolicitada != null) && tipoSede==null) {
			if (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro") && tipoInformacionSolicitada != null) {
				try {// Si se selecciona libro hay que mostrar la lista de
					//lista de nombres de autores
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							listaNombreLibros);
				} catch (TemplateException e) {
					e.printStackTrace();
				}
			} 
		}
		//Se ha seleccionado ventas o datos y encima para libro se ha seleccionado el tipo de sede
		else if ((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos"))
				&& tipoRecursoSobreElQueSeSolicitaInformacion != null
				&& (tipoSede != null || tipoInformacionSolicitada != null)) {
			if (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro") && tipoInformacionSolicitada == null && tipoSede!=null) {
				//Si ya se ha seleccionado el tipo de sede
				try {// Si se selecciona libro hay que mostrar la lista de
					//lista de nombres de autores
					if(tipoSede.equalsIgnoreCase("Totales")){//Aqui acaba	
					List<String> datosFinales = stardog.getDatosNumVentasTotalesEnTodasLasSedesLibro(nombreRecursoSeleccionado);
					if(datosFinales.size()>1){
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							listaNombreLibros, nombreRecursoSeleccionado, tipoSede, datosFinales);
					}
					else{//Si no se ha vendido ningun ejemplar
						datosFinales = new ArrayList<>();
						datosFinales.add(nombreRecursoSeleccionado);
						datosFinales.add("0");
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
								listaNombreLibros, nombreRecursoSeleccionado, tipoSede, datosFinales);
					}
					}
					else if(!tipoSede.equalsIgnoreCase("Totales")){//Si selecciona ventas libro y se ha seleccionado sede
						if(nombreSedeSeleccionada==null){
							listaSedes=stardog.getSedesNames();
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
								listaNombreLibros, nombreRecursoSeleccionado, tipoSede, listaSedes);
						}
						else{
							List<String> datosFinales = stardog.getDatosNumVentasTotalesEnSedeConcretaLibro(nombreRecursoSeleccionado, nombreSedeSeleccionada);
							if(datosFinales!=null){
							responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
									listaNombreLibros, nombreRecursoSeleccionado, tipoSede, listaSedes, nombreSedeSeleccionada, datosFinales);
							}else{//si no hay datos
								datosFinales= new ArrayList<>();
								datosFinales.add(nombreRecursoSeleccionado);
								datosFinales.add(nombreSedeSeleccionada);
								datosFinales.add("0");
								responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
										listaNombreLibros, nombreRecursoSeleccionado, tipoSede, listaSedes, nombreSedeSeleccionada, datosFinales);
							}
							}
					}
				} catch (TemplateException | RepositoryException | MalformedQueryException | QueryEvaluationException | TupleQueryResultHandlerException | UnsupportedQueryResultFormatException e) {
					e.printStackTrace();
				}
			} else if (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoSede!=null && nombreRecursoSeleccionado!=null){
				if(tipoSede.equalsIgnoreCase("Sede")){
				if(nombreSedeSeleccionada==null){
				try {
					listaSedes=stardog.getSedesNames();
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaLugaresNacimiento, nombreRecursoSeleccionado, tipoInformacionSolicitada, tipoSede, listaSedes);

				} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
					e.printStackTrace();
				}}else if(nombreSedeSeleccionada!=null) {
					try {
						List<String> datosFinales= stardog.getDatosNumVentasTotalesEnSedeConcretaPorAutorySede(nombreRecursoSeleccionado, nombreSedeSeleccionada);
						if(datosFinales.size()>1){
						responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaNombreAutor, nombreRecursoSeleccionado, tipoInformacionSolicitada, listaSedes, nombreSedeSeleccionada, datosFinales);
						}else{
							datosFinales= new ArrayList<>();
							datosFinales.add(nombreRecursoSeleccionado);
							datosFinales.add(nombreSedeSeleccionada);
							datosFinales.add("0");
							responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaNombreAutor, nombreRecursoSeleccionado, tipoInformacionSolicitada, listaSedes, nombreSedeSeleccionada, datosFinales);
						}
						} catch (TemplateException | RepositoryException | MalformedQueryException | QueryEvaluationException e) {
						e.printStackTrace();
					}
				}
				}
				else if(tipoSede.equalsIgnoreCase("Totales")){
					try {
						
						List<String> datosFinales=stardog.getDatosNumVentasTotalesEnTodasLasSedesByAuthor(nombreRecursoSeleccionado);
						if(datosFinales.size()>1){
						responseData= generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaNombreAutor, nombreRecursoSeleccionado, tipoInformacionSolicitada, tipoSede,datosFinales);
						}
						else{
							datosFinales= new ArrayList<>();
							datosFinales.add(nombreRecursoSeleccionado);
							datosFinales.add("0");
							responseData= generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion, listaNombreAutor, nombreRecursoSeleccionado, tipoInformacionSolicitada, tipoSede,datosFinales);
						}
						} catch (TemplateException | RepositoryException | MalformedQueryException | QueryEvaluationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
		
		System.out.println(responseData + "vacio joder");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(responseData);
	}
}