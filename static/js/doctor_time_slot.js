let create_btn = document.querySelector('#create_btn');
let time_input = document.querySelector('#time_input');
let doctor_id = document.querySelector('#doctor_id_span').innerHTML;
 
 
console.log(doctor_id);
console.log(time_input);

let del_btns = document.querySelectorAll('.del_btn');
del_btns.forEach((del_btn)=>{
	del_btn.onclick = async ()=>{
		const response = await fetch('delete_time_slot.do?doctor_slot_time_id='+del_btn.id);
		const data = await response.text();
		console.log(data,' ########'); 
		location.reload();
	}   
});
 





//~~~~~~~~~~~~~~~~~~~~~~~ for slot creation ~~~~~~~~~~~~~~~~~~~~~~~
create_btn.onclick = async ()=>{
	console.log(time_input.value); 
	let time = time_input.value;
	if(time==''){
		alert('Selete time for the slot');
	}else{
		const response = await fetch('create_time_slot.do?slot_time='+time+'&doctor_id='+doctor_id);
		const data = await response.text();
		console.log(data);
		//alert('Slot added successfully');
		time_input.value = ''; 
		location.reload();
	}
	
	 
}   

 
  