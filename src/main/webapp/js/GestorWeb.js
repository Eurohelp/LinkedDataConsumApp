function getData() {
	var form = $("#form");
	$.ajax({
		url : "ServGeneradorIndex",
		data : form.serialize(),
		type : "post",
		success : function(data) {
			console.log("jolines"+data)
			console.log(data);
			if (data.includes("No hay datos que recuperar")) {
				console.log("error")
				swal(
						   'Ops!',
						   data,
						   'warning'
						  );
			} else {
				$("#pageContent").html("");
				$("#buttonSubmitClass").html("");
				$("#pageContent").html(data);
			}
		}
	});
}
function restablecer() {
	$("#pageContent").html("");
	$("#buttonSubmitClass").html("");

	var form = $("#form");
	$.ajax({
		url : "ServGeneradorIndex",
		data : form.serialize(),
		type : "post",
		success : function(data) {
			console.log("jolines"+data)
			console.log(data);
			if (data.includes("No hay datos que recuperar")) {
				console.log("error")
				swal(
						   'Ops!',
						   data,
						   'warning'
						  );
			} else {
				$("#pageContent").html("");
				$("#pageContent").html(data);
			}
		}
	});
}