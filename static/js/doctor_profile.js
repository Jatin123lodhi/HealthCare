let service_time_span = document.querySelector('#service_time_span');
 
let profile_form  = document.querySelector('.profile_form');
profile_form.service_time.value = service_time_span.innerHTML;  

let update_btn = document.querySelector('#id_save');
update_btn.onclick = ()=>{
	alert('profile updated');
};
 