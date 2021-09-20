<!DOCTYPE html>
<html lang="en">
<head>
 	<%@ include file="head.jsp" %>
    <title>Document</title>
  
    <link rel="stylesheet" href="static/css/form.css"/>;
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
</head>
<body>
    <%@  include file="header.jsp"%>
    <div class="navigate border border-info mb-5" style="background-color:#131324">
        <div class="container ">
            <div class="row">
               <div class="col py-2">
               	<a href="index.jsp">Home </a> <span class="text-white">></span>
                <a href="">Login </a> <span class="text-white">></span>
                    
               </div>
            </div>
        </div>
    </div>

    <div class="main_body">
        <h3 class="text-info text-center pt-3">Hospital Login -</h3>

        <div class="container  " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col-6   text-center"  >
                     
                    <img src="static/images/login2.jpg"  alt="" style="width: 100%;"  >
                </div>
                <div class="col-6 pt-5 pl-5  ">
                     <% String  errorMsg = (String)request.getAttribute("error"); %>
                    <% if(errorMsg!= null){  %>
                    	<h6 class="border border-danger pt-3"><%= errorMsg %></h6>
                    <% } %>
                    
                    <form action="hospital_login.do" method="post" class="p-4">
                         
                         <div class="form-group">
                            <label for="id_email">Enter email:</label>
                            <input type="email"   name="email" class="form-control form_inp" autocomplete="on" placeholder="Enter email" id="id_email">
                            <small id="email_help" class=" form-text text-muted">Enter a valid email ex- ram@gmail.com.in</small>
                            <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
                        	
                        </div>
                        <div class="form-group">
                            <label for="id_password">Password:</label>
                            <input type="password"  name="password" class="form-control form_inp" autocomplete="off" placeholder="Enter password" id="id_password">
                            <i id="view_password" class="fa fa-eye" aria-hidden="true"></i>
                            <small id="password_help" class="form-text text-muted">Password must  be 8 characters long</small>
                            <small id="password_error" class="form-text  text-danger hide">Invalid password</small>
                        </div>
                         <div class="g-recaptcha" data-sitekey="6LeKxNwaAAAAAF-2RXheHRFx0CCX6_vPj_YgiDqk"></div>
                        <button type="submit" class="btn btn-info mt-4">Login</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
    <script type="text/javascript" src="static/js/login.js"></script> 
</body>
</html>