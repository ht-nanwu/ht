<?php
class Index{

	//首页面
	public function init(){
		if(!isset($_SESSION['info'])){
			jump('user','login');
		}
		
		$model = model();
		
		$data['list'] = $model->select('loads',$_GET);
		$data['name'] = $_SESSION['info']['name'];
		
		view('list.html',$data);
		
		
	}
	
	
	
	
	
}