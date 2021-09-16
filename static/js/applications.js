const show_btns = document.querySelectorAll('.show_btn');
const form_box = document.querySelector('.form-box');
 
let hosp_span = document.querySelector('.hospital_id');
let lengthId = hosp_span.id.length;
let hospitalId = hosp_span.id.substring(3,lengthId+1);  
console.log(hospitalId,' hospid'); 

//~~~~~~~~~~~~~~~~~~~~~~~ cross and show btn ~~~~~~~~~~~~~~~~~~~~

 
const form = document.querySelector('#profile_form');
show_btns.forEach((show_btn)=>{
	const doctor_id = show_btn.id.substring(8,show_btn.id.length+1);
	console.log(doctor_id,' --doctorId'); 
	show_btn.onclick = ()=>{
		form_box.style.display = 'block';
		bringDoctorProfile(doctor_id)
		.then((data)=>{
			console.log(data);
			form.name.value = data.name;
			form.doctor_id.value = data.doctorId;
			form.contact.value = data.contactNo;
			form.email.value = data.email;
			form.gender.value = data.gender;
			form.address.value = data.address;
			form.city = data.city.cityId;
			form.specialization.value = data.specialization;
			form.experience.value = data.experience;
			form.service_time.value = data.serviceTime.serviceTime;
			  
		})
		.catch((err)=>{
			console.log(err,' ----err');
		}); 
	
	}; 
});


//~~~~~~~~~~~~~~~~~~~~~~ accept and reject ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const accept_btns = document.querySelectorAll('.accept_btn');
const reject_btns = document.querySelectorAll('.reject_btn');

const changeApplicationStatus = async (applicationId,applicationStatusId,docId)=>{
	const response = await fetch('changeApplicationStatus.do?application_id='+applicationId+'&application_status_id='+applicationStatusId+'&doctor_id='+docId+'&hospital_id='+hospitalId);
	const data = await response.text();
	return data;
};

accept_btns.forEach((accept_btn)=>{
	accept_btn.onclick = ()=>{
	 
		const application_id = accept_btn.id.substring(7,accept_btn.id.length+1);
		const doc_span = document.querySelector('.appId_'+application_id);
		const doc_id = doc_span.id.substring(3,doc_span.id.length+1);
		console.log(application_id,'  !!!!');
		changeApplicationStatus(application_id,2,doc_id)
		.then((data)=>{
			alert(data+' --> accepted');
			const row = document.querySelector('#id_'+application_id);
			row.remove();
			
			const cells = document.querySelectorAll('.s_no');
			let i =1;
			cells.forEach((cell)=>{
				cell.innerHTML = i++; 
			});
			
			
		}).catch((err)=>{
			console.log(err,'&&');
		}); 
		 
	};
});

reject_btns.forEach((reject_btn)=>{
	reject_btn.onclick = ()=>{
	 
		const application_id = reject_btn.id.substring(7,reject_btn.id.length+1);
		console.log(application_id,'  !!!!');
		changeApplicationStatus(application_id,3)
		.then((data)=>{
			alert(data+' --> rejected');
			const row = document.querySelector('#id_'+application_id);
			row.remove();
			
			const cells = document.querySelectorAll('.s_no');
			let i =1;
			cells.forEach((cell)=>{
				cell.innerHTML = i++; 
			});
		}).catch((err)=>{
			console.log(err,'&&');
		}); 
		 
	};
});




//~~~~~~~~~~~~~~~~~~~~~~ bring doctor info ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const bringDoctorProfile = async (doctorId)=>{
	const response = await fetch('bringDoctorProfile.do?doctor_id='+doctorId);
	const data = await response.json();
	return data;
};

 




const cross = document.querySelector('.fa-times');
cross.onclick = ()=>{
	form_box.style.display='none';
};

