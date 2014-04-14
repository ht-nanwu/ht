<?php
	//定义常量
	define('MODEL','./Model/');
	define('CONTROLLER','./Controller/');
	define('VIEW','./Views/');
	
	//开启session
	session_start();
	
	//加载配置文件和常函数
	include_once './config.php';
	include_once './common.php';
	
	//检测&设置默认控制器
	if(isset($_GET['c']) && !empty($_GET['c'])){
		$controller = ucfirst($_GET['c']);
	}else{
		$controller = 'Index';
	}
	
	//检测&设置默认操作
	if(isset($_GET['a']) && !empty($_GET['a'])){
		$action = strtolower($_GET['a']);
	}else{
		$action = 'init';
	}
	
	//加载请求的控制器
	$file = CONTROLLER.$controller.'.class.php';
	if(file_exists($file)){
		include_once $file;
	}else{
		echo 'No This Controller';
	}

	//运行
	$app = new $controller();
	if(method_exists($app,$action)){
		$app->$action();
	}else{
		echo 'No This Action';
	}
	
