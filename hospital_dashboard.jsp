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
                   <a href="register_opt.jsp">Hospital Dashboard  </a> <span class="text-white">></span>
                   
               </div>
            </div>
        </div>
     </div>
     <%@ include file="hospital_header_btns.jsp" %>
     
     <div class="container text-center">
     	<div class="rows p-4">
     		<div class="cols p-4">
     			<h1>Dashboard page</h1>
     		</div>
     	</div>
     </div>
    <%@ include file="footer.jsp"%>
</body>
</html>