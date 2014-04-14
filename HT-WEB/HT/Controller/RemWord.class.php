<?php
include('Model/RemWordModel.class.php');
class RemWord{
	/**
	 * default action method
	 */
	function  init() {
		$initModel =  new RemWordModel();
		$findWords = $initModel->findWord();
		$initModel->useDB->close();
		echo json_encode($findWords);
	}
}
?>