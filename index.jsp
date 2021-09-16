<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    
    
</head>
<body>
    <%@  include file="header.jsp"%>
    <div class="main_body jumbotron jumbotron-fluid banner" >
        <div class="container box   pl-5 mb-5">
            <h1 class="text-white p-2 mb-0" >Find best doctors and hospitals near you</h1>
            <p class="lead text-white p-2">The best services and hospitals in your city!  </p>
            <form class="form-inline pt-3 ">
               
                <select class=" mr-1 btn btn-info" style="height: 45px;" id="slc_fld">
                	<option value="0">Select</option>
                	<option value="1">Hospitals</option>
                	<option value="2">Doctors</option>
                	<option value="3">Medicines</option>
                </select>
                 <input type="search" class="form-control w-75 " id="srh_field" style="height: 45px;" placeholder="Search doctors, hospitals, medicines">
                <input type="submit" value="Search" id="srch_btn" class="btn btn-info ml-1" style="height: 45px;">
            </form>
            
            <div class="container mt-1 w-75 text-info " style="display:none;" id="doctor_srch_func">
		     	<div class="rows p-2">
		     		<div class="cols  ">
		     			 <form class="form-inline p-3" >
		     				<div class="form-group">
		     					<% ArrayList<Hospital> hospitals = Hospital.getHospitalNames();  %> 
		     				 
		     					<select class="form-control btn btn-info border border-info  "   id="id_hospital" name="hospital">
		     						<option value='0'>Select Hospital</option>
		     						<% for(int i=0;i<hospitals.size();i++){ %>
		     							<option value='<%=hospitals.get(i).getHospitalId() %>' ><%= hospitals.get(i).getName() %></option>
		     							
		     						<%} %>
		     						 
		     					</select>
		     					<% ArrayList<String> specialities = Doctor.getDoctorSpeciality();  %>
		     					 
		     					<select class="form-control ml-4 border border-info btn btn-info" id="id_speciality"   name="speciality">
		     						<option value='0'>Select speciality</option>
		     						<% for(int i=0;i<specialities.size();i++){ %>
		     							<option value='<%=specialities.get(i)  %>' ><%= specialities.get(i) %></option>
		     							
		     						<%} %>
		     						 
		     						 
		     					</select>
		     					
		     					<select class="form-control ml-4 border border-info btn btn-info " id="id_timing"    name="timing">
		     						<option value='0'>Select Timing</option>
		     						<option value='1'>10AM-12PM</option>
		     						<option value='2'>12PM-02PM</option>
		     						<option value='3'>2PM-04PM</option>
		     						<option value='4'>4PM-6PM</option>
		     					</select>  
		     					 
		     				</div>
		     			</form>
		     		</div>
		     		
		     	</div>
     		</div>
     		
     		
            
            
        </div>
        
    </div>
    <%@ include file="footer.jsp"%>
    <script type="text/javascript" src="static/js/index.js"></script>
</body>

</html>