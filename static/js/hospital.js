const srh_field = document.querySelector("#id_srh");
const search_btn = document.querySelector("#search_btn");
const div1 = document.querySelector('#div_1');
const div2 = document.querySelector('#div_2');
 
//~~~~~~~~~~~~~~~~~~ Hospital Records ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

const bringHospitalRecords = async ()=>{
	let response = await fetch('bringHospitalRecords.do?key='+srh_field.value);
	const data =  await response.json();
	return data;
};
 
 
 
search_btn.onclick = ()=>{
	bringHospitalRecords()
	.then((data)=>{
		let hospitals =  document.querySelectorAll('.rec_div'); 
		for(var j=0;j<hospitals.length;j++){
			hospitals[j].remove();
		}
		 
		for(var i=0;i<data.length;i++){
			 
			let main_container = document.querySelector('.box');
			let container_div = document.createElement('div');
			container_div.classList.add('container','pt-4','rec_div');
			main_container.append(container_div);
			 
			let row_div = document.createElement('div');
			row_div.classList.add('row');
			container_div.append(row_div);
			
			
			let col_div_3 = document.createElement('div');
			col_div_3.classList.add('col-3','border','border-info','p-2');
			col_div_3.setAttribute('style','height:250px');
			row_div.append(col_div_3);
			
			let img_tag = document.createElement('img');
			img_tag.setAttribute('src','show_hospital_logo.do?logo='+data[i].logo);
			img_tag.classList.add('w-100','h-100');
			col_div_3.append(img_tag);
			
			
			let col_div_9 = document.createElement('div');
			col_div_9.classList.add('col-9','border','border-info','p-2');
			row_div.append(col_div_9);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			let table = document.createElement('table');
			table.classList.add('table','table-dark','mt-3');
		
			col_div_9.append(table);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			let row_1 =  document.createElement('tr');
			table.append(row_1);
			
			let cell_1 = document.createElement('td');
			row_1.append(cell_1);
			cell_1.innerHTML = 'Name';
			
			let cell_2 = document.createElement('td');
			row_1.append(cell_2);
			cell_2.innerHTML = data[i].name;
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			let row_2 = document.createElement('tr');
			table.append(row_2);
			
			cell_1 = document.createElement('td');
			row_2.append(cell_1);
			cell_1.innerHTML = 'Email';
			
			cell_2 = document.createElement('td');
			row_2.append(cell_2);
			cell_2.innerHTML = data[i].email; 
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			let row_3 = document.createElement('tr');
			table.append(row_3);
			
			cell_1 = document.createElement('td');
			row_3.append(cell_1);
			cell_1.innerHTML = 'Contact No-';
			
			cell_2 = document.createElement('td');
			row_3.append(cell_2);
			cell_2.innerHTML = data[i].contactNo;
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			let row_4 = document.createElement('tr');
			table.append(row_4);
			
			cell_1 = document.createElement('td');
			row_4.append(cell_1);
			cell_1.innerHTML = 'City';
			
			cell_2 = document.createElement('td');
			row_4.append(cell_2);
			cell_2.innerHTML =  data[i].city.city;
		}
		
	
	 
		console.log(data,' ----');
	})
	.catch((err)=>{
		console.log(err, ' ----#');
	});
};