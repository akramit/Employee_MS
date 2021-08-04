<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Admin Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: yellow;  
}  
button {   
       background-color: #4CAF50;   
       width: 10%;  
        color: blue;   
        padding: 20px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
   
</style>   
</head>    
<body>    
    <center> <h1> Hello Admin! </h1> </center>  
	<form>
    <b> Employee </b> :  
	<a href = "addEmployee.jsp"> <input type = "submit" name = "addUser" value = "Add" /></a>
	<a href = "editEmployee.jsp"> <input type = "submit" name = "editUser" value = "Edit" /></a>
	<a href = "viewEmployee.jsp"> <input type = "submit" name = "viewUser" value = "View" /></a>
	<a href = "delEmployee.jsp"> <input type = "submit" name = "deleteUser" value = "Delete" /></a>
	<br />
	<br />
	<br />
    <b>    Department </b>:
    <a href = "addDept.jsp"> <input type = "button" name = "addDepartment" value = "Add" /></a>
	<a href = "viewDept.jsp"> <input type = "button" name = "viewDepartment" value = "View" /></a>
<br />
<br />
<br />
    <b>    Regulations </b>: 
    <a href = "createReg.jsp"><input type = "button" name = "addReg" value = "Add" /></a>
	<a href = "viewReg.jsp"><input type = "button" name = "viewReg" value = "View" /></a>
	   </form> 
</body>     
</html>  