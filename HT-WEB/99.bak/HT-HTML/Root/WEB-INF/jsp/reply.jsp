<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<tiles:insert definition="layout" flush="true">
	<tiles:put name="script" type="string" direct="true">
		<script>
			$(document).ready(function() {
				$('#topic').click(function() {
					$('body').append('<div id="body_hidden"></div>');
					$('#body_hidden').fadeIn(300);
					$('#topic_hidden_content').fadeIn(300);
				});
				$('#topic_hidden_content').click(function() {
					$('#body_hidden,#topic_hidden_content').fadeOut(300, function() {
						$('#body_hidden').remove();
					});
				});
				
				$('#reply_button').click(function() {
					var textarea  = $('.textarea_reply')[0],
					taWidth = textarea.offsetWidth,
					taHeight = textarea.offsetHeight,
					taTop = textarea.offsetTop,
					taLeft = textarea.offsetLeft,
					taText = textarea.value,
					fpTop = $('.each_reply')[0].offsetTop - 3;
					
					var $postContent = $('<p>').addClass('post_content').text(taText).css('visibility', 'hidden'),
						$postTimestamp = $('<p>').addClass('post_info').text('Posted on: ' + new Date().toUTCString()).css('visibility', 'hidden'),
						$post = $('<li>').addClass('each_reply').append($postContent).append($postTimestamp).hide();
					textarea.value = '';
					$post.prependTo('.reply_list');
					
					var $hoverDiv = $('<div>').addClass('hover').text(taText.substring(3) + '......')
									.css({'width': taWidth,'height': taHeight,'top': taTop,'left': taLeft});
					$hoverDiv.appendTo('#reply').delay(500).animate({'top': fpTop}, 1000, 'swing')
									.queue(function() {
									$postContent.css('visibility', 'visible');
									$hoverDiv.delay(200).stop().fadeOut();
									$postTimestamp.hide().css('visibility', 'visible').fadeIn();
									});
					$post.delay(500).slideDown(1000);
				});
			});
		</script>
	</tiles:put>
	<tiles:put name="content" type="string" direct="true">
		<div id="content">
			<div id="article">
				<label for="tab1">前一篇</label>
				<label for="tab2">后一篇</label>
				<pre id="article_content">
				
				</pre>
			</div>
			<div id="reply">
				<textarea class="textarea_reply"></textarea>
				<span id="reply_button" class="clearfix">提交</span>
				<div class="reply_content">
					<ul class="reply_list">
						<li class="each_reply">
							<p class="post_content">test</p>
							<p class="post_info">test</p>
						</li>
						<li class="each_reply">
							<p class="post_content">test</p>
							<p class="post_info">test</p>
						</li>
						<li class="each_reply">
							<p class="post_content">test</p>
							<p class="post_info">test</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</tiles:put>
</tiles:insert>