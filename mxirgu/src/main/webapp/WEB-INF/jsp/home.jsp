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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">

.banner {
	color:white;
	background: #363636;
	height: 50px;
}

.tabs .tab-pane{
  margin-left:30px;
}

.tabs h3{
  font-size:20px;
  margin-top:10px;
  margin-bottom:60px;
}

.tabs p{
  font-size:14px;
}

.tabs a{
  font-size:15px;
  font-family:OpenSans,sans-serif;
  font-weight:700;
  color:#787878;
  padding:30px;
}

.tabs li{
  background-color:#f2f2f2;
  text-align:center;
  height:90px;
  width:110px;
  padding-top:35px;
  list-style-position:inside;
  border-right: 1px solid #e2e2e2;
  border-bottom: 1px solid #e2e2e2;
 }

.tabs li.active{
  background-color:#777777;
}
.tabs li.active a{

  color:#ffffff;
}
</style>
<script type="text/javascript">
$(function() {
	var $a = $(".tabs li");
	$a.click(function() {
		$a.removeClass("active");
		$(this).addClass("active");
	});
});
</script>
</head>
<body>
<div class="tabs">
	<div class="container-fluid" style="background-color: #f2f2f2;">
		<div class="row banner">
			<div class="col-1" style="background-color: #1d1d1d">
				
			</div>
			<div class="col-2" style="background-color: #1d1d1d">
				<h1 style="margin: 2px;"> Company</h1>
			</div>
			<div class="col-7">
	 			
	 		</div>
	 		<div class="col-2">
	 			David
	 		</div>
	 	</div>
		<div class="row" align="left">
			<div class="col-1" style="padding-left: 0; padding-right: 0">
				<ul class="nav nav-pills nav-stacked flex-column">
					<li class="active"><a href="#tab_a" data-toggle="pill">TAB 1</a></li>
					<li><a href="#tab_b" data-toggle="pill">TAB 2</a></li>
					<li><a href="#tab_c" data-toggle="pill">TAB 3</a></li>
					<li><a href="#tab_c" data-toggle="pill">TAB 3</a></li>
					<li><a href="#tab_c" data-toggle="pill">TAB 3</a></li>
				</ul>
			</div>
			<div class="col-11">
				<div class="tab-content">
					<div class="tab-pane active" id="tab_a">
						<iframe src="${pageContext.request.contextPath}/listUser" width="100%" height="520px" style="border:0" allowtransparency="true">
			            	The application cannot be displayed  in your browser :(
			            </iframe>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>


	</body>
</html>