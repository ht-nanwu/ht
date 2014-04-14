<?php
include('Model/SelectArticleModel.class.php');
/**
 * Enter description here ...
 * @author 吴圣平
 *
 */
class SelectArticle{
	/**
	 * default action method
	 * @param unknown_type $param
	 */
	function  init() {
		$initModel =  new SelectArticleModel();
		$findArticle = $initModel->findArticle($_POST["articleId"]);
		$findComments = $initModel->findComments($_POST["articleId"]);
		$initModel->insertScanHsy($_POST["articleId"], $_SERVER["REMOTE_ADDR"]);
		$initModel->useDB->close();
		$returnJson = array($findArticle,$findComments);
		echo json_encode($returnJson);
	}
}
?>