<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Forget Password</title>
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
        <%
            String message = (String) request.getAttribute("message");%>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page">Forget Password</a>
                    </li>
                </ul>
            </div>
        </nav><br><br>
        <form action = "./ForgetPasswordServlet" method ="Post" onsubmit ="return verifyPassword()">
            <div class ="container form-outline border">
                <div class = "container form-outline mb-4">
                    <h1>Enter Email Id</h1>
                </div>
                <div class = "container form-outline mb-4">
                    Email : <input type = "email" id = "cemail" class = "form-control" name = "email" placeholder="Enter your email id" required/>
                </div>
                <div class = "container form-outline mb-4">
                    New Password : <input type = "password" id = "pass" class = "form-control" name = "pass" placeholder="Enter new password" required/>
                </div>
                <div class = "container form-outline mb-4">
                    Confirm Password : <input type = "password" id = "cpass" class = "form-control" name = "cpass" placeholder="Enter confirm password" required/>
                </div>
                <div class = "container text-center ">
                    <button type="submit" name = action value = "Delete" class="btn btn-primary btn-block mb-2">Submit</button>
                </div>
            </div>
        </form> 
        <%
            if(message != null)
            { %>
                <script type="text/javascript">
                    var msg = "<%=message%>";
                    alert(msg);
                </script>
                <% }
        %>
    </body>
</html>
