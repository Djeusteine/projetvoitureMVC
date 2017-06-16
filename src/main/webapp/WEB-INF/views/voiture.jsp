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

<h1> Ajouter une voiture</h1>
	<form:form action="addVoit" method="post" modelAttribute="voiture">
		<form:input type="hidden" id="id" path="id" />
		<label for="marque">Marque :</label>
		<form:input type="text" id="marque" path="marque" />
		<label for="constructeur">constructeur :</label>
		<form:input type="text" id="constructeur" path="constructeur"/>
		<label for="personne">Propriétaire :</label>
		<form:select path="personne.id" items="${personnes}" itemValue="id" />
		<form:button>submit</form:button>
	</form:form>
	
	<h1>Liste des voitures</h1>
	<table id="personnes">
		<tbody>
			<c:forEach items="${voitures}" var="voit">
				<tr>
					<td>${voit.marque}</td>
					<td>${voit.constructeur}</td>
					<td>${voit.personne.nom} ${voit.personne.prenom}</td>
					<td><a href="delVoit?vId=${voit.id}">supprimer</a></td>
					<td><a href="updateVoit?vId=${voit.id}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>