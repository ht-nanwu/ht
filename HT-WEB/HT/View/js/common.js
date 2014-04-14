// 查询文章ajax
function findArticle(id) {
	if(id != "B1" && id != "B2"){
		$(".reply_list").html('');
		$.ajax({
			type:"POST",
			url:"getAction.php",
			dataType:"json",
			data:{articleId:id},
			beforeSend:function(){
				$('.tree-node-selected').append('<img src="View/images/loading.gif" id="load"/>');
			},
			success:function(json){
				$('#load').remove();
				$("#loading").remove();
				$('#title').html(json[0][0]['title']);
				$('#content').html(unescape(json[0][0]['content']));
				$('#readTimes').html("浏览(" + json[0][0]['readTimes'] + ") |");
				$('#recieveGoodTimes').html("赞(" + json[0][0]['recieveGoodTimes'] +")");
				findComments(json[1]);
			}
		});
	} else if(id != "B2") {
		window.location="view/N2.html";
		//window.open("view/N2.html");
	} else {
		window.location="view/N2_7.html";
		//window.open("view/N2.html");
	}
}
	
// 查询评论
function findComments(json) {
	$(".reply_list").html('');
	var insertComment_1 = '<li class="each_reply"><p class="post_content">';
	var insertComment_2 = '</p><p class="post_info">';
	var insertComment_3 = '</p></li>';
	$.each(json,function(i){
		$prependInfo = insertComment_1+unescape(json[i]["comment"])+insertComment_2+json[i]["updateTime"]+insertComment_3;
		$(".reply_list").delay(500).prepend($prependInfo);
	});
}
	
// 加载comment动画效果
function loadCommemt() {
		var textarea  = $('.textarea_reply')[0],
		taWidth = textarea.offsetWidth,
		taHeight = textarea.offsetHeight,
		taTop = textarea.offsetTop,
		taLeft = textarea.offsetLeft,
		taText = textarea.value,
		fpTop = textarea.offsetTop + 160;
		
		var $postContent = $('<p>').addClass('post_content').text(taText).css('visibility', 'hidden'),
			$postTimestamp = $('<p>').addClass('post_info').text('Posted on: ' + (new Date().Format("yyyy-MM-dd hh:mm:ss"))).css('visibility', 'hidden'),
			$post = $('<li>').addClass('each_reply').append($postContent).append($postTimestamp).hide();
		textarea.value = '';
		$post.prependTo('.reply_list');
		
		var $hoverDiv = $('<div>').addClass('hover').text(taText.substring(0,13) + '......')
						.css({'width': taWidth,'height': taHeight,'top': taTop,'left': taLeft});
		$hoverDiv.appendTo('#reply').delay(500).animate({'top': fpTop}, 1000, 'swing')
						.queue(function() {
						$postContent.css('visibility', 'visible');
						$hoverDiv.delay(200).stop().fadeOut();
						$postTimestamp.hide().css('visibility', 'visible').fadeIn();
						});
		$post.delay(500).slideDown(1000,function(){
			$.ajax({
				type:"POST",
				url:"getAction.php",
				dataType:"json",
				data:
				{
					action:'insertComment',
					comment:taText,
					Id:$('#articleId').val()
				},
				success:function(json){
					findComments(json);
				}
			});
		});
}
	
// 时间格式化
Date.prototype.Format = 
function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}

function writeToTable(id,spell,word,meaning){
	var dom_tr = $('<tr>');
	$(dom_tr).append($('<td>',{width:'39px',height:'22px',id:'td_index'}));
	$(dom_tr).append($('<td>',{width:'38px',height:'22px',id:'word_index'}).html(id));
	$(dom_tr).append($('<td>',{width:'100px',height:'22px',id:'td_input'}));
	$(dom_tr).append($('<td>',{width:'80px',height:'22px',id:'td_spell'}).html(spell));
	$(dom_tr).append($('<td>',{width:'80px',height:'22px',id:'td_word'}).html(word));
	$(dom_tr).append($('<td>',{width:'200px',height:'22px',id:'td_meaning'}).html(meaning));
	$(dom_tr).append($('<td>',{width:'47px',height:'22px',id:'td_detail',align:'center'})
			 .append($('<a>',{href:'javascript:void(0)',id:'td_lnk_detail'}).html('详细')));
	$(dom_tr).append($('<td>',{width:'80px',height:'22px',id:'td_dictionary',align:'center'})
			 .append($('<img>',{src:'images/search.png',id:'td_img_dictionary'})));
	$(dom_tr).append($('<td>',{width:'80px',height:'22px',id:'td_status',align:'center'}));
	$(dom_tr).append($('<td>',{width:'40px',height:'22px',id:'td_del',align:'center'})
			 .append($('<input>',{type:'checkbox',id:'td_ckbox_del'})));
	$(dom_tr).append($('<td>',{width:'40px',height:'22px',id:'td_button'})
			 .append($('<img>',{src:'images/edit.png',id:'td_edit_button'}).hide()));
	
	$('#result_body_table').prepend($(dom_tr));
	reWriteIndex();
}

function reWriteIndex(){
	$('#result_body_table tr').each(function(i){
		$(this).find('#td_index').html(new Number(i) + 1)
	});
}

function updateWords(){
	var parent = $(this).parents('tr');
	
	var wordIndex = $('#word_index',parent).html();
	var input = $('#td_input',parent).html();
	var spell = $('#td_spell',parent).html();
	var word = $('#td_word',parent).html();
	var meaning = $('#td_meaning',parent).html();
	if(spell == "" && word=="" && meaning==""){
		alert("更新失败")
	}
	var del = 0;
	if($('#td_ckbox_del',parent).is(':checked')){
		del = 1;
	}
	$.ajax({
        type:"POST",
        url:"../getAction.php",
        dataType:"text",
		beforeSend:function(){
			$('#td_edit_button',parent).attr('src','images/loading.gif');
		},
        data:
        {
            action:"updateWord",
            id:wordIndex,
            input:input,
            word:word,
            spell:spell,
            meaning:meaning,
            del:del
        },
        success:function(json){
        	$('#td_edit_button',parent).attr('src','images/edit.png');
        	if(input != "" && $('#test').is(':checked')){
        		if(input == spell){
        			$('#td_status',parent).html('OK').css('color','blue');
        		}else{
        			$('#td_status',parent).html('NG').css('color','red');
        		}
				$('#td_spell',parent).css('background-color','white');
        	} else {
        		$('td',parent).each(function(){
        			$(this).css('color',"");
            	});
        		$('#td_edit_button',parent).fadeOut( "slow" );
        	}
        }
    });
}

//TD可编辑更改
//TODO
function editTd(){
	var filledWord = $(this).text();
	if(filledWord == ""){
		filledWord = $(this).find('#td_edit_input').val();
	}
	$(this).html('<input type="textarea" style="width:95%" id="td_edit_input">');
	$(this).find('#td_edit_input').val(filledWord);
	$(this).find('#td_edit_input').focus();
	$(this).find('#td_edit_input').bind({
		focusout:function(){
	        $(this).closest('td').text($(this).val());
	    },
	    change:function(){
	    	$(this).closest('td').css('color','red');
	    	$(this).closest('tr').find('img[id="td_edit_button"]').show().css("cursor","pointer");
		}
	});
}

//考试倒计时
function countDownToExm(){
	// set the date we're counting down to
	var target_date = new Date(2014,06,05,23,59,59).getTime();
	 
	// variables for time units
	var days, hours, minutes, seconds;
	 
	// get tag element
	var countdown = document.getElementById("countDown");
	 
	// update the tag with id "countdown" every 1 second
	setInterval(function () {
	 
	    // find the amount of "seconds" between now and target
	    var current_date = new Date().getTime();
	    var seconds_left = (target_date - current_date) / 1000;
	 
	    // do some time calculations
	    days = parseInt(seconds_left / 86400);
	    seconds_left = seconds_left % 86400;
	     
	    hours = parseInt(seconds_left / 3600);
	    seconds_left = seconds_left % 3600;
	     
	    minutes = parseInt(seconds_left / 60);
	    seconds = parseInt(seconds_left % 60);
	     
	    // format countdown string + set tag value
	    countdown.innerHTML = "N2考试倒计时<font color='red'>" + days + "</font>天, " + hours + "小时, "
	    + minutes + "分钟, " + seconds + "秒";  
	 
	}, 1000);
}