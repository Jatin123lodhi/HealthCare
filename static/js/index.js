const select_field = document.querySelector('#slc_fld');
const search_field = document.querySelector('#srh_field');
const search_btn = document.querySelector('#srch_btn');
const city_id = document.querySelector('#id_city'); 
const form_box = document.querySelector('.form-box');
 

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
let speciality;
const speciality_divs = document.querySelectorAll(".speciality");
speciality_divs.forEach((speciality_div)=>{
	speciality_div.onclick = getSpecialityId; 
});


 
 
function getSpecialityId(){  	 
		const div_id = this.id;	 
		speciality_id = div_id.substring(5);
		speciality = this.childNodes[3].innerHTML;
		 
		if(city_id.value==0){
			alert('Select City for best results');
		}else{
			 bringDoctorRecord(city_id.value,speciality_id);
		}
}
 
let bringAvailableSlots = async (doctorId)=>{
	let response = await fetch('bringAvailableSlots.do?doctor_id='+doctorId);
	let data = await response.json();
	//console.log(data,'-----data');
	return data;
};


function bringDoctorRecord(cityId,speciality_id){
	// so as the city and speciality is selected this function will send request and bring records -  
	bringDoctorRecords(cityId,speciality_id)
			.then((data)=>{     
				
				
				 
				console.log(data,'------');
				
				//~~~~~~~~~ this is to remove all the previous searched records  ~~~~~~~~~~~~~~~~~~
				let info_div =  document.querySelectorAll('.rec_div'); 
				for(var j=0;j<info_div.length;j++){
					info_div[j].remove();
				}
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				
				
				//~~~~~~~~ this is to show heading for what speciality is searched ~~~~~~~~~~~~~~~~~~~~~~~~~~~
				document.querySelector('.result').classList.remove('d-none');
				document.querySelector('#spec_span').innerHTML=speciality; 
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				
				
				//~~~~~ for each data we have to show it in div with three parts , img,data, appointmnt btn
				
				for(var i=0;i<data.length;i++){
					 
					//console.log(data); 
					let rec_container= document.querySelector('.rec_container'); // the main container created in index.jsp page
					
					
					//~~~~~~~~~~~ now creating a container div which will have three parts ~~~~~~~~~~~~~~~~~~~~~~ 
					let container_div = document.createElement('div');
					container_div.classList.add('container','pb-2','mb-3','rec_div','border','border-info','rounded');
					rec_container.append(container_div);
					
					
					//~~~~~~~~~~ creating row_div inside the container div ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
					let row_div = document.createElement('div');
					row_div.classList.add('row');
					container_div.append(row_div);
					 
					//~~~~~~~ col-3 div for the image inside  row_div ~~~~~~~~~~~~~~~~~~~~~~~~~
					
					let col_div_3 = document.createElement('div');
					col_div_3.classList.add('col-3','p-2');
					col_div_3.setAttribute('style','height:250px','border','border-info');
					row_div.append(col_div_3);
					
					let img_tag = document.createElement('img');
					img_tag.setAttribute('src','show_doctor_logo.do?logo='+data[i].logo);
					img_tag.classList.add('w-100','h-100');
					col_div_3.append(img_tag);
					
					//~~~~~~~ col-6 div for the doctor_data inside  row_div ~~~~~~~~~~~~~~~~~~~~~~~~~
					
					let col_div_6 = document.createElement('div');
					col_div_6.classList.add('col-6','p-2','pl-4');
					row_div.append(col_div_6);
					
					//~~~~~~ table for info ~~~~~~~~~~
					let table = document.createElement('table');
					table.classList.add('table','h-100','font-weight-bold','text-secondary');
					col_div_6.append(table);
					  
					//~~~~~~~ creating first row with two cells ~~~~~~~~~~~
					let row_1 =  document.createElement('tr');
					table.append(row_1);
					
					let cell_1 = document.createElement('td');
					row_1.append(cell_1);
					cell_1.innerHTML = 'Name -';
					
					let cell_2 = document.createElement('td');
					row_1.append(cell_2);
					cell_2.innerHTML = data[i].name;
					
					//~~~~~~ creating second row with two cells~~~~~~~~~~~ 
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
					cell_2.innerHTML =  speciality;
					
				    //~~~~~~creating 3rd col in first data row  for appointment btn~~~~~~~~~~~~~~~~~~~~~~~~~
					let col_div_3a = document.createElement('div');
					col_div_3a.classList.add('col-3','pl-4','p-2','pt-5');
					row_div.append(col_div_3a);
					
					let btn_div = document.createElement('div');
					btn_div.classList.add('btn','btn-info','mt-5','mr-2','btn_func');
					btn_div.setAttribute('id',data[i].doctorId);
					btn_div.innerHTML = 'Book Appointment';
					col_div_3a.append(btn_div);
					
					//~~~~~ we have to program appointment btn click ~~~~~~~~~~~~~
					btn_div.onclick = ()=>{
						
						
						//~~~~~~~~~~creating row for morning  ~~~~~~~~~~~~~~~~~~~~~~
						let row_div1 = document.createElement('div');
						row_div1.classList.add('row','mb-1');
						container_div.append(row_div1);
						
						//~~~~~~~ creating a col-3 for the morning row~~~~~~~~~~~~~~~~~~~
						let col_div_3_M_slot = document.createElement('div');
						col_div_3_M_slot.classList.add('col-3','p-2','pt-3','border','border-light');
						col_div_3_M_slot.setAttribute('style','min-height:100px');
						row_div1.append(col_div_3_M_slot);
						
						//~~~~~~adding image tag ~~~~~~~~~~~~~~~~~~~~~~~~~
						let morning_img_tag = document.createElement('img');
						morning_img_tag.setAttribute('src','static/images/morning.png');
						morning_img_tag.classList.add('ml-5');
						morning_img_tag.style.height = '20px';
						col_div_3_M_slot.append(morning_img_tag);
						
						let span_morning = document.createElement('span');
						span_morning.classList.add('ml-3');
						span_morning.innerHTML = 'Morning';
						col_div_3_M_slot.append(span_morning);
						
						//~~~~~~~~~~ creating a col-9 for the morning row ~~~~~~~~~~~~~~~~
						let col_div_9_slot = document.createElement('div');
						col_div_9_slot.classList.add('col-9','p-2','pt-3','border','border-light');
						col_div_9_slot.setAttribute('style','min-height:100px');
						row_div1.append(col_div_9_slot);
						
						//~~~~~~~~~~creating row for afternoon ~~~~~~~~~~~~~~~~~~~~~
						let row_div2 = document.createElement('div');
						row_div2.classList.add('row','mb-1');
						container_div.append(row_div2);
						
						//~~~~~~~~~creating a col-3 for the afternoon row ~~~~~~~~~~~~
						let col_div_3_A_slot = document.createElement('div');
						col_div_3_A_slot.classList.add('col-3','p-2','pt-3','border','border-light');
						col_div_3_A_slot.setAttribute('style','min-height:100px');
						row_div2.append(col_div_3_A_slot);
						
						let noon_i_tag = document.createElement('i');
						noon_i_tag.classList.add('ml-5','fa','fa-sun-o');
						col_div_3_A_slot.append(noon_i_tag);
						
						let span_noon = document.createElement('span');
						span_noon.classList.add('ml-3');
						span_noon.innerHTML = 'Afternoon';
						col_div_3_A_slot.append(span_noon);
						
						//~~~~~~~~ creating a col-9 for the afternoon row ~~~~~~~~~~~~~
						let col_div_9_A_slot = document.createElement('div');
						col_div_9_A_slot.classList.add('col-9','p-2','pt-3','border','border-light');
						col_div_9_A_slot.setAttribute('style','min-height:100px');
						row_div2.append(col_div_9_A_slot);
						
						
						
						//~~~~~~~~~~creating row for evening ~~~~~~~~~~~~~~~~~~~~~
						let row_div3 = document.createElement('div');
						row_div3.classList.add('row','mb-1');
						container_div.append(row_div3);
						
						//~~~~~~~~~creating a col-3 for the evening row ~~~~~~~~~~~~
						let col_div_3_E_slot = document.createElement('div');
						col_div_3_E_slot.classList.add('col-3','p-2','pt-3','border','border-light');
						col_div_3_E_slot.setAttribute('style','min-height:100px');
						row_div3.append(col_div_3_E_slot);
						
						let eve_img_tag = document.createElement('img');
						eve_img_tag.setAttribute('src','static/images/sunset.png');
						eve_img_tag.classList.add('ml-5');
						eve_img_tag.style.height = '20px';
						col_div_3_E_slot.append(eve_img_tag);
						
						let span_eve = document.createElement('span');
						span_eve.classList.add('ml-3');
						span_eve.innerHTML = 'Evening';
						col_div_3_E_slot.append(span_eve);
						
						//~~~~~~~~ creating a col-9 for the evening row ~~~~~~~~~~~~~
						let col_div_9_E_slot = document.createElement('div');
						col_div_9_E_slot.classList.add('col-9','p-2','pt-3','border','border-light');
						col_div_9_E_slot.setAttribute('style','min-height:100px');
						row_div3.append(col_div_9_E_slot);
						
						 
						
						bringAvailableSlots(btn_div.id)
						.then((data)=>{
							
							for(var i=0;i<data.length;i++){
								let f2p = data[i].doctorTimeSlot.time.substring(0,2); 
								let l2p = data[i].doctorTimeSlot.time.substring(9);
								
								let slot_btn = document.createElement('button');
								slot_btn.classList.add('btn','btn-outline-info','mx-2','my-2');
								slot_btn.setAttribute('id',''+data[i].doctorTimeSlot.doctorTimeSlotId);
								let btntime = data[i].doctorTimeSlot.time.substring(0,5)+ data[i].doctorTimeSlot.time.substring(8);
								slot_btn.innerHTML = btntime;
								if(f2p<'12' && l2p=='AM'){
									col_div_9_slot.append(slot_btn);
								}else if((f2p=='12'|| f2p<'04') && l2p=='PM'){
									col_div_9_A_slot.append(slot_btn);
								}else{
									col_div_9_E_slot.append(slot_btn);
								}
								
								
								
								
							}
						})
						.catch((err)=>{
							console.log(err);
						});
						
						// ~~~~~~~ btns inside col-9 in morining row ~~~~~~~~~~~~~~~~~~~~~~
						
					
					};
					
					let h6_avalibility = document.createElement('h6');
					col_div_3a.append(h6_avalibility);
					h6_avalibility.classList.add('text-secondary','mt-2');
					h6_avalibility.innerHTML = 'Avaibale Tommorow';
					
					/*
					
					
					 
					
					
					
					let btn_noon1 = document.createElement('button');
					btn_noon1.classList.add('btn','btn-outline-info','mx-2');
					btn_noon1.innerHTML = '12:00 PM';
					col_div_9_A_slot.append(btn_noon1);
					
					*/
					
				
				} //~~~~~~~~ ending of for loop for each data ~~~~~~~~~~~~~~~~~~~
				window.scrollTo(0,1500);
			})//~~~~~~~~~~~ ending of then block~~~~~~~~~~~~~~~~~~~~~~~~~~
			.catch((err)=>{
				console.log(err, ' ----#');
			});
} //~~~~~~~ ending of bring doctor records func ~~~~~~~~~~~~~~~~~~~~~~~~~~~



//~~~~~~~~~~ programming of search btn ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
search_btn.onclick = (event)=>{
	event.preventDefault();
	if(select_field.value==0){
		alert("first select the category");
	}else{
		let key = search_field.value;
		if(select_field.value==1){ //~~~~~~ so if we have selected type = hospital then ~~~~~~~~~~~~~
			
			bringHospitalRecords()
			.then((data)=>{
				//~~~~ to show the results heading for searched records ~~~~~~~~~~~~
				document.querySelector('.result').classList.remove('d-none'); 
				
				//~~~~~ to remove all prev searched records ~~~~~~~
				let hospitals =  document.querySelectorAll('.rec_div'); 
				for(var j=0;j<hospitals.length;j++){
					hospitals[j].remove();
				}
				
				
				//~~~~~~ to show data ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
				for(var i=0;i<data.length;i++){
					window.scrollTo(0, 700); 
					//~~~~~ getting the rec_container inside which all the containers with data will be present ~~~~~~~ 
					let rec_container= document.querySelector('.rec_container');
					
					 
					//~~~~ creating the records container inside which we have two cols, one for img and , and second for data ~~~~
					let container_div = document.createElement('div');
					container_div.classList.add('container','pt-4','rec_div');
					rec_container.append(container_div);
					 
				
					// creating a row in side the container div 
					let row_div = document.createElement('div');
					row_div.classList.add('row','border','border-info','rounded');
					container_div.append(row_div);
					
					// creating col-3 div for img 
					let col_div_3 = document.createElement('div');
					col_div_3.classList.add('col-3','p-2');
					col_div_3.setAttribute('style','height:250px');
					row_div.append(col_div_3);
					
					let img_tag = document.createElement('img');
					img_tag.setAttribute('src','show_hospital_logo.do?logo='+data[i].logo);
					img_tag.classList.add('w-100','h-100');
					col_div_3.append(img_tag);
					
					// creating col-9 div for data
					let col_div_9 = document.createElement('div');
					col_div_9.classList.add('col-9','p-2','pl-3');
					row_div.append(col_div_9);
					
					//~~ creating table for info ~~~~~~~~~~~
					let table = document.createElement('table');
					table.classList.add('table','h-100','text-secondary','font-weight-bold');
					col_div_9.append(table);
					
					
				 
					//~~~~ creating first row with two cells ~~~~~
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
				} // ending of for loop for each data
				 
				console.log(data,' ----');
			}) // ~~~~~~ ending of then block ~~~~~~~~~~~~~~~~~
			.catch((err)=>{
				console.log(err, ' ----#');
			}); 
		}else if(select_field.value==2){  // ~~~~~~~~~ if we have selected type = doctor
			bringDoctorRecord(); 
		}
	} // ~~~~ else block closing ~~~~~~~	
};