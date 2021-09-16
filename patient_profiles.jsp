<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    <link rel="stylesheet" href="static/css/form.css">
    <style>
    	.form-box{
    		position:absolute;
    		top:0;
    		left:0;
    		max-width:100%;
    		height:200%;
    		z-index:1;
    		background-color: rgba(0,0,0,0.5);
    		display:none;
    	}
    </style>
</head>
<body>
    <%@  include file="header.jsp"%>
     <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">Patient Profiles  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>Patient Profiles</h3>
     		</div>
     	</div>
     </div>
     
     <div class="container ">
     	<div class="row">
     		<div class="col">
     			<div class="form-inline p-2 mt-3 "> 
	   				 <div class="form-group ml-3"> 
	   				 	<input type="text" class="form-control" id="id_srh" placeholder="Enter name or email" style="width:500px">
	   				 </div>
	   				 <button class=" ml-2 btn btn-info" id="search_btn" >Search</button>
     			</div>
     			<table class="table table-dark mt-3">
     			
     			</table> 			
     		</div> 
     	</div>
     </div>
      
      
     <div class="container px-5 pb-5 form-box">
     	<div class="row px-5 pb-5 mx-5">
     		<div class="col p-5 mx-5 ">
     			
     			
     			<div class="form border border-info px-5 pt-2 pb-5 mx-5 mb-5 mt-2 bg-white" style="min-height:700px">
     				<%@ include file="patient_header_btns.jsp" %>
     				<i class="fa fa-times fa-lg float-right" style="cursor:pointer"></i>
     				<div class="container  border-bottom border-info text-info mb-4 ">
				     	<div class="rows px-3 pb-2 pt-1 ">
				     		<div class="cols ">
				     			<h3 id="heading">Patient Profile</h3>
				     		</div>
				     	</div>
				    </div>
     				<div id="patient_profile_div" >
	     				
	 					<form class="profile_form">
		     				<div class="row mb-2 mt-3">
		     					<div class="col ">
		     						<label for="id_name">Name:</label>
			     					<input type="text" class="form-control form_inp" name="name" id="id_name">
			     					<small id="name_error" class="form-text text-danger hide">Invalid Name</small>
		     					</div>
		     					<div class="col">
		     						<label for="id_patient_id">Patient Id:</label>
			     					<input type="text" class="form-control form_inp" name="patient_id" id="id_patient_id">     					 
			                        <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
		     					</div>
		     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_weight">Weight(Kg) :</label>
		     						<input type="text" class="form-control" name="weight" id="id_weight"> 
		     					</div>
		     					<div class="col">
		     						<label for="id_height">Height(ft) :</label>
		     						<input type="text" class="form-control" name="height" id="id_height"> 
		     					</div>
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_dob">Date of Birth:</label>
		     						<input type="date" value="26-06-2021" class="form-control" name="dob" id="id_dob">
		     					</div>
		     					<div class="col ">
		     						<label for="id_bg">Blood Group:</label>
			     					 <select class="form-control" name="blood_group" id="id_bg">
			     					 	<option value="">Select Blood Group</option>
			     					 	<option value="A+">A+</option>
			     					 	<option value="B+">B+</option>
			     					 	<option value="AB+">AB+</option>
			     					 	<option value="O+">O+</option>
			     					 	<option value="A-">A-</option>
			     					 	<option value="B-">B-</option>
			     					 	<option value="AB-">AB-</option>
			     					 	<option value="O-">O-</option>
			     					 </select>
		     					</div>
		     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_contact">Contact:</label>
		     						<input type="text" class="form-control" name="contact" id="id_contact">
		     					</div>
		     					<div class="col">
		     						<label for="id_email">Email:</label>
			     					<input type="text" class="form-control form_inp" name="email" id="id_email" disabled>     					 
			                        <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
		     					</div>
		     					 
		     				</div>
		     			 	
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label class="d-block mt-1">Gender:</label>
			     					<div class="form-check d-inline mr-3">
				     					<input type="radio" class="form-check-input " value='m' name="gender" id="id_male">
				     					<label for="id_male">Male</label>	 	     					
				     				</div>
				     				<div class="form-check d-inline mr-3">
				     					<input type="radio" class="form-check-input " value='f' name="gender" id="id_female">
				     					<label for="id_female">Female</label>	     					
				     				</div>
				     				<div class="form-check d-inline mr-3">
				     					 <input type="radio" class="form-check-input" value='o'  name="gender" id="id_other">
				     					 <label for="id_other">Other</label>	     					
				     				</div>
		     					</div>
		     					<div class="col">
		     						<label for="id_city1">City</label>
				              		<select class="form-control"  name="city" id="id_city1">
				              			<option>Select city</option>                      			                      			
				              			<% for(City city:cities){ %>
				              				<%if(hospital!=null&&city.getCityId()==hospital.getCity().getCityId()){ %>
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
		     						<label for="id_room_no">Room No:</label>
			     					<input type="text" class="form-control form_inp" name="room_no" id="id_room_no">     			                         
		     					</div> 
		     					<div class="col">
		     						<label for="id_bed_no">Bed No:</label>
			     					<input type="text" class="form-control form_inp" name="bed_No"  id="id_bed_no" >     					      
		     					</div>     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_address">Address</label>
		                  			<textarea rows="4"  name="address" class="form-control  " autocomplete="off" id="id_address"> </textarea> 
		     					</div>
		     				</div>
		     				
		     				<button class="btn btn-info" id="id_update">Update</button>
	     				</form>
     				</div>
     			 	<div id="patient_reports_div" class="mt-3">
     			 	 	
     			 		
     			 	</div>
     			 	 
     			</div>
     			
     			
     		</div>
     		 	 
     	</div>
     </div>
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <script type="text/javascript" src="static/js/patient_profile.js"></script>
  
    
</body>
</html>