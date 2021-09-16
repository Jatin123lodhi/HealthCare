<!DOCTYPE html>
<html lang="en">
<head>
 	<%@ include file="head.jsp" %>
    <title>Hcare :: Register Options</title>
  
    
    
</head>
<body>
    <%@  include file="header.jsp"%>
    
    <div class="navigate border border-info mb-5" style="background-color:#131324">
        <div class="container">
            <div class="row">
               <div class="col py-2">
                   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="">Registration Options </a> <span class="text-white">></span>
               </div>
            </div>
        </div>
    </div>

    <div class="main_body">
        <h3 class="text-secondary text-center pt-3">Login as -</h3>

        <div class="container" style="height: 470px;">
            <div class="row text-center mt-3  "  >
                <div class="col-4">
                    <!-- <img src="static/images/hospitallogo.png" alt="" class="img-fluid mt-4" style="width:60%;"> -->
                    <i class="fa fa-hospital-o fa-5x mt-5"></i>
                     
                </div>
                <div class="col-4 ">
                    <img src="static/images/doctor1.png" alt="" class="img-fluid mt-4" style="width: 30%;">
                     
                </div>
                <div class="col-4 ">
                    <img src="static/images/patient.png" alt="" class="img-fluid mt-4" style="width: 45%;">
                     
                </div>
                
            </div>

            <div class="row text-center  mt-3">
                <div class="col-4 ">
                    <a href="hospital_login.do" class="btn btn-info">Hospital</a>
                </div>
                <div class="col-4">
                    <a href="doctor_login.do" class="btn btn-info">Doctor</a>
                </div>
                <div class="col-4">
                    <a href="patient_login.do" class="btn btn-info">Patient</a>
                </div>
            </div>
        </div>
    </div>

     <%@ include file="footer.jsp"%>
</body>
</html>