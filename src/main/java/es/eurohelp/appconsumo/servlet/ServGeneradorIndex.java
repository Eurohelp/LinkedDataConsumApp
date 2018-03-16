package es.eurohelp.appconsumo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
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
		String tipoInformacionDatos = request.getParameter("tipoInformacion-Datos");
		String tipoInformacionVentas = request.getParameter("tipoInformacion-Ventas");
		String tipoInformacionVentasAutorCantante = request.getParameter("tipoInformacion-Ventas-Autor-Cantante");
		String tipoInformacionVentasAutorNombreSede = request.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede");
		String tipoInformacionVentasAutorNombreSeleccionado = request.getParameter("tipoInformacion-Ventas-Autor-Nombre");
		String tipoInformacionVentasAutorNombreSedeSeleccionado = request.getParameter("tipoInformacion-Ventas-Autor-Nombre-Sede-Sede");

		String responseData ="";
		if(tipoConsulta==null){//Si es la primera vez que se ejecuta
			try {
				responseData = generadorIndex.generarIndex("null");
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		else if((tipoConsulta.equalsIgnoreCase("Ventas") || tipoConsulta.equalsIgnoreCase("Datos")) && tipoInformacionVentas==null){
			try {
				responseData = generadorIndex.generarIndex(tipoConsulta);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && (tipoInformacionVentas.equalsIgnoreCase("Autor") || tipoInformacionVentas.equalsIgnoreCase("Cantante")) && tipoInformacionVentasAutorCantante==null){ //Si se selecciona ventas y autor/cantante
			try {
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && tipoInformacionVentas.equalsIgnoreCase("Autor") && tipoInformacionVentasAutorCantante.equalsIgnoreCase("Nombre") && tipoInformacionVentasAutorNombreSede==null){
			try {
				listaNombreAutor = stardog.getAuthorsNames();
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas, tipoInformacionVentasAutorCantante, listaNombreAutor);
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && tipoInformacionVentas.equalsIgnoreCase("Autor") && tipoInformacionVentasAutorCantante.equalsIgnoreCase("Nombre") && tipoInformacionVentasAutorNombreSede.equals("Sede") ){
			try {
				listaSedes = stardog.getSedesNames();
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas, tipoInformacionVentasAutorCantante, listaNombreAutor, tipoInformacionVentasAutorNombreSeleccionado, listaSedes);
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && tipoInformacionVentas.equalsIgnoreCase("Autor") && tipoInformacionVentasAutorCantante.equalsIgnoreCase("Nombre") && tipoInformacionVentasAutorNombreSede.equals("Sede") && tipoInformacionVentasAutorNombreSedeSeleccionado!=null){
			try {
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas, tipoInformacionVentasAutorCantante, listaNombreAutor, tipoInformacionVentasAutorNombreSeleccionado, listaSedes, tipoInformacionVentasAutorNombreSedeSeleccionado);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		//Ahora para libros
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && (tipoInformacionVentas.equalsIgnoreCase("Libro")) && tipoInformacionVentasAutorCantante==null){ //Si se selecciona ventas y autor/cantante
			try {
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && tipoInformacionVentas.equalsIgnoreCase("Libro") && tipoInformacionVentasAutorCantante.equalsIgnoreCase("Nombre") && tipoInformacionVentasAutorNombreSede==null){
			try {
				listaNombreLibros = stardog.getBooksNames();
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas, tipoInformacionVentasAutorCantante, listaNombreLibros);
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}
		}
		else if(tipoConsulta.equalsIgnoreCase("Ventas") && tipoInformacionVentas.equalsIgnoreCase("Libro") && tipoInformacionVentasAutorCantante.equalsIgnoreCase("Nombre") && tipoInformacionVentasAutorNombreSede.equals("Sede") ){
			try {
				listaSedes = stardog.getSedesNames();
				responseData = generadorIndex.generarIndex(tipoConsulta, tipoInformacionVentas, tipoInformacionVentasAutorCantante, listaNombreLibros, tipoInformacionVentasAutorNombreSeleccionado, listaSedes);
			} catch (RepositoryException | MalformedQueryException | QueryEvaluationException | TemplateException e) {
				e.printStackTrace();
			}
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(responseData);
	}
}
