<?php
include('Model/InsertCommentModel.class.php');
/**
 * Enter description here ...
 * @author 吴圣平
 *
 */
class InsertComment{
	/**
	 * default action method
	 * @param unknown_type $param
	 */
	function  init() {
		$initModel =  new InsertCommentModel();
		$articleId = $_POST["Id"];
		$ip = addslashes($_SERVER["REMOTE_ADDR"]);
		$comment = htmlentities(addslashes($_POST["comment"]));
		$initModel->insertComments($articleId, $ip, $comment);
		echo json_encode($initModel->findComments($articleId));
		$initModel->useDB->close();
	}
}
?>