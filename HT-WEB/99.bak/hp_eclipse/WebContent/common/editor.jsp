<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="hidden-editor">
	<a href="" id="btn_close" title="Close Window"> <img
			src="pic/close_pop.png" id="btn-close" title="Close Window"
			alt="Close"> </a>
	<form method="post" action="articleAddAction" name="form1" enctype="multipart/form-data">
		<div id="main-content">
			<div id="aritcleAdd-head">
				<div id="aritcleAdd-title">
					<strong> 文章题目： </strong>
					<input id="aritcleAdd-inputText" type="text" placeholder="标题"
						size="50" name="articleAdd.article_title" />
				</div>

				<div id="aritcleAdd-note">
					<strong>作者评论：</strong>
					<input id="aritcleAdd-inputText" type="text" placeholder="评论"
						size="50" name="articleAdd.article_note" />
				</div>

				<div id="articleAdd-category">
					<strong>文章分类：</strong>
					<select id="big-category" name="articleAdd.article_big_category">
				       <option>----大分类----</option>
				       <option>源码DEMO</option>
				       <option>游戏人生</option>
				       <option>奇闻趣事</option>
			   		</select>
				    <select class="small-category">
				           <option>----小分类----</option>
				    </select>
				    <select class="small-category">
				       <option>Database</option>
				       <option>Java</option>
				       <option>Android</option>
				       <option>struts</option>
				       <option>Js</option>
				       <option>其它语言</option>
				   </select>  
				   <select class="small-category">
				       <option>DOTA</option>
				       <option>传奇</option>
				       <option>火焰之纹章</option>
				       <option>其它游戏</option>
				   </select>
				   <select class="small-category" >
				       <option>生边</option>
				       <option>摘录</option>
				       <option>转载</option>
				       <option>其它</option>
				    </select>
				</div>
			</div>
			 <script type="text/javascript">
		        $(document).ready(function(){
		            $("#big-category").change(function(){
		                $("#big-category option").each(function(i,o){
		                    if($(this).attr("selected"))
		                    {
		                        $(".small-category").removeAttr('name').hide();
		                        $(".small-category").eq(i).attr('name','articleAdd.article_small_category').show();
		                    }
		                });
		            });
		            $("#big-category").change();
		        });
 			</script>
			<fieldset id="editorArea">
				<legend>
					<strong>&nbsp;请输入内容：</strong>
				</legend>
				<div id="homeproject-editor">
				</div>
				<div id="editor-button">
					<div>
						回复
					</div>
				</div>
			</fieldset>
		</div>
		<input type="hidden" name="articleAdd.article_content" value=""
			id="airticle-content" />
	</form>
</div>