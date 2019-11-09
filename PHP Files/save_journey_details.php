<?php
$con = mysqli_connect("localhost","root","error","employee101");
if (isset($_POST["name"])) {
$reg_name=$_POST["name"];
}
if (isset($_POST["fromadd"])) {
$frombus=$_POST["fromadd"];
}
if (isset($_POST["toadd"])) {
$tobus=$_POST["toadd"];
}
if (isset($_POST["ticketdata"])) {
$ticketdata=$_POST["ticketdata"];
}
$sql = "INSERT INTO journey_details(username,from_address,to_address,ticketdata) VALUES('$reg_name','$frombus','$tobus','$ticketdata')";
mysqli_query($con,$sql);
$sql1="SELECT price FROM bus_route_price where frombustop='$frombus' AND tobustop='$tobus'";

if ($result=mysqli_query($con,$sql1))
  {
  // Fetch one and one row
  while ($row=mysqli_fetch_row($result))
    {
    printf ("%s",$row[0]);
    }
  // Free result set
  mysqli_free_result($result);
}
mysqli_close($con);
?>
