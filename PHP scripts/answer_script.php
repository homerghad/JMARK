<?php
require "init.php";
$question_id = $_POST["Question_ID"];

$sql_query = "SELECT Answer_ID FROM ANSWER WHERE Question_ID = $question_id";
$result = mysqli_fetch_all($mysqli->query($query), MYSQLI_ASSOC);
?>