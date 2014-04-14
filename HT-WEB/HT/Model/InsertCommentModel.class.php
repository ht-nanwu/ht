<?php
include_once('common/DBUtil.php');
/**
 * 插入评论
 * @author 吴圣平
 *
 */
class InsertCommentModel{
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}

	/**
	 * 插入浏览记录
	 * @param 文章Id $articleId
	 * @param ip地址 $ip
	 */
	function insertComments($articleId, $ip,$comment) {
		//更新文章浏览
		$commentInsertSql = "INSERT INTO commentinfo (articleId,userIP,comment,updateTime) 
					VALUES('$articleId','$ip','$comment',NOW())";
		$this->useDB->excuteSql($commentInsertSql);
	}
	
	/**
	 * 检索评论
	 * @param 文章Id $articleId
	 * @return Ambigous <string, multitype:>
	 */
	function findComments($articleId) {
		$commentFindSql = "SELECT comment,updateTime FROM commentinfo WHERE articleId='$articleId'";
		// 检索评论
		return $this->useDB->selectBy($commentFindSql);
	}
}
?>