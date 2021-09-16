const patient_reports_div = document.querySelector('#patient_reports_div');
const btns = document.querySelectorAll('.btn1');
let admissionId;
const patient_id_span = document.querySelector('#patient_id');
let patient_id = patient_id_span.innerHTML; 

//~~~~~~~~~~~~~ bring Admission Id ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
const bringAdmissionId = async ()=>{
	let response = await fetch('bring_admission_details.do?patient_id='+patient_id);
	//let data = await response.responseText;
	let data = await response.text();
	return data;  
};
  
bringAdmissionId().then((data)=>{
	admissionId = data; 
	
	bringTestRecords().then((data)=>{
				
				for(let i=0;i<data.length;i++){
					plus_btn.click();
					//console.log(data ,data[i].testType.testType, data[i].date, data[i].fileName,' ~~~~~~');
				  		
					let col_1 = document.querySelector('#id_col1_'+(i+1));
					col_1.innerHTML =  data[i].date;
					col_1.classList.add('text-center');
 
					let col_2 = document.querySelector('#id_col2_'+(i+1));
					col_2.innerHTML =  data[i].testType.testType;
					col_2.classList.add('text-center');
					 
					let col_3 = document.querySelector('#id_col3_'+(i+1));
					col_3.innerHTML =  data[i].fileName;
					col_3.classList.add('text-center');
					
					let anchor_tag = document.querySelector('#id_anchor_'+(i+1));
					console.log(anchor_tag,'** ancchor');
					anchor_tag.href = 'downloadFile.do?file_name='+data[i].fileName;
					 
			 
				}
		 	
			})
			.catch((error)=>{
				console.log(error,'%%');
				
			});
	
  	
})
.catch((err)=>{
	console.log(err,'^^');
});


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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



let i=0;
plus_btn.onclick = ()=>{
	
	let record_row = document.createElement('div');
	record_row.classList.add('row','id_'+(++i));
	test_report_container.appendChild(record_row);
	 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	let col1 = document.createElement('div');	
	col1.classList.add('col-3','p-3','border','border-info');
	col1.setAttribute('id','id_col1_'+i);
	record_row.appendChild(col1);
	
	
	 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 	
	let col2 = document.createElement('div');	
	col2.classList.add('col-3','p-3','border','border-info');
	col2.setAttribute('id','id_col2_'+i);
	record_row.appendChild(col2);	
	
	let col3 = document.createElement('div');	
	col3.classList.add('col-4','p-3','border','border-info');
	col3.setAttribute('id','id_col3_'+i);
	record_row.appendChild(col3);
	
	let col4 = document.createElement('div');	
	col4.classList.add('col-2','p-3','border','border-info');
	record_row.appendChild(col4);
	
	let anchor = document.createElement('A');
	anchor.setAttribute('id','id_anchor_'+i);
	col4.append(anchor);
	
	let download = document.createElement('i');
	download.classList.add('fa','fa-download','fa-lg','ml-5');
	download.setAttribute('style','cursor:pointer');
	download.setAttribute('id','id_download_'+i);
	anchor.appendChild(download);
   
		 
};
	
	


//~~~~~~~~~~~~~~~ bringTestRecords ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const bringTestRecords = async ()=>{
	
	let response = await fetch("bring_test_records.do?admission_id="+admissionId);
	let data = await response.json();
	return data;
};

	






btns.forEach((btn)=>{
	
	btn.onclick = (ev)=>{
	
		 
		 
		
		
		
		//console.log(ev.target.id.substring(4)+'_div','##########$$');
		const target_div = document.querySelector('#'+ev.target.id.substring(4)+'_div','*&&&');
		//console.log(target_div);
		target_div.style.display = 'block';
		 
		
		if(target_div.id=='patient_reports_div'){
			
			bringTestRecords().then((data)=>{
				
				for(let i=0;i<data.length;i++){
					plus_btn.click();
					console.log(data ,data[i].testType.testType, data[i].date, data[i].fileName,' ~~~~~~');
				 
					document.querySelector("#date_"+(i+1)).value = assignDate(data[i].date);
					
					let col_1 = document.querySelector('#id_col1_'+(i+1));
					col_1.innerHTML =  data[i].date;
					col_1.classList.add('text-center');
 
					let col_2 = document.querySelector('#id_col2_'+(i+1));
					col_2.innerHTML =  data[i].testType.testType;
					col_2.classList.add('text-center');
					 
					let col_3 = document.querySelector('#id_col3_'+(i+1));
					col_3.innerHTML =  data[i].fileName;
					col_3.classList.add('text-center');
			 
				}
		 	
			})
			.catch((error)=>{
				console.log(error,'%%');
				
			});
			
		 
			  	
		}
	}
});	

	