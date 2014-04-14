<?php
include('Model/SelectDelAndUndelModel.class.php');

class SelectDelAndUndel{

	function  init() {
		$initModel =  new SelectDelAndUndelModel();
		echo json_encode($initModel->selectDelAndUndel());
		$initModel->useDB->close();
	}
}
?>