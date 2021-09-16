//by name we are searching  the patiens 
const srh_field = document.querySelector("#id_srh");
const search_btn = document.querySelector("#search_btn");
const form_box = document.querySelector('.form-box');
const form = document.querySelector('.profile_form');
const test_report_btn = document.querySelector('#test_report_btn');
const scans_btn = document.querySelector('#scans_btn');
const bill_btn = document.querySelector('#bill_btn');
const patient_profile_btn = document.querySelector('#patient_profile_btn');
const patient_profile_div = document.querySelector('#patient_profile_div');
const heading = document.querySelector('#heading');
const btns = document.querySelectorAll('.btn1');
const new_record_btn = document.querySelector('#new_record_btn');
const patient_reports_div = document.querySelector('#patient_reports_div');
let patient_id;
let admissionId;
patient_reports_div.style.display = 'none';


//~~~~~~~~~~~~~~~ bringTestRecords ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const bringTestRecords = async ()=>{
	
	let response = await fetch("bring_test_records.do?admission_id="+admissionId);
	let data = await response.json();
	return data;
};



//~~~~~~~~~~~~~~~ btns fuctions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
let flag = 0;
btns.forEach((btn)=>{
	
	btn.onclick = (ev)=>{
		
		patient_reports_div.style.display = 'none';
		patient_profile_div.style.display = 'none'; 
 
		const target_div = document.querySelector('#'+ev.target.id.substring(4)+'_div','*&&&');
		target_div.style.display = 'block';
		heading.innerHTML = ev.target.innerHTML;
	 
		if(target_div.id=='patient_reports_div'){
			
			if(flag==0){
				flag = 1;
				bringTestRecords().then((data)=>{
				 
					for(let j=0;j<data.length;j++){
	 
						plus_btn.click();
						 
				
						document.querySelector("#date_"+(j+1)).value = assignDate(data[j].date);
						document.querySelector("#select_tag_"+(j+1)).remove();	
						document.querySelector("#id_file_input_"+(j+1)).remove();
						document.querySelector("#id_upload_"+(j+1)).remove();
											
						//console.log(document.querySelector('#id_col2_'+(i+1)));
						let col_2 = document.querySelector('#id_col2_'+(j+1));
						col_2.innerHTML =  data[j].testType.testType;
						col_2.classList.add('text-center');
						
						//console.log(document.querySelector('#id_col3_'+(i+1)));
						let col_3 = document.querySelector('#id_col3_'+(j+1));
						 
					 	const file_nm = data[j].fileName.substring(form.email.value.length+1);
						col_3.classList.add('text-center'); 
						col_3.innerHTML =  file_nm;
						col_3.setAttribute('style','word-wrap:break-word');
						
						let anchor_tag = document.querySelector('#id_anchor_'+(j+1));
						//console.log(anchor_tag,'** ancchor');
						anchor_tag.href = 'downloadFile.do?file_name='+data[j].fileName;
					  
					}
				 
			})
			.catch((error)=>{
				console.log(error,'%%');
				
			});
			}
	 		  	
		}
	}
});	
 
//  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Test Reports ~~~~~~~~~~~~~~~~~~~~~~~~~
 
const test_report_container = document.createElement("div");
test_report_container.classList.add('container', 'px-4', 'pt-4', 'pb-5', 'mt-4' ,'border', 'border-primary', 'table', 'table-dark');
patient_reports_div.appendChild(test_report_container);
 

const test_report_thead = document.createElement('div');
test_report_thead.classList.add('row', 'text-center');

test_report_container.appendChild(test_report_thead);

const head1 = document.createElement('div');
head1.classList.add('col-3','p-3','border','border-info');
head1.innerHTML = 'Date';

const head2 = document.createElement('div');
head2.classList.add('col-3','p-3','border','border-info');
head2.innerHTML = 'Type';

const head3 = document.createElement('div');
head3.classList.add('col-4','p-3','border','border-info');
head3.innerHTML = 'File Name';

const head4 = document.createElement('div');
head4.classList.add('col-2','p-3','border','border-info');
head4.innerHTML = '';

test_report_thead.appendChild(head1);
test_report_thead.appendChild(head2);
test_report_thead.appendChild(head3);
test_report_thead.appendChild(head4);

const add_btn_div = document.createElement('div');
add_btn_div.classList.add('mb-4','mt-4'); 
const plus_btn = document.createElement('i');
plus_btn.classList.add('fa','fa-plus-square','fa-2x','float-right');
add_btn_div.appendChild(plus_btn); 
patient_reports_div.appendChild(add_btn_div);

 
let i=0;
plus_btn.onclick = ()=>{
	
	let record_row = document.createElement('div');
	record_row.classList.add('row','record_row','id_'+(++i));
	test_report_container.appendChild(record_row);
	 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	let col1 = document.createElement('div');	
	col1.classList.add('col-3','p-3','border','border-info');
	record_row.appendChild(col1);
	
	
	let date_input = document.createElement('input');
	date_input.setAttribute('type','date');
	date_input.classList.add('form-control');
	date_input.setAttribute('id','date_'+i);
	col1.appendChild(date_input);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 	
	let col2 = document.createElement('div');	
	col2.classList.add('col-3','p-3','border','border-info');
	col2.setAttribute('id','id_col2_'+i);
	record_row.appendChild(col2);	
	
	let col3 = document.createElement('div');	
	col3.classList.add('col-4','p-3','border','border-info','text-wrap');
	col3.setAttribute('id','id_col3_'+i);
	 
	record_row.appendChild(col3);
	
	let col4 = document.createElement('div');	
	col4.classList.add('col-2','p-3','border','border-info');
	record_row.appendChild(col4);
	//~~~~~~~~~~~~~~~~~~~~~ select tag for test types ~~~~~~~~~
	
	let select_tag = document.createElement('select');
	select_tag.classList.add('form-control');
	let option_tag = document.createElement('option');
	option_tag.innerHTML = 'Select test type';
	option_tag.setAttribute('value','0');
	select_tag.appendChild(option_tag);
	select_tag.setAttribute('id','select_tag_'+i);
	col2.appendChild(select_tag);	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ test types records~~~~~~~~~~~~~~~~~~~~~~~~~~
	const test_types_records = async ()=>{
		let response = await fetch('collectTestTypesRecords.do');
		const data = await response.json();
		return data;
	};
	
	test_types_records().then((data)=>{
		
		for(let j=1;j<=data.length;j++){
			 
			var option_tag1 = document.createElement('option');
			option_tag1.innerHTML =  data[j-1];
			option_tag1.setAttribute('value',''+j);
			select_tag.appendChild(option_tag1);
			 
		}		 
		
	}).catch((err)=>{
		console.log(err,'###');
	}); 

	
	let text_input1 = document.createElement('input');
	text_input1.setAttribute('type','file');
	text_input1.setAttribute('id','id_file_input_'+i);
	text_input1.setAttribute('class','form-control-file');
	text_input1.setAttribute('placeholder','File Name');
	text_input1.classList.add('form-control');
	//upload_form.appendChild(text_input1);
	col3.appendChild(text_input1);
	
	let upload_btn = document.createElement('button');
	upload_btn.setAttribute('id','id_upload_'+i);
	upload_btn.classList.add('btn','btn-info','mt-3');
	upload_btn.innerHTML = 'Upload';
	//upload_form.appendChild(upload_btn);
	col3.appendChild(upload_btn);
 	
	 
		
	// ~~~~~~~~  form submission ~~~~~~~~~~~~~
	upload_btn.onclick = (ev)=>{
		const btn_id = ev.target.id.substring(10);
		const fileInput = document.querySelector('#id_file_input_'+btn_id);
		
		const formData = new FormData();
		
		formData.append('file', fileInput.files[0]);
		
		const options = {
		  method: 'POST',
		  body: formData,
		   
		};
		
		let upload_btn_id = ev.target.id;
		let date_btn_id = 'date_'+upload_btn_id.substring(10); 
		let date_field = document.querySelector('#'+date_btn_id);
		//console.log(date_field.value,'**');
		
		let select_tag_id = 'select_tag_'+upload_btn_id.substring(10);
		let select_tag_field = document.querySelector('#'+select_tag_id);
		let selected_value = select_tag_field.value;
		//console.log(select_tag_field.value,"%%");
		
	  
		
	 
		fetch('test_report_upload.do?admission_id='+admissionId+'&email='+form.email.value+'&test_type_id='+select_tag_field.value+'&date='+date_field.value, options);
		 
		alert('File uploaded');
		
		
		col2.innerHTML = select_tag_field.options[selected_value].innerHTML;
		col2.classList.add('text-center');
		select_tag_field.remove();
		
		
		
		
		
		
		/*let anchor_tag = document.querySelector('#id_anchor_'+(i+1));
		console.log(anchor_tag,'** ancchor');
		anchor_tag.href = 'downloadFile.do?file_name='+data[i].fileName;*/
		
		 
	};
	 
	let upload = document.createElement('i');
	let remove = document.createElement('i');
	
	upload.classList.add('fa','fa-upload','fa-lg','mr-3','ml-4');
	upload.setAttribute('style','cursor:pointer');
	
	remove.classList.add('fa','fa-trash','fa-lg','mr-3','ml-3','id_'+(i));
	remove.setAttribute('style','cursor:pointer');
	
	
	 
	col4.appendChild(remove);
	
	let anchor = document.createElement('A');
	anchor.setAttribute('id','id_anchor_'+i);
	col4.append(anchor);
	
	
	let download = document.createElement('i');
	download.classList.add('fa','fa-download','fa-lg','ml-3');
	download.setAttribute('style','cursor:pointer');
	anchor.appendChild(download);
	
	remove.onclick = (ev)=>{
		let del_row = document.querySelector('.'+ev.target.classList[5]);
		del_row.remove();
	};
	
}; 
  
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const collectPatientRecords = async ()=>{
	let response = await fetch('collectPatientRecords.do?key='+srh_field.value);
	const data =  await response.json();
	return data;
};


const address = document.querySelector('#id_address'); 
search_btn.addEventListener('click',()=>{
	collectPatientRecords().then((data)=>{
		
		let table = document.querySelector('.table');
		table.innerHTML = '';
		let header = table.createTHead();
		let row = header.insertRow(0);
		
		row.insertCell(0).innerHTML = 'S No';	 
		row.insertCell(1).innerHTML = 'Name';
		row.insertCell(2).innerHTML = 'Email';
		row.insertCell(3).innerHTML = 'Address';
		row.insertCell(4).innerHTML = 'Bed No';
		
		for(let i=0;i<data.length;i++){
			var row1 = header.insertRow(i+1);
 			row1.onclick = ()=>{
				form_box.style.display='block';				
				form.name.value = data[i].name;
				form.patient_id.value = data[i].patientId;
				form.weight.value = data[i].weight;
				form.height.value = data[i].height;				  
				form.dob.value = assignDate(data[i].dob);
				form.blood_group.value = data[i].bloodGroup;
				form.contact.value = data[i].contactNo;				 
				form.email.value = data[i].email;
				form.gender.value = data[i].gender;
				form.city.value = data[i].city.cityId;		 
				address.innerHTML = data[i].address;
				form.bed_No.value = data[i].bed.bedNo;
				form.room_no.value = data[i].bed.room.roomNo;
				
				//~~~~~~~~~~ admission_id ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
				patient_id = form.patient_id.value;
				
				const bringAdmissionId = async ()=>{
					let response = await fetch('bring_admission_details.do?patient_id='+patient_id);
					//let data = await response.responseText;
					let data = await response.text();
					return data;  
				};
				
				
				bringAdmissionId().then((data)=>{
					admissionId = data;  
					 	
				})
				.catch((err)=>{
					console.log(err,'^^');
				});
								
								  
			};
			row1.style.cursor = 'pointer';
			hoverFunc(row1);
			row1.insertCell(0).innerHTML = i+1;
			row1.insertCell(1).innerHTML = data[i].name;
			row1.insertCell(2).innerHTML = data[i].email;
			row1.insertCell(3).innerHTML = data[i].address;
			row1.insertCell(4).innerHTML = data[i].bed.bedNo;
			 
		}

		
		 
		console.log(data);
	 
		 
	}).catch((error)=>{
		console.log(error);
		
	});
	
});

 
const cross = document.querySelector('.fa-times');
cross.onclick = ()=>{
	form_box.style.display='none';
};

function hoverFunc(ele){
	ele.onmouseover = ()=>{
		ele.style.color='yellow';
	};
	ele.onmouseout = ()=>{
		ele.style.color='white';
	};
}


const update = document.querySelector('#id_update');
const updateRecords = async ()=>{
	console.log(form.city.value,' ^^^^^^^^^^');
	
	let response = await fetch(`update_patient_record.do?name=${form.name.value}&email=${form.email.value}&height=${form.height.value}&weight=${form.weight.value}&address=${address.value}&contact=${form.contact.value}&bloodGroup=${form.blood_group.value}&gender=${form.gender.value}&city_id=${form.city.value}`);	 
	
	return response.text();
};
 
update.onclick = ()=>{
	updateRecords().then((data)=>{
		console.log(data);
		alert(data);
	}).catch((error)=>{
		console.log(error);
	});
};

function assignDate(stringDate){
	//console.log(stringDate,' stringDate');
	const d = new Date(stringDate);
	let y = d.getFullYear();
	let m = d.getMonth();
	let day = d.getDate();
	if(m<10){
		m = m + 1;
		m = '0'+m;
	}
	if(day<10){
		day = '0'+day;
	}
	return y+'-'+m+'-'+day;
	
}




 

 
		
 

 
 