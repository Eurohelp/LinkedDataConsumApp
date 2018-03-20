<form name="form" id="form">
		<#if tipoConsulta?has_content &&  tipoConsulta == "null" && !tipoInfoConcreta?has_content>
     <div class="panel list-group">
     ¿Qué deseas consultar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas">Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		</#if>
		<#if tipoConsulta?has_content &&  tipoConsulta == "Ventas" && !tipoInfoConcreta?has_content>
		<div class="panel list-group">
		¿Qué deseas consultar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
         </#if>
		<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && !datosSolicitados?has_content>
		 <#if  tipoInfoConcreta=="Autor">
		 		<div class="panel list-group">
		 <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
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
			<#else>
				<div class="panel list-group">
		 <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre">Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				</#if>
         </#if>
		<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && !listaNombreSedes?has_content && !listaDatos?has_content>
            <#if tipoInfoConcreta=="Autor" && datosSolicitados=="Nombre"> 
            <div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor" selected>Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
						<option value="${nombre}">${nombre}</option>
             </#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select>
					<#elseif tipoInfoConcreta=="Libro" && datosSolicitados=="Nombre">
					  <div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
						<option value="${nombre}">${nombre}</option>
             </#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select>
					</#if>
         </#if>
		<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && NombreRecurso?has_content && listaNombreSedes?has_content && !listaDatos?has_content>
				 <#if tipoInfoConcreta=="Autor" && datosSolicitados=="Nombre">
		  <div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor" selected>Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
             <#if NombreRecurso=="${nombre}">
						<option value="${nombre}" selected>${nombre}</option>
 			<#else>
 						<option value="${nombre}" >${nombre}</option>
 				</#if>            	
</#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede" selected>Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select> 
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
			<#list listaNombreSedes as nombreSede>
						<option value="${nombreSede}">${nombreSede}</option>
</#list>
	</select> 
	<#elseif tipoInfoConcreta=="Libro" && datosSolicitados=="Nombre">
	<div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
             <#if NombreRecurso=="${nombre}">
						<option value="${nombre}" selected>${nombre}</option>
 			<#else>
 						<option value="${nombre}">${nombre}</option>
 				</#if>            	
</#list>

	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede" selected>Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select> 
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
			<#list listaNombreSedes as nombreSede>
						<option value="${nombreSede}">${nombreSede}</option>
</#list>
	</select> 
</#if>
</#if>

<#-- Si selecciona todas las sedes -->
<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && NombreRecurso?has_content && !listaNombreSedes?has_content && listaDatos?has_content && sedeSeleccionada=="Totales">
				 <#if tipoInfoConcreta=="Libro" && datosSolicitados=="Nombre" >
		  <div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
             <#if NombreRecurso=="${nombre}">
						<option value="${nombre}" selected>${nombre}</option>
 			<#else>
 						<option value="${nombre}" >${nombre}</option>
 				</#if>            	
</#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales" selected>Todas las sedes</option>
					</select>
	<div class="queryResults" id="queryResults"><table id="resultTable" name="resultTable">
	<tr>
    <th>Libro</th>
    <th>TotalVentas</th>
  </tr>
   <tr>
   <#list listaDatos as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>  	
</#if>
</#if>


<#-- El ultimo -->
<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && NombreRecurso?has_content && listaNombreSedes?has_content && listaDatos?has_content && sedeSeleccionada!="Totales">
				 <#if tipoInfoConcreta=="Autor" && datosSolicitados=="Nombre" >
		  <div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor" selected>Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
             <#if NombreRecurso=="${nombre}">
						<option value="${nombre}" selected>${nombre}</option>
 			<#else>
 						<option value="${nombre}" >${nombre}</option>
 				</#if>            	
</#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede" selected>Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select> 
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
			<#list listaNombreSedes as nombreSede>
			             <#if sedeSeleccionada=="${nombreSede}">
						<option value="${nombreSede}" selected>${nombreSede}</option>
						<#else>			
						<option value="${nombreSede}">${nombreSede}</option>			
						</#if>
</#list>
	</select> 
	<#else>
	<div class="panel list-group">
              <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Disco">Disco</option>
						<option value="Autor">Autor</option>
						<option value="Cantante">Cantante</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select> 
				<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
             <#list listaNombreRecursos as nombre>
             <#if NombreRecurso=="${nombre}">
						<option value="${nombre}" selected>${nombre}</option>
 			<#else>
 						<option value="${nombre}">${nombre}</option>
 				</#if>            	
</#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede" selected>Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select> 
		<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
			<#list listaNombreSedes as nombreSede>
						<#if sedeSeleccionada=="${nombreSede}">
						<option value="${nombreSede}" selected>${nombreSede}</option>
						<#else>			
						<option value="${nombreSede}">${nombreSede}</option>			
						</#if>
</#list>
	</select>
		<div class="queryResults" id="queryResults"><table id="resultTable" name="resultTable">
	<tr>
    <th>Libro</th>
    <th>Sede</th>
    <th>TotalVentas</th>
  </tr>
   <tr>
   <#list listaDatos as dato>
    <td>${dato}</td>
  </#list>
  </tr>
	</table>
	</div>
	</#if>
</#if>
     </div>
 </form>
<div class="buttonSubmitClass">
			<input type="submit" class="btn btn-primary" value="Ejecutar"
				onclick="getData()">
		</div>