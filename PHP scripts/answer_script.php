<?php
require "connect.php";
$question_id = $_POST["Question_ID"];

$sql_query = "SELECT Answer_ID FROM ANSWER WHERE Question_ID = $question_id";
$result = $dbc->query($sql_query);

//stores an array of arrays, each array corresponding to one element that matches the above condition
//e.g. $resultArray[0][0] gives ID number one
$resultArray = $result->fetch_all(MYSQLI_NUM);


foreach ($resultArray as $value) {
	echo $value[0];
}

?>