<?php
include_once('common/DBUtil.php');
/**
 * 插入评论
 * @author 吴圣平
 *
 */
class EditArticleModel{
	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}

	/**
	 * Enter 插入文章
	 * @param 文章id $articleId
	 * @param 标题 $title
	 * @param 内容 $content
	 */
	function insertArticle($articleId,$title,$content) {
		//更新文章浏览
		$articleSql = "INSERT INTO articleinfo (title,articleId,content,recieveGoodTimes) 
							VALUES('$title','$articleId','$content',0)";
		$checkArticleExsit = "SELECT COUNT(articleId) AS rows From articleinfo WHERE articleId = '$articleId'";
		$updateArticle = "UPDATE articleinfo SET content='$content',title='$title' WHERE articleId='$articleId'";
		$count = (array)$this->useDB->selectBy($checkArticleExsit);
		if($count[0]["rows"] == 0){
			$this->useDB->excuteSql($articleSql);
			return 0;
		}else if($count[0]["rows"] == 1){
			$this->useDB->excuteSql($updateArticle);
			return 1;
		}else {
			return 2;
		}
	}
}
?>