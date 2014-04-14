<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value="css/ht.css" />" rel="stylesheet"></link>
<script type="text/javascript" src="<c:url value="js/jquery.js" />"></script>
<tiles:insert attribute="script"></tiles:insert>
</head>
<body>
	<!-- Navigation -->
	<tiles:insert attribute="header"></tiles:insert>
	<!-- Content -->
	<tiles:insert attribute="content"></tiles:insert>
	<!-- Aside -->
	<tiles:insert attribute="aside"></tiles:insert>
	<!-- Footer -->
	<tiles:insert attribute="footer"></tiles:insert>

	<div id="topic_hidden">
		<pre id="topic_hidden_content">
			hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!hello world!!!
		</pre>
	</div>
</body>
</html>