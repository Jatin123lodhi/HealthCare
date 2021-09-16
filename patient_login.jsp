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
                <a href=""> Patient Login </a> <span class="text-white">></span>
                    
               </div>
            </div>
        </div>
    </div>

    <div class="main_body">
        <h3 class="text-info text-center pt-3">Patient Login -</h3>

        <div class="container border-top border-info " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col-6 pt-5 text-center"  >
                     
                    <img src="static/images/login1.png" alt="" style="width: 35%;" class=" pt-3 ">
                </div>
                <div class="col-6 pt-2 pl-5 border-left border-info ">
                     <% String  errorMsg = (String)request.getAttribute("error"); %>
                    <% if(errorMsg!= null){  %>
                    	<h6 class="border border-danger pt-3"><%= errorMsg %></h6>
                    <% } %>
                    
                    
                    
                    
                    <form action="patient_login.do" method="post" class="p-4 " id="login_form">
                         
                         <div class="form-group">
                            <label for="id_email">Enter email:</label>
                            <input type="email" value="${param.email}" name="email" class="form-control form_inp" autocomplete="on" placeholder="Enter email" id="id_email">
                            <small id="email_help" class=" form-text text-muted">Enter a valid email ex- ram@gmail.com.in</small>
                            <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
                        	
                        </div>
                        <div class="form-group">
                            <label for="id_password">Password:</label>
                            <input type="password" value="${param.password}" name="password" class="form-control form_inp" autocomplete="off" placeholder="Enter password" id="id_password">
                            <i id="view_password" class="fa fa-eye" aria-hidden="true"></i>
                            <small id="password_help" class="form-text text-muted">Password must  be 6 characters long</small>
                            <small id="password_help" class="form-text text-muted">If you are admitted by the hospital then password is already sent to your mail</small>
                            <small id="password_error" class="form-text  text-danger hide">Invalid password</small>
                        </div>
                         <div class="g-recaptcha" data-sitekey="6LeKxNwaAAAAAF-2RXheHRFx0CCX6_vPj_YgiDqk"></div>
                        <button class="btn btn-info mt-4">Login</button>
                    </form>
                    

                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
    <script type="text/javascript" src="static/js/login.js"></script> 
    <!-- <script type="text/javascript" src="static/js/patient_login.js"></script> --> 
</body>
</html>