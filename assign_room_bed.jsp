<!DOCTYPE html>
<%@ page import="models.Bed" %>
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
                   <a href="#">Assign Room and Bed  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows mt-2 ">
     		<div class="cols">
     			<h3 class="pb-2">Assign Room and Bed</h3>
     		</div>
     	</div>
     </div>
     
     <div class="container">
     	<div class="col">
     		<div class="row">
     			<form class="form-inline p-3" >
     				<div class="form-group">
     					<label for="id_room"></label>
     					<select class="form-control  " id="id_room" name="room">
     						<option value='0'>Select Room</option>
     						<option value='1'>1</option>
     						<option value='2'>2</option>
     						<option value='3'>3</option>
     						<option value='4'>4</option>
     					</select>
     					<input type="button" class ="btn btn-info ml-3 " id="id_check" value="Check">	
     					
     					<span><i class="fa fa-bed fa-lg ml-5 mr-2" style="color:red"></i>: Occupied </span>
     					<span><i class="fa fa-bed fa-lg ml-5 mr-2" style="color:green"></i>: Vacant </span>
     					
     					<label for="id_bed" class="ml-5">Bed No: </label>
     					<input type="text" name="bed_no" id="id_bed" class="form-control ml-3" placeholder="Select the bed no" >
     					<input type="button" class="btn btn-info ml-3" value="Assign bed" id="assign_bed">
     				</div>
     			</form>
     			 	
     		</div>
     	</div>
     </div>
     
     <div class="container border border-info" style="display:none" id="bed_box">
     
     	<div class="row" style="min-height:350px;" id="bed_box_row">
     		<%-- <% ArrayList<Bed> list = (ArrayList<Bed>)request.getAttribute("bedInfo");
     			if(list!=null){ %>
     		
	     		<% for(int i=0; i<list.size();i++){ 
	     			if(list.get(i).getBedStatus().getBedStatusId()==2){ %>
	     				<div class="col-2  occupied text-center">    			 
			     			 <i class="fa fa-bed fa-3x px-3 pt-3 pb-2" style="color:red"> </i>
			     			 <div class="text-center"><%= list.get(i).getBedNo() %> </div>     			      			  
			     		</div>
	     		<%	}else{ %>
	     				<div class="col-2   text-center" style="cursor:pointer" id="102">    			 
			     			 <i class="fa fa-bed fa-3x px-3 pt-3 pb-2" style="color:green"> </i>
			     			 <div class="text-center"><%= list.get(i).getBedNo() %></div>     			      			  
			     		</div>
	     			
     			
     		<% }}}  %> --%>
     		
     		
     		
     		
     		<!-- <div class="col-2  occupied text-center">    			 
     			 <i class="fa fa-bed fa-3x px-3 pt-3 pb-2" style="color:red"> </i>
     			 <div class="text-center">101</div>     			      			  
     		</div>
     		<div class="col-2   text-center" style="cursor:pointer" id="102">    			 
     			 <i class="fa fa-bed fa-3x px-3 pt-3 pb-2" style="color:green"> </i>
     			 <div class="text-center">102</div>     			      			  
     		</div> -->
     	 
     	</div>
     </div>
 
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <script src='static/js/assign_room_bed.js'></script>
</body>
</html>