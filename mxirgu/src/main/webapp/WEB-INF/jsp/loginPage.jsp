<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
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
    
</body>
</html>