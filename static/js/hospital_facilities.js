 
  
let inputs = document.querySelectorAll('.form-check-input');
 
inputs.forEach((input)=>{
	  
	let facility_type = input.parentElement.parentElement.parentElement.id;
	let facility = input.id;
	
	//console.log(input.checked); 
	
	input.addEventListener('click',()=>{
		let x = input.checked?1:0;
		console.log(x);
	});
	
});
 