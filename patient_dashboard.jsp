<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    
    
</head>
<body>
    <%@  include file="header.jsp"%>
     <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">Patient Dashboard  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <!-- <div class="container  ">
	    <div class="row">
	        <div class="col-4"></div>
	        <div class="col-8 text-right">
	           <a href="hospital_dashboard.do" class="btn btn-success">Dashboard</a>
	           <a href=" " class="btn btn-success">Test Reports</a>
	           <a href=" " class="btn btn-success">Scans</a> 
	           <a href=" " class="btn btn-success">Billing</a> 
	           <a href=" " class="btn btn-success">Medical Reports</a> 
	          
	        </div>
	    </div>
	</div> -->
     
     <!-- <div class="container text-center">
     	<div class="rows p-4">
     		<div class="cols p-4">
     			<h1>Patient Dashboard</h1>
     		</div>
     	</div>
     </div> -->
     
     <div class="container mt-5 ">
     	<div class="row">
     		<div class="col">
     			<ul class="nav nav-pills" id="myTab" role="tablist">
				  <li class="nav-item" role="presentation">
				    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#patient_reports_div" role="tab" aria-controls="patient_reports_div" aria-selected="true">Test Reports</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Scans</a>
				  </li>
				  <li class="nav-item" role="presentation">
				    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">Billing Details</a>
				  </li>
				</ul>
				<div class="tab-content  m-3 p-2" id="myTabContent">
				  <div class="tab-pane fade show active" id="patient_reports_div" role="tabpanel" aria-labelledby="home-tab">
				  
				  	
				  
				  </div>
				  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">b</div>
				  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">c</div>
				</div>
     		</div>
     	</div>
     </div>
     <span class="d-none" id="patient_id">${patient.getPatientId()}</span>
    <%-- <%@ include file="footer.jsp"%> --%>
    <script src="static/js/patient_test_reports.js"></script>
</body>
</html>