	<form name="form" id="form">
		<#if tipoConsulta?has_content &&  tipoConsulta == "null" && !tipoInfoConcreta?has_content !datosSolicitados?has_content>
		<#-- Si no se ha seleccionado nada aún -->
<div class="panel list-group">
     ¿Qué deseas ssssssssssssssssssssssssconsultar?
	<select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos">Datos</option>
	</select>
</#if>
<#-- Si ya se ha seleccionado entre ventas y datos -->
<#if tipoConsulta?has_content && !tipoInfoConcreta?has_content && !datosSolicitados?has_content >
<#if tipoConsulta == "Ventas">
<#-- Si se ha seleccionado Ventas-->
		<div class="panel list-group">
		     ¿Qué deseas consultdddddddddddddddddddar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
	<#elseif tipoConsulta == "Datos">
	<#-- Si se ha seleccionado Datos-->
	<div class="panel list-group">
	     ¿Qué deseas consultadffffffffffffffr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas">Ventas</option>
			<option value="Datos" selected>Datos</option>
		</select>
				¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
		</#if>
</#if>
	<#-- Si ya se ha seleccionado el tipo de consulta y sobre qué tipo de datos desea obtener infomacion-->
<#if tipoConsulta?has_content && tipoInfoConcreta?has_content && !datosSolicitados?has_content && !NombreRecurso?has_content>
<#if tipoInfoConcreta=="Libro" && listaNombreRecursos?has_content && !listaNombreSedes?has_content && !tipoSede?has_content>
<#if tipoConsulta == "Ventas">
<div class="panel list-group">
		     ¿Qué deseas conssxxxxxxxxxxxxxltar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
	<#elseif tipoConsulta == "Datos">
	<div class="panel list-group">
	     ¿Qué deseas consultasdsdsdsdsdsdsdsdsdsdsdsdsdsdsdr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas">Ventas</option>
			<option value="Datos" selected>Datos</option>
		</select>
		</#if>
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select>
Título:
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
 <#list listaNombreRecursos as nombre>
 					<option value="${nombre}">${nombre}</option>
</#list>
</select>
¿De qué sede quieres recibir la información?
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select>
<#elseif tipoInfoConcreta=="Autor" && !tipoDatoRecursoSolicitado?has_content && !listaNombreRecursos?has_content && !NombreRecurso?has_content>
<#if tipoConsulta == "Ventas">
<div class="panel list-group">
		     ¿Qué deseas conssdvvvvvvvvvultar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
	<#elseif tipoConsulta == "Datos">
	<div class="panel list-group">
	     ¿Qué deseas consultasdsdsdsdsdsdsdsdsdsdsdsdsdsdsdr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas">Ventas</option>
			<option value="Datos" selected>Datos</option>
		</select>
		</#if>
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor" selected>Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre">Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select>
</#if>
</#if>

<#-- Se ha seleccionado de la lista de libros un titulo o de la lista de autores un lugar de nacimiento o un nombre de autor-->
<#if tipoConsulta?has_content && tipoInfoConcreta?has_content && !datosSolicitados?has_content && (listaNombreRecursos?has_content || NombreRecurso?has_content)>
<#if tipoSede?has_content && tipoInfoConcreta=="Libro" && NombreRecurso?has_content && tipoSede?has_content><#--Corresponde al libro-->
¿Qué deseas consuldsssssssssssstar?MIKELLLLLLL
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select><#--COMPLETARRRRRRRRRRRRRRRRRR HAY QUE DIFERENCIAR ENTRE VENTAS Y DATOS Y PROCESARLO YA-->
			<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
		 <#if NombreRecurso == "${nombre}">
 					<option value="${nombre}" selected>${nombre}</option>
 		<#else>
 		 			<option value="${nombre}">${nombre}</option>
 		</#if></#list>
					</select>

¿De qué sede quieres recibir la información?
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
<#if tipoSede=="Sede">
						<option value="Sede" selected>Sede</option>
						</select>
						<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 						<option value="${nombreSede}" selected>${nombreSede}</option>
								 
						</#list>
</select>
						<#else><#--Si selecciona ventas/datos libro sede totales-->
						<option value="Totales" selected>Todas las sedes</option>
						</select>
						<div class="queryResults" id="queryResults"><table id="resultTable" name="resultTable">
	<tr>
    <th>Libro</th>
    <th>TotalVentas</th>
  </tr>
   <tr>
   <#list listaNombreSedes as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>  	
</#if>
					


<#elseif tipoInfoConcreta=="Autor" && listaNombreRecursos?has_content>
¿Qué deseas consuldsssssssssssstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor" selected>Autor</option>
						<option value="Cantante">Cantante</option>
					</select>
<#if tipoDatoRecursoSolicitado=="Nombre"><#--Corresponde al AUTOR y se ha solicitado nombre-->
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select>
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					 <#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
<#elseif tipoDatoRecursoSolicitado=="NacidoEn"><#--Corresponde al libro y se ha solicitado lugar nacimiento-->
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre">Nombre</option>
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
										<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
</#if>
</#if>
</#if>
<#-- Se dispone para que puedan seleccionar titulo o nombre del recurso del que quieran obtener información-->
</div>
 </form>
<div class="buttonSubmitClass">
			<input type="submit" class="btn btn-primary" value="Ejecutar"
				onclick="getData()">
</div>