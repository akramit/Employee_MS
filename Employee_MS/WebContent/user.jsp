<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> User Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  

 form {   
        border: 3px solid #f1f1f1;   
    }   
   
</style>   
</head>    
<body>    
      <h1> Hello User ! </h1>
    <br>
    <br>
    <br>
    <br>
    

	<form action="userControlServlet" method = "POST">
	<b> View Regulations </b> : 
		<input type= "hidden" name = "userControls" value = "viewReg" />
		<input type= "hidden" name = "userId" value = <%= request.getAttribute("userId") %> />
		<input type="submit" name="viewReg" value="View">
	</form>
    
    <br />
	<form> 
    <b> Comments </b>: <input type="button" name="viewComments" value="View"> <input type="button" name="upadateComm" value="Update">
    <br />
    </form>
    <form>
    <b> Track Status </b>:   <input type="text" placeholder="Enter Compliance ID" name="compId" required> <input type="button" name="trackStatus" value="Track">
	</form>
    <br>
    <br>
    <input type="button" name="login" value="Home Page" width="20%">

</body>     
</html>  