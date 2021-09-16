const ajaxRequest = async ()=>{
	
	const response =  await fetch(`checkPatientEmail.do?email=${emailField.value}`);
	//console.log(response,'!!!!!!!!!!!!!!');
	return response.text();
};