 
<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    <link rel="stylesheet" href="static/css/form.css">
    <style>
    	
    </style>
</head>
<body>
    <%@  include file="header.jsp"%>
     <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">Apply  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%-- <%@ include file="hospital_header_btns.jsp" %> --%>
     <div class="container  ">
	    <div class="row">
	        <div class="col-2"></div>
	        <div class="col-10 text-right">
	           <a href="doctor_profile.do" class="btn btn-success">Profile</a>
	           <a href="apply_in_hospital.do" class="btn btn-success">Apply in Hospital</a>  
	        </div>
	    </div>
	 </div>
     
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3> Apply in Hospital</h3>
     		</div>
     	</div>
     </div>
      
     <span id="id_<%=doctor.getDoctorId()%>" class="doctor_id"></span>
      <div class="container mt-4 border border-info w-50  ">
     	<div class="rows p-3">
     		<div class="cols  ">
     			 <form action="apply_in_hospital.do" method="post" enctype="multipart/form-data"> 
     			 	<div class="form-group" id="upload_div">
     					<span class="text-info font-weight-bold" id="label_upload_license">Upload license(in pdf) :</span>
     				 	<input type="file" id="file_upload" name="file"  class="form-control-file  mt-2 border border-info rounded">	 	
     				</div>
     				<div class="form-group" id="uploaded_div" style="display:none;">
     					<label for="uploaded_file" class="text-info font-weight-bold">Uploaded license :</label>
     				 	<input type="text" id="uploaded_file" name="file_uploaded"  class=" form-control border border-info">	 	
     				</div>
     			 		
     			 	<div class="form-group">
	     			 	<% ArrayList<Hospital> hospitals = Hospital.getHospitalNames();  %>
	     			 	<label class="text-info font-weight-bold">Select Hospital: </label>
	     			 	<select class="form-control btn btn-outline-info font-weight-bold" id="id_hospital" name="hospital">
	     						<option value='0'>Select Hospital</option>
	     						<% for(int i=0;i<hospitals.size();i++){ %>
	     							<option value='<%=hospitals.get(i).getHospitalId() %>' ><%= hospitals.get(i).getName() %></option>
	     						<%} %>	 
	     				</select>
     				</div>
     				
     				<div class="form-group text-center">
	     				<input type="submit" class="btn btn-info " id="apply_btn" value="Apply">
	     				<button class="btn btn-danger ml-4" id="cancel_btn">Cancel</button>
     				</div>
     			 	
     			</form>
     			 
     			 <h5 id="status" class="text-info"></h5>
     			  
     		</div>
     	</div>
     </div>
     <h4 class="text-info text-center mt-3 d-none"> Response: <span> Waiting</span></h4>
     
     
     
      
    <script type="text/javascript" src="static/js/apply_in_hospital.js"></script>
</body>
</html>