<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<style>
    .gBubble
    {
        color:black;
        font-family:Tahoma, Geneva, sans-serif;
        font-size:12px;    
    }
    
    .modal-header-primary {
		color:#fff;
		padding:9px 15px;
		border-bottom:1px solid #eee;
		background-color: #428bca;
		-webkit-border-top-left-radius: 5px;
		-webkit-border-top-right-radius: 5px;
		-moz-border-radius-topleft: 5px;
		-moz-border-radius-topright: 5px;
		 border-top-left-radius: 5px;
		 border-top-right-radius: 5px;
	}
</style>
<script>
	$(document).ready(function(){	
		$('[data-toggle="popover"]').popover({ placement : 'right', trigger: "hover" });
		userLoad();
		
	});
	
	function userLoad(){
		
		var ruta = obtenerContexto();
		
		var formatterBotones = function(cellVal,options,rowObject)
		{	
			var opciones = "<center>";
				
				opciones += "<a href=javascript:userEdit('";
				opciones += rowObject.idUser + "','";
				opciones += rowObject.password + "','";
				opciones += rowObject.nickUser + "','";
				opciones += rowObject.firstName + "','";
				opciones += rowObject.lastName.replace(/\s/g,"_") + "','";
				opciones += rowObject.birthdate + "') >";
				opciones += "<img src='/"+ruta+"/recursos/images/icons/edit_24x24.png' border='0' title='User EDIT...'/>";
				opciones += "</a>";
				
				opciones += "&nbsp;&nbsp;";
				
				opciones += "<a href=javascript:userDelete('";
				opciones += rowObject.idUser + "') >";
				opciones += "<img src='/"+ruta+"/recursos/images/icons/eliminar_24x24.png' border='0' title='User DELETE'/>";
				opciones += "</a>";
				
				opciones += "</center>";
				
			return opciones;
					
		};
		
		jQuery("#grilla").jqGrid(
		{
			url : 'users-all.json',
			datatype : "json",
			mtype: 'POST',
			height: 'auto',
			width: 'auto',
			colNames : ['ID', 'Nick User', 'First Name', 'Last Name', 'Birthdate', 'Options'],
			colModel : [{
				name : 'idUser',
				index: 'idUser',
				sortable:false,
				width: 50,
				align: 'center'
			},{
				name : 'nickUser',
				index: 'nickUser',
				sortable:false,
				width: 50,
				align: 'left'
			},{
				name : 'firstName',
				index: 'firstName',
				sortable:false,
				width: 100,
				align: 'left'
			},{
				name : 'lastName',
				index: 'lastName',
				sortable:false,
				width: 100,
				align: 'left'
			},{
				name : 'birthdate',
				index: 'birthdate',
				sortable:false,
				width: 100,
				align: 'center',
				format: 'd/m/Y',
				formatter: 'date'
			},{					
				name:'idUser',
				index:'idUser',
				width:100,
				sortable:false,
				search: false,
				formatter:formatterBotones
			}],								
			rowNum : 20,
			pager : '#pgrilla',
			sortname : 'idUser',
			autowidth: true,
			rownumbers: true,
			viewrecords : true,
			sortorder : "idUser",
			caption : "User All"				

		}).trigger('reloadGrid');
	}

	
	function userEdit(idUser, nickUser, password, firstName, lastName, birthdate){
		//alert("userEdit");
		$('#user_modal').modal({
			backdrop: 'static',
			keyboard: false
		});
		
		$('#title').html("Modify User");
		colorLabels();
		
		$('#idUser').val(idUser);
		$('#nickUser').val(nickUser);
		$('#password').val(password);
		$('#firstName').val(firstName);
		$('#lastName').val(lastName.replace(/\_/g," "));
		$('#birthdate').val(birthdate);
	}
	
	function colorLabels(){
		$('#lblnickUser').css("color","black");
		$('#lblpassword').css("color","black");
		$('#lblfirstName').css("color","black");
		$('#lbllastName').css("color","black");
		$('#lblbirthdate').css("color","black");
		
		$('#lblnickUser-img').hide();
		$('#lblpassword-img').hide();
		$('#lblfirstName-img').hide();
		$('#lbllastName-img').hide();
		$('#lblbirthdate-img').hide();
	}
	
	
	function save(){
		
		var ruta = obtenerContexto();
		jsonObj = [];
		var parameters = new Object();
		parameters.idUser = $("#idUser").val();
		parameters.nickUser = $("#nickUser").val();
		parameters.password = $("#password").val();
		parameters.firstName = $("#firstName").val();
		parameters.lastName = $("#lastName").val();
		var fecha = new Date($("#birthdate").val());		
		parameters.birthdate = fecha;
		
		$.ajax({
			type: "POST",
		    async:false,
		    url: "save-user.json",
		    cache : false,
		    data: parameters,
		    success: function(result){
		            
		        if(result.camposObligatorios.length == 0){
	                	
	            	$('#user_modal').modal('hide');
	            	
		            $.gritter.add({
						// (string | mandatory) the heading of the notification
						title: 'Mensaje',
						// (string | mandatory) the text inside the notification
						text: result.mensaje,
						// (string | optional) the image to display on the left
						image: "/" + ruta + "/recursos/images/confirm.png",
						// (bool | optional) if you want it to fade out on its own or just sit there
						sticky: false,
						// (int | optional) the time you want it to be alive for before fading out
						time: ''
					});
		            
		            userLoad();
		            
				}else{
	                	
	            	colorLabels();
	            	fila = "";
	            	$.each(result.camposObligatorios, function(id, obj){
	                        
	                	$("#" + obj.nombreCampo).css("color", "red");
	                    $("#" + obj.nombreCampo + "-img").show();
	                    $("#" + obj.nombreCampo + "-img").attr("data-content", obj.descripcion);
	                        
					});
	                	
				}
	                
			}
		});	
	}

	
	function NewUser(){
		$('#user_modal').modal({
			backdrop: 'static',
			keyboard: false
		});
		
		$('#title').html("New User");
		colorLabels();
		
		$('#idUser').val('');
		$('#nickUser').val('');
		$('#password').val('');
		$('#firstName').val('');
		$('#lastName').val('');
		$('#birthdate').val('');
	}
	
</script>

</head>
<body>
	<table border="0" width="100%">
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td width="10%" align="right"><b>ID<b/></td>
			<td width="2%">:</td>
			<td width="10%"><input type="text" id="findID" class="form-control" maxlength="8" /></td>
			<td width="15%" align="right"><b>FIRST NAME<b/></td>
			<td width="2%">:</td>
			<td width="15%"><input type="text" id="findFirstName" class="form-control" maxlength="150" /></td>
			<td width="46%">&nbsp;</td>		
		</tr>
		<tr><td colspan="7">&nbsp;</td></tr>
		<tr>
			<td colspan="7">&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" onclick="findUser()">
					<img src="recursos/images/icons/buscar_16x16.png" alt="Find User..." />&nbsp;Find
				</button>&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" onclick="NewUser()" data-target="#user_modal">
					<img src="recursos/images/icons/nuevo_16x16.png" alt="New User..." />&nbsp;New
				</button>
			</td>
		</tr>
		<tr><td colspan="7"><hr></td></tr>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="7">
				<table id="grilla"></table>
				<div id="pgrilla"></div>
			</td>
		</tr>
	</table>
	
	
<div class="modal fade" id="user_modal" role="dialog" data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog">
		
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-header-primary">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><span id="title" /></h4>
			</div>
			<div class="modal-body">
				
					<table border="0" style="width: 500px;">
						<tr>
							<td colspan="7" align="right">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="7" align="left">
								<button type="button" class="btn btn-primary" onclick="save(1)">
									<img src="recursos/images/icons/guardar_16x16.png" alt="Save User Information" />&nbsp;Save
								</button>
							</td>
						</tr>
						<tr>
							<td colspan="7" align="right">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lblidUser"><b>ID User (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="text" id="idUser" class="form-control" maxlength="200" disabled="disabled"/></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lblnickUser"><b>Nick User (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="text" id="nickUser" class="form-control" maxlength="200" /></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lblpassword"><b>Password (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="password" id="password" class="form-control" maxlength="200" style="text-transform: uppercase;"/></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lblfirstName"><b>First Name (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="text" id="firstName" class="form-control" maxlength="200" style="text-transform: uppercase;"/></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lbllastName"><b>Last Name (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="text" id="lastName" class="form-control" maxlength="200" style="text-transform: uppercase;"/></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td><span id="lblbirthdate"><b>Birthdate (*)</b></span></td>
							<td width="5px">&nbsp;</td>
							<td><b>:</b></td>
							<td width="5px">&nbsp;</td>
							<td><input type="text" id="birthdate" class="form-control" maxlength="200" style="text-transform: uppercase;"/></td>
							<td valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td width="10px">&nbsp;</td>
							<td colspan="6"><b>(*) Required fields</b></td>
						</tr>
					</table>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
		  
	</div>
</div> 
 
<div class="modal fade" id="alert_modal" role="dialog" data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog">
		
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-header-primary">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Delete User</h4>
			</div>
			<div class="modal-body">
					
				<table border="0">
					<tr>
						<td><img src="recursos/images/icons/exclamation_32x32.png" border="0" />&nbsp;<b><span id="mensajeEliminar" /></b></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="aceptar">Yes</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Not</button>
			</div>
		</div>
		  
	</div>
</div>
	
</body>
</html>