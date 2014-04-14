<?php
register_shutdown_function("writeToLog");
function writeToLog() {

	$faild = error_get_last();
	if(count($faild)==0){
	}else {
		$log = Logger::getLogger('**!!!!!!!!!!!!!!HaveError!!!!!!!!!!!!!!**');
		$log->error($faild);
	}
}
?>