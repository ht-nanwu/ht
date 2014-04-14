<?php
class Model{
	
	private $link;
	
	//连接数据库
	public function __construct(){
		$this->link = mysql_connect(HOST,DBUSER,DBPASS) or die('ERROR: ' . mysql_error());
		mysql_select_db(DBNAME,$this->link) or die('ERROR: ' . mysql_error());
		mysql_query('set names utf8');
	}
	
	//查询一个用户是否存在，如果存在返回用户信息，不存在返加false
	public function findUser($param){
		$sql = 'select * from user where username = "' . $param['username'] . '" and userpass = "' . md5($param['userpass']) .'"';
		$result = mysql_query($sql,$this->link);
		if($result){
			return $row = mysql_fetch_assoc($result);
		}else{
			return false;
		}
	}
	
	//执行查讯语句
	public function query($sql = ''){
		if(empty($sql)){
			return 'SQL语句不能为空';
		}
		$result = mysql_query($sql,$this->link);
		if(!$result){
			return mysql_error();
		}else{
			while($data[] = mysql_fetch_assoc($result)){}
			unset($data[count($data)-1]);
			return $data;
		}
	}
	
	//查讯多条数据
	public function select($table, $data = '', $logic = ' and '){
		if(is_array($data)){
			foreach($data as $k=>$v){
				if($v){
					$sql[] = $k . ' like ' . '"%' . $v . '%"';  
				}
			}
			if(isset($sql)){
				$sql = ' where ' . implode($logic,$sql);
			}else{
				$sql = '';
			}
		}else{
			$sql = '';
		}
		$sql = 'select * from '. $table . $sql;
		return $this->query($sql);
	}
	
	//只查一条数据
	public function find($table, $data = '', $logic = ' and '){
		if(is_array($data)){
			foreach($data as $k=>$v){
				$sql[] = $k . '=' . '"' . $v . '"';  
			}
			$sql = ' where ' . implode($logic,$sql);
		
		}else{
			$sql = '';
		}
		$sql = 'select * from '. $table . $sql . ' limit 1';
		return $this->query($sql);
	}
	
	//添加数据
	public function insert($table, $data = ''){
		if(is_array($data)){
			foreach($data as $k=>$v){
				$field[] = $k;
				$value[] = '"' . $v . '"';
			}
			$field = implode(',',$field);
			$value = implode(',',$value);
			$sql = 'insert into ' . $table . '(' . $field . ')' . ' values('.$value.')';
			$result = mysql_query($sql);
			if(!$result){
				return mysql_error();
			}else{
				return true;
			}
		}else{
			return '没有数据可添加';
		}
	}
	
	
	
	
	
}