<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery.js"></script>
<title>JqueryAjaxTest</title>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			async:true,
			beforeSend: function(jqXHR,settings ){
				$('#jqXHR').val(jqXHR);
				$('#settings').val(settings);
			},
			url : "JqueryAjaxTest.action",
		});
	});
</script>
</head>
<body>
	<p>
	<h1>async:</h1>
	所有请求均为异步请求（也就是说这是默认设置为 true ）
	</p>
	<input type="text" value="" id="jqXHR">
	<input type="text" value="" id="settings">
</body>
</html>