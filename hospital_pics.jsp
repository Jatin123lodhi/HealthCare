<!DOCTYPE html>
<%@page import="models.HospitalPic"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
 	<%@ include file="head.jsp" %>
     
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
     
    <link rel="stylesheet" href="static/css/dropzone.min.css">
    
</head>
<body>
    <%@  include file="header.jsp"%>
    <div class="navigate border border-info mb-3" style="background-color:#131324">
        <div class="container ">
            <div class="row">
               <div class="col py-2">
               	<a href="index.jsp">Home </a> <span class="text-white">></span>
                <a href="">Profile Pics </a> <span class="text-white">></span>
                
                    
               </div>
            </div>
        </div>
    </div>
    <%@ include file="hospital_header_btns.jsp" %> 

    <div class="main_body">
        <h3 class="text-info text-center pt-3">Profile Pics -</h3>

        <div class="container border-top border-info " style="min-height: 500px;">
            <div class="row pt-4 ">
                <div class="col">
                    
                    <ul class="nav nav-pills" id="myTab"  >
					  <li class="nav-item"  >
					    <a class="nav-link active " id="id_allPics" data-toggle="tab" href="#home"  >All Uploaded Pics</a>
					  </li>
					  <li class="nav-item" role="presentation">
					    <a class="nav-link" id="id_uploadPics" data-toggle="tab" href="#profile"  >Uplaod New Pics</a>
					  </li>
					</ul>
					
					<div class="tab-content p-5" id="myTabContent">
					  
					  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
					  	 
					  	   <ul class="nav nav-pills" id="all-tabs1">
	                       <li class="nav-item">
	                           <a href="#id_interior1" class="nav-link active" data-toggle="tab">Interior</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_exterior1" class="nav-link" data-toggle="tab">Exterior</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_parking1" class="nav-link" data-toggle="tab">Parking</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_rooms1" class="nav-link" data-toggle="tab">Rooms</a>
	                       </li>
	                        <li class="nav-item">
	                           <a href="#id_ot1" class="nav-link" data-toggle="tab">Operation-Theatre</a>
	                       </li>
	                        <li class="nav-item">
	                           <a href="#id_reception1" class="nav-link" data-toggle="tab">Reception</a>
	                       </li>
	                   </ul>
						   <% ArrayList<HospitalPic> hospitalPics = (ArrayList<HospitalPic>)request.getAttribute("hospitalPics"); 
						   
						   %> 
						    
		                   <div class="tab-content" id="all-panes1">
		                        <div class="tab-pane show active fade p-3 card-columns" id="id_interior1">
		                         <%int flag = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==1){
	                            	 	flag++; %>
	                            	 	<div class="card">
	                            	 	 <img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"   width="320px">
	                                 	</div>	
		                              <%}}
		                          if(flag==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>		                      
		                        </div>
		                        
		                        <div class="tab-pane fade p-3 card-columns" id="id_exterior1">
		                            <% int flag1 = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==2){
	                            	 	flag1++; %>
	                            	 	<div class="card">
	                            	 	 <img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"   width="320" >
	                                 	</div>
		                              <%}}
		                          if(flag1==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>
		                        </div>
		                        <div class="tab-pane fade p-3 card-columns" id="id_parking1">
		                             <% int flag3 = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==3){
	                            	 	 flag3++; %>
	                            	 	 <div class="card">
	                            	 	 	<img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"   width="320" >
	                            	 	 </div>
	                            	 	 
	                                 
		                              <%}}
		                          if(flag3==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>
		                        </div>
		                        <div class="tab-pane fade p-3 card-columns" id="id_rooms1">
		                             <% int flag4 = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==4){
	                            	 	flag4++; %>
	                            	 	 <div class="card">
	                            	 	 	<img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"  width="320" >
	                            	 	 </div>
		                              <%}}
		                          if(flag4==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>
		                        </div>
		                        <div class="tab-pane fade p-3 card-columns" id="id_ot1">
		                            <% int flag5 = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==5){
	                            	 	flag5++; %>
	                            	 	 <div class="card">
	                            	 	 	<img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"   width="320"  >
	                            	 	 </div>
		                              <%}}
		                          if(flag5==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>
		                        </div>
		                        <div class="tab-pane fade p-3 card-columns" id="id_reception1">
		                         	<% int flag6 = 0;
		                           for(HospitalPic hospitalPic: hospitalPics){  %>
		                            	 
	                            	<% if(hospitalPic.getPicType().getPicTypeId()==6){
	                            	 	flag6++; %>
	                            	 	 <div class="card">
	                            	 	 	<img src="showHospitalPics.do?pic_path=<%= hospitalPic.getPicPath() %>"  width="320"  >
	                            	 	 </div>
		                              <%}}
		                          if(flag6==0){  %>
	                            	 <h3> No image</h3>
	                             <% } %>
		                        </div>
		                    </div>
               
					  	 
					  </div>
					  
					  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
					    <ul class="nav nav-tabs " id="all-tabs">
	                       <li class="nav-item">
	                           <a href="#id_interior" class="nav-link active" data-toggle="tab">Interior</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_exterior" class="nav-link" data-toggle="tab">Exterior</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_parking" class="nav-link" data-toggle="tab">Parking</a>
	                       </li>
	                       <li class="nav-item">
	                           <a href="#id_rooms" class="nav-link" data-toggle="tab">Rooms</a>
	                       </li>
	                        <li class="nav-item">
	                           <a href="#id_ot" class="nav-link" data-toggle="tab">Operation-Theatre</a>
	                       </li>
	                        <li class="nav-item">
	                           <a href="#id_reception" class="nav-link" data-toggle="tab">Reception</a>
	                       </li>
	                   </ul>

	                    <div class="tab-content" id="all-panes">
	                        <div class="tab-pane show active fade" id="id_interior">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_interior">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_interior" value="Upload"> 
	                        </div>
	                        <div class="tab-pane fade" id="id_exterior">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_exterior">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_exterior" value="Upload"> 
	                        </div>
	                        <div class="tab-pane fade" id="id_parking">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_parking">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_parking" value="Upload"> 
	                        </div>
	                        <div class="tab-pane fade" id="id_rooms">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_rooms">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_rooms" value="Upload"> 
	                        </div>
	                        <div class="tab-pane fade" id="id_ot">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_ot">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_ot" value="Upload"> 
	                        </div>
	                        <div class="tab-pane fade" id="id_reception">
	                            <form class="dropzone pt-4 mt-5 mx-4 border border-primary" id="picup_reception">
									
								</form>
	
								<input class="mt-4 btn btn-primary ml-4" type="button" id="btn_reception" value="Upload"> 
	                        </div>
	                    </div>
               
					  </div>
					</div>
                    
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
    <script src="static/js/dropzone.min.js"></script>
    <script>
		
    
    	let forms = document.querySelectorAll('.dropzone');
    	forms.forEach((form,index)=>{
    		  let form_id = form.id; //
    		  Dropzone.autoDiscover = false;
    		  //console.log(Dropzone.options);
    		  Dropzone.options.form_id=
    			{
    				paramName: 'file',
    				maxFilesize: 5,
    				uploadMultiple: true,
    				createImageThumbnails: true,
    				maxFiles: 1,
    				acceptedFiles: '.jpeg,.png,.gif,.jfif,.jpg',
    				addRemoveLinks: true,
    				autoProcessQueue: false
    			};
    		   
    		  console.log(index, '!!!!!!!!!!!!!!!!!!!');
    		  let id = index+1;            // why 10 print ho rha tha 
    		  let dropzone = new Dropzone('#'+form.id, {url:'hospital_pics_upload.do?pic_type_id='+id});
    		  
    		  let btn = document.querySelector('#btn'+form.id.substring(5)); 
    		   
    		  btn.dz = dropzone;
    		  btn.addEventListener('click',()=>{
    		  	btn.dz.processQueue();
    		  
    		  });
    	});
    
    
    
    	<%-- Dropzone.autoDiscover = false;

		Dropzone.options.picup_interior=
		Dropzone.options.picup_exterior=
		{
			paramName: 'file',
			maxFilesize: 5,
			uploadMultiple: true,
			createImageThumbnails: true,
			maxFiles: 1,
			acceptedFiles: '.jpeg,.png,.gif,.jfif,.jpg',
			addRemoveLinks: true,
			autoProcessQueue: false
		}; 


		let dropzone = new Dropzone('#picup_interior', {url: 'hospital_pics_upload.do?pic_type_id=1'});

		let btn = document.querySelector('#btn');
		btn.addEventListener('click',()=>{
			dropzone.processQueue();
		});
		
		 --%>

		 
		 
	</script>
     
</body>
</html>