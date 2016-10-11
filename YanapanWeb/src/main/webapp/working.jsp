<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Working List</title>
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
		workingLoad();
		
	});
	
	function workingLoad(){
		
		var ruta = obtenerContexto();
		
		var formatterBotones = function(cellVal,options,rowObject)
		{	
			//firstName = replaceAll(rowObject.firstName, " ", "#");
			//lastName = replaceAll(rowObject.lastName, " ", "#");
			var opciones = "<center>";
				
				opciones += "<a href=javascript:workingEdit('";
				opciones += rowObject.idWorkingDate + "') >";
				opciones += "<img src='/"+ruta+"/recursos/images/icons/edit_24x24.png' border='0' title='Working EDIT'/>";
				opciones += "</a>";
				
				opciones += "&nbsp;&nbsp;";
				
				opciones += "<a href=javascript:workingDelete('";
				opciones += rowObject.idWorkingDate + "') >";
				opciones += "<img src='/"+ruta+"/recursos/images/icons/eliminar_24x24.png' border='0' title='Working DELETE'/>";
				opciones += "</a>";
				
				opciones += "</center>";
				
			return opciones;
					
		};
		
		jQuery("#grilla").jqGrid(
		{
			url : 'working-all.json',
			datatype : "json",
			mtype: 'POST',
			height: 'auto',
			width: 'auto',
			colNames : ['ID', 'First Name', 'Last Name', 'Type', 'Time', 'Latitude', 'Longitude', 'Options'],
			colModel : [{
				name : 'idWorkingDate',
				index: 'idWorkingDate',
				sortable:false,
				width: 50,
				align: 'center'
			},{
				name : 'user.firstName',
				index: 'user.firstName',
				sortable:false,
				width: 100,
				align: 'left'
			},{
				name : 'user.lastName',
				index: 'user.lastName',
				sortable:false,
				width: 100,
				align: 'left'
			},{
				name : 'type',
				index: 'type',
				sortable:false,
				width: 50,
				align: 'center'
			},{
				name : 'time',
				index: 'time',
				sortable:false,
				width: 100,
				align: 'center'
			},{
				name : 'latitude',
				index: 'latitude',
				sortable:false,
				width: 100,
				align: 'center'
			},{
				name : 'longitude',
				index: 'longitude',
				sortable:false,
				width: 100,
				align: 'center'
			},{					
				name:'idWorkingDate',
				index:'idWorkingDate',
				width:100,
				sortable:false,
				search: false,
				formatter:formatterBotones
			}],								
			rowNum : 20,
			pager : '#pgrilla',
			sortname : 'idWorkingDate',
			autowidth: true,
			rownumbers: true,
			viewrecords : true,
			sortorder : "idWorkingDate",
			caption : "WorkingDate All",
			afterInsertRow: function(rowId, data, item){
				//alert(rowId + ' - ' + data + ' - ' + item.total);
				if ( (item.type == "I")  ) {
					$("#grilla").setCell(rowId, 'type', 'INGRESO', { 'background-color':'#F5A9A9','color':'white','font-weight':'bold' });
				} else {
					$("#grilla").setCell(rowId, 'type', 'SALIDA', { 'background-color':'#F5A9A9','color':'white','font-weight':'bold' });
				}
			}

		}).trigger('reloadGrid');
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
				<button type="button" class="btn btn-primary" onclick="findWorkingDate()">
					<img src="recursos/images/icons/buscar_16x16.png" alt="Find WorkingDate..." />&nbsp;Find
				</button>&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" onclick="NewworkingDate">
					<img src="recursos/images/icons/nuevo_16x16.png" alt="New WorkingDate..." />&nbsp;New
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
</body>
</html>