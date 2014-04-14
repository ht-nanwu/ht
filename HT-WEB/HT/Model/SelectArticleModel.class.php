<?php
include_once('common/DBUtil.php');
/**
 * 搜索文章的持久层
 * @author 吴圣平
 *
 */
class selectArticleModel{
	
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}
	
	/**
	 * 根据文章id查询文章
	 * @param 文章id $articleId
	 */
	function findArticle($articleId) {
		// 查询用sql文
		$selArticleSql =
		"SELECT
			a.title,
			a.articleId,
			a.content,
			a.recieveGoodTimes,
			b.readTimes
		FROM
			articleinfo a,
			(
				SELECT
					COUNT(articleId) AS readtimes
				FROM
					readinfo
				WHERE
					articleId = '$articleId'
			) b
		WHERE
			a.articleId = '$articleId'";
		
		// 检索文章
		$return = $this->useDB->selectBy($selArticleSql);		
		return $return;
	}

	/**
	 * 根据文章id查询文章评论
	 * @param 文章id $articleId
	 */
	function findComments($articleId) {
		$commentFindSql = "SELECT comment,updateTime FROM commentinfo WHERE articleId='$articleId'";
		// 检索文章
		$return = $this->useDB->selectBy($commentFindSql);
		return $return;
	}

	/**
	 * 插入浏览记录
	 * @param 文章 $articleId
	 * @param ip地址 $ip
	 */
	function insertScanHsy($articleId, $ip) {
		//更新文章浏览
		$readTimesSql = "INSERT INTO readinfo (articleId,userIP,updateTime) VALUES('$articleId','$ip',NOW())";
		$this->useDB->excuteSql($readTimesSql);
	}

}
?>
