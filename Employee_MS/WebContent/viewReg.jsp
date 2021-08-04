<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Regulations </title>  
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
    <center> <h1> View Regulations! </h1> </center>   
        <form action = "adminControlServlet" method = "POST"> 
        <input type="hidden" name="action" value="viewReg"/>
        <div class="container">   
            <label>Compliance ID : </label>   
            <input type="text" placeholder="Enter Compliance ID" name="compId" required> 
             <button style="margin-right: 16px; font-size: 15px" type="submit"> View </button>
        </div>   
    </form>     
</body>   
</html>