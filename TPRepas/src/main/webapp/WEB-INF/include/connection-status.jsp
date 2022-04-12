<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section>
	<c:choose>
		<c:when test="${utilisateurConnecte != null}">
		Vous êtes connecté avec : ${utilisateurConnecte.username}
		<form action="./deconnexion" method="POST">
				<button name="deconnexion">Se déconnecter ?</button>
			</form>
		</c:when>
		<c:otherwise>
		Vous n'êtes pas connecté : <a href="./connexion">connexion</a>
		</c:otherwise>
	</c:choose>
</section>