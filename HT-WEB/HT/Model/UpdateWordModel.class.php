<?php
include_once('common/DBUtil.php');
/**
 * 搜索文章的持久层
 * @author 吴圣平
 *
 */
class UpdateWordModel{
	
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}
	
	/**
	 * 更新单词
	 */
	function updateWord($id,$spell,$word,$meaning,$del) {
		// 更新sql文
		$updateWordSql = 
		"UPDATE 
			n2_word 
		 SET 
		 	spell='$spell',
		 	word='$word',
		 	meaning='$meaning',
		 	del='$del',
		 	updateTime=now()
		 WHERE
		 	id='$id'	
		 	";
		if($id == ""){
			$updateWordSql = "INSERT INTO `n2_word` (`spell`, `word`, `meaning`, `del`, `updateTime`) VALUES ('$spell', '$word', '$meaning' , '0',now())";
			
		}
		// 检索文章
		echo $updateWordSql;
		$return = $this->useDB->excuteSql($updateWordSql);
		return $return;
	}
	
	/**
	 * 更新单词
	 */
	function updateSpellMiss($id,$spell,$input) {
		// 插入sql文
		$updateWordSql = "INSERT INTO `spell_miss` (`id`, `well_spell`, `bad_spell`) VALUES ('$id', '$spell', '$input')";
		
		$return = $this->useDB->excuteSql($updateWordSql);
		return $return;
	}
}
?>
