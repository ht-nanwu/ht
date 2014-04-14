<?php
include_once('common/DBUtil.php');
/**
 * 搜索文章的持久层
 * @author 吴圣平
 *
 */
class SelectDelAndUndelModel{
	
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}

	function selectDelAndUndel() {
		// 查询用sql文
		$selAllWords =
		"SELECT
			a.delNum,
			b.undelNum
		FROM
			(
				SELECT
					COUNT(*) AS delNum
				FROM
					n2_word
				WHERE
					del = '1'
			) a,
			(
				SELECT
					COUNT(*) AS undelNum
				FROM
					n2_word
				WHERE
					del = '0'
			) b";
		
		// 检索文章
		$return = $this->useDB->selectBy($selAllWords);		
		return $return;
	}
}
?>
