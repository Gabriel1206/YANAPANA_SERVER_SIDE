<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>

<div id="dialog" title="">
	<form style="margin-top: 1.0em;" action="<c:url value="/login"/>" method="post">
		<center>
			<img src="recursos/images/error404.jpg" border=0 />
			<br><br>
			<input type="submit" name="aceptar" value="Ir a página principal" class="btn btn-primary" />
		</center>
	</form> 
</div>

</body>
</html>