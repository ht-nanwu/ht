<?php
//跳转页面
function jump(){
	$port = isset($_SERVER['SERVER_PORT']) && $_SERVER['SERVER_PORT'] == '443' ? 'https://' : 'http://';
	$url = $port . $_SERVER['HTTP_HOST'].':'.$_SERVER['SERVER_PORT']."/View/a/index.html";
	header('Location: ' . $url);
}
?>