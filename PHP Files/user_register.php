<?php
$con = mysqli_connect("localhost","root","error","employee101");
if (isset($_POST["regname"])) {
$reg_name=$_POST["regname"];
}
if (isset($_POST["regemail"])) {
$reg_email=$_POST["regemail"];
}
if (isset($_POST["regage"])) {
$reg_age=$_POST["regage"];
}
if (isset($_POST["regpassword"])) {
$reg_pass=$_POST["regpassword"];
}
$sql = "INSERT INTO user_details(name,email,age,password) VALUES('$reg_name','$reg_email','$reg_age','$reg_pass')";
if(mysqli_query($con,$sql)){
 
echo 'php 	Data Submit Successfully';
 
}
else{
 
echo 'Try Again';
 
}
mysqli_close($con);
?>
