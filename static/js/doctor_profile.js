let service_time_span = document.querySelector('#service_time_span');
 
let profile_form  = document.querySelector('.profile_form');
profile_form.service_time.value = service_time_span.innerHTML;  

let update_btn = document.querySelector('#id_save');
update_btn.onclick = ()=>{
	alert('profile updated');
};

let dropzone_box = document.querySelector(".dropzone_box");
 
dropzone_box.style.display = 'none';

let upload_btn = document.querySelector('#btn');
 
 

let edit_pic = document.querySelector('.edit_pic');
edit_pic.onclick = ()=>{
	dropzone_box.style.display = 'block';
	upload_btn.classList.remove('d-none'); 
}; 

 