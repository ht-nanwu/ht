<?php
include('Model/EditArticleModel.class.php');
include('Model/SelectArticleModel.class.php');
/**
 * Enter description here ...
 * @author 吴圣平
 *
 */
class EditArticle{
	/**
	 * default action method
	 * @param unknown_type $param
	 */
	function  init() {
		$initModel =  new EditArticleModel();
		$articleId = addslashes($_POST["articleId"]);
		$title = addslashes($_POST["title"]);
		$content= addslashes($_POST["content"]);
		echo $initModel->insertArticle($articleId, $title, $content);
		$initModel->useDB->close();
	}

	/**
	 * 更新文章
	 * @param unknown_type $param
	 */
	function  updateArticle() {
		$initModel =  new SelectArticleModel();
		$articleId = addslashes($_POST["articleId"]);
		echo json_encode($initModel->findArticle($articleId));
		$initModel->useDB->close();
	}
}
?>