 
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.DoctorTimeSlot"%>
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
                   <a href="doctor_time_slot.do">Time Slots </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     
     <%@ include file='doctor_header_btns.jsp'%>
     
     <span class='d-none' id='doctor_id_span'>${doctor.getDoctorId()}</span>
     <div class="container  border-bottom border-info text-info">
     	<div class="row p-1">
     		<div class="cols  ">
     			<h3> Create New Time Slot</h3>
     		</div>
     	</div>
     </div>
      
     <div class="container  ">
     	<div class="row">
     		<div class="col">
     			<form class="form-inline py-2 pt-3">
     				<h5 class="ml-5 ">Enter time :</h5>
     				<input type="time" class="form-control mx-3 " id="time_input" >
     				<div class="btn btn-info" id="create_btn">Create</div>
     			</form>
     		</div>
     	</div>
     </div>
     
      <div class="container mt-5 border-bottom border-info text-info">
     	<div class="row">
     		<div class="col">
     			<h3> Available Slots -</h3>
     		</div>
     	</div>
     	 
     </div>
     <% ArrayList<DoctorTimeSlot> list = DoctorTimeSlot.bringTimeSlots(doctor.getDoctorId()); %>
      
    <div class="container mt-3">
     	<div class="row">
     		<% for(DoctorTimeSlot dts:list){ %>
     			<%
     			String convTime = "";
     			try {       
     	           String _24HourTime = dts.getTime().toString();
     	           SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
     	           SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
     	           Date _24HourDt = _24HourSDF.parse(_24HourTime);
     	           //System.out.println(_24HourDt);
     	           //System.out.println(_12HourSDF.format(_24HourDt));
     	           convTime = _12HourSDF.format(_24HourDt);
     	       } catch (Exception e) {
     	           e.printStackTrace();
     	       } %>
    	 		<div class="col-3">
    	 			<button class='btn btn-info my-3 ml-3 pr-2'><%=  convTime %> </button>
    	 			<button class='btn btn-info ml-n2 del_btn' id='<%=dts.getDoctorTimeSlotId() %>'> <i class="fa fa-times" aria-hidden="true"></i></button> 
    	 			 
    	 		</div>
     		<%} %>
     		 
     		
     	</div>
     </div>
      
     
     
     
     <script src='static/js/doctor_time_slot.js'></script> 
     
</body>
</html>