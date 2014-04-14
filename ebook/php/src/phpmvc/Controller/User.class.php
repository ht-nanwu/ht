<?php
class User{

	public function login(){
		//载入登录视图
		$data['info'] = isset($_GET['info']) ? $_GET['info'] : '';
		view('login.html',$data);
	}

	public function doLogin(){
		//载入model类
		$model = model();
		$info = $model->find('user',$_POST);
		
		if($info){
			//将用户信息存入session
			$_SESSION['info'] = $info[0];
			
			//跳转到首页面
			jump('index');
		}else{
			jump('user','login','用户名或密码错误');
		}

	}
	
}