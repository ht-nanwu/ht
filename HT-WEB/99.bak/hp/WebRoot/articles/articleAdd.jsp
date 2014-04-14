<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../headerPathCommon.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<script type="text/javascript" src="js/mine-editor.js"></script>
		<%@ include file="../headerFileCommon.jsp"%>
	</head>

	<body>
		<form method="post" action="articleAddAction" name="form1">
			<div id="main-content">
				<div id="aritcleAdd-head">
					<div id="aritcleAdd-title">
						<strong> 文章题目： </strong>
						<input id="aritcleAdd-inputText" type="text" placeholder="haha"
							size="50" name="articleTitle" />
					</div>

					<div id="aritcleAdd-note">
						<strong>作者寄语：</strong>
						<input id="aritcleAdd-inputText" type="text" placeholder="haha"
							size="50" name="articleNote" />
					</div>

					<div id="articleAdd-category">
						<strong>文章分类：</strong>
						<select>
							<optgroup label="Swedish Cars">
								<option value="volvo">
									Volvo
								</option>
								<option value="saab">
									Saab
								</option>
							</optgroup>

							<optgroup label="German Cars">
								<option value="mercedes">
									Mercedes
								</option>
								<option value="audi">
									Audi
								</option>
							</optgroup>
						</select>
					</div>
				</div>
				<fieldset id="editorArea">
					<legend>
						&nbsp;请输入内容：
					</legend>
					<div id="homeproject-editor">
					</div>
					<div id="editor-button"><div>回复</div></div>
				</fieldset>
			</div>
			<input type="hidden" name="articleContent" value="" />
		</form>
		<script>
			$("#editor-button div").click(
					function() {
						var editorHtml = window.frames[0].document.body.innerHTML;
							form1.articleContent.value = editorHtml;
							form1.submit();
					});
		</script>
	</body>

</html>
