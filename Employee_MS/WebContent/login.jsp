<!DOCTYPE html>   
<%@page import="java.io.PrintWriter"%>
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  
button {   
       background-color: #4CAF50;   
       width: 10%;  
        color: orange;   
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
    <center> <h1>Employee Management System </h1> </center>   
    <form>  
        <div class="container"> 
        	
       		 <%-- <c:if test=${invalid eq 'true'}"> invalid Credentials</c:if>--%>
       		 
       		 <span style = "color:red"> <% request.getAttribute("message"); %></span>
       		<br />
        	
            <label>UserID : </label>   
            <input type="text" placeholder="UserID" name="username" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" name="password" required>   
            Login : <input type = "submit" name = "user" value = "User" />   <input type = "submit" name = "admin" value = "Admin" />  
        </div>   
    </form>
    
    <% if(request.getParameter("user")!= null){ %>
      	<jsp:forward page="userServlet"></jsp:forward>
    <%} 
      else if(request.getParameter("admin")!= null){ %>
    	<jsp:forward page="adminServlet"></jsp:forward>
    <%}%>
    	
    
</body>     
</html>  