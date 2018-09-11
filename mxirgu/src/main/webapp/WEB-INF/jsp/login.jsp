<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form id="login-form" action="/login" method="post">
		<div class="form-group">
			<label for="login">Nombre de usuario</label> <input
				name="username" class="form-control" />
		</div>
		<div class="form-group">
			<label for="password">Contraseña</label> <input name="password"
				type="password" class="form-control" />
		</div>
		<sec:csrfInput />
		<button type="submit" class="btn btn-primary">Acceder</button>
	</form>
</body>
</html>