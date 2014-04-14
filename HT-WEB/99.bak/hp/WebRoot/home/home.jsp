<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../headerPathCommon.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>myHome</title>
		<%@ include file="../headerFileCommon.jsp"%>
		<script type="text/javascript" src="js/mine-editor.js"></script>
		<script>
			$(document).ready(function() {
				$("#editor-button div").click(function() {
					var writeConfirm = confirm("确定发表？")
					if(writeConfirm){
						$("img",window.frames[0].document.body).removeAttr("src");
						var editorHtml = window.frames[0].document.body.innerHTML;
						$('#airticle-content').attr('value', editorHtml);
						form1.submit();
					}
				});
		
				$("#fixed_title a").click(function() {
					$("#hidden-editor").fadeIn(300);
					$('#menu-body').append('<div id="hidden-all"></div>');
					$('#hidden-all').fadeIn(300);
				});
		
				$('#btn-close, #hidden-all').live('click', function() {
					var liveConfirm = confirm("确定离开编辑画面吗？")
					if (liveConfirm) {
						$('#hidden-all,#hidden-editor').fadeOut(300, function() {
									$('#hidden-all').remove();
								});
					}
					return false;
				});
				
				$('div[id=text]').each(function(){
					var id = $(this).find('input').val();
					$(this).find('img[id|=img_prev]').each(function(){
						index = $(this).attr('id').substring(9);
						$(this).attr('src','getImage.action?imagepath='+index+'&id='+id);
					})
				});
			});
		</script>
	</head>
	<body id="menu-body">
		<div id="home-top">


			<div id="nav">
				<div id="fixed_title">
					<a href="javascript:void(0);" style="text-decoration: none">╭(╯3╰)╮亲留点啥。。。。</a>
				</div>
			</div>
		</div>

		<div id="menu">
			<div id="maincontent" class="clearfix">

				<div id="maincontent_left" class="clearfix">

					<div id="post">
						<s:iterator value="articleList">

							<div id="date">
								<s:property value="updatetime_year" />
								<BR>
								<s:property value="updatetime_month_day" />
							</div>

							<div id="info">
								<h2>
									<a href="" title=""><s:property value="article_title" /> </a>
								</h2>
								<span id="posted">Posted by <a href="" title=""
									rel="author"> <s:property value="article_user" /> </a> in <a
									href="" title=""> <s:property value="article_big_category" />
								</a>, <a href="" title=""> <s:property
											value="article_small_category" /> </a> </span>
							</div>

							<div id="text">
								<input type="hidden" value=<s:property value="article_title" />>
								<p>
									${article_content}
								</p>
							</div>
						</s:iterator>
						<div id="details">
							<span id="responses"> <a href="" title="">120Comments</a>
							</span>
							<a href="" id="postlink">read more</a>
						</div>
						<div id="GuestLeaveMsgBoard" class="clearfix">
							
							<div id="Comments">
								<label>name:</label>
								<br><input type="text" name="">
								<br>
								<br>
								<label>mail:</label>
								<br>
								<input type="text" name="">
								<textarea rows="2"> </textarea>
								<div id="Comments-Img">
									<div id="Comments-Img-upload"
										onClick="document.getElementById('loadButton').click();">
									</div>
									<input type="file" style="display: none" id="loadButton"
										onchange="getImage(this)" />
									<div id="commit">
										回复
									</div>
								</div>

								<div id="showImage">
									<img id="img_prev">
								</div>
							</div>
						</div>
						<div id="comments-contents">
							<img alt="游客" src="pic/guest.png" width="36px" height="36px">
							<span style="color: #369; font-size: 1.2em;">wushp</span>
							<p style="margin-left: 35px;">
								Cool! Although there seems to be an disconnect when you use
								returns. If you use a return it counts a character. For example
								if you use 1 return when you reach 1 character remaining you can
								no longer type a character until you remove the return.
							</p>
						</div>

						<div id="comments-contents">
							<img alt="游客" src="pic/guest.png" width="36px" height="36px">
							<span style="color: #369; font-size: 1em;">wushp</span>
							<p style="margin-left: 35px;">
								Cool! Although there seems to be an disconnect when you use
								returns. If you use a return it counts a character. For example
								if you use 1 return when you reach 1 character remaining you can
								no longer type a character until you remove the return.
							</p>
						</div>

						<div id="comments-contents">
							<img alt="游客" src="pic/guest.png" width="36px" height="36px">
							<span style="color: #369; font-size: 1em;">wushp</span>
							<p style="margin-left: 35px;">
								Cool! Although there seems to be an disconnect when you use
								returns. If you use a return it counts a character. For example
								if you use 1 return when you reach 1 character remaining you can
								no longer type a character until you remove the return.
							</p>
						</div>

					</div>

					<div id="loading_more">
						<a href="http://ww">查看更多 剩余（3）篇</a>
					</div>
				</div>
				<div id="maincontent_right">
					<script>
						getHuaMian('common/topRight.jsp', '#maincontent_right');
					</script>
				</div>
			</div>
		</div>
		<%@ include file="../common/editor.jsp"%>
	</body>
</html>