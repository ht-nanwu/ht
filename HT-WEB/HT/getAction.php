<?php
	//定义常量
	define('CONTROLLER','Controller/');
	define('VIEW','View/');
	
	//加载配置文件和常函数
	include_once 'common/Constance.php';
	include_once 'common/FunctionUtil.php';
	$controller = "";
	$action = "init";
	//根据url决定action
	if(isset($_GET['role']) && !empty($_GET['role'])){
		if($_GET['role'] == "admin"){
			header("Location: View/a/index.html");			
		}
	}else if(isset($_POST['action']) && !empty($_POST['action'])){
		if(isset($_POST['method']) && !empty($_POST['method'])){
			$action = $_POST['method'];
		}
		$controller = ucfirst($_POST['action']);
	}else {
		$controller = "SelectArticle";
	}
	//加载请求的控制器
	$file = CONTROLLER.$controller.'.class.php';
	if(file_exists($file)){
		include_once $file;
		//运行
		$app = new $controller();
		$app->$action();
	}
?>