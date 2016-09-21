<html xmlns:c="http://java.sun.com/jsp/jstl/core"  
xmlns:spring="http://www.springframework.org/tags" 
xmlns:jsp="http://java.sun.com/JSP/Page">


<head>
	<!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /-->
	<meta http-equiv="Content-Type" content="text/html; charset=8859-1" />
	<title>Autenticacion de Usuario</title>
	<link rel="shortcut Icon" href="recursos/images/icons/AYZA-Juntos-32.ico" type="image/x-icon">
	<script language="javascript" src="recursos/js/jquery-1.8.2.min.js"></script>
	<script language="javascript" src="recursos/js/jquery-ui-1.10.4.custom.min.js"></script>
	<link rel="stylesheet" href="recursos/css/redmond/jquery.ui.all.css" type="text/css" />
	<link rel="stylesheet" href="recursos/css/bootstrap.css" type="text/css" />
	<style>
	.centrar {
	    /*
	    width:300px;
	    height:300px;
	    background-color:#d9d9d9;
	    */
	    position:fixed;
	    margin-left:-150px; /* half of width */
	    margin-top:-150px;  /* half of height */
	    top:50%;
	    left:50%;
	}
	</style>
	<script>
	$(function() {
		
	});
	</script>
</head>
<body>
	<table border="0" align="center" class="centrar">
		<tr>
			<td>
				<div class="panel panel-primary">
					<div class="panel-heading">Autenticación de Usuario</div>
					<div class="panel-body">
						<form style="margin-top: 1.0em;" action="<c:url value="/j_spring_security_check"/>" method="post">
							<table border="0" cellpadding="5">
								<tr>
									<td rowspan="4">
										<img src="recursos/images/usuarios.png" border="0" />
									</td>
								</tr>
								<tr>
									<td width="30px">&nbsp;</td>
									<td>
										<div class="input-group">
									      <div class="input-group-addon"><img src="recursos/images/icons/correo_16x16.png" border="0" /></div>
									      <input class="form-control" type="text" name="j_username" placeholder="Ingrese su usuario">
									    </div>
									</td>
									<td width="30px">&nbsp;</td>
								</tr>
								<tr> 
									<td width="30px">&nbsp;</td>
									<td>
										<div class="input-group">
									      <div class="input-group-addon"><img src="recursos/images/icons/security_16x16.png" border="0" /></div>
									      <input class="form-control" type="password" name="j_password" placeholder="Ingrese su clave">
									    </div>
									</td>
									<td width="30px">&nbsp;</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td align="right">
										<input type="submit" name="aceptar" value="Aceptar" class="btn btn-primary" />
									</td>
									<td width="30px">&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</td>
		</tr>
	</table>
	
</body>
</html>