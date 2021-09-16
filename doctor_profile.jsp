 
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
                   <a href="register_opt.jsp">Doctor Profiles  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%-- <%@ include file="hospital_header_btns.jsp" %> --%>
     <div class="container  ">
	    <div class="row">
	        <div class="col-2"></div>
	        <div class="col-10 text-right">
	           <a href="hospital_profile.do" class="btn btn-success">Profile</a>
	           <a href="apply_in_hospital.do" class="btn btn-success">Apply in Hospital</a>  
	        </div>
	    </div>
	 </div>
     
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>Doctor Profile</h3>
     		</div>
     	</div>
     </div>
     
     
      
     <div class="container  bg-info px-2 pb-5 form-box">
     	<div class="row px-2 pb-5 mx-3">
     		<div class="col p-4 mx-2 ">
     			
     			
     			<div class="form border border-info px-5 pt-2 pb-5 mx-5 mb-5 mt-3 bg-white" style="min-height:600px">
     				 
     			 
     				<div id="doctor_profile_div" >
	     				
	 					<form action="doctor_profile.do" class="profile_form" method="post">
	 						 <div class="row mb-2 mt-3">
		     					<div class="col ">
		     						<label for="id_name">Name:</label>
			     					<input type="text" value="${doctor.getName()}" class="form-control form_inp" name="name" id="id_name">
			     					 
		     					</div>
		     					<div class="col">
		     						<label for="id_patient_id">Doctor Id:</label>
			     					<input type="text" value="${doctor.getDoctorId()}" class="form-control form_inp" name="patient_id" id="id_patient_id" disabled>     					 
			                        
		     					</div>
		     					 
		     				</div>
		     			
		     				<div class="row mb-2">
		     					
		     					<div class="col">
		     						<label for="id_service_time">Service Time :</label>
			     					 <span class="d-none" id="service_time_span">${doctor.getServiceTime().getServiceTimeId()}</span>
			     					 <select class="form-control"  name="service_time" id="id_service_time">
			     					 	<option value="0">Select time</option>
			     					 	<option value="1">10AM-12PM</option>
			     					 	<option value="2">12PM-2PM</option>
			     					 	<option value="3">2PM-6PM</option>
			     					 	<option value="4">6PM-8PM</option>
			     					 	<option value="5">8PM-10PM</option>
			     					 	 
			     					 </select>
		     					</div>
		     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_contact">Contact:</label>
		     						<input type="text" value="${doctor.getContactNo()}" class="form-control" name="contact" id="id_contact" >
		     					</div>
		     					<div class="col">
		     						<label for="id_email">Email:</label>
			     					<input type="text" value="${doctor.getEmail()}" class="form-control form_inp" name="email" id="id_email" disabled>     					 
			                      
		     					</div>
		     					 
		     				</div>
		     			 	
		     				<div class="row mb-2">
		     					<div class="col">
		     						<% String gen = doctor.getGender(); %>
		     						<label class="d-block mt-1">Gender:</label>
			     					<div class="form-check d-inline mr-3">
			     						 
			     						<% if(gen!=null && gen.equals("male")){ %>
			     							<input type="radio" class="form-check-input " value="male" name="gender" id="id_male" checked >
			     						<%}else{%>
			     							<input type="radio" class="form-check-input " value="male" name="gender" id="id_male" >
			     							
			     						<%} %>
				     					
				     					<label for="id_male">Male</label>	 	     					
				     				</div>
				     				<div class="form-check d-inline mr-3">
				     					
				     					<% if(gen!=null && gen.equals("female")){ %>
			     							<input type="radio" class="form-check-input " value="female" name="gender" id="id_female" checked >
			     						<%}else{%>
			     							<input type="radio" class="form-check-input " value="female" name="gender" id="id_female" >
			     							
			     						<%} %>
				     					<label for="id_female">Female</label>	     					
				     				</div>
				     				<div class="form-check d-inline mr-3">
				     					 <% if( gen!=null && gen.equals("other")){ %>
			     							<input type="radio" class="form-check-input " value="other" name="gender" id="id_other" checked >
			     						<%}else{%>
			     							<input type="radio" class="form-check-input " value="other" name="gender" id="id_other" >
			     							
			     						<%} %>
				     					 <label for="id_other">Other</label>	     					
				     				</div>
		     					</div>
		     					<div class="col">
		     						<label for="id_city1">City</label>
				              		<select class="form-control"  name="city" id="id_city1">
				              			<option>Select city</option>                      			                      			
				              			<% for(City city:cities){ %>
				              				<%if(doctor!=null&&city.getCityId()==doctor.getCity().getCityId()){ %>
				              				<option value="<%=city.getCityId() %>" selected> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>	
				              				<%}else{ %>
				              				<option value="<%=city.getCityId() %>"> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>
				              				<% }%>
				              			<%} %>
				              		</select>  
		     					</div>
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_specialization">Specialization:</label>
			     					<input type="text" value="${doctor.getSpecialization()}" class="form-control form_inp" name="specialization" id="id_specialization">     			                         
		     					</div> 
		     					<div class="col">
		     						<label for="id_experience">Experience:</label>
			     					<input type="text" value="${doctor.getExperience()}" class="form-control form_inp" name="experience"  id="id_experience" placeholder="in years">     					      
		     					</div>     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_address">Address</label>
		                  			<textarea rows="4"  name="address" class="form-control  " autocomplete="off" id="id_address">${doctor.getAddress()} </textarea> 
		     					</div>
		     				</div>
		     				
		     				<button class="btn btn-info mt-3" id="id_save">Update</button>
	     				</form>
     				</div>
     			 	 
     			 	 
     			</div>
     			
     			
     		</div>
     		 	 
     	</div>
     </div>
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <script type="text/javascript" src="static/js/doctor_profile.js"></script>
  
    
</body>
</html>