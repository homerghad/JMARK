<?php
require "init.php";
$question_id = $_POST["Question_ID"];

$sql_query = "SELECT Question_Text FROM QUESTION WHERE Question_ID = $question_id";
$result = mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0){
	$row = mysqli_fetch_assoc($result);
	$q_text = $row["Question_Text"];
	echo "Question Found ".$q_text;
}
else{
	echo "Question not found ID#".$question_id;
}
?>
