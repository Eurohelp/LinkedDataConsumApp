<form name="form" id="form">
		<#if tipoConsulta?has_content &&  tipoConsulta == "null" && !tipoInfoConcreta?has_content>
     <div class="panel list-group">
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas">Ventas</option>
			<option value="Datos">Datos</option>
		</select>
		</#if>
		<#if tipoConsulta?has_content &&  tipoConsulta == "Ventas" && !tipoInfoConcreta?has_content>
		<div class="panel list-group">
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
		<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && !listaNombreSedes?has_content>
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
						<option value="${nombre}">${nombre}</option>
             </#list>
	</select> 
	<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select>
					</#if>
         </#if>
		<#if tipoConsulta?has_content && tipoConsulta == "Ventas" && tipoInfoConcreta?has_content && datosSolicitados?has_content && NombreRecurso?has_content && listaNombreSedes?has_content>
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
 						<option value="${nombre}" selected>${nombre}</option>
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
 						<option value="${nombre}" selected>${nombre}</option>
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
     </div>
 </form>