<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Confirmation Ajout Camera</div>
			<div class="card-body">

				<div class="form-group">
					<label class="control-label">ID :</label> 
					<input type="text" name="id" class="form-control" value="${camera.id }" /> 
					
					<label class="control-label">Type :</label>
					<input type="text" name="type" class="form-control" value="${camera.type }" />
					
					<label class="control-label">Name :</label>
					<input type="text" name="name" class="form-control" value="${camera.name }" />
					
					<label class="control-label">resolution :</label>
					<input type="text" name="resolution" class="form-control" value="${camera.resolution }" />
					
				</div>
			</div>

		</div>
	</div>
</body>
</html>
