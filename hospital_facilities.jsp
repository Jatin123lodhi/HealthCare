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
                   <a href="register_opt.jsp">Facilities  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container ">
     	<div class="rows ">
     		<div class="cols ">
     			<h3 class="border-bottom border-info text-info pt-3 pb-2 pl-2">Add Facilities </h3>
     		</div>
     	</div>
     </div>
     
     <div class="container">
     	<div class="row">
     		<div class="col">
     			<ul class="nav nav-tabs">
     				<li class="nav-item">
     					<a href="#dental" class="nav-link active" data-toggle="tab" >Dental Facility</a>
     				</li>
     				<li class="nav-item">
     					<a href="#b" class="nav-link" data-toggle="tab">ECG Services</a>
     				</li>
     				<li class="nav-item">
     					<a href="#c" class="nav-link" data-toggle="tab">Scans</a>
     				</li>
     				<li class="nav-item">
     					<a href="#d" class="nav-link" data-toggle="tab">RadioLogy/X-rays</a>
     				</li>
     				<li class="nav-item">
     					<a href="#e" class="nav-link" data-toggle="tab">Physiotherpy</a>
     				</li>
     				<li class="nav-item">
     					<a href="#f" class="nav-link" data-toggle="tab">Pharmacy</a>
     				</li>
     				
     				 
     			</ul>
     			
     			<div class="tab-content p-5">
     				<div class="tab-pane fade show active" id="dental" >
     					<form >
     						<div class="form-check">
     							<input type="checkbox" value="1" class="form-check-input border border-danger" id=" cosmetic">
     							<label for="id_cosmetic"  >Cosmetic Dentistry</label>    							
     						</div>
     						<div class="form-check">
     							<input type="checkbox" class="form-check-input" id="endodontic">
     							<label for="id_endodontic">Endodontic</label>    							
     						</div>
     						<div class="form-check">
     							<input type="checkbox" class="form-check-input" id="pediatric">
     							<label for="id_pediatric">Pediatric</label>    							
     						</div>
     						 
     					</form>
     				</div>
     				<div class="tab-pane fade" id="b" >123</div>
     				<div class="tab-pane fade" id="c" >345</div>
     				<div class="tab-pane fade" id="d" >678</div>
     				<div class="tab-pane fade" id="e" >910</div>
     				<div class="tab-pane fade" id="f" >112</div>
     				 
     			</div>
     		</div>
     	</div>
     </div>
    <%-- <%@ include file="footer.jsp"%> --%>
    <script text="text/javascript" src="static/js/hospital_facilities.js"></script>
</body>
</html>