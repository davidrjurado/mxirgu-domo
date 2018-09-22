<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style type="text/css">
		body{
			background-image:url("https://mdbootstrap.com/img/Photos/Others/architecture.jpg");
			background-size:cover; 
		}
		
		.login-form {
			margin-top:60px;
			box-shadow: 0px 0px 10px 1px grey;
			border-radius: 5px;
			padding-bottom: 20px;
			background: white;
		}
		
	</style>
</head>
<body>

 	<div class="container">
 		<div class="login-form col-md-4 offset-md-4">
 			<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
 				<div class="form-group">
 					<label>Username</label>
 					<input type="text" class="form-control" name='username'>
 				</div>
 				
 				<div class="form-group">
 					<label>Password</label>
 					<input type="password" class="form-control" name='password'>
 				</div>
 				<button class="btn btn-primary btn-block" type="submit">Login</button>
 				<!-- /login?error=true -->
     			<c:if test="${param.error == 'true'}">
         			<div style="color:red;margin:10px 0px;">
                          Login Failed!!!<br />
                		Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 	</div>
    			</c:if>
 			</form>
 		</div>
 	</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>