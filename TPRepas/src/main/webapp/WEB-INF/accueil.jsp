<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Accueil</title>

<link rel="stylesheet" href="./css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />



</head>
<body>
	<header>
		<!-- include "standard" : recopie du code html "statique" -->
		<%@ include file="./include/nav.html"%>
		<%@ include file="./include/connection-status.jsp"%>
	</header>

	<h1>ACCUEIL</h1>
	<nav>
		<a href="./ajoutRepas">Ajouter un nouveau repas</a> <br /> <br /> <br />
		<a href="./historique">Visualiser les repas</a>
	</nav>

</body>
</html>