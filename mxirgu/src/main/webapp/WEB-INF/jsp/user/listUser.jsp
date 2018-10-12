<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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

function paginate (number){
	document.getElementById("pageNumber").value = number;
	document.forms[0].submit();
}

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

<style type="text/css">

tbody {
    display:block;
    height:325px;
    overflow:auto;
}

thead, tbody tr {
	background-color: white;
    display:table;
    width:100%;
    table-layout:fixed;/* even columns width , fix width of table too*/
}
thead {
    width: calc( 100% - 1em )/* scrollbar is average 1em/16px width, remove it from thead width */
}

</style>

</head>
<body style="background: transparent !important;">
	<div class="container-fluid" style="background-color: #f2f2f2">
		<div class="row banner">
	 		<h3 style="color:#4a4a4a;font-weight: bold">Users</h3>
	 	</div>
	 	<div class="row" align="left">
		 	<!-- Button list displayed in the header -->
			<c:forEach items="${listConfiguration.buttonList}" var="button">
				<c:choose>
					<c:when test = "${button.action.value == 0}">
						<a href="${pageContext.request.contextPath}${button.requestMapping}" class="btn btn-secondary btn-sm" style="margin: 5px"> <i class="fa fa-plus" style="margin: 5px"></i>New</a>
					</c:when>
					<c:when test = "${button.action.value == 1}">
						<a href="${pageContext.request.contextPath}${button.requestMapping}" class="btn btn-secondary btn-sm" style="margin: 5px"> <i class="fa fa-file-text-o" style="margin: 5px"></i>Audit Trail</a>
					</c:when>
					<c:otherwise>
						Error action button not defined.
					</c:otherwise>
				</c:choose>
			</c:forEach>
	 	</div>
		<div class="row" align="left">
		<!-- Data list -->
			<table class="table table-sm table-fixed">
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
					<c:forEach items="${listData.recordList}" var="row">
						<tr>
						<c:forEach items="${row}" var="cell">
							
							<c:choose>
								
								<c:when test = "${cell.render.value == 0}">
								<td>
									${cell.field}
								</td>
								</c:when>
								
								<c:when test = "${cell.render.value == 1}">
								<td>
									<c:choose>
										<c:when test = "${cell.field}">
											<i class="fa fa-check-square-o" aria-hidden="true"></i>
										</c:when>
									
										<c:otherwise>
											
											<i class="fa fa-square-o" aria-hidden="true"></i>
										</c:otherwise>	
									</c:choose>
								</td>		
								</c:when>
								
								<c:when test = "${cell.render.value == 2}">
								<td style="width: 40px">
									<a href="${pageContext.request.contextPath}${cell.field}" class="btn btn-dark btn-sm"> <i class="fa fa-trash-o"></i></span></a>
								</td>
								</c:when>
								
								<c:when test = "${cell.render.value == 3}">
								<td style="width: 40px">
									<a href="${pageContext.request.contextPath}${cell.field}" class="btn btn-dark btn-sm"> <i class="fa fa-pencil"></i></a>
								</td>
								</c:when>
								<c:otherwise>
									Error render not defined.
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
	</div>
	<form:form method="POST" action="${pageContext.request.contextPath}/listUser" modelAttribute="listCriteria" style="display: inline;vertical-align: middle;"> 
		<div class="row">
			<div class="col" align="left">
				Showing ${listData.from} to ${listData.to} of ${listData.totalRecord} entries
			</div>
			<div class="col" style="display: inline;" align="center">
				<a href="#" class="btn btn-dark btn-sm <c:if test = "${listCriteria.pageNumber == 1}">disabled</c:if>" onclick="paginate(1);"> <i class="fa fa-angle-double-left" aria-hidden="true"></i></a>
				<a href="#" class="btn btn-dark btn-sm <c:if test = "${listCriteria.pageNumber == 1}">disabled</c:if>" onclick="paginate(${listCriteria.pageNumber - 1});"> <i class="fa fa-angle-left" aria-hidden="true"></i></a>
				<form:select id="pageNumber" path="pageNumber" style="vertical-align: middle;" onchange="document.forms[0].submit();">
					<c:forEach var = "i" begin = "1" end = "${listData.pages}">
		         		  <form:option value="${i}" label="${i}" />
		     		</c:forEach>
				</form:select>
				<a href="#" class="btn btn-dark btn-sm <c:if test = "${listCriteria.pageNumber == listData.pages}">disabled</c:if>" onclick="paginate(${listCriteria.pageNumber + 1});"> <i class="fa fa-angle-right" aria-hidden="true"></i></a>
				<a href="#" class="btn btn-dark btn-sm <c:if test = "${listCriteria.pageNumber == listData.pages}">disabled</c:if>" onclick="paginate(${listData.pages});"> <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
			</div>
			<div class="col" align="right">
				<form:input type="hidden" path="sortBy" id="sortBy"/>
				<form:input type="hidden" path="sortDirection" id="sortDirection"/>
				<form:select path="recordsDisplayed" onchange="document.forms[0].submit();" style="vertical-align: middle;">
				    <form:option value="10" label="10" />
				    <form:option value="25" label="25" />
				    <form:option value="50" label="50" />
				</form:select>
				<a href="" class="btn btn-dark btn-sm" onclick="document.forms[0].submit();"> <i class="fa fa-refresh"></i></a>
			</div>
		</div>
		</form:form>
	</div>
</body>
</html>