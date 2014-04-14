/*
 * homeproject编辑器
 * 
 * 作者：吴圣平
 */
$(document).ready(function() {

	/* img计数器 */
	var count = 0;

	/* 控件行数计数器 */
	var rowCounts = 0;

	/* 行控件数计数器 */
	var eachRowControlsCounts = 1;

	/* 背景图片偏移计数 */
	var backgroundMoveCounts = 4;

	/* 编辑器的div控件 */
	var controlsDiv = [
			// 第一排
			'bold', 'italic', 'underline', 'strikethrough', '|', 'subscript',
			'superscript', '|', 'InsertOrderedList', 'InsertUnorderedList',
			'|', 'outdent', 'indent', '|', 'justifyLeft', 'justifyCenter',
			'justifyRight', 'justifyFull', '|', 'RemoveFormat', '|', 'undo',
			'redo',
			// 第二排
			'image', 'InsertHorizontalRule', 'createLink', 'unlink', '|',
			'cut', 'copy', 'paste', 'print'];

	/* 编辑器的select控件及其内容 */
	var controlsSelectOption = [{
				'Font' : '',
				'Verdana' : 'Verdana',
				'Arial' : 'Arial',
				'Georgia' : 'Georgia',
				'Trebuchet MS' : 'Trebuchet MS'
			}, {
				'1' : '1',
				'2' : '2',
				'3' : '3',
				'4' : '4',
				'5' : '5',
				'6' : '6',
				'7' : '7'
			}, {
				'Style' : '',
				'Paragrapg' : '<p>',
				'head 1' : '<h1>',
				'head 2' : '<h2>',
				'head 3' : '<h3>',
				'head 4' : '<h4>',
				'head 5' : '<h5>',
				'head 6' : '<h6>'
			}];
	/* 编辑器的位置 */
	var controlsPosition = ['-120', '-150', '-180', '-210', '-240', '-270',
			'-300', '-330', '-360', '-390', '-420', '-450', '-480', '-510',
			'-720', '-540', '-570', '-600', '-630', '-660', '-690', '-30',
			'-60', '-90', '-750'];

	/* 创建各个控件的div */
	$.each(controlsDiv, function(n, value) {

				if (n == 0 || n == 23) {
					$('#homeproject-editor')
							.append("<div id=\"row-header\"></div>");
					++rowCounts;
					eachRowControlsCounts = 1
				}

				if (controlsDiv[n] != "|") {

					$('#homeproject-editor > :nth-child(' + rowCounts + ')')
							.append("<div id=\"each-control\"></div>")
							.find('>:nth-child(' + eachRowControlsCounts + ')')
							.attr("title", value);
					++eachRowControlsCounts;
				} else {
					$('#homeproject-editor>:nth-child(' + rowCounts + ')')
							.append("<div id=\"each-control-divider\"></div>");
					++eachRowControlsCounts;
				}
			});

	// 添加selec-font控件
	$("div[title='image']").before("<select id=\"select-font\"></select>");

	// 添加selec-size控件
	$("div[title='image']").before("<select id=\"select-size\"></select>");

	// 添加selec-style控件
	// $("div[title='image']").before("<select id=\"select-style\"></select>");

	// 给select添加option
	$.each(controlsSelectOption, function(index_1, value_1) {
				$.each(value_1, function(index_2, value_2) {
					$($('#homeproject-editor select[id^="select-"]')[index_1])
							.append('<option value=\'' + value_2 + '\'>'
									+ index_2 + '</option>');
						// $('#homeproject-editor > div:last > :nth-child(' +
						// (index_1+1) + ')').append('<option value=\''+value_2
						// +'\'>'+index_2 +'</option>')；
					});
			});

	/*
	 * 1.每个控件布置背景 2.控件悬浮效果
	 */
	$("div[id='each-control']").each(function(index) {
		$(this).attr("style",
				'background-position: 0px ' + controlsPosition[index] + 'px;');
		$(this).hover(function() {
			$(this).attr(
					"style",
					'background-position: 34px ' + controlsPosition[index]
							+ 'px;');
		},

		function() {
			$(this).attr(
					"style",
					'background-position: 0px ' + controlsPosition[index]
							+ 'px;');
		});

	});

	/* 添加iframe和textarea */
	$('#homeproject-editor')
			.append('<iframe id=\"editor-iframe"\ frameborder=\"0\" width=\"584px"\ height=\"175px\"></iframe>');
	if (getBrowser() == 'i') {
		var editorForExecCommand = document.frames["editor-iframe"].document;
	} else {
		var editorForExecCommand = document.getElementById("editor-iframe").contentWindow.document;
	}

	// 只需键入以下设定，iframe立刻变成编辑器。
	editorForExecCommand.designMode = 'On';
	editorForExecCommand.contentEditable = true;

	// 但是IE与FireFox有点不同，为了兼容FireFox，所以必须创建一个新的document。
	editorForExecCommand.open();
	editorForExecCommand
			.writeln('<html><body style=\'background:#666;color:white;margin:0;font-size:1.4em;\'></body></html>');
	editorForExecCommand.close();

	/* 创建各个控件的div */
	$.each(controlsDiv, function(n, value) {

		if (controlsDiv[n] != "|") {
			if (controlsDiv[n] != "image" && controlsDiv[n] != "createLink") {
				$("div[title=\'" + value + "\']").click(function() {
							editorForExecCommand.execCommand(value);
						});
			} else if (controlsDiv[n] == "image") {
				$("div[title=\'image\']").click(function() {
					$('#homeproject-editor')
							.append('<input id="editor-inputFile-'
									+ count
									+ '" type="file" onchange="getImage(this,1,'
									+ count
									+ ')" name="myFile" style="display:none"></input>');
					if (getBrowser() == "i") {
						var win = window.frames["editor-iframe"];
						win.focus();
						win.document.selection.createRange()
								.pasteHTML('<img id=\"img_prev\"></img>');
					} else {
						var win = document.getElementById('editor-iframe');
						var focusPoint = win.contentWindow.getSelection()
								.getRangeAt(0);
						focusPoint.insertNode(focusPoint
								.createContextualFragment('<img id="img_prev-'
										+ count + '"></img>'));
					}
					$('#editor-inputFile-' + count).click();
					count++;
				});
			} else {
				$("div[title=\'createLink\']").click(function() {
					editorForExecCommand
							.execCommand('CreateLink', true, 'true');
				});
			}
		}
	});
	$('#select-font').change(function() {
		editorForExecCommand.execCommand('fontname', false,
				$('#select-font option:selected').text());
	});

	$('#select-size').change(function() {
		editorForExecCommand.execCommand('fontsize', false,
				$('#select-size option:selected').text());
	});

});
