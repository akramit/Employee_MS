<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Employee </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: yellow;  
}  
button {   
       background-color: #4CAF50;   
       width: 10%;  
        color: black;   
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
        border: 2px solid blue;   
        box-sizing: border-box;   
    }
   </style>
</head>
   <body>    
    <center> <h1> Add Employee  </h1> </center>   
    <form action = "adminControlServlet" method = "POST">  
        <div class="container">   
            <label>First Name : </label>   
            <input type="text" placeholder="Enter First Name" name="fname" required> 
            <label>Last Name : </label>   
            <input type="text" placeholder="Enter Last Name" name="lname" required>  <br />
            <label>Date of Birth : </label>   
            <input type="text" placeholder="Enter Date of Birth" name="dob" required>  <br />
            <label>Email : </label>   
            <input type="text" placeholder="Enter Email" name="email" required>  <br />
            <label>Department : </label>   
            <input type="text" placeholder="Enter Department" name="dep" required>  <br />
              
             <button style="margin-right: 16px; font-size: 15px" type="submit"> Add </button>
        </div>   
    </form>   
</body>   
</html>