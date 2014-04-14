<%@ include file="/WEB-INF/jsp/common/include.jsp"%>
<tiles:insert definition="layout" flush="true">
	<tiles:put name="script" type="string" direct="true">
		<script>
			$(document).ready(
					function() {
						$('#topic').click(function() {
							$('body').append('<div id="body_hidden"></div>');
							$('#body_hidden').fadeIn(300);
							$('#topic_hidden_content').fadeIn(300);
						});
						$('#topic_hidden_content').click(
								function() {
									$('#body_hidden,#topic_hidden_content')
											.fadeOut(300, function() {
												$('#body_hidden').remove();
											});
								});
					});
		</script>
	</tiles:put>
	<tiles:put name="content" type="string" direct="true">
		<div id="content">
			<ul id="content_tab">
				<li><a class="select_new" href="#">最新</a></li>
				<li><a class="select_popular" href="#">热门</a></li>
				<li><a class="selcet_discuess" href="#">讨论区</a></li>
			</ul>
			<div id="item_list" class="clearfix">
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
				<div id="single_item">
					<div id="title">
						<a href="#">你们好啊，我是网管</a>
					</div>
					<div id="scan_times">
						<ul id="scan_times_ul">
							<li><img alt="浏览次数" src="image/scan_times.png"> <span>33</span>
							</li>
						</ul>
					</div>
					<div id="topic">
						<h1>asdasdasdasdasd</h1>
					</div>
					<a id="topic_more" href="index.action">More</a>
				</div>
			</div>
		</div>
	</tiles:put>
</tiles:insert>