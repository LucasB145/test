<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Historique</title>
<%@ include file="./import/include.html"%>
</head>
<body>
	<h1>HISTORIQUE</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Date</th>
				<th>Heure</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="repas" items="${listeRepas}">
				<tr>
					<td>${repas.date}</td>
					<td>${repas.heure}</td>
					<td><a href="?idRepas=${repas.id}">details</a></td>
				</tr>
				
				<c:if test="${param.idRepas == repas.id}">
					<tr>
						<td colspan="3">
							<ul>
								<c:forEach var="ingredient" items="${listeIngredients}">
									<li>${ingredient}</li>
								</c:forEach>
							</ul>	
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
<nav>
	<a href="ajoutRepas">Ajouter un nouveau repas</a>|
	<a href="index.html">Retour à l'accueil</a>
</nav>

</body>
</html>