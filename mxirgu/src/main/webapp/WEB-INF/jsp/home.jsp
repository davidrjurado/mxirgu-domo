<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<%@page import="com.mxirgu.domo.bean.list.ListSort"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<script src="https://use.fontawesome.com/012315d209.js"></script>
<style type="text/css">

.banner {
	color:white;
	background: #a7a7a7;
	height: 80px;
}
.footer {
	color:white;
	background: #a7a7a7;
	height: 20px;
}

</style>
</head>
<body>
	<div class="container-fluid">
	 	<div class="row banner">
	 		<h1> Middleware</h1>
	 	</div>
	 	<div class="row">
		 	<div class="col-2">
		 		<nav class="nav flex-column">
				  <a class="nav-link active" href="#">User</a>
				  <a class="nav-link" href="#">Profiles</a>
				  <a class="nav-link" href="#">Setting</a>
				  <a class="nav-link disabled" href="#">Disabled</a>
				</nav>
			</div>
			<div class="col-10">
				<iframe src="${pageContext.request.contextPath}/listUser" width="100%" height="450px" style=" border: 0">
					Application cannot be displayed on your browser :(
				</iframe>
			</div>	
	 	</div>
		<div class="row footer">
	 		<!-- Footer -->
	 	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>