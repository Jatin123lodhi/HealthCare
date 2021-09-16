<!DOCTYPE html>
<%-- <%@ page import="java.util.ArrayList,models.City" %> --%>
<%-- <%@ page import="models.Hospital" %> --%>

<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>Hcare::HospitalProfile</title>
 	<link rel="stylesheet" href="static/css/dropzone.min.css">
    <link rel="stylesheet" href="static/css/form.css">
 
</head>
<body>
    <%@  include file="header.jsp" %>
    
    <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="register_opt.jsp">Hospital Profile Info </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
    </div>

    <div class="main_body">
  	      <%@ include file="hospital_header_btns.jsp" %>
        <div class="container  " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col-6 pt-5 text-center  px-5">
                    <img alt="" src="show_hospital_logo.do?logo=${hospital.logo}" height="200">
                    <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup">

					</form>

					<input class="mt-4 btn btn-info" type="button" id="btn" value="Upload"> 
                    
                </div>
                <div class="col-6 pt-5 pl-5 ">
                   <h3 class="text-info border-bottom border-info text-center pt-3 pb-3">Hospital Profile Info</h3>
                    <% String  errorMsg = (String)request.getAttribute("error"); %>
                    <% if(errorMsg!= null){  %>
                    	<h6 class="border border-danger pt-3"><%= errorMsg %></h6>
                    <% } %>
                    
                   
                    <form action="hospital_profile.do" method="post" class="p-4" id="id_form">
                         
                         <div class="form-group">
                             <label for="id_name">Name:</label>
                             <input type="text"value="${hospital.name}" name="name" class="form-control form_inp" autocomplete="off" placeholder="Enter hospital's name" id="id_name">
                         	 <small id="name_help" class=" form-text text-muted">Allowed characters are a-z, A-Z, 0-9 and spaces</small>	
                         	 <small id="name_error" class=" form-text text-danger hide">Invalid name. Enter a valid name</small>	
                         
                         </div>
                         <div class="form-group">
                            <label for="id_email">Email:</label>
                            <input type="email" value="${hospital.email}" name="email" class="form-control form_inp" autocomplete="off" placeholder="Enter email" id="id_email">
                            <small id="email_help" class=" form-text text-muted">Enter a valid email ex- ram@gmail.com.in</small>
                            <small id="email_error" class=" form-text  text-danger hide">Invalid email</small>
                        	
                        </div>
                        <div class="form-group">
                            <label for="id_password">Password:</label>
                            <input type="password" value="${hospital.password}" name="password" class="form-control form_inp" autocomplete="off" placeholder="Enter password" id="id_password">
                            <i id="view_password" class="fa fa-eye" aria-hidden="true"></i>
                            <small id="password_help" class="form-text text-muted">Password must  be 8 characters long</small>
                            <small id="password_error" class="form-text  text-danger hide">Invalid password</small>
                        </div>
                       
                       	<div class="form-group">
                       		<label for="id_start_date">Start Date.</label>
                       		<input type="date" value="${hospital.startDate}"  name="start_date" class="form-control  " autocomplete="off" id="id_start_date">
                       		<small id="start_date_help" class="form-text text-muted">When your hospital was started</small>
                       	</div>
                       	
                       	<div class="form-group">
                       		<label for="id_description">Hospital General Description</label>
                       		<textarea rows="4"   name="description" class="form-control  " autocomplete="off" id="id_description">${hospital.description}</textarea>
                       		 
                       	</div>
                       	<div class="form-group">
                       		<label for="id_address">Address</label>
                       		<textarea rows="4"  name="address" class="form-control  " autocomplete="off" id="id_address">${hospital.address}</textarea>
                       		 
                       	</div>
                       	
                       
                       	
                       	<div class="form-group">
                       		<label for="id_city">City</label>
                       		<select class="form-control"  name="city" id="id_city">
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
                       	
                       	<div class="form-group">
                       		<label for="id_contact_no">Contact No. </label> 
                       		<input type="number"  value="${hospital.contactNo}" name="contact_no" class="form-control  " autocomplete="off" id="id_contact_no">
                       		<small id="contact_no_help" class="form-text text-muted">Enter 10 digit contact number</small>
                       		 
                       	</div>
                       	
                       	<div class="form-group" id="otp_box">
                       		<label for="id_otp">Enter OTP</label>
	                       	<div class="container">
	                       		<div class="row">
	                       			<div class="col-4">	                       							              
				                       	<input type="text"   class="form-control ml-n2" id="otp_field">			                       							                       	 
	                       			</div>
	                       			<div class="col-4">
	                       				<input type="button" id="check_otp" class="btn btn-info  " value="Verify OTP"> 	                       				 
	                       			</div>
	                       			<div class="col-4">
	                       				<small id="verify_otp_help" class="form-text "></small> 	                       				 
	                       			</div>
	                       		</div>
	                       	</div>
	                        <small id="verify_otp_help1" class="form-text text-danger mt-2">Check the contact_no or resend the otp</small>                   	
                       	</div>
                       	
                       	 
                       	
                       	
                       	
                       	
                       	
                        <input type="button" class="btn btn-info mt-4" id="id_send_otp" value="Send OTP">
                        <input type="submit" class="btn btn-info mt-4" value="Save" id="id_save_btn"> 
                        
                        
                    </form>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
   <script src="static/js/dropzone.min.js"></script>
   <script>
		Dropzone.autoDiscover = false;

		Dropzone.options.picup = {
			paramName: 'file',
			maxFilesize: 1,
			uploadMultiple: false,
			createImageThumbnails: true,
			maxFiles: 1,
			acceptedFiles: '.jpeg,.png,.gif,.jpg,.jfif',
			addRemoveLinks: true,
			autoProcessQueue: false
		};


		let dropzone = new Dropzone('#picup', {url: 'hospital_logo_upload.do'});

		let btn = document.querySelector('#btn');
		btn.addEventListener('click',()=>{
			dropzone.processQueue();
		});
	</script>
	<script type="text/javascript" src="static/js/common.js"></script>
	<script type="text/javascript" src="static/js/hospital_profile.js"></script>
</body>
</html>