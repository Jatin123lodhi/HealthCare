 //-------------- VIEW Password ------------------------------
 
const password_input = document.querySelector('#id_password');
const eye_btn = document.querySelector("#view_password");

eye_btn.addEventListener('click',function(event){
	let x = password_input.attributes.type.value;
	if(x=='password'){
		password_input.attributes.type.value = 'text';
	} else{
		password_input.attributes.type.value = 'password';
	}
	 
});
