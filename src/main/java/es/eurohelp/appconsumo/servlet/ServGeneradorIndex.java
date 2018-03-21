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
		System.out.println();
		GeneradorIndex generadorIndex = new GeneradorIndex();
		Stardog stardog = new Stardog();
		String tipoConsulta = request.getParameter("tipoInformacion");
		System.out.println(tipoConsulta);
		String tipoRecursoSobreElQueSeSolicitaInformacion = request.getParameter("tipoInformacion-Ventas");
		String tipoInformacionSolicitada = request.getParameter("tipoInformacion-Ventas-Autor-Cantante");
		String tipoSede = request.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede");
		String nombreRecursoSeleccionado = request.getParameter("tipoInformacion-Ventas-Autor-Nombre");
		String tipoInformacionVentasAutorNombreSedeSeleccionado = request
				.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede-Sede");

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
				&& tipoRecursoSobreElQueSeSolicitaInformacion != null) {
			if(tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoInformacionSolicitada==null){
				try {
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion);
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor") && tipoInformacionSolicitada!=null) {
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
			} else {//Aqui entra si se selecciona libro para que salgan los titulos
				try {
					listaNombreLibros = stardog.getBooksNames();
					responseData = generadorIndex.generarIndex(tipoConsulta, tipoRecursoSobreElQueSeSolicitaInformacion,
							listaNombreLibros);
				} catch (TemplateException | RepositoryException | MalformedQueryException | QueryEvaluationException e) {
					e.printStackTrace();
				}
			}//Si se selecciona ventas o datos y el tipo de datos
		} 
		else if ((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos"))
				&& tipoRecursoSobreElQueSeSolicitaInformacion != null
				&& (tipoSede != null || tipoInformacionSolicitada != null)) {
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

		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede == null) {
		// try {
		// listaNombreAutor = stardog.getAuthorsNames();
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreAutor);
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException | TemplateException e) {
		// e.printStackTrace();
		// }
		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede.equals("Sede")) {
		// try {
		// listaSedes = stardog.getSedesNames();
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreAutor,
		// nombreRecursoSeleccionado, listaSedes);
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException | TemplateException e) {
		// e.printStackTrace();
		// }
		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Autor")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede.equals("Sede")
		// && tipoInformacionVentasAutorNombreSedeSeleccionado != null) {
		// try {
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreAutor,
		// nombreRecursoSeleccionado, listaSedes,
		// tipoInformacionVentasAutorNombreSedeSeleccionado);
		//
		// } catch (TemplateException e) {
		// e.printStackTrace();
		// }
		// }
		// // Ahora para libros
		// else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// (tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro"))
		// && tipoInformacionSolicitada == null) { // Si se
		// // selecciona
		// // ventas y
		// // autor/cantante
		// try {
		// System.out.println(1);
		//
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion);
		// } catch (TemplateException e) {
		// e.printStackTrace();
		// }
		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede == null) {
		// try {
		// System.out.println(2);
		//
		// listaNombreLibros = stardog.getBooksNames();
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreLibros);
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException | TemplateException e) {
		// e.printStackTrace();
		// }
		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede.equals("Sede")
		// && tipoInformacionVentasAutorNombreSedeSeleccionado == null) {
		// try {
		// System.out.println(3);
		//
		// listaSedes = stardog.getSedesNames();
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreLibros,
		// nombreRecursoSeleccionado, listaSedes);
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException | TemplateException e) {
		// e.printStackTrace();
		// }
		// } else if (tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede.equals("Sede")
		// && tipoInformacionVentasAutorNombreSedeSeleccionado != null) {
		// try { // si fin no se cambia la tabla
		// System.out.println(4);
		// if (tipoInformacionVentasAutorNombreSedeSeleccionado != "Totales") {
		// List<String> listaDatos =
		// stardog.getDatosNumVentasTotalesEnSedeConcretaResource(
		// nombreRecursoSeleccionado,
		// tipoInformacionVentasAutorNombreSedeSeleccionado);
		// if (listaDatos == null) {
		// responseData = "No hay datos que recuperar: \nNo se han vendido
		// ejemplares de "
		// + nombreRecursoSeleccionado + " en la sede de "
		// + tipoInformacionVentasAutorNombreSedeSeleccionado;
		// } else {
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreLibros,
		// nombreRecursoSeleccionado,
		// tipoInformacionVentasAutorNombreSedeSeleccionado,listaDatos);
		// }
		// }
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException
		// | TupleQueryResultHandlerException |
		// UnsupportedQueryResultFormatException | TemplateException e) {
		// e.printStackTrace();
		// }
		// }
		// else if(tipoConsulta.equalsIgnoreCase("Ventas") &&
		// tipoRecursoSobreElQueSeSolicitaInformacion.equalsIgnoreCase("Libro")
		// && tipoInformacionSolicitada.equalsIgnoreCase("Nombre")
		// && tipoSede.equals("Totales")
		// && tipoInformacionVentasAutorNombreSedeSeleccionado == null){
		// List<String> listaDatos;
		// try {
		// listaDatos =
		// stardog.getDatosNumVentasTotalesEnTodasLasSedesResource(nombreRecursoSeleccionado);
		// responseData = generadorIndex.generarIndex(tipoConsulta,
		// tipoRecursoSobreElQueSeSolicitaInformacion,
		// tipoInformacionSolicitada, listaNombreLibros,
		// nombreRecursoSeleccionado,
		// tipoSede, listaDatos);
		// } catch (RepositoryException | MalformedQueryException |
		// QueryEvaluationException | TemplateException e) {
		// e.printStackTrace();
		// }
		// }
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(responseData);
	}
}