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
<title>Users</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<script src="https://use.fontawesome.com/012315d209.js"></script>

<script>

function sort (sortBy){
	document.forms[0].sortBy.value=sortBy;
	if (document.forms[0].sortDirection.value == null || document.forms[0].sortDirection.value == 0){
		document.forms[0].sortDirection.value = 1;
	} else {
		document.forms[0].sortDirection.value = 0;
	}
	document.forms[0].submit();
}

</script>
</head>
<body>
	<div class="container-fluid">
	 
	<!-- Button list displayed in the header -->
		<c:forEach items="${listConfiguration.buttonList}" var="button">
			<c:choose>
				<c:when test = "${button.action.value == 0}">
					<a href="${pageContext.request.contextPath}${button.requestMapping}" class="btn btn-success" style="margin: 5px"> <i class="fa fa-plus" style="margin: 5px"></i>New</a>
				</c:when>
				<c:when test = "${button.action.value == 1}">
					<a href="${pageContext.request.contextPath}${button.requestMapping}" class="btn btn-info" style="margin: 5px"> <i class="fa fa-file-text-o" style="margin: 5px"></i>Audit Trail</a>
				</c:when>
				<c:otherwise>
					Error action button not defined.
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
	<form:form method="POST" action="${pageContext.request.contextPath}/listUser" modelAttribute="listCriteria"> 
		<form:input type="hidden" path="sortBy" id="sortBy"/>
		<form:input type="hidden" path="sortDirection" id="sortDirection"/>
	</form:form>
	
	<table class="table table-sm table-hover">
		<thead class="table-secondary">
			<tr>
			<c:forEach items="${listConfiguration.columnsList}" var="column">
				<c:choose>
					<c:when test = "${column.sortable}">
						<th scope="col" style="cursor:pointer" onclick="sort('${column.dbField}')">
						${column.title}
						<c:choose>
							<c:when test = "${listCriteria.sortBy == column.dbField}">
								<c:choose>
									<c:when test = "${listCriteria.sortDirection == 0}">
										<i class="fa fa-sort-asc" aria-hidden="true" style="margin: 5px"></i>	
									</c:when>
									<c:otherwise>
										<i class="fa fa-sort-desc" aria-hidden="true" style="margin: 5px"></i>
									</c:otherwise>
								</c:choose>
							</c:when>	
							<c:otherwise>
								<i class="fa fa-sort" aria-hidden="true" style="margin: 5px"></i>
							</c:otherwise>
						</c:choose>
						</th>
					</c:when>
		        	<c:otherwise>
			            <th scope="col">${column.title}</th>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<th scope="row">${user.id}</th>
					<td>${user.login}</td>
					<td>${user.name}</td>
					<td>${user.surname}</td>
					<td>
						<a href="${pageContext.request.contextPath}/editUser/${user.id}" class="btn btn-info"> <i class="fa fa-pencil"></i></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/removeUser/${user.id}" class="btn btn-danger"> <i class="fa fa-trash-o"></i></span></a>
					</td>
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