const ajaxRequest = async ()=>{
	
	const response =  await fetch(`checkDoctorEmail.do?email=${emailField.value}`);
	//console.log(response,'!!!!!!!!!!!!!!');
	return response.text();
};