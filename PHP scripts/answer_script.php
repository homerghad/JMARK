<?php
<<<<<<< HEAD
require "init.php";
$question_id = $_POST["Question_ID"];

$sql_query = "SELECT Answer_ID FROM ANSWER WHERE Question_ID = $question_id";
$result = mysqli_fetch_all($mysqli->query($query), MYSQLI_ASSOC);
=======
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

>>>>>>> bbc7bb0c309e2e681d12691e3ceb44f506420651
?>