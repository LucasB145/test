<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:param name="titre" value="Connexion" />
<body>

	<header>
		<%@ include file="./include/nav.html"%>
		<%@ include file="./include/connection-status.jsp"%>
	</header>

	<h1>Connexion</h1>
	
	<!-- on affiche les éventuelles erreurs -->
	<p class="erreur">${erreur}</p>
	
	<form action="./connexion" method="post">
		<label>Utilisateur : </label>
		<input type="text" name="username"/><br>
		
		<label>Mot de passe : </label>
		<input type="password" name="password"/><br>
		
		<button>Connexion</button>
	
	</form>

</body>
</html>