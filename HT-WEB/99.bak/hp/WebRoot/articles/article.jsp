<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String content = request.getContextPath();
	pageContext.setAttribute("ctx", content);
%>
<!DOCTYPE HTML>
<html>
	<head>

		<title>动态文章内容</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="${ctx }/css/articles.css">
		<link rel="stylesheet" href="${ctx }/css/tinyeditor.css">
		<script src="${ctx }/js/tiny.editor.packed.js"></script>
		<script src="${ctx }/js/jquery.min.js"></script>

	</head>

	<body>
		<div id="main-content">
			<div id="article">
				<div>
						<s:iterator value = "articleList">
							<h2 id="title"> 
								文章题目：<s:property value="article_id" />
							</h2>
							<span id="writer">用户：吴圣平</span>
			
							<div id="writer-note">
								<div id="writer-note-content">
									<strong>作者寄语:</strong>
								</div>
							</div>
							<div id="pictures">
							</div>
			
							<div id="content">
							
							</div>
						</s:iterator>
						<br>
				</div>
				<div id="buttonposition">
					<span id="modify" onclick="articleModify()">
						文章修改
					</span>
				</div>	
			</div>

			<p id="commments-title">
				<br>
				评论：
			</p>
			<form method="post" action="articleAddComment" name="form1">
			<div id="comments">
			<s:iterator value = "ArticleCommentParent_Map"id="colum">  
				<s:iterator value = "#colum.value">
					<div id="commentUser" >
					<s:property value="article_comment_user"/>:&nbsp;回复&lt;楼主&gt;
					</div>
					<div id="commentcontent">
						<s:property value="article_comment"/>
					</div>
					<s:iterator value = "ArticleCommentChild_Map" id="colum">
						<s:iterator value = "#colum.value">
							<div id="commentContent1">
								<s:property value="article_comment_child_user"/>
							</div>
						</s:iterator>		
					</s:iterator>
				</s:iterator>		
			</s:iterator>			
			</div>
			</form>
			<div id="edit_border">
			<fieldset id="editorArea">
					<legend>
						&nbsp;请输入内容：
					</legend>
					<textarea id="tinyeditor" style="width: 400px; height: 200px"></textarea>
				</fieldset>
			</div>	
			<script src="${ctx }/js/editorStart.js"></script>
		<script>
	document.getElementById("button").setAttribute("onclick", "getTxt1()");
	function getTxt() {
		var newHtml = window.frames[0].document.getElementById("editor").innerHTML;
		var creatHtml = document.createElement("div");
			creatHtml.id="comments";
			creatHtml.innerHTML = newHtml;
			document.getElementById("commentsLists").appendChild(creatHtml);
		
	}
	function getTxt1() {
					
	}
	
	function getParentName(){

		$("#1").click( function () { alert("123123"); });
	}
	</script>
			
		</div>
	</body>
</html>


