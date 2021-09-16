<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    
    
</head>
<body>
    <%@  include file="header.jsp"%>
     <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container  ">
            <div class="row">
               <div class="col py-2  ">
               	   <a href="index.jsp">Home </a> <span class="text-white">></span>
                   <a href="hospital.do"> Hospital  </a> <span class="text-white"></span> 
               </div>
            </div>
        </div>
     </div>
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>Search Hospitals</h3>
     		</div>
     	</div>
     </div>
     
     <div class="container box mb-5">
     	<div class="row">
     		<div class="col ">
     		
   				<div class="form-inline p-2 mt-3 srch"> 
   				  <div class="form-group ml-3"> 
   				 	<input type="text" class="form-control" name='hospital' id="id_srh" placeholder="Enter hospital name" style="width:500px">
   				  </div>
   				  <button class=" ml-2 btn btn-info" id="search_btn" >Search</button>
    			</div>
    			
    			<!-- <div class="container pt-4">
    				<div class="row">
    					<div class="col-3 border border-info p-2" id="div_1">
    						<img alt="" src="show_hospital_logo.do?logo=jabalpur@gm.com/jabalpurhospital.jpg" width="100%" height="100%">
    					</div>
    					<div class="col-9 border border-info " id="div_2">
    					    <table class="table table-dark mt-3">
     							<tr>
     								<td>Name</td>
     								<td>Fortis Hospital</td>
     							<tr>
     							<tr>
     								<td>Email</td>
     								<td>jatinlodhi111@gmail.com</td>
     							<tr>
     							<tr>
     								<td>City</td>
     								<td>Jabalpur</td>
     							<tr>
     							<tr>
     								<td>Contact No</td>
     								<td>777888777</td>
     							<tr>
     						</table> 
    					</div>
    				</div>
    				
    		   </div> -->
    		   
     		 			
     		</div> 
     	</div>
     </div>
     
     
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <script type="text/javascript" src="static/js/hospital.js"></script>
     
</body>
</html>