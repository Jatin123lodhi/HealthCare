const  doctor_id = document.querySelector('.doctor_id');
const  len = doctor_id.id.length;
const doc_id = doctor_id.id.substring(3,len+1);

let upload_div = document.querySelector('#upload_div');
let uploaded_div = document.querySelector('#uploaded_div');
let uploaded_file = document.querySelector('#uploaded_file');
let selc_hospital = document.querySelector('#id_hospital');
let status = document.querySelector('#status');
let apply_btn = document.querySelector('#apply_btn');
let cancel_btn = document.querySelector('#cancel_btn');
//~~~~~~~~~~~ check Application exists or not ~~~~~~~

const checkApplicationExists = async()=>{
	const response = await fetch("checkApplicationExists.do?doctor_id="+doc_id);
	const data = await response.json();
	return data;
};
let file_name = "";
checkApplicationExists()
.then((data)=>{
	//console.log(data[0].doctorLicenseFile,'**&&&');
	//console.log(data[0].hospital.hospitalId,'**&&&'); 
	console.log(data[0]); 
	if(data.length!=0){
		 
		uploaded_div.style.display = 'block';
		upload_div.style.display = 'none';
		file_name = data[0].doctorLicenseFile
		uploaded_file.value = file_name;
		selc_hospital.value = data[0].hospital.hospitalId;
		status.innerHTML = 'Status - '+data[0].applicationStatus.applicationStatus;
		apply_btn.value = 'Applied';
		apply_btn.disabled = true;
	}else{
		cancel_btn.disabled = true;
		console.log(data,'false aya re');
	}
})
.catch((error)=>{
	console.log(error,' ##');
});

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// ~~~~~~~~~~~~~~~ apply btn ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


apply_btn.onclick = ()=>{
	//cancel_btn.disabled = false;
	//apply_btn.disabled = true;
	alert('Applied for the hospital');
	apply_btn.value = 'Applied';
 
}
 
//~~~~~~~~~~~~~~~ Cancel btn ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



const cancelApplication = async ()=>{
	const response = await fetch("cancelApplication.do?doctor_id="+doc_id+"&file_name="+file_name);
	const data = await response.text();
	return data;
};


cancel_btn.onclick = (ev)=>{
	ev.preventDefault();
	cancelApplication()
	.then((data)=>{
		if(data=='true'){
			alert('Application Canceled !');
			uploaded_div.style.display = 'none';
			upload_div.style.display = 'block';
				 
			selc_hospital.value = 0;
			status.innerHTML = '';
			apply_btn.value = 'Apply';
			apply_btn.disabled = false;
			cancel_btn.disabled = true;
		}else{
			 
		}
	})
	.catch((err)=>{
		console.log(err,'-----  err');
	});
};










/* 




let status = document.querySelector('#status');

//bring the file name
const bringApplicationInfo = async()=>{
	const response = await fetch('bringApplicationInfo.do');
	const data = await response.json();
	return data;
};

bringApplicationInfo()
.then((data)=>{
	uploaded_file.value = data[0].doctorLicenseFile;
	uploaded_file.disabled = true;
	selc_hospital.value = data[0].hospitalId;
	 
	console.log(data,'-----data');
	
	upload_div.style.display = 'none';
	apply_btn.value = 'Applied';
	
	
}).catch((error)=>{
	console.log(error,'---- error');
});

status.innerHTML = 'Status: Waiting';

//console.log(file_upload);
//file_upload.value = 'abc.pdf';

 


cancel_btn.onclick = ()=>{
	cancel_btn.disabled = true;
	apply_btn.disabled = false;
	apply_btn.value = 'Apply';
	uploaded_div.style.display = 'none';
	upload_div.style.display = 'block';
	selc_hospital.value = '0';
	status.style.display = 'none';
};*/