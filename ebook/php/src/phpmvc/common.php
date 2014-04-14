<?php
/**
 *常用函数
 *
 */

//载入model类,并实例化
function model($name = 'model'){
	$name = ucfirst($name);
	$file = MODEL.$name.'.class.php';
	if(file_exists($file)){
		include_once $file;
		return $model = new $name();
	}else{
		echo 'No This Model';
	}
}

//载入视图
function view($name,$param){
	$file = VIEW.$name;
	if(file_exists($file)){
		extract($param);
		include_once $file;
	}else{
		echo 'No This View';
	}
}


//跳转页面
function jump($c = 'Index', $a = 'init', $info = ''){
	$port = isset($_SERVER['SERVER_PORT']) && $_SERVER['SERVER_PORT'] == '443' ? 'https://' : 'http://';
	$info = $info ? '&info=' . $info : '';
	$url = $port . $_SERVER['HTTP_HOST'].':'.$_SERVER['SERVER_PORT'].$_SERVER['PHP_SELF'] . '?c=' . $c . '&a=' . $a . $info;
	header('Location: ' . $url);
}




