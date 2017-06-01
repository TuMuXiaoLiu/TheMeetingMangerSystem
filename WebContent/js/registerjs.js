$("document").ready(function() {
	$("#employeename").blur(function() {
		if($(this).val().trim().length == 0) {
			$("#empnamespan").show();
		} else {
			$("#empnamespan").hide();
		}
	});

	$("#email").blur(function() {
		if($(this).val().trim().length == 0) {
			$("#emailspan").show();
		} else {
			$("#emailspan").hide();
		}
	});

});