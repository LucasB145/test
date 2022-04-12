<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Ajouter</title>
<%@ include file="./import/include.html"%>
</head>
<body>
	<h1>AJOUT</h1>
	<p class="message-erreur">${messageErreur}</p>
	<form action="./ajoutRepas" method="POST">

		<label>date : </label> <input name="date" type="date" required></input><br />
		<br /> <label>heure : </label> <input name="heure" type="time"
			required></input><br /> <br /> <label>description : </label>
		<textarea name="description" cols="25" rows="6"
			placeholder="séparer les ingrédients par des virgules" required></textarea>
		<br /> <br />
		<nav>
			<div class="form-buttons">
				<button name="ok">Valider</button>
				<a href="./">Annuler</a>
			</div>
		</nav>


	</form>

</body>
</html>