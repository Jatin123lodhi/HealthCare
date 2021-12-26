<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>
	<style>
		html {
  			scroll-behavior: smooth;
		}
		
		 
    	/* .form-box{
    		position:absolute;
    		top:0;
    		left:0;
    		max-width:100%;
    		height:100%;
    		z-index:1;
    		background-color: rgba(0,0,0,0.5);
    		display:flex;
    		align-items: center;
    		justify-content:center;
    	} */
    	 
    
	</style>
    
    
</head>
<body>
    <%@  include file="header.jsp"%>
    <div class="main_body   jumbotron jumbotron-fluid banner" >
        <div class="container   pl-5 mb-5">
            <h1 class="text-white p-2 mb-0" >Find best doctors and hospitals near you</h1>
            <p class="lead text-white p-2">The best services and hospitals in your city!  </p>
            <form class="form-inline pt-3 ">
               	<select class="form-control btn btn-info border border-info mr-2" style="height: 45px;"  id="id_city" name="hospital">
					<option value='0'>Select City</option>
					<% for(int i=0;i<cities.size();i++){ %>
					<option value='<%=cities.get(i).getCityId() %>' ><%= cities.get(i).getCity() %></option>
							
					<%} %>		 
				</select>
                <select class=" mr-1 btn btn-info" style="height: 45px;" id="slc_fld">
                	<option value="0">Type</option>
                	<option value="1">Hospitals</option>
                	<option value="2">Doctors</option>
                	<option value="3">Medicines</option>
                </select>
                 <input type="search" class="form-control w-50 " id="srh_field" style="height: 45px;" placeholder="Search doctors, hospitals, medicines">
                <input type="submit" value="Search" id="srch_btn" class="btn btn-info ml-1" style="height: 45px;">
            </form>
              
        </div>
        <div class="container rounded  bg-white mt-5 p-3">
        	<div class="row p-2">
        		<div class="col-2  speciality btn btn-outline-info  text-center pt-1 "   id="spec_1" style="cursor:pointer">
        			 <img src="static/images/tooth.png"  class="h-50">
        			 <div>Dentist</div>
        		</div>
        		<div class="col-2  speciality btn btn-outline-info text-center pt-2" id="spec_2" style="cursor:pointer">
        			<img src="static/images/skin.png" class="h-50" >
        			<div>Dermatologist</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info text-center" id="spec_3" style="cursor:pointer">
        			<img src="static/images/bones.png" style="cursor:pointer" class="h-50">
        			<div>Orthopedic</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info text-center" id="spec_4" style="cursor:pointer">
        			<img src="static/images/heart.png" style="cursor:pointer" class="h-50" >
        			<div>Cardiologist</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info text-center pt-2" id="spec_5" style="cursor:pointer">
        			<img src="static/images/brain.png" style="cursor:pointer" class="h-50" >
        			<div>Phychiarist</div>
        		</div>
        		<div class="col-2  speciality btn btn-outline-info  text-center pt-1" id="spec_6" style="cursor:pointer">
        			<img src="static/images/eye.png" style="cursor:pointer" class="h-50">
        			<div>Ophthalmologist</div>
        		</div>
        		 
        	</div>
        	<div class="row p-2">
        		<div class="col-2 speciality btn btn-outline-info border border-info text-center pt-1" id="spec_7" style="cursor:pointer">
        			 <img src="static/images/generalDoc.png" class="h-50" >
        			 <div>General Physician</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info  border border-info text-center pt-2" id="spec_8" style="cursor:pointer">
        			<img src="static/images/veternary.png" class="h-50">
        			<div>Veterinarian</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info border border-info text-center" id="spec_9" style="cursor:pointer">
        			<img src="static/images/neurologist.png" style="cursor:pointer" class="h-50">
        			<div>Neurologist</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info border border-info text-center pt-1" id="spec_10" style="cursor:pointer">
        			<img src="static/images/baby.png" style="cursor:pointer" class="h-50">
        			<div>Paediatrician</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info  border border-info text-center pt-2" id="spec_11" style="cursor:pointer">
        			<img src="static/images/female.png" style="cursor:pointer" class="h-50" >
        			<div>Gynecologist</div>
        		</div>
        		<div class="col-2 speciality btn btn-outline-info border border-info text-center pt-1" id="spec_12" style="cursor:pointer">
        			<img src="static/images/ayurveda.png" style="cursor:pointer" class="h-50">
        			<div>Ayurvedic</div>
        		</div>
        		 
        	</div>
        </div>
        
    </div>
    
    <div class="container   p-3 rec_container"  >
    	  <h5 class="text-secondary d-none result">Search Results for <span id="spec_span"></span>-</h5>
    </div>
    
    <!-- <div class="container px-5 pb-5 form-box">
     	<div class="row px-5 pb-5 mx-3">
     		<div class="col p-5 mx-3 ">
     			
     			
     			<div class="form border border-info rounded px-5 pt-2 pb-5  mb-5   bg-white" style="min-height:700px;min-width:970px" id="slots_div">
     				
     				<i class="fa fa-times fa-lg float-right mt-2 ml-n2" style="cursor:pointer"></i>
     				<div class="container  border-bottom border-info text-info mb-4 ">
				     	<div class="rows px-3 pb-2 pt-1 ">
				     		<div class="cols ">
				     			<h3 id="heading" class="mt-2">Book Slots -</h3>
				     		</div>
				     	</div>
				    </div>
     				
   
     			</div>
     			
     			
     		</div>
     		 	 
     	</div>
     </div> -->
    <%@ include file="footer.jsp"%>
    <script type="text/javascript" src="static/js/index.js"></script>
</body>

</html>