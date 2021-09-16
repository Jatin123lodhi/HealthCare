<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>Hcare::Doctor Registration</title>
 
    <link rel="stylesheet" href="static/css/form.css">
     
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
</head>
<body>
    <%@  include file="header.jsp"%>
    
    <div class="navigate border border-info " style="background-color:#131324">
        <div class="container">
            <div class="row">
               <div class="col py-2">
                   <a href="register_opt.jsp">Registration Options </a> <span class="text-white">></span>
                   <a href="">Doctor Registration </a><span class="text-white">></span>
               </div>
            </div>
        </div>
    </div>

    <div class="main_body">
        <h3 class="text-info text-center pt-3 mt-4">Register as Doctor-</h3>

        <div class="container border-top border-info " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col-6 pt-5 text-center"  >
                     
                    <img src="static/images/doctor2.png" alt="" style="width: 45%;" class=" pt-5 ">
                </div>
                <div class="col-6 pt-5 pl-5 border-left border-info">
                    <form action="doctor_register.do" method="post" class="p-4">
                   		<div class="form-group">
                             <label for="id_name"> Name:</label>
                             <input type="text"value="${param.name}" name="name" class="form-control form_inp"  placeholder="Enter name" id="id_name">
                         	 <small id="name_help" class=" form-text text-muted">Allowed characters are a-z, A-Z, 0-9 and spaces</small>	
                         	 <small id="name_error" class=" form-text text-danger hide">Invalid name. Enter a valid name</small>	
                         
                        </div>
                        <div class="form-group">
                            <label for="id_email">Enter email:</label>
                            <input type="email" value="${param.email}" name="email" class="form-control form_inp"  placeholder="Enter email" id="id_email">
                            <small id="email_help" class=" form-text text-muted">Enter a valid email ex- ram@gmail.com.in</small>
                            <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
                        	
                        </div>
                        <div class="form-group">
                            <label for="id_password">Password:</label>
                            <input type="password" value="${param.password}" name="password" class="form-control form_inp"  placeholder="Enter password" id="id_password">
                            <i id="view_password" class="fa fa-eye" aria-hidden="true"></i>
                            <small id="password_help" class="form-text text-muted">Password must  be 4 characters long</small>
                            <small id="password_error" class="form-text  text-danger hide">Invalid password</small>
                        </div>
                        <div class="g-recaptcha" data-sitekey="6LeKxNwaAAAAAF-2RXheHRFx0CCX6_vPj_YgiDqk"></div> 
                        <button class="btn btn-info mt-3">Submit</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
    <script type="text/javascript" src="static/js/doctor_register.js"></script>
    <script type="text/javascript" src="static/js/common_register.js"></script>
    
</body>
</html>