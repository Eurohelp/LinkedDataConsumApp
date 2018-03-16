function getData() {
	var form = $("#form");
	$.ajax({
		url : "ServGeneradorIndex",
		data : form.serialize(),
		type : "post",
		success : function(data) {
			console.log(data);
			$("#pageContent").html("");
			$("#pageContent").html(data);
		}
	});
}