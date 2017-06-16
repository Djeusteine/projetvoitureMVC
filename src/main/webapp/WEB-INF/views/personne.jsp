<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>app title</title>
</head>
<body>
	<h1> Ajouter une personne</h1>
	<form:form action="addPers" method="post" modelAttribute="personne">
		<form:input type="hidden" id="id" path="id" />
		<label for="nom">Nom :</label>
		<form:input type="text" id="nom" path="nom" />
		<label for="prenom">Prénom :</label>
		<form:input type="text" id="prenom" path="prenom"/>
		<label for="age">Nom :</label>
		<form:input type="text" id="age" path="age" />
		<form:button>submit</form:button>
	</form:form>
	
	<h1>Liste des personnes</h1>
	<table id="personnes">
		<tbody>
			<c:forEach items="${personnes}" var="pers">
				<tr>
					<td>${pers.nom}</td>
					<td>${pers.prenom}</td>
					<td>${pers.age}</td>
					<td><a href="delPers?pId=${pers.id}">supprimer</a></td>
					<td><a href="updatePers?pId=${pers.id}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>