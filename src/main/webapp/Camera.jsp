<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Recherche des Cameras</div>
            <div class="card-body">
                <form action="chercher.do" method="get">
                    <label>Rechercher avec le nom : </label>
                    <input type="text" name="motCle" value="${model.motCle}" />
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </form>
                <table class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Type</th>
                        <th>Name</th>
                        <th>Resolution</th>
                        <th>Action Supprimer</th>
                        <th>Action Editer</th>
                    </tr>
                    <c:forEach items="${model.cameras}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.type}</td>
                            <td>${p.name}</td>
                            <td>${p.resolution}</td>
                            <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimer.do?id=${p.id}">Supprimer</a></td> 
              				<td><a href="editer.do?id=${p.id}">Edit</a></td> 
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>