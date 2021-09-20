const select_field = document.querySelector('#slc_fld');
const search_field = document.querySelector('#srh_field');
const search_btn = document.querySelector('#srch_btn');
const city_id = document.querySelector('#id_city'); 

 

const bringHospitalRecords = async ()=>{
	let response = await fetch('bringHospitalRecords.do?key='+srh_field.value);
	const data =  await response.json();
	return data;
};

const bringDoctorRecords = async (cityId,specialityId)=>{
	//let response = await fetch('bringDoctorRecords.do?key='+search_field.value);
	let response = await fetch('bringDoctorRecords.do?city_id='+cityId+'&speciality_id='+specialityId);
	const data =  await response.json();
	return data;
};
 
/*select_field.onclick = ()=>{
	if(select_field.value==2){
		const doctor_srch_func = document.querySelector('#doctor_srch_func');	
		doctor_srch_func.style.display = 'block';
	}
} */
let speciality_id;
const speciality_divs = document.querySelectorAll(".speciality");
speciality_divs.forEach((speciality_div)=>{
	speciality_div.onclick = myIdFunction; 
});

 
 
function myIdFunction(){  	 
		const div_id = this.id;	 
		speciality_id = div_id.substring(5);
		
		if(city_id.value==0){
			alert('Select City for best results');
		}else{
			 bringDoctorRecord(city_id.value,speciality_id);
		}
}
 


function bringDoctorRecord(cityId,speciality_id){
	 
	bringDoctorRecords(cityId,speciality_id)
			.then((data)=>{
				
				window.scrollTo(0,1500);
			 
				console.log(data,'$$@@@');
				//let main_container = document.querySelector('.rec_container');
				let hospitals =  document.querySelectorAll('.rec_div'); 
				for(var j=0;j<hospitals.length;j++){
					hospitals[j].remove();
				}
				 
				for(var i=0;i<data.length;i++){
					document.querySelector('.result').classList.remove('d-none'); 
					//let main_container = document.querySelector('.box');
					let rec_container= document.querySelector('.rec_container');
					 
					let container_div = document.createElement('div');
					container_div.classList.add('container','pt-4','rec_div');
					//main_container.append(container_div);
					rec_container.append(container_div);
					 
					let row_div = document.createElement('div');
					row_div.classList.add('row','border','border-info','rounded');
					container_div.append(row_div);
					
					
					let col_div_3 = document.createElement('div');
					col_div_3.classList.add('col-3','p-2');
					col_div_3.setAttribute('style','height:250px','border','border-info');
					row_div.append(col_div_3);
					
					let img_tag = document.createElement('img');
					img_tag.setAttribute('src','show_doctor_logo.do?logo='+data[i].logo);
					img_tag.classList.add('w-100','h-100');
					col_div_3.append(img_tag);
					
					 
					
					let col_div_6 = document.createElement('div');
					col_div_6.classList.add('col-6','p-2');
					row_div.append(col_div_6);
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let table = document.createElement('table');
					table.classList.add('table','h-100','font-weight-bold','text-secondary');
				
					col_div_6.append(table);
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					
					let row_1 =  document.createElement('tr');
					table.append(row_1);
					
					let cell_1 = document.createElement('td');
					row_1.append(cell_1);
					cell_1.innerHTML = 'Name -';
					
					let cell_2 = document.createElement('td');
					row_1.append(cell_2);
					cell_2.innerHTML = data[i].name;
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_2 = document.createElement('tr');
					table.append(row_2);
					
					cell_1 = document.createElement('td');
					row_2.append(cell_1);
					cell_1.innerHTML = 'Experience -';
					
					cell_2 = document.createElement('td');
					row_2.append(cell_2);
					cell_2.innerHTML = data[i].experience; 
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_3 = document.createElement('tr');
					table.append(row_3);
					
					cell_1 = document.createElement('td');
					row_3.append(cell_1);
					cell_1.innerHTML = 'Service Time -';
					
					cell_2 = document.createElement('td');
					row_3.append(cell_2);
					cell_2.innerHTML = data[i].serviceTime.serviceTime;
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_4 = document.createElement('tr');
					table.append(row_4);
					
					cell_1 = document.createElement('td');
					row_4.append(cell_1);
					cell_1.innerHTML = 'Specialization -';
					
					cell_2 = document.createElement('td');
					row_4.append(cell_2);
					cell_2.innerHTML =  "Dentist"
					
				    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let col_div_3a = document.createElement('div');
					col_div_3a.classList.add('col-3','p-2','pt-5');
					row_div.append(col_div_3a);
					
					
					
					let btn_div = document.createElement('div');
					btn_div.classList.add('btn','btn-info','mt-5','mr-2');
					btn_div.innerHTML = 'Book Appointment';
					col_div_3a.append(btn_div);
					
					let h6_avalibility = document.createElement('h6');
					col_div_3a.append(h6_avalibility);
					h6_avalibility.classList.add('text-secondary','mt-2');
					h6_avalibility.innerHTML = 'Avaibale Tommorow';
				}
				
			
			 
				
				
			})
			.catch((err)=>{
				console.log(err, ' ----#');
			});
}

 
search_btn.onclick = (event)=>{
	event.preventDefault();
	if(select_field.value==0){
		alert("first select the category");
	}else{
		let key = search_field.value;
		if(select_field.value==1){
			bringHospitalRecords()
			.then((data)=>{
				document.querySelector('.result').classList.remove('d-none'); 
				let hospitals =  document.querySelectorAll('.rec_div'); 
				for(var j=0;j<hospitals.length;j++){
					hospitals[j].remove();
				}
				 
				for(var i=0;i<data.length;i++){
					window.scrollTo(0, 700); 
					//let main_container = document.querySelector('.box');
					let rec_container= document.querySelector('.rec_container');
					 
					
					let container_div = document.createElement('div');
					container_div.classList.add('container','pt-4','rec_div');
					//main_container.append(container_div);
					rec_container.append(container_div);
					 
					
			  
					 
				 
				
					let row_div = document.createElement('div');
					row_div.classList.add('row','border','border-info','rounded');
					container_div.append(row_div);
					
					
					let col_div_3 = document.createElement('div');
					col_div_3.classList.add('col-3','p-2');
					col_div_3.setAttribute('style','height:250px');
					row_div.append(col_div_3);
					
					let img_tag = document.createElement('img');
					img_tag.setAttribute('src','show_hospital_logo.do?logo='+data[i].logo);
					img_tag.classList.add('w-100','h-100');
					col_div_3.append(img_tag);
					
					
					let col_div_9 = document.createElement('div');
					col_div_9.classList.add('col-9','p-2','pl-3');
					row_div.append(col_div_9);
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let table = document.createElement('table');
					table.classList.add('table','h-100','text-secondary','font-weight-bold');
				
					col_div_9.append(table);
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					
					let row_1 =  document.createElement('tr');
					table.append(row_1);
					
					let cell_1 = document.createElement('td');
					row_1.append(cell_1);
					cell_1.innerHTML = 'Name';
					
					let cell_2 = document.createElement('td');
					row_1.append(cell_2);
					cell_2.innerHTML = data[i].name;
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_2 = document.createElement('tr');
					table.append(row_2);
					
					cell_1 = document.createElement('td');
					row_2.append(cell_1);
					cell_1.innerHTML = 'Email';
					
					cell_2 = document.createElement('td');
					row_2.append(cell_2);
					cell_2.innerHTML = data[i].email; 
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_3 = document.createElement('tr');
					table.append(row_3);
					
					cell_1 = document.createElement('td');
					row_3.append(cell_1);
					cell_1.innerHTML = 'Contact No-';
					
					cell_2 = document.createElement('td');
					row_3.append(cell_2);
					cell_2.innerHTML = data[i].contactNo;
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					let row_4 = document.createElement('tr');
					table.append(row_4);
					
					cell_1 = document.createElement('td');
					row_4.append(cell_1);
					cell_1.innerHTML = 'City';
					
					cell_2 = document.createElement('td');
					row_4.append(cell_2);
					cell_2.innerHTML =  data[i].city.city;
				}
				
			
			 
				console.log(data,' ----');
			})
			.catch((err)=>{
				console.log(err, ' ----#');
			}); 
		}else if(select_field.value==2){
			bringDoctorRecord(); 
			
		}
	}
	
	
};