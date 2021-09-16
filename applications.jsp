<!DOCTYPE html>
<%@ page import="models.Application" %>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>
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
                   <a href="register_opt.jsp">Doctor Applications  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp"%>
     
     <div class="container ">
     	<div class="rows ">
     		<div class="cols ">
     			<h3 class="border-bottom border-info text-info pt-3 pb-2 pl-2">Doctor Applications  </h3>
     		</div>
     	</div>
     </div>
     
     <div class="container">
     	<div class="row">
     		<div class="col">
     			 
     			<% ArrayList<Application> list = Application.bringAllApplications(hospital.getHospitalId()); %>
     			 
     			
   				<table class="table table-dark">
   					<thead>
   						<tr>
   							<td>S No.</td>
   							<td>Doctor Name</td>
   							<td>License</td>
   							<td>View Profile</td>
   							<td>Request</td>
   						</tr>
   						 
   					</thead>
   				<%for(int i=0;i<list.size();i++){  %>
   			 	 
   					<tbody>
   						<tr id="id_<%=list.get(i).getApplicationId() %>">
   							<td class="s_no"><%= i+1 %> </td>
   							<td><%= list.get(i).getDoctor().getName() %> </td>
   							<td><a href="showDoctorLicense.do?fileName=<%= list.get(i).getDoctorLicenseFile()%>">Download File</a></td>
   							<td><input type="button" value="Show" id="id_show_<%=list.get(i).getDoctor().getDoctorId() %>" class="btn btn-info show_btn"></td>
   							<td>
    							<input type="button" value="Accept" class="btn btn-info accept_btn" id="accept_<%=list.get(i).getApplicationId() %>">
    							<input type="button" value="Reject" class="btn btn-info reject_btn" id="reject_<%=list.get(i).getApplicationId() %>">
    							<span id="id_<%= list.get(i).getHospital().getHospitalId() %>" class="hospital_id"></span>
    							<span id="id_<%=list.get(i).getDoctor().getDoctorId() %>" class="appId_<%=list.get(i).getApplicationId() %>"></span>
   							</td>
   						</tr>
   					</tbody>
   				<%} %>	
   				</table>
     				<%-- <h5><%= " License-    "+list.get(i).getDoctorLicenseFile()+"     doctorId-  "+list.get(i).getDoctorId()+"    AppstatusId-  "+list.get(i).getApplicationStatus().getApplicationStatusId() %></h5> --%>
     			
     			 
     		</div>
     	</div>
     </div>
     
     <div class="container px-5 pb-5 form-box">
     	<div class="row px-5 pb-5 mx-5">
     		<div class="col p-5 mx-5 ">
     			
     			
     			<div class="form border border-info px-5 pt-2 pb-5 mx-5 mb-5 mt-2 bg-white" style="min-height:700px">
     				 
     				<i class="fa fa-times fa-lg float-right mt-3" style="cursor:pointer"></i>
     				<div class="container  border-bottom border-info text-info mb-4 mt-3 ">
				     	<div class="rows px-3 pb-2 pt-1 ">
				     		<div class="cols ">
				     			<h3 id="heading">Doctor Profile</h3>
				     		</div>
				     	</div>
				    </div>
     				<div id="doctor_profile_div" >
	     				
	 					<form class="doctor_form" id="profile_form">
		     				<div class="row mb-2 mt-3">
		     					<div class="col ">
		     						<label for="id_name">Name:</label>
			     					<input type="text" class="form-control form_inp" name="name" id="id_name">
			     					 
		     					</div>
		     					<div class="col">
		     						<label for="id_doctor_id">Doctor Id:</label>
			     					<input type="text" class="form-control form_inp" name="doctor_id" id="id_doctor_id">     					 
			                         
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
			                      
		     					</div>
		     					 
		     				</div>
		     			 	
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="gender" class="d-block mt-1">Gender:</label>
			     					<input type="text" class="form-control form_inp" name="gender" id="id_gender"> 
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
		     						<label for="id_specialization">Specialization:</label>
			     					<input type="text" class="form-control form_inp" name="specialization" id="id_specialization">     			                         
		     					</div> 
		     					<div class="col">
		     						<label for="id_experience">Experience:</label>
			     					<input type="text" class="form-control form_inp" name="experience"  id="id_experience" >     					      
		     					</div>     					 
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_service_time">Service Time:</label>
		                  			<input type="text" class="form-control form_inp" name="service_time"  id="id_service_time" > 
		     					</div>
		     				</div>
		     				<div class="row mb-2">
		     					<div class="col">
		     						<label for="id_address">Address</label>
		                  			<textarea rows="4"  name="address" class="form-control  " autocomplete="off" id="id_address"> </textarea> 
		     					</div>
		     				</div>
		     				
		     				 
	     				</form>
     				</div>
     			 	 
     			 	 
     			</div>
     			
     			
     		</div>
     		 	 
     	</div>
     </div>
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <script type="text/javascript" src='static/js/applications.js'></script>
     
</body>
</html>