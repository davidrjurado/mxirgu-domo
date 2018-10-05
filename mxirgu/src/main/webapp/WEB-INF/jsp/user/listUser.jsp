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
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
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

function displayFilter(entity, field )
{
	$.ajax({
        url: "http://localhost:8081/mxirgu/getFilterValues?entity="+entity+"&column="+field
    }).then(function(data) {
    	var options = "";
    	
    	$.each(data, function(index, element) {
    		 options +='<div class="form-check" align="left">';
    	     options +='	<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">';
    	     options +='<label class="form-check-label" for="defaultCheck1" id="filter${column.dbField}">';
    	     options += element.value0;
    	     options +='	</label>';
    	   	 options +='</div>';
    		
    		
        });
    	$('#filterValues_'+field).html(options);
    });
}
</script>
</head>
<body>
	<div class="container-fluid" style="background-color: #f2f2f2">
	 
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
	
	<table class="table table-sm " style="background-color: white">
		<thead>
			<tr>
			<c:forEach items="${listConfiguration.columnsList}" var="column">
				<th scope="col">
				<!-- Decide if the field is filtereable -->
					<c:choose>
						<c:when test = "${column.filtereable}">
							<div class="dropdown" onclick="displayFilter('${listConfiguration.entity}','${column.dbField}')">
							  <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:#333333">
							    ${column.title}
							    <!-- Decide if the field is sortable -->
								<c:if test = "${column.sortable}">
									<c:choose>
										<c:when test = "${listCriteria.sortBy == column.dbField}">
											<c:choose>
												<c:when test = "${listCriteria.sortDirection == 0}">
													<i class="fa fa-sort-asc" aria-hidden="true" style="cursor:pointer;margin: 5px" onclick="sort('${column.dbField}')"></i>	
												</c:when>
												<c:otherwise>
													<i class="fa fa-sort-desc" aria-hidden="true" style="cursor:pointer;margin: 5px" onclick="sort('${column.dbField}')"></i>	
												</c:otherwise>
											</c:choose>
										</c:when>	
										<c:otherwise>
											<i class="fa fa-sort" aria-hidden="true" style="cursor:pointer;margin: 5px" onclick="sort('${column.dbField}')"></i>
										</c:otherwise>
									</c:choose>
								</c:if>
							  </a>
							
							  <div class="dropdown-menu" id="filterValues_${column.dbField}">
								<div class="form-check" align="center">
									<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
									<label class="form-check-label" for="defaultCheck1" id="filter${column.dbField}">
									    Loading...
									</label>
								</div>
							  </div>
						</div>	
						</c:when>
						<c:otherwise>
							${column.title}
						</c:otherwise>
					</c:choose>	
					
					
				</th>
			</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUsers}" var="row">
				<tr>
				<c:forEach items="${row}" var="cell">
					<td>
					<c:choose>
						
						<c:when test = "${cell.render.value == 0}">
							${cell.field}
						</c:when>
						
						<c:when test = "${cell.render.value == 1}">
							<c:choose>
								<c:when test = "${cell.field}">
									<i class="fa fa-check-square-o" aria-hidden="true"></i>
								</c:when>
							
								<c:otherwise>
									
									<i class="fa fa-square-o" aria-hidden="true"></i>
								</c:otherwise>	
							</c:choose>		
						</c:when>
						
						<c:when test = "${cell.render.value == 2}">
							<a href="${pageContext.request.contextPath}${cell.field}" class="btn btn-danger"> <i class="fa fa-trash-o"></i></span></a>
						</c:when>
						
						<c:when test = "${cell.render.value == 3}">
							<a href="${pageContext.request.contextPath}${cell.field}" class="btn btn-info"> <i class="fa fa-pencil"></i></a>
						</c:when>
						<c:otherwise>
							Error render not defined.
						</c:otherwise>
					</c:choose>
					</td>
				</c:forEach>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 </div>
</body>
</html>