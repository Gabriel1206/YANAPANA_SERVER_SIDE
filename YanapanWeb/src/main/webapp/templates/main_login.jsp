<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<title><tiles:getAsString name="titulo" /></title>
<script>
function redimensionar(){
	//alert("ancho : " + screen.width + "\nalto : " + screen.height);
	porcentajeAltura = 87;
	alturaMaxima = (screen.height*porcentajeAltura)/100;
	alturaMaxima = alturaMaxima + "px";
	var tabla = document.getElementById('tablaPrincipal');
	tabla.style.height = alturaMaxima; 
}
</script>
</head>
<body onload="javascript:redimensionar();">
	<table border="0" id="tablaPrincipal" align="center" width="80%">
		<tr>
			<td valign="top">
				<table border="0" style="width:100%;height:100%">
					<tr>
						<td height="5%">
							<table border="0" style="width:100%;">
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td valign="top" align="center">
							<table border="0" style="width:99.5%;height:100%">
								<tr>
									<td valign="top">
										<br/>
										<fieldset>
										<legend class="leyenda">&nbsp;</legend>
											<tiles:insertAttribute name="contenido" />
										</fieldset>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="2%">
				<table border="0" width="100%">
					<tr>
						<td>
							<tiles:insertAttribute name="pie" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>

</html>