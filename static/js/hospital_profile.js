let save_btn = document.querySelector('#id_save_btn');
let contact_no = document.querySelector('#id_contact_no');
let send_otp = document.querySelector('#id_send_otp');
let otp_help = document.querySelector('#verify_otp_help');
let otp_help1 = document.querySelector('#verify_otp_help1');
save_btn.style.display = 'none';
otp_help1.style.display = 'none';

//~~~~~~~~~~~~~~~~~~ verify otp ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
let otp_box = document.querySelector('#otp_box');
let otp_field = document.querySelector('#otp_field');
let check_otp = document.querySelector('#check_otp');
let otp_received;
otp_box.style.display = 'none'; 

check_otp.addEventListener('click',()=>{
	
	if(otp_received==otp_field.value){
			console.log('otp verified ');
			otp_help.innerHTML = 'OTP Verified';
			otp_help.style.color = 'blue';
			otp_help1.style.display = 'none';
			save_btn.style.display = 'block';
	
			
	}else{
		console.log('Invalid OTP');
		otp_help.innerHTML = 'Invalid OTP';
		otp_help.style.color = 'red';
		
		contact_no.disabled = false;
		otp_help1.style.display = 'block'; 
		send_otp.style.display = 'block';
	}
	
});

save_btn.addEventListener('click',()=>{
	contact_no.disabled = false;
});







//~~~~~~~~~~~~~~~~~~~~  otp send ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
const sendOtp = async ()=>{
	
	response  = await fetch('send_otp.do?contactNo='+contact_no.value);
	return response.text();
};

send_otp.addEventListener('click',()=>{
	send_otp.style.display = 'none';
	otp_box.style.display = 'block';
	contact_no.disabled = true;
	otp_help1.style.display = 'none';
	otp_field.value = '';
	sendOtp().then((data)=>{
		 otp_received = data;
	}).catch((error)=>{
		console.log(error,'^^^');
	});
	
}); 


