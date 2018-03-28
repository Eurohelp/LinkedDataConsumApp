<form name="form" id="form" class="form">
    <#if tipoConsulta?has_content && tipoConsulta=="null" && !tipoInfoConcreta?has_content !datosSolicitados?has_content && !NombreRecurso?has_content>
        <#-- Si no se ha seleccionado nada a?n -->
            <div class="panel list-group">                
           <h7>&iquest;Qu&eacute; deseas consultar?</h7>df
                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
		<option value="Ventas">Ventas</option>
		<option value="Datos">Datos</option>
	</select>
    </#if>
    <#-- Si ya se ha seleccionado entre ventas y datos -->
        <#if tipoConsulta?has_content && !tipoInfoConcreta?has_content && !datosSolicitados?has_content && !NombreRecurso?has_content>
            <#if tipoConsulta=="Ventas">
                <#-- Si se ha seleccionado Ventas-->
                    <div class="panel list-group">
<h7>&iquest;Qu&eacute; deseas consultar?</h7>dfsf
                        <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select> <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                        <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select>
                        <#elseif tipoConsulta=="Datos">
                            <#-- Si se ha seleccionado Datos y ya se tiene el nombre del recurso a mostrar-->
                                <div class="panel list-group">
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>ws
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select> <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro">Libro</option>
						<option value="Autor">Autor</option>
					</select>
            </#if>
        </#if>
        <#-- Si ya se ha seleccionado el tipo de consulta y sobre qu? tipo de datos desea obtener infomacion-->
            <#if tipoConsulta?has_content && tipoInfoConcreta?has_content && !datosSolicitados?has_content && !NombreRecurso?has_content>
                <#if tipoInfoConcreta=="Libro" && listaNombreRecursos?has_content && !listaNombreSedes?has_content && !tipoSede?has_content>
                    <#if tipoConsulta=="Ventas">
                        <div class="panel list-group">
                          <h7>&iquest;Qu&eacute; deseas consultar?</h7>dsv
                            <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select> 
		<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                            <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select> 
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
                            <#elseif tipoConsulta=="Datos">
                                <div class="panel list-group">
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>dfvvf
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select> 
		<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>sdvgf
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
 					<option value="${nombre}">${nombre}</option>
		</#list>
</select>
                    </#if>
                    <#elseif tipoInfoConcreta=="Autor" && !tipoDatoRecursoSolicitado?has_content && !listaNombreRecursos?has_content && !NombreRecurso?has_content>
                        <#if tipoConsulta=="Ventas">
                            <div class="panel list-group">
                                <h7>&iquest;Qu&eacute; deseas consultar?</h7>wre
                                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
                                <#elseif tipoConsulta=="Datos">
                                    <div class="panel list-group">
                                        <h7>&iquest;Qu&eacute; deseas consultar?</h7>
                                        <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
                        </#if>
                        <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                        <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select><h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre">Nombre</option>
						<option value="NacidoEn">Nacido en</option>
					</select>
                </#if>
            </#if>
            <#-- Se ha seleccionado de la lista de libros un titulo o de la lista de autores un lugar de nacimiento o un nombre de autor-->
                <#if tipoConsulta?has_content && tipoInfoConcreta?has_content && !datosSolicitados?has_content && !listaDatosTotales?has_content && (listaNombreRecursos?has_content || NombreRecurso?has_content)>

                    <#if tipoConsulta=="Datos" && tipoInfoConcreta=="Libro" && NombreRecurso?has_content>
                        <#elseif tipoSede?has_content && tipoInfoConcreta=="Libro" && NombreRecurso?has_content && tipoSede?has_content>
                            <#--Corresponde al libro-->
                            <div class="panel list-group">
                                <h7>&iquest;Qu&eacute; deseas consultar?</h7>bfgnar
                                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
								<option value="Ventas" selected>Ventas</option>
								</select> 
								<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
								<option value="Libro" selected>Libro</option>
								</select>
								<h7>Elige una opci&oacute;n:</h7>
                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
		 <#list listaNombreRecursos as nombre>
		 <#if NombreRecurso == "${nombre}">
 		 			<option value="${nombre}" selected>${nombre}</option>
 		</#if></#list>
					</select>
					<h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                       <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
<#if tipoSede=="Sede">
<#if !sedeSeleccionada?has_content>
						<option value="Sede" selected>Sede</option>
						</select>
						<h7>Elige una opci&oacute;n:</h7>
                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 	<option value="${nombreSede}">${nombreSede}</option>
						</#list>
</select>
</div>
                    </form>
                    </div>
                    </#if>
                    <#else>
                    </div>
                    </form>
                    </div>
                        <#--Si selecciona ventas/datos libro sede totales-->
                            <option value="Totales" selected>Todas las sedes</option>
                            </select>
                            </div>
</form>
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
                <#elseif tipoInfoConcreta=="Autor" && listaNombreRecursos?has_content && !NombreRecurso?has_content>
                    <#if tipoConsulta=="Datos">
                        <div class="panel list-group">
                            <h7>&iquest;Qu&eacute; deseas consultar?</h7>fef
                            <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
                            <#else>
                                <div class="panel list-group">
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
                    </#if>
                    <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
                    <#if tipoDatoRecursoSolicitado=="Nombre">
                        <#--Corresponde al AUTOR y se ha solicitado nombre-->
                            <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					 <#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select> <h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede">Sede</option>
								 	<option value="Totales">Todas las sedes</option>
</select>
                            <#elseif tipoDatoRecursoSolicitado=="NacidoEn">
                                <#--Corresponde al libro y se ha solicitado lugar nacimiento-->
                                    <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select> <h7>Elige una opci&oacute;n:</h7>
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
                                <h7>&iquest;Qu&eacute; deseas consultar?</h7>fdbf
                                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select>
                                <#if tipoInfoConcreta=="Libro">
                                    <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
								</#if>
</#list></select>
                                    <#elseif tipoInfoConcreta=="Autor">
                                        <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                        <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
                                        <#if tipoDatoRecursoSolicitado=="Nombre">
                                            <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select>
                                            <#else>
                                                <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
                                        </#if><h7>Elige una opci&oacute;n:</h7>
                                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
								</#if>
</#list></select>
                                </#if>

                                <#--Aqui se muestra la tabla correspondiente dependiendo del tipo si es libro o si es de un autor-->
                                    <#if tipoInfoConcreta=="Libro">
                                    </div>
</form>
                                        <div class="queryResults" id="queryResults">
                                            <table id="resultTable" name="resultTable" class="table table-striped">
                                                <thead class="thead-dark">
                                                    <tr>
                                                        <th>Libro</th>
                                                        <th>Autor</th>
                                                        <th>Descripcion</th>
                                                    </tr>
                                                </thead>
                                                <tr>
                                                    <#list listaDatosTotales as dato>
                                                        <td>${dato}</td>
                                                        <#if listaDatosTotales?size<3>
                                                            <#--Si no se disponen de datos para ese libro -->
                                                                <td>-</td>
                                                        </#if>
                                                    </#list>
                                                </tr>
                                            </table>
                                        </div>
                                        <#elseif tipoInfoConcreta=="Autor" && tipoDatoRecursoSolicitado=="Nombre">
                                           </div>
</form>
                                            <div class="queryResults" id="queryResults">
                                                <table id="resultTable" name="resultTable" class="table table-striped">
                                                    <thead class="thead-dark">
                                                        <tr>
                                                            <th>Autor</th>
                                                            <th>Descripcion</th>
                                                        </tr>
                                                    </thead>
                                                    <tr>
                                                        <#list listaDatosTotales as dato>
                                                            <td>${dato}</td>
                                                        </#list>
                                                    </tr>
                                                </table>
                                            </div>
                                            <#elseif tipoInfoConcreta=="Autor" && tipoDatoRecursoSolicitado=="NacidoEn">
                                                <h7>Elige una opci&oacute;n:</h7>
                                                <select class="form-control" id="tipoInformacion-Datos-LugarNac-Autor" name="tipoInformacion-Datos-LugarNac-Autor">
					<#list listaNombreSedes as nombre> 				 				
								<option value="${nombre}">${nombre}</option>
</#list></select>

                                    </#if>
                        </#if>
                        <#-- Si se ha seleccionado datos, lugar nacim, -->
                            <#if (tipoConsulta=="Datos" ) && listaNombreRecursos?has_content && listaNombreSedes?has_content>
                                <div class="panel list-group">
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>febfg
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Datos" selected>Datos</option>
		</select> 
		<h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
					<h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
					<h7>Elige una opci&oacute;n:</h7>
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
                                    </div>
</form>
                                        <div class="queryResults" id="queryResults">
                                            <table id="resultTable" name="resultTable" class="table table-striped">
                                                <thead class="thead-dark">
                                                    <tr>
                                                        <th>Autor</th>
                                                        <th>Descripcion</th>
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
                            </#if>

                            <#if tipoConsulta=="Ventas" && listaNombreRecursos?has_content && listaNombreSedes?has_content && !sedeSeleccionada?has_content>
                                
                                    <#if tipoInfoConcreta=="Autor">
                                    <div class="panel list-group">
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>efaa
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>
                                        <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                        <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
                                        <#if tipoDatoRecursoSolicitado=="Nombre">
                                            <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
					</select>
                                            <#elseif tipoDatoRecursoSolicitado=="NacidoEn">
                                                <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                                <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select>
                                        </#if><h7>Elige una opci&oacute;n:</h7>
                                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>
                                        <#if tipoSede=="Sede">
                                            <h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                                            <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede" selected>Sede</option>
</select><h7>Elige una opci&oacute;n:</h7>
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
                                    <h7>&iquest;Qu&eacute; deseas consultar?</h7>erbghe
                                    <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select> <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select> <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select> <h7>Elige una opci&oacute;n:</h7>
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
                                                            <div class="panel list-group">
                                <h7>&iquest;Qu&eacute; deseas consultar?</h7> ngeth
                                <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected>Ventas</option>
		</select>

                                <#if tipoInfoConcreta=="Libro">
                                    <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Libro" selected>Libro</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
							 <#if NombreRecurso == "${nombre}">
 				 				<option value="${nombre}" selected>${nombre}</option>
							</#if>
</#list></select>
                                    <#else>
                                        <#-- Si se selecciona autor-->
                                            <h7>&iquest;Sobre qu&eacute; tipo de recurso?</h7>
                                            <select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected>Autor</option>
					</select>
                                            <#if tipoDatoRecursoSolicitado=="NacidoEn">
                                                <#--Corresponde al libro y se ha solicitado lugar nacimiento-->
                                                    <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="NacidoEn" selected>Nacido en</option>
					</select><h7>Elige una opci&oacute;n:</h7>
                                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
                                                    <#elseif tipoDatoRecursoSolicitado=="Nombre">
                                                        <h7>&iquest;A partir de qu&eacute; tipo de datos?</h7>
                                                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected>Nombre</option>
</select><h7>Elige una opci&oacute;n:</h7>
                                                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
					<#list listaNombreRecursos as nombre>
 				 					<option value="${nombre}">${nombre}</option>
</#list></select>
                                            </#if>
                                </#if>
                                <#if sedeSeleccionada?has_content>
                                    <h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede" selected>Sede</option>
</select><h7>Elige una opci&oacute;n:</h7>
                                    <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede-Sede">
								 <#list listaNombreSedes as nombreSede>
								 <#if sedeSeleccionada == "${nombreSede}">
								 	<option value="${nombreSede}" selected>${nombreSede}</option>
								 </#if>
						</#list>
</select>
                                    <#else>
                                        <h7>&iquest;Sobre qu&eacute; sede quieres recibir la informaci&oacute;n?</h7>
                                        <select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Totales" selected>Todas las sedes</option>
</select>
                                </#if>
</div>
</form>
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

                            <#-- Se dispone para que puedan seleccionar titulo o nombre del recurso del que quieran obtener informaci?n-->
                                </div>
</form>
</div>
<div class="buttonSubmitClass" id ="buttonSubmitClass">
    <input type="submit" class="btn btn-primary" value="Ejecutar" onclick="getData()">
    <input type="submit" class="btn btn-primary" value="Restablecer" onclick="restablecer()">
</div>