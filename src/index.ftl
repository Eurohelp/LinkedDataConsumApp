<form name="form" id="form">
		<#if tipoConsulta?has_content &&  tipoConsulta == "null">
		<div class="panel list-group">
     &iquest;Qu&eacute; deseas consultar?1
	<select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos">Datos</option>
	</select>
	</div>
</form>
<#elseif tipoConsulta?has_content &&  tipoConsulta == "Ventas">
<div class="panel list-group">
     &iquest;Qu&eacute; deseas consultar?1
	<select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas" selected>Ventas</option>
		<option value="Datos">Datos</option>
	</select>
	</div>
</form>
	<#--Tipo recurso-->
<#if !tipoInfoConcreta?has_content>
	<#--Si aun no se selecciona nada-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select> 
<#elseif tipoInfoConcreta?has_content &&  tipoInfoConcreta=="Libro">
	<#--Si ya se ha seleccionado libro-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Autor">Autor</option>
					</select> 
Elige una opci&oacute;n:
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
								</#if>
</#list></select>
	
	
<#elseif tipoInfoConcreta?has_content &&  tipoInfoConcreta=="Autor">
	<#--Si ya se ha seleccionado autor-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor" selected>Autor</option>
					</select> 
</#if>



<#---------------------------------------------------------------------------------------------------------------------------------------------------------->


<#elseif tipoConsulta?has_content &&  tipoConsulta == "Datos">
<div class="panel list-group">
     &iquest;Qu&eacute; deseas consultar?1
	<select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos" selected>Datos</option>
	</select>
	</div>
</form>
	<#--Tipo recurso-->
<#if !tipoInfoConcreta?has_content>
	<#--Si aun no se selecciona nada-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select> 
<#elseif tipoInfoConcreta?has_content &&  tipoInfoConcreta=="Libro">
	<#--Si ya se ha seleccionado libro-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
						<option value="Autor">Autor</option>
					</select> 
				
<#elseif tipoInfoConcreta?has_content &&  tipoInfoConcreta=="Autor">
	<#--Si ya se ha seleccionado autor-->
&iquest;Sobre qu&eacute; tipo de recurso?
				<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor" selected>Autor</option>
					</select> 
</#if>
</#if>