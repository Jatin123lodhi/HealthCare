<!DOCTYPE html>
<html lang="en">
<head>
  	<%@ include file="head.jsp" %>
    <title>HCare::Index Page</title>

    <link rel="stylesheet" href="static/css/form.css">
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
                   <a href=" ">Patient Test Reports  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container  border-bottom border-info text-info">
     	<div class="rows p-3">
     		<div class="cols  ">
     			<h3>Patient Test Reports</h3>
     		</div>
     	</div>
     </div>
     <%@ include file="patient_header_btns.jsp" %>
     
     <div class="container   mt-5">
     	<div class="row">
     		<div class="col">
     			 <tabel class="table table-dark">
     			 	<thead>
     			 		<tr>
     			 			<td></td>
     			 			<td></td>
     			 			<td></td>
     			 		</tr>
     			 	</thead>
     			 	<tbody></tbody>
     			 </tabel>
     			 			
     		</div> 
     	</div>
     </div>
      
      
     
    <%-- <%@ include file="footer.jsp"%> --%>
    <!-- <script type="text/javascript" src="static/js/patient_profile.js"></script> -->
  
    
</body>
</html>