 
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
                   <a href="">Doctor  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     
    
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>Doctors</h3>
     		</div>
     	</div>
     </div>
     
     <div class="container mt-3 border border-info text-info">
     	<div class="rows p-2">
     		<div class="cols  ">
     			 <form action="doctor_records.do" method="post" class="form-inline p-3" >
     				<div class="form-group">
     					<% ArrayList<Hospital> hospitals = Hospital.getHospitalNames();  %> 
     				 
     					<select class="form-control  " id="id_hospital" name="hospital">
     						<option value='0'>Select Hospital</option>
     						<% for(int i=0;i<hospitals.size();i++){ %>
     							<option value='<%=hospitals.get(i).getHospitalId() %>' ><%= hospitals.get(i).getName() %></option>
     							
     						<%} %>
     						 
     					</select>
     					<% ArrayList<String> specialities = Doctor.getDoctorSpeciality();  %>
     					 
     					<select class="form-control ml-4 " id="id_speciality" name="speciality">
     						<option value='0'>Select speciality</option>
     						<% for(int i=0;i<specialities.size();i++){ %>
     							<option value='<%=specialities.get(i)  %>' ><%= specialities.get(i) %></option>
     							
     						<%} %>
     						 
     						 
     					</select>
     					
     					<select class="form-control ml-4 " id="id_timing" name="timing">
     						<option value='0'>Select Timing</option>
     						<option value='1'>10AM-12PM</option>
     						<option value='2'>12PM-02PM</option>
     						<option value='3'>2PM-04PM</option>
     						<option value='4'>4PM-6PM</option>
     					</select>  
     					<button class="btn btn-info ml-5"> Check</button>
     				</div>
     			</form>
     		</div>
     		
     	</div>
     </div>
     
      
      
     
    
</body>
</html>