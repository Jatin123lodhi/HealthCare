<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    <link rel="stylesheet" href="static/css/form.css">
    
</head>
<body>
    <%@  include file="header.jsp"%>
     <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">New Patient Admission  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>New Patient Admission</h3>
     		</div>
     	</div>
     </div>
     <div class="container  w-50">
     	<div class="row">
     		<div class="col">
     			<form action="new_admission.do" method="post" class="p-5">
     				<div class="form-group ">
     					 <label for="id_name">Name:</label>
     					<input type="text" class="form-control form_inp" name="name" id="id_name">
     					<small id="name_error" class="form-text text-danger hide">Invalid Name</small>
     				</div>
     				<div class="form-group ">
     					 <label for="id_email">Email:</label>
     					<input type="text" class="form-control form_inp" name="email" id="id_email">     					 
                        <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
     				</div>
     				 
     				<div class="form-group ">
     					 <label for="id_contact">Contact:</label>
     					<input type="text" class="form-control" name="contact" id="id_contact">
     				</div>
     				<div class="form-group">
     					 <label for="id_dob">Date of Birth:</label>
     					<input type="date" class="form-control" name="dob" id="id_dob">
     				</div>
     				<div class="form-group p-2">
     					<label class="d-block">Gender:</label>
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
     				
     				<div class="form-group">
     					 <label for="id_bg">Blood Group:</label>
     					 <select class="form-control" name="blood_group" id="id_bg">
     					 	<option value="A+">A+</option>
     					 	<option value="B+">B+</option>
     					 	<option>AB+</option>
     					 	<option>O+</option>
     					 	<option>A-</option>
     					 	<option>B-</option>
     					 	<option>AB-</option>
     					 	<option>O-</option>
     					 </select>
     				</div>
     				
     				<div class="form-group">
     					<label for="id_weight">Weight(Kg) :</label>
     					<input type="text" class="form-control" name="weight" id="id_weight">    					
     				</div>
     				
     				<div class="form-group">
     					<label for="id_height">Height(ft) :</label>
     					<input type="text" class="form-control" name="height" id="id_height">    					
     				</div>
     				
     				<div class="form-group">
                  		<label for="id_address">Address</label>
                  		<textarea rows="4"  name="address" class="form-control  " autocomplete="off" id="id_address"> </textarea> 
                  	</div>
                  	
                  	<div class="form-group">
	              		<label for="id_city1">City</label>
	              		<select class="form-control"  name="city" id="id_city1">
	              			<option>Select city</option>                      			                      			
	              			<% for(City city:cities){ %>
	              				<%if(city.getCityId()==hospital.getCity().getCityId()){ %>
	              				<option value="<%=city.getCityId() %>" selected> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>	
	              				<%}else{ %>
	              				<option value="<%=city.getCityId() %>"> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>
	              				<% }%>
	              			<%} %>
	              		</select>
	              	</div>
                  
                  	<input type="submit" value="Save Details" class="btn btn-info">
     				
     			</form>
     		</div>
     	</div>
     </div>
     
    <%-- <%@ include file="footer.jsp"%> --%>
    
    <script src="static/js/patient_admission.js"></script>
    
</body>
</html>