

function validateUser() {
	var param = new Object();
	param.nickUser = $("#nickUser").val();
	param.password = $("#password").val();
	
	$.ajax({
		type : "GET",
		url : "rest/v1/users",
		data : JSON.stringify(param),
		async : true,
		dataType : "json",
		
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json")
		},
		success : function(data, status, jqXHR) {
			mostrarMensajeInfo("OK");
			
		},
		error : function (jqXHR, textStatus, errorThrown) {
			respuestaJson = jQuery.parseJSON(jqXHR.responseText);
			mostrarMensajeError(respuestaJson.mensaje)
		},
		complete : function(e, xhr, settings) {
			console.log("Complete");
			console.log("e.status: " + e.status);
		}
	});
	
	event.preventDefault();
};