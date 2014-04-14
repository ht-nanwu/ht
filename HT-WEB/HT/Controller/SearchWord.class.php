<?php
include('Model/SearchWordModel.class.php');
/**
 * Enter description here ...
 * @author 吴圣平
 *
 */
class SearchWord{
	/**
	 * default action method
	 */
	function  init() {
		$initModel =  new SearchWordModel();
		echo json_encode($initModel->searchWords($_POST["id"], $_POST["dateTime"],addslashes($_POST["spell"])));
		$initModel->useDB->close();
	}
}
?>