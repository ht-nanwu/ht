<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>iterator Tag Example</title>
<style type="text/css">@import url(css/main.css);</style>
<style>
table {
	padding:0px;
	margin:0px;
	border-collapse:collapse;
}
td, th {
	border:1px solid black;
	padding:5px;
	margin:0px;
}
.evenRow {
    background:#f8f8ff;
}
.oddRow {
	background:#efefef;
}
</style>
</head>
<body>
<div id="global" style="width:250px">
    First 4 prime number
	<ul>
    <s:iterator value="{2, 3, 5, 7}">
        <li><s:property/></li>
    </s:iterator>
    </ul>

    <s:set name="car" value="{ 'Chrysler', 'Ford', 'Kia'}"/>
    Cars:
    <s:iterator value="#car" status="status">
    	<s:property/><s:if test="!#status.last">,</s:if>
    </s:iterator>
	<p>
    <table>
    <tr>
        <th>Id</th>
        <th>Description</th>
    </tr>
    <s:iterator value="commentValue" status="status">
   
        <s:property value="id"/>
        <s:property value="articleComent"/>

    </s:iterator>
    

    </table>
    
    
</div>
</body>
</html>
