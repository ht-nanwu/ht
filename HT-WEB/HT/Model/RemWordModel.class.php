<?php
include_once('common/DBUtil.php');
/**
 * 搜索文章的持久层
 * @author 吴圣平
 *
 */
class RemWordModel{
	
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}
	
	/**
	 * 随机查询单词
	 */
	function findWord() {
		// 查询用sql文
		$selArticleSql = "SELECT * FROM n2_word WHERE del = 0 ORDER BY RAND() LIMIT 10";
		
		// 检索文章
		$return = $this->useDB->selectBy($selArticleSql);		
		return $return;
	}
}
?>
