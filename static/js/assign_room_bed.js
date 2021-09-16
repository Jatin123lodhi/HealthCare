let input_bed_no = document.querySelector('#id_bed');
let assign_bed = document.querySelector('#assign_bed');
// ~~~~~~~~~~~~~~~~ room select ~~~~~~~~~~~~~~~~~~~~~
 

let room = document.querySelector('#id_room');
let check_btn = document.querySelector('#id_check');

check_btn.onclick = ()=>{
	if(room.value!=0){
		bringRoomAndBedData(room.value);
	}
};

var req1 = null;
function bringRoomAndBedData(room_id){
	req1 = new XMLHttpRequest();	 
	req1.open('post','beds.do?room_id='+room_id,'true');	 
	req1.onreadystatechange = showInDiv;	 
	req1.send();
}


let bed_id;

let bed_box = document.querySelector('#bed_box');
let bed_box_row = document.querySelector('#bed_box_row');
function showInDiv(){
	bed_box_row.innerHTML = ''; 
	input_bed_no.value = '';
	if(req1.readyState==4 && req1.status==200){
		 
		const resp = req1.responseText;
		const respObj = eval(resp);
		console.log(respObj); 
		bed_box.style.display = 'block';
		 
		for(let i=0;i<respObj.length;i++){
			
			let bed_icon_div = document.createElement('div');
			bed_icon_div.classList.add("col-2","text-center");
			//bed_icon_div.id = respObj[i].bedNo;
			
			bed_icon_div.style.cursor = 'pointer';  
			
			let img = document.createElement('i');
			img.classList.add('fa','fa-bed','fa-3x','px-3','pt-3','pb-2');		 
			bed_icon_div.appendChild(img);
			
			let bed_no_div = document.createElement('div');
			bed_no_div.classList.add('text-center');
			bed_no_div.innerHTML = respObj[i].bedNo;
			bed_icon_div.appendChild(bed_no_div);
			
			if(respObj[i].bedStatus.bedStatusId==1){
				 img.style.color = 'green';
				
			}else{
				bed_icon_div.classList.add("occupied");
				img.style.color = 'red'; 
			}
			bed_box_row.appendChild(bed_icon_div);
			
			bed_icon_div.addEventListener('click',()=>{
				
				if(!bed_icon_div.classList.contains('occupied')){
				 	
					input_bed_no.value = respObj[i].bedNo;  
					bed_id = respObj[i].bedId;
					
	 				
				}else{
					console.log(bed_icon_div.classList,'~~~~');
					console.log('bed occupied');
					alert('bed occupied');
				}
				
			});
			
			 
		}
	  
	}
}

assign_bed.onclick = ()=>{
					assignRoomAndBedNo()
					.then((data)=>{
						//alert(typeof data);	
						console.log(data,'$$$');
						alert(data);
						window.location = 'hospital_dashboard.do'; 
				 
					}).catch((error)=>{
						console.log(error);
					});
};

const assignRoomAndBedNo = async()=>{
	response  = await fetch('assign_room_bed.do?bed_id='+bed_id);
	return response.text();
};




















