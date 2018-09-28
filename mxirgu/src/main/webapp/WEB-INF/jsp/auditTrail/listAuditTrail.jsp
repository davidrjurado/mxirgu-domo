<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Users</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<script src="https://use.fontawesome.com/012315d209.js"></script>
</head>
<body>

	<div class="container-fluid">
		
		<a href="${pageContext.request.contextPath}/listUser" class="btn btn-info"> <i class="fa fa-plus"></i>Back</a>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">User</th>
					<th scope="col">Action</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listAuditTrail}" var="audit">
					<tr>
						<th scope="row">${audit.id}</th>
						<td>${audit.user.name}</td>
						<td>${audit.action}</td>
						<td>${audit.processDate}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

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