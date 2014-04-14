/**
 * 取得menu的子页面
 * 
 * @param huaMianAddress
 *            画面
 * @param divID
 *            目标ID
 * @return 加载目标页面
 */

function getHuaMian(huaMianAddress, divID) {
	$(divID).load(huaMianAddress, function(response, status, xhr) {
				if (status == "error") {
					var msg = "Sorry but there was an error: ";
					$("#error").html(msg + xhr.status + " " + xhr.statusText);
				}
			});
}
// 获取浏览器版本
function getBrowser() {
	var agentValue = window.navigator.userAgent.toLowerCase();
	if (agentValue.indexOf('msie') > 0) {
		return "i";
	} else if (agentValue.indexOf('firefox') > 0) {
		return "f";
	} else if (agentValue.indexOf('chrome') > 0) {
		return "c";
	}
}
/**
 * 图片取得
 * 
 * @param 图片流
 * @param 获取图片方式
 * 
 */
function getImage(input, flag, count) {
	if (getBrowser() == "i") {
		targetID = document.frames["editor-iframe"].document
				.getElementById('img_prev');
	} else {
		// targetID =
		// document.getElementById("editor-iframe").contentWindow.document
		// .getElementById('img_prev');
		var selector = '#img_prev-' + count;
		targetID = $(selector, window.frames[0].document.body)[0];
	}
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			if (flag == 1) {
				targetID.src = e.target.result;
				targetID.width = 150;
				targetID.height = 200;
			}
		};
		reader.readAsDataURL(input.files[0]);

	} else {

		// targetID.select();
		// 解决IE9下document.selection拒绝访问的错误
		// targetID.blur();
		targetID.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		targetID.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = input.value;
		targetID.width = 150;
		targetID.height = 200;
	}

}
