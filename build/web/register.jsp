<%-- 
    Document   : register.jsp
    Created on : 2022 May 5, 11:30:57
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
        <script>  
            function verifyPassword() {  
            var pw = document.getElementById("password").value;
            var cpw = document.getElementById("cpassword").value;
            //check empty password field  
            if(pw == "") {  
               document.getElementById("message").innerHTML = "**Fill the password please!";  
               return false;  
            }  

           //minimum password length validation  
            if(pw.length < 8) {  
               document.getElementById("message").innerHTML = "**Password length must be atleast 8 characters";  
               return false;  
            }  

          //maximum length of password validation  
            if(pw.length > 15 & cpw === pw) {  
               document.getElementById("message").innerHTML = "**Password length must not exceed 15 characters";  
               return false;  
            } else {  
               alert("Password is correct");  
            }  
          }  
        </script>  

    </head>
    <body>
        <jsp:include page="index.html" />
        <form method = "POST" action = "/Rosa/CustomerRegisterController" onsubmit ="return verifyPassword()"><br><br>
            <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Register</h1>
                <p>Please register your self</p>
            </div>
            <div class = "container form-outline mb-4">
                Email : <input type = "email" id = "email" class = "form-control" name = "email" placeholder="Enter your email id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Name : <input type = "text" id = "name" class = "form-control" name = "name" placeholder = "Enter your name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Address : <input type = "text" id = "address" class = "form-control" name = "address" placeholder="Enter your Address" required/>
            </div>
            <div class = "container form-outline mb-4">
                Pin : <input type = "text" id = "pin" class = "form-control" name = "pin" placeholder="Enter your Pin" maxlength = "6" required/>
            </div>
            <div class = "container form-outline mb-4">
                Mobile Number : <input type = "text" id = "mobile" class = "form-control" name = "mobile" value = "" placeholder = "Enter your mobile number" required/>
            </div>
            <div class = "container form-outline mb-4">
                Password : <input type = "password" id = "password" class = "form-control" name = "password" placeholder = "Enter the password" required/>
            </div>
            <div class = "container form-outline mb-4">
                Confirm Password : <input type = "password" id = "cpassword" class = "form-control" name = "cpassword" placeholder = "Confirm the password" required/>
            </div>
            <div class = "container text-center">
                <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
            </div>
            <div class = "container text-center mb-4">
                <a href = "login.jsp">Already Register ? Login</a><br>
            </div>
            </div><br>
        </form>
    </body>
</html>
