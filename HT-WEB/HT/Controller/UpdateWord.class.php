<?php
include('Model/UpdateWordModel.class.php');
/**
 * Enter description here ...
 * @author 吴圣平
 *
 */
class UpdateWord{
	/**
	 * default action method
	 * @param unknown_type $param
	 */
	function  init() {
		$initModel =  new UpdateWordModel();
		$spell = addslashes($_POST["spell"]);
		$word = addslashes($_POST["word"]);
		$meaning = addslashes($_POST["meaning"]);
		
		$initModel->updateWord($_POST["id"],$spell,$word,$meaning,$_POST["del"]);
		
		if($_POST["spell"] != $_POST["input"] && $_POST["id"] != "" && $_POST["input"] != ""){
			$initModel->updateSpellMiss($_POST["id"], $spell, addslashes($_POST["input"]));
		}
		$initModel->useDB->close();
	}
	
	function updateAll() {
		$initModel =  new UpdateWordModel();
		$id = $_POST["id"];
		$input = $_POST["input"];
		$spell = $_POST["spell"];
		$word = $_POST["word"];
		$meaning = $_POST["meaning"];
		$del = $_POST["del"];
		
		for ($i = 0; $i < count($id); $i++) {
			$initModel->updateWord($id[$i],addslashes($spell[$i]),addslashes($word[$i]),addslashes($meaning[$i]),$del[$i]);
			
			if($spell[$i] != $input[$i]){
				$initModel->updateSpellMiss($id[$i], addslashes($spell[$i]), addslashes($input[$i]));
			}
		}
		$initModel->useDB->close();
	}
}
?>