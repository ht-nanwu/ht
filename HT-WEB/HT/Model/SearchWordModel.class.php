<?php
include_once('common/DBUtil.php');
/**
 * 搜索文章的持久层
 * @author 吴圣平
 *
 */
class SearchWordModel{

	/*数据库对象*/
	public $useDB;

	/** 构造器 */
	public function __construct()
	{
		$this->useDB = new DBUtil();
	}

	function searchWords($id,$dateTime,$spell) {
		$id = addslashes($id);
		$dateTime = addslashes($dateTime);
		// 查询用sql文
		$searchWords = "";
		if($id == "" && $dateTime== "" && $spell == ""){
			$searchWords = "
			SELECT
				*
			FROM
				n2_word
			WHERE
				del='0'
			ORDER BY
				RAND()
			LIMIT 100";
		} else {
			$whereArr = array("$id","$spell","$dateTime");
			$whereStr = " del='0' ";
			//$empty_count = 0;
			for ($i = 0; $i < count($whereArr); $i++) {
//				if($whereArr[$i] != ""){
//					if($empty_count==0){
//						if($i==0){
//							$whereStr .= "id='$whereArr[$i]'";	
//						} else if($i==1){
//							$whereStr .= "spell='$whereArr[$i]'";
//						} else {
//							$whereStr .= "updateTime='$whereArr[$i]'";
//						}
//					} else {
//						$whereStr .= " AND ";
//						if($i==1){
//							$whereStr .= "spell='$whereArr[$i]'";
//						} else {
//							$whereStr .= "updateTime='$whereArr[$i]'";
//						}
//					}
//					$empty_count++;
//				}
				if($whereArr[$i] != ""){
					$whereStr .= " AND ";
					if($i==0){
						$whereStr .= "id='$whereArr[$i]'";		
					}else if($i==1){
						$whereStr .= "(spell like '%$whereArr[$i]%'";
						$whereStr .= " or word like '%$whereArr[$i]%')";
					} else {
						$whereStr .= "updateTime like '$whereArr[$i]%'";
					}
				}
			}
			$searchWords = "
			SELECT
				*
			FROM
				n2_word
			WHERE
			$whereStr
			ORDER BY
				LENGTH(spell) DESC";
		}

		// 检索文章
		$return = $this->useDB->selectBy($searchWords);
		return $return;
	}
}
?>
