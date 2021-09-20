<%@ page import="models.Hospital" %>
<%@ page import="models.Patient" %>
<%@ page import="models.Doctor" %>
<%@ page import="java.util.ArrayList,models.City" %>

<div class="header">

    <div class="container-fluid  ">
        <div class="row">
            <div class="col-4 ">
                <div class="row">
                    <div class="col-4  ">
                    	<a href="index.jsp" style="text-decoration:none"><img src="static/images/logo.jpg" alt="" class="img-fluid" style="height:100px;"></a>
                    	
                    </div>
                    <div class="col-8   pt-3 pb-1">
                        <a href="index.jsp" style="text-decoration:none"> <h2 class="text-success py-1 font-weight-bold">Health Care</h2></a>
                        <p class="text-primary text-info">We take care of your health.</p>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-4  px-5 pt-2  ">
                <a href="hospital.do" class="btn btn-outline-info">Hospitals</a>
                <a href="doctor.do" class="btn btn-outline-info">Doctors</a>
                <button class="btn btn-outline-info">Medicines</button>

                <form action="" class="form-inline pt-3 ">
                    <input type="search" class="form-control" name="search" id="id_search">
                    <input type="submit" value="Search" name="srch_btn" id="id_srch_btn" class="btn btn-info ml-1">
                </form>
            </div>
            <div class="col-4  pt-2 ">
                <div class="row">
                    <div class="col mt-2 text-right">
                        
                        <a href="index.jsp"><i class="fa fa-home mr-3 fa-lg " style="cursor: pointer;color:info"></i></a>
                        <div class="dropdown pr-3"  style="display:inline">
                        	<a href="#" class="dropdown-toggle mr-3" id="dropdownMenuLink" data-toggle="dropdown"><i class="fa fa-sliders fa-lg"></i></a>
                        	<% Hospital hospital = (Hospital)session.getAttribute("hospital");  %>                      	 
                        	<% Patient patient = (Patient)session.getAttribute("patient");  %>                      	 
                        	<% Doctor doctor = (Doctor)session.getAttribute("doctor");  %>                      	 
                        	                      	 
                       	
                    
                        	<div class="dropdown-menu border border-primary ml-n5 pr-0 mt-2" style="min-width:20px;"  aria-labelledby="dropdownMenuLink">
                        		<% if(hospital==null && patient==null && doctor==null ){ %>
	                        		<a href="login_opt.jsp" class="dropdown-item text-info "><i class="fa fa-sign-in  "></i> Login</a>
	                        		<a href="register_opt.jsp" class="dropdown-item text-info "><i class="fa fa-user-plus  "></i> Register</a>
	                     	   	<%}else if(hospital!=null){ %>
	                     	   		
	                     	   		<a href="logout.do" class="dropdown-item text-info"><i class="fa fa-sign-out  "></i> Logout</a> 
	                     	   		<a href="hospital_profile.do" class="dropdown-item text-info "><i class="fa fa-user  "></i> Profile</a> 
	                     	   	<%}else if(doctor!=null){ %>
                     	   		
	                     	   		<a href="logout.do" class="dropdown-item text-info"><i class="fa fa-sign-out  "></i> Logout</a> 
	                     	   		<a href="doctor_profile.do" class="dropdown-item text-info "><i class="fa fa-user  "></i> Profile</a>  
		                        <%}else if(patient!=null){ %>
		                        	<a href="logout.do" class="dropdown-item text-info"><i class="fa fa-sign-out  "></i> Logout</a> 
	                     	   		<a href="doctor_profile.do" class="dropdown-item text-info "><i class="fa fa-user  "></i> Profile</a>                  
		                        <% } %>  
                        	</div>
                        	<span class="ml-3"></span>
                        	
                        </div>
                        
                        
                     
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 ml-auto" >
                        <% ArrayList<City> cities = City.getAllCities(); %>
                        <div class="form-group pt-4  city-select  ">
                            <select name="" id="" class="form-control">
                                <option value='0'>Select city</option>                      			                      			
                       			<% int cityId=0;
                       			if(hospital!=null){ cityId= hospital.getCity().getCityId();}
                       			else if(patient!=null){ cityId = patient.getCity().getCityId();}
                       			else if(doctor!=null){ cityId = doctor.getCity().getCityId();}
                       				
                       			%>
                       			<% for(City city:cities){ %>
                       				
                       				<%if(cityId!=0 && city.getCityId()==cityId){ %>
                       				<option value="<%=city.getCityId() %>" selected> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>	
                       				<%}else{ %>
                       				<option value="<%=city.getCityId() %>"> <%= city.getCity()+" ("+city.getState().getState()+")"  %> </option>
                       				<% }%>
                       			<%} %>
                            </select>
                        </div>
                    </div>
                </div>
                
                
            </div>
        </div>
        <span class="text-primary text-center ml-3">Welcome ${hospital.getName()} ${patient.getName()} ${doctor.getName()} </span>
    </div>
    
   
</div>