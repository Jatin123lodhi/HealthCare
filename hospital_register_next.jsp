<!DOCTYPE html>
<html lang="en">
<head>
 	<%@ include file="head.jsp" %>
    <link rel="stylesheet" href="static/css/hospital_signup.css">
     
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    
    
</head>
<body>
    <%@  include file="header.jsp"%>
    <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">Registration Options  </a> <span class="text-white">></span>
                   <a href="#">Hospital Registration  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     

    <div class="main_body">
       
        <div class="container  " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col-6 pt-5 text-center"  >
                     
                    <img src="static/images/hospitallogo.png" alt="" style="width: 50%;" class=" pt-5 ">
                </div>
                <div class="col-6  pt-5 pl-5 ">
                  
                  <h3>Registered Successfully</h3>
     				<h5 class="mt-3 mb-5">Activate the account using the activation link sent to your mail</h5>
					<h6 class="mt-3 text-muted p-2">Mail not received ? Register again using the <a href="hospital_register.jsp">link.</a></h6>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
    <!-- <script type="text/javascript" src="static/js/hospital_register.js"></script> -->
</body>
</html>