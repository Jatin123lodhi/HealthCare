const ajaxRequest = async ()=>{
	
	const response =  await fetch(`checkHospitalEmail.do?email=${emailField.value}`);
	//console.log(response,'!!!!!!!!!!!!!!');
	return response.text();
};