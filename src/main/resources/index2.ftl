	<form name="form" id="form">
		<#if tipoConsulta?has_content &&  tipoConsulta == "null" && !tipoInfoConcreta?has_content !datosSolicitados?has_content && !NombreRecurso?has_content>
		<#-- Si no se ha seleccionado nada aún -->
<div class="panel list-group">
     ¿Qué deseas ssssssssssssssssssssssssconsultar?
	<select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos">Datos</option>
	</select>
</#if>
<#-- Si ya se ha seleccionado entre ventas y datos -->
<#if tipoConsulta?has_content && !tipoInfoConcreta?has_content && !datosSolicitados?has_content && !NombreRecurso?has_content>
<#if tipoConsulta == "Ventas">
<#-- Si se ha seleccionado Ventas-->
		<div class="panel list-group">
		     ¿Qué deseas consultdddddddddddddddddddar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion" >
			<option value="Ventas" selected>Ventas</option>
		</select>
		¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select> 
	<#elseif tipoConsulta == "Datos">
	<#-- Si se ha seleccionado Datos y ya se tiene el nombre del recurso a mostrar-->
	<div class="panel list-group">
	     ¿Qué deseas consultadffffffffffffffr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
				¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
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
		</select>
		¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select>
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
	<#elseif tipoConsulta == "Datos">
	<div class="panel list-group">
	     ¿Qué deseas consultasdsdsdsdsdsdsdsdsdsdsdsdsdsdsdr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
		¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select>
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
 					<option value="${nombre}">${nombre}</option>
		</#list>
</select>
</#if>
<#elseif tipoInfoConcreta=="Autor" && !tipoDatoRecursoSolicitado?has_content && !listaNombreRecursos?has_content && !NombreRecurso?has_content>
<#if tipoConsulta == "Ventas">
<div class="panel list-group">
		     ¿Qué deseas conssdvvvvvvvvvultar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
	<#elseif tipoConsulta == "Datos">
	<div class="panel list-group">
	     ¿Qué deseas consultasdsdsdsdsdsdsdsdsdsdsdsdsdsdsdr?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
		</#if>
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select> 
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre">Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select>
</#if>
</#if>
<#-- Se ha seleccionado de la lista de libros un titulo o de la lista de autores un lugar de nacimiento o un nombre de autor-->
<#if tipoConsulta?has_content && tipoInfoConcreta?has_content && !datosSolicitados?has_content && !listaDatosTotales?has_content && (listaNombreRecursos?has_content || NombreRecurso?has_content)>

<#if tipoConsulta=="Datos" && tipoInfoConcreta=="Libro" && NombreRecurso?has_content>
perritoooooooooooooooooooooooooo
<#elseif tipoSede?has_content && tipoInfoConcreta=="Libro" && NombreRecurso?has_content && tipoSede?has_content><#--Corresponde al libro-->
¿Qué deseas consuldsssssssssssstar?MIKELLLLLLL
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select><#--COMPLETARRRRRRRRRRRRRRRRRR HAY QUE DIFERENCIAR ENTRE VENTAS Y DATOS Y PROCESARLO YA-->
			<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
		 <#if NombreRecurso == "${nombre}">
 		 			<option value="${nombre}" selected>${nombre}</option>
 		</#if></#list>
					</select>

¿De qué sede quieres recibir la información?

<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
<#if tipoSede=="Sede">
<#if !sedeSeleccionada?has_content>
						<option value="Sede" selected>Sede</option>
						</select>
						<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 	<option value="${nombreSede}">${nombreSede}</option>
								 
						</#list>
</select>
</#if>

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
<#elseif tipoInfoConcreta=="Autor" && listaNombreRecursos?has_content && !NombreRecurso?has_content>
<#if tipoConsulta=="Datos">
<div class="panel list-group">
¿Qué deseas consuldsssssssssssxxxxxxxxxstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
		<#else>
		<div class="panel list-group">
		¿Qué deseas consuldsssssssssssxxxxsadsdffxxxxxstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
		</#if>
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
<#if tipoDatoRecursoSolicitado=="Nombre"><#--Corresponde al AUTOR y se ha solicitado nombre-->
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select>
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					 <#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>

<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede">Sede</option>
								 	<option value="Totales">Todas las sedes</option>
</select>
<#elseif tipoDatoRecursoSolicitado=="NacidoEn"><#--Corresponde al libro y se ha solicitado lugar nacimiento-->
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
										<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
</#if>
</#if>
</#if>
<#--Si se ha seleccionado datos y autor/libro y ya se ha seleccionado el recurso-->
<#if tipoConsulta=="Datos" && listaNombreRecursos?has_content && listaDatosTotales?has_content && !sedeSeleccionada?has_content>
<div class="panel list-group">
¿Qué deseas consuldssdfvstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
<#if tipoInfoConcreta=="Libro">
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select>
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
								</#if>
</#list></select>
<#elseif tipoInfoConcreta=="Autor">
¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
<#if tipoDatoRecursoSolicitado=="Nombre">					
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select>
<#else>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
</#if>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
								</#if>
</#list></select>
</#if>

<#--Aqui se muestra la tabla correspondiente dependiendo del tipo si es libro o si es de un autor-->
<#if tipoInfoConcreta=="Libro">
<div class="queryResults" id="queryResults">
<table id="resultTable" name="resultTable">
	<tr>
    <th>Libro</th>
    <th>Autor</th>
    <th>Descripcion</th>
  </tr>
   <tr>
   <#list listaDatosTotales as dato>
    <td>${dato}</td>
       <#if listaDatosTotales?size<3> <#--Si no se disponen de datos para ese libro -->
    <td>-</td>    
</#if>
  </#list>
  </tr>
	</table>
	</div>  					
<#elseif tipoInfoConcreta=="Autor" && tipoDatoRecursoSolicitado=="Nombre">
<div class="queryResults" id="queryResults">
<table id="resultTable" name="resultTable">
	<tr>
    <th>Autor</th>
    <th>Descripcion</th>
  </tr>
   <tr>
   <#list listaDatosTotales as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>  
<#elseif tipoInfoConcreta=="Autor" && tipoDatoRecursoSolicitado=="NacidoEn">
<select class="form-control" id="tipoInformacion-Datos-LugarNac-Autor" name="tipoInformacion-Datos-LugarNac-Autor">
					<#list listaNombreSedes as nombre> 				 				
								<option value="${nombre}">${nombre}</option>
</#list></select>

</#if>
</#if>
<#-- Si se ha seleccionado datos, lugar nacim, -->
<#if (tipoConsulta=="Datos") && listaNombreRecursos?has_content && listaNombreSedes?has_content>
<div class="panel list-group">
¿Qué deseas consuldssdfddddffddddvstar?

         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
		¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>

<select class="form-control" id="tipoInformacion-Datos-LugarNac-Autor" name="tipoInformacion-Datos-LugarNac-Autor">
						<#if sedeSeleccionada?has_content>
						<#list listaNombreSedes as nombre>
						<#if sedeSeleccionada = "${nombre}">
								<option value="${nombre}" selected>${nombre}</option>						
</#if>
	</#list>
	<#else>
							<#list listaNombreSedes as nombre>
								<option value="${nombre}">${nombre}</option>						
	</#list>
	</#if>
</select>

	<#if listaDatosTotales?has_content>
	<div class="queryResults" id="queryResults">
<table id="resultTable" name="resultTable">
	<tr>
    <th>Autor</th>
    <th>Descripcion</th>
  </tr>
   <tr>
   <#list listaDatosTotales as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>  
	</#if>				
</#if>

<#if tipoConsulta=="Ventas" && listaNombreRecursos?has_content && listaNombreSedes?has_content && !sedeSeleccionada?has_content>
<div class="panel list-group">
¿Qué deseas consuldssdfdsvvvvvvvvvvvvvascsdddvstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
		
<#if tipoInfoConcreta=="Autor">
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select> 
					
					<#if tipoDatoRecursoSolicitado=="Nombre">
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select>
<#elseif tipoDatoRecursoSolicitado=="NacidoEn">					
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
</#if>
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>
<#if tipoSede=="Sede">
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede" selected>Sede</option>
</select>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
<#list listaNombreSedes as nombre>
 				 				<option value="${nombre}">${nombre}</option>
</#list>
</select>
</#if>
</#if>
</#if>

<#if tipoConsulta=="Ventas" && listaNombreRecursos?has_content && listaDatosTotales?has_content && tipoDatoRecursoSolicitado=="NacidoEn">
<div class="panel list-group">
¿Qué deseas consuldssdfdsdstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
		
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select> 
		
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>

<select class="form-control" id="tipoInformacion-Datos-LugarNac-Autor" name="tipoInformacion-Datos-LugarNac-Autor">
					<#list listaDatosTotales as nombre>
 				 				<option value="${nombre}">${nombre}</option>
</#list></select>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede">Sede</option>
								 	<option value="Totales">Todas las sedes</option>
</select>

</#if>

<#if tipoConsulta=="Ventas" && listaNombreRecursos?has_content && listaDatosTotales?has_content && sedeSeleccionada?has_content>
¿Qué deseas consuldssdfddddfvvvvvvvvvvvvadafbagthy5efddddvstar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>

<#if tipoInfoConcreta=="Libro">
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select> 
						<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>
<#else> <#-- Si se selecciona autor-->
¿Sobre qué tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select> 
<#if tipoDatoRecursoSolicitado=="NacidoEn"><#--Corresponde al libro y se ha solicitado lugar nacimiento-->
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
										<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
<#elseif tipoDatoRecursoSolicitado=="Nombre">
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
</select>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
</#if>
</#if>
<#if sedeSeleccionada?has_content>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede" selected>Sede</option>
</select>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 <#if sedeSeleccionada == "${nombreSede}">
								 	<option value="${nombreSede}" selected>${nombreSede}</option>
								 </#if>
						</#list>
</select>
<#else>
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Totales" selected>Todas las sedes</option>
</select>
</#if>

						
<div class="queryResults" id="queryResults"><table id="resultTable" name="resultTable">
	<tr>
    <th>Recurso</th>
    <th>Sede</th>
    <th>TotalVentas</th>
  </tr>
   <tr>
   <#list listaDatosTotales as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>
</#if>

<#-- Se dispone para que puedan seleccionar titulo o nombre del recurso del que quieran obtener información-->
</div>
 </form>
<div class="buttonSubmitClass">
			<input type="submit" class="btn btn-primary" value="Ejecutar"
				onclick="getData()">
</div>