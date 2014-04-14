<?php
/**
 * 数据库链接，数据的增删，改，查
 * @author 吴圣平
 *
 */
class DBUtil {

	/** 链接对象*/
	private $link;

	/** 构造器 */
	public function __construct()
	{
		$this->link = new mysqli(HOST,USER,PSWD,DATEBASE);
		// 数据库异常
		if ($this->link->connect_error) {
			die();
		}
	}

	public function close(){
		$this->link->close();
	}

	/**
	 * 对某个表进行全检索
	 * @param 表名 $dbName
	 * @param 查询条件 $where
	 * @return string
	 */
	public function selectBy($selectSql){
		// 返回结果
		$resultArray = array();
		// 查询结果编码设置
		$this->link->set_charset("utf8");
		$result = $this->link->query($selectSql);
		// 生成数据集
		while($row = mysqli_fetch_array($result)){
			array_push($resultArray,$row);
		}
		// 数据集以及db切断
		$result->close();
		return $resultArray;

	}

	/**
	 * 插入或者更新
	 * @param sql文 $excuteSql
	 * @return string
	 */
	public function excuteSql($excuteSql){
			// 编码设置
			$this->link->set_charset("utf8");
			$this->link->query($excuteSql);
	}
}
?>