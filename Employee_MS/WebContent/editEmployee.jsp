<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Employee </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  
button {   
       background-color: #4CAF50;   
       width: 10%;  
        color: blue;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }
   </style>
</head>
   <body>    
    <center> <h1> Modify Employee Details! </h1> </center>   
    <form action="adminControlServlet" method = "POST">  
    	<input type="hidden" name="action" value="update"/>  
        <div class="container">   
            <label>Employee ID : </label>   
            <input type="text" placeholder="Enter Employee ID" name="empId" required> 
            <label>First Name : </label>   
            <input type="text" placeholder="Enter First Name" name="fname" required> 
            <label>Last Name : </label>   
            <input type="text" placeholder="Enter Last Name" name="lname" required>  
            <label>Date of Birth : </label>   
            <input type="text" placeholder="Enter Date of Birth" name="dob" required> 
            <label>Email : </label>   
            <input type="text" placeholder="Enter Email" name="email" required> 
            <label>Department : </label>   
            <input type="text" placeholder="Enter Department" name="dep" required> 
             <button style="margin-right: 16px; font-size: 15px" type="submit"> Modify </button>
        </div>   
    </form>     
</body>   
</html>