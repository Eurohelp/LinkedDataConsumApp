<html lang="es"><head>
<meta charset="UTF-8">
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>Eurohelp Consulting</title>
<!-- Progress bar -->
<script src="https://rawgit.com/kimmobrunfeldt/progressbar.js/1.0.0/dist/progressbar.js"></script>
<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/alertifyjs/1.10.0/alertify.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/alertify.min.css">
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/default.min.css">
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/semantic.min.css">
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/bootstrap.min.css">
<!--RTL version-->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/alertify.rtl.min.css">
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/default.rtl.min.css">
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/semantic.rtl.min.css">
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/alertifyjs/1.10.0/css/themes/bootstrap.rtl.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<!-- Fuente -->

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="http://labratrevenge.com/d3-tip/javascripts/d3.tip.v0.6.3.js"></script>
<script src="/LinkedDataConsumApp/js/sweetalert2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
<script src="/LinkedDataConsumApp/js/GestorWeb.js"></script>
<script src="/LinkedDataConsumApp/js/GestorTabla.js"></script>


<body>
	<div class="blended_grid">
		<div class="pageHeader">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand">Eurohelp Consulting</a>
					</div>
				</div>
			</nav>
		</div>
		<div class="pageContent" id="pageContent">	<form name="form" id="form">
		
		<div class="panel list-group">
		¿Qué deseas consultar?
         <select class="form-control" id="tipoInformacion" name="tipoInformacion">
			<option value="Ventas" selected="">Ventas</option>
		</select>
		¿Sobre qué tipo de recurso?
		<select class="form-control" id="tipoInformacion-Ventas" name="tipoInformacion-Ventas">
						<option value="Autor" selected="">Autor</option>
					</select>
		¿A partir de qué tipo de datos?
<select class="form-control" id="tipoInformacion-Ventas-Autor-Cantante" name="tipoInformacion-Ventas-Autor-Cantante">
						<option value="Nombre" selected="">Nombre</option>
					</select>
					Elige una opción:
					<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre" name="tipoInformacion-Ventas-Autor-Nombre">
 				 					<option value="Alexandre Dumas">Alexandre Dumas</option>
 				 					<option value="Rafael Sánchez Ferlosio">Rafael Sánchez Ferlosio</option>
 				 					<option value="Hernán Rivera Letelier">Hernán Rivera Letelier</option>
 				 					<option value="Ford Madox Ford">Ford Madox Ford</option>
 				 					<option value="Agatha Christie">Agatha Christie</option>
 				 					<option value="Aldous Huxley">Aldous Huxley</option>
 				 					<option value="Saul Bellow">Saul Bellow</option>
 				 					<option value="Darío Vilas Couselo">Darío Vilas Couselo</option>
 				 					<option value="Kingsley Amis">Kingsley Amis</option>
 				 					<option value="Willa Cather">Willa Cather</option>
 				 					<option value="Eduardo Mendoza">Eduardo Mendoza</option>
 				 					<option value="Lucía Etxebarria">Lucía Etxebarria</option>
 				 					<option value="Cao Xueqin">Cao Xueqin</option>
 				 					<option value="Jorge Luis Borges">Jorge Luis Borges</option>
 				 					<option value="Carmen Martín Gaite">Carmen Martín Gaite</option>
 				 					<option value="John Dos Passos">John Dos Passos</option>
 				 					<option value="D. H. Lawrence">D. H. Lawrence</option>
 				 					<option value="Richard Nathaniel Wright">Richard Nathaniel Wright</option>
 				 					<option value="Vladímir Nabokov">Vladímir Nabokov</option>
 				 					<option value="James Baldwin">James Baldwin</option>
 				 					<option value="Jean Rhys">Jean Rhys</option>
 				 					<option value="Pío Baroja">Pío Baroja</option>
 				 					<option value="Evelyn Waugh">Evelyn Waugh</option>
 				 					<option value="Arthur C. Clarke">Arthur C. Clarke</option>
 				 					<option value="Gabriel García Márquez">Gabriel García Márquez</option>
 				 					<option value="Nathanael West">Nathanael West</option>
 				 					<option value="Theodore Dreiser">Theodore Dreiser</option>
 				 					<option value="George Orwell">George Orwell</option>
 				 					<option value="José Emilio Pacheco">José Emilio Pacheco</option>
 				 					<option value="Ramón J. Sender">Ramón J. Sender</option>
 				 					<option value="José Luis Sampedro">José Luis Sampedro</option>
 				 					<option value="Alfredo Bryce Echenique">Alfredo Bryce Echenique</option>
 				 					<option value="Álvaro Mutis">Álvaro Mutis</option>
</select>
	¿Sobre qué sede quieres recibir la información?
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede">Sede</option>
								 	<option value="Totales">Todas las sedes</option>
</select>

Elige una opción:
<select class="form-control" id="tipoInformacion-Ventas-Autor-Nombre-Sede" name="tipoInformacion-Ventas-Autor-Nombre-Sede">
								 	<option value="Sede">Alava</option>
								 	<option value="Totales">Madrid</option>
</select>



</div>
<div class="queryResults" id="queryResults">
<table name="table table-striped">
	  <thead class="thead-dark">
	<tr>
    <th>Recurso</th>
    <th>Sede</th>
    <th>TotalVentas</th>
  </tr>
  </thead>
   <tr>
    <td>Alexandre Dumas</td>
 	<td>Alava</td>
 	<td>58850</td>
  </tr>
	</table>
	</div>
 </form>
<div class="buttonSubmitClass">
			<input type="submit" class="btn btn-primary" value="Ejecutar" onclick="getData()">
			<input type="submit" class="btn btn-primary" value="Reestablecer" onclick="getData()">
</div></div>
		<div class="footer"></div>
	</div>

</body></html>