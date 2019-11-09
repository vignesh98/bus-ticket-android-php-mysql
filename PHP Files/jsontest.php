 <?php
$con=mysqli_connect("localhost","id10741334_busproject","error","employee101");
$sql="SELECT price FROM bus_route_price where frombustop='hebbal' AND tobustop='hebbal'";

if ($result=mysqli_query($con,$sql))
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
