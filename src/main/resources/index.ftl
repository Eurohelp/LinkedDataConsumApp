<form name="form" id="form" class="form">
<#if tipoConsulta?has_content && tipoConsulta=="null">
<div class="panel list-group">                
           <h7>&iquest;Qu&eacute; deseas consultar?</h7>
                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos">Datos</option>
	</select>
	</div>
</form>





   <#----------------------------------------------------------------------------------------------------------------------------------------------->
<#elseif tipoConsulta?has_content && tipoConsulta=="Ventas">
<div class="panel list-group">                
           <h7>&iquest;Qu&eacute; deseas consultar?</h7>
                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas" selected>Ventas</option>
	</select>
<#if !tipoInfoConcreta?has_content>
<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                     <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
<#elseif tipoInfoConcreta?has_content && tipoInfoConcreta=="Libro">
<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                     <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select>
	<#if listaNombreRecursos?has_content && !NombreRecurso?has_content && !tipoSede?has_content>
<h7>Elige una opci&oacute;n:</h7>
         <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
 			<option value="${nombre}">${nombre}</option>
		</#list>
</select>
<h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede">Sede</option>
						<option value="Totales">Todas las sedes</option>
					</select>
					
	<#elseif listaNombreRecursos?has_content && NombreRecurso?has_content && tipoSede?has_content>
	<h7>Elige una opci&oacute;n:</h7>
         <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
		 <#if NombreRecurso=="${nombre}">
 			<option value="${nombre}" selected>${nombre}</option>
		</#if>		
</#list>
</select>
<#if tipoSede=="Sede">
<h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Sede" selected>Sede</option>
					</select>
					
	<#if listaNombreSedes?has_content && !sedeSeleccionada?has_content>
	<h7>Elige una opci&oacute;n:</h7>
                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 	<option value="${nombreSede}">${nombreSede}</option>
								 
						</#list>
</select>
<#elseif listaNombreSedes?has_content && sedeSeleccionada?has_content>
	<h7>Elige una opci&oacute;n:</h7>
                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 <#if sedeSeleccionada=="${nombreSede}">
								 	<option value="${nombreSede}" selected>${nombreSede}</option>
								 </#if>
						</#list>
</select>
</form>
</div>
<div class="queryResults" id="queryResults">
                                    <table id="resultTable" name="resultTable" class="table table-striped">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>Recurso</th>
                                                <th>Sede</th>
                                                <th>TotalVentas</th>
                                            </tr>
                                        </thead>
                                        <tr>
                                            <#list listaDatosTotales as dato>
                                                <td>${dato}</td>
                                            </#list>
                                        </tr>
                                    </table>
                                </div>
</#if>
<#elseif tipoSede=="Totales">
<h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
						<option value="Totales" selected>Todas las sedes</option>
					</select>
	</form>
	</div>
	<div class="queryResults" id="queryResults">
                                <table id="resultTable" name="resultTable" class="table table-striped">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Libro</th>
                                            <th>TotalVentas</th>
                                        </tr>
                                    </thead>
                                    <tr>
                                        <#list listaNombreSedes as dato>
                                            <td>${dato}</td>
                                        </#list>
                                    </tr>
                                </table>
                            </div>
</#if>
</#if>
   <#-- -->

<#elseif tipoInfoConcreta?has_content && tipoInfoConcreta=="Autor">
<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                     <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
</#if>



























   <#----------------------------------------------------------------------------------------------------------------------------------------------->

<#elseif tipoConsulta?has_content && tipoConsulta=="Datos">
<div class="panel list-group">                
           <h7>&iquest;Qu&eacute; deseas consultar?</h7>
                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Datos" selected>Datos</option>
	</select>
	</div>
</form>

</#if>


<div class="buttonSubmitClass" id ="buttonSubmitClass">
    <input type="submit" class="btn btn-primary" value="Ejecutar" onclick="getData()">
    <input type="submit" class="btn btn-primary" value="Restablecer" onclick="restablecer()">
</div>