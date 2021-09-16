const inputs = document.querySelectorAll('.form_inp');
const form = document.forms[1];
const result={
  name: false,
  email: false,
  password: false
};


//~~~~~~~~~~~~~~~~~~~~ unique email ~~~~~~~~~~~~~~~~~~~~~~~~~

const emailField = document.querySelector('#id_email');




const checkEmail = ()=>{
	if(result['email']){
		ajaxRequest().then((data)=>{
			const emailError = document.querySelector('#email_error');
			if(data=='true'){
				emailError.innerHTML = 'Email Aready Exists !'
				emailField.classList.replace('success','fail');
				emailError.classList.replace('hide','show');
				result['email'] = false;
			}
			
			//console.log(data);
		}).catch((error)=>{
			console.log(error);
		});
	}
};




emailField.addEventListener('blur',checkEmail);



//-------------- VIEW Password ------------------------------

const password_input = inputs[2];
const eye_btn = document.querySelector("#view_password");

eye_btn.addEventListener('click',function(event){
	let x = password_input.attributes.type.value;
	if(x=='password'){
		password_input.attributes.type.value = 'text';
	} else{
		password_input.attributes.type.value = 'password';
	}
	 
});

//----------------Validation------------------------------------


const patterns = {
	name : /^[a-zA-Z0-9 ]{2,30}$/ ,
	email : /^([a-zA-Z][a-zA-Z\d-_]*)@([a-zA-Z\d-_]{2,})\.([a-zA-Z]{2,5})(\.[a-zA-Z]{2,5})?$/ ,
	password : /^[a-zA-Z0-9_-]{4,20}$/
};



form.addEventListener('submit',function(event){
	if(result.name&&result.email&&result.password){
		return true;
	}else{
		event.preventDefault();
		return false;
	}
});



function validate(pattern,field){
	
	//let help = document.querySelector('#'+field.attributes.name.value+'_help');
	let error = document.querySelector('#'+field.attributes.name.value+'_error');
	//console.log(field.attributes.name.value,'!!!!!!!!!!!');
	if(field.attributes.name.value=='email'){
		error.innerHTML = 'Invalid Email';
	}
	if(pattern.test(field.value)){
		result[field.attributes.name.value]= true; 
		if(field.classList.contains('red')){
			field.classList.replace('red','blue');
		}else{
			field.classList.add('blue');
		}
		error.classList.replace('show','hide');
	}else{
		if(field.classList.contains('blue')){
			field.classList.replace('blue','red');
		}else{
			field.classList.add('red');
		}
		result[field.attributes.name.value] = false;
		error.classList.replace('hide','show');
		
	}
}



inputs.forEach(function(input){
	 input.addEventListener('keyup',function(event){
		 
		 

		let pattern = patterns[event.target.attributes.name.value];
		 	
		let field = event.target;
			 
		validate(pattern,field);
					
		
	});
});



