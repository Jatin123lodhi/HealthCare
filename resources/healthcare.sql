create database healthcare;

use healthcare;

create table pic_types(
    pic_type_id int auto_increment primary key,
    pic_type varchar(30) not null
);


#inserting records
insert into pic_types (pic_type) values ('Interior'),('Exterior'),('Parking'),('Rooms'),('OT'),('Reception');

## #########################################################################################
## #########################################################################################

create table states(
    state_id int auto_increment primary key,
    state varchar(35) not null
);


#inserting records
insert into states (state) values ('MP'),('UP');

INSERT INTO states (state) VALUES ('Not Selected');

## #########################################################################################
## #########################################################################################

create table specializations(
	specialization_id int auto_increment primary key,
	specialization varchar(50) not null
);

#alter table specializations modify specialization_id int auto_increment;   -- if we forget auto_increment likhna
---------------------- inserting recors --------------------------------
insert into specializations
(specialization)
values
('Dentist'),('Dermatologist'),('Orthopedic'),('Cardiologist'),('Phychiarist'),('Ophthalmologist'),('General Physician'),('Veterinarian'),('Neurologist'),('Paediatrician'),('Gynecologist'),('Ayurvedic');



## #########################################################################################
## #########################################################################################
create table service_times(	
	service_time_id int auto_increment primary key,
	service_time varchar(30) not null
);

---------------------- Query ------------------------------
insert into service_times (service_time) value ('10:00 AM-12:00 PM'),('12:00 PM-02:00 PM'),('02:00 PM-04:00 PM'),('04:00 PM-06:00 PM');




## #########################################################################################
## #########################################################################################
 
create table cities(
    city_id int auto_increment primary key,
    city varchar(35) not null,
    state_id int not null,
    constraint FK_cities_states foreign key (state_id) references states (state_id)
);

#inserting records 

insert into cities
(city,state_id)
values
('Jabalpur',1),('Bhopal',1),('Indore',1),
('Kanpur',2),('Lucknow',2),('Agra',2);


#alter table cities drop foreign key FK_cities_states;
#alter table cities add constraint FK_cities_states foreign key (state_id) references states (state_id);

# ---------------------Query ----------------------------------
INSERT INTO cities (city, state_id) VALUES ('Not Selected', 3);
#select city_id,city,s.state from cities as c inner join states as s where c.state_id=s.state_id;






## #########################################################################################
## #########################################################################################


 
create table status(
    status_id int auto_increment primary key,
    status varchar(20) not null
);


#inserting records 

insert into status 
(status)
values 
('active'),('inactive'),('blocked'),('ended');

insert into status (status) value ('profile incomplete'); 
#update hospitals set status_id=5 where email='jatinlodhi11@gmail.com';
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

## #########################################################################################
## #########################################################################################

create table release_status(
    release_status_id int auto_increment primary key,
    release_status varchar(20) null
);

-- ----------------------- Queries ---------------------------

insert into release_status (release_status) value ('cured'),('partially cured'),('dead'),('give up');

## #########################################################################################
## #########################################################################################

create table diseases(
    disease_id int auto_increment primary key,
    disease varchar(60) not null
);

## #########################################################################################
## #########################################################################################

create table facility_types(
    facility_type_id int auto_increment primary key,
    facility_type varchar(40) not null
);

## #########################################################################################
## #########################################################################################

create table rooms(
    room_id int  auto_increment primary key,
    room_no int  not null,
    bed_count int not null,
    floor_no int not null
);

## ------------------- Query ---------------------
insert into rooms (room_no,bed_count,floor_no) value ('1','10','1'),('2','7','1'); 
insert into rooms (room_no,bed_count,floor_no) value ('3','15','2'),('4','10','2'); 


## #########################################################################################
## #########################################################################################

create table test_types(
    test_type_id int auto_increment primary key,
    test_type varchar(40) not null
);

-- ------------------------- Query --------------------------------------------------


insert into test_types (test) value ('RBC'),('Prothrombin Time'),('Kindey func test'),('CBC');
-- select test from test_types;
--alter table test_types change column test test_type varchar(40) not null;
## #########################################################################################
## #########################################################################################

create table medicines(
    medicine_id int auto_increment primary key,
    medicine varchar(60) not null
);
## #########################################################################################
## #########################################################################################
create table bed_status(
	bed_status_id int auto_increment primary key,
	bed_status varchar(20) not null
);

## ~~~~~~~~~~~~~~~~~~ Query ~~~~~~~~~~~~~~~~~~~~~~~~~~~
insert into bed_status (bed_status) value ('vacant'),('reserved');
  

## #########################################################################################
## #########################################################################################

create table beds(
	bed_id int auto_increment primary key,
	bed_no int not null,
	room_id int not null,
	bed_status int not null default 1,
	constraint fk_beds_rooms foreign key (room_id) references rooms (room_id)
);
## ----------------- Query -----------------------------
insert into beds  (bed_no,room_id) values ('101','1'),('102','1'),('103','1'),('104','1'),('105','1'),('106','1'),('107','1'),('108','1'),('109','1'),('110','1');
insert into beds  (bed_no,room_id) values ('201','2'),('202','2'),('203','2'),('204','2'),('205','2'),('206','2'),('207','2');


## #########################################################################################
## #########################################################################################

create table patients(
    patient_id int auto_increment primary key,
    name varchar(40) not null,
    gender varchar(10) not null,
    email varchar(60) not null unique,
    password varchar(100),
    contact_no varchar(10),
    address varchar(400),
    city_id int ,
    profile_pic varchar(100),
    dob Date,
    blood_group varchar(10) ,
    weight varchar(20),
    height varchar(20) ,
    activation_code varchar(100),
    status_id int ,
    bed_id int,
    constraint fk_patients_cities foreign key (city_id) references cities (city_id),
    constraint fk_patients_status foreign key (status_id) references status (status_id),
    constraint fk_patients_beds foreign key (bed_id) references beds (bed_id);

);
-- alter table patients change column gender gender varchar(1);
-- alter table patients change column contact_no contact_no varchar(10);
-- alter table patients change column address address varchar(400);
-- alter table patients change column city_id city_id int ;
-- alter table patients change column dob dob Date;
-- alter table patients change column blood_group blood_group varchar(10);
-- alter table patients change column weight weight varchar(20);
-- alter table patients change column height height varchar(20);
-- alter table patients change column status_id status_id int default 2;

-- alter table patients add column bed_id int;
-- alter table patients add constraint fk_patients_beds foreign key (bed_id) references beds (bed_id);
-- select * from patients where email=? OR name like '"+key+"%' 

-- select patient_id,name,contact_no,address,password,status_id,h.city_id,city,dob,blood_group,weight,height,bed_no,room_no
-- FROM patients AS p INNER JOIN cities AS c inner join beds as b inner join rooms as r where email=? AND p.city_id=c.city_id
-- and p.bed_id=b.bed_id and b.room_id=r.room_id"



## #########################################################################################
## #########################################################################################

create  table doctors(
    doctor_id int auto_increment primary key,
    name varchar(40) not null,
    email varchar(60) not null,
    password varchar(100) not null,
    specialization int  null,
    address varchar(400)  null,
    contact_no varchar(10)  null,
    experience varchar(20)  null,
    profile_pic varchar(100) ,
    activation_code varchar(100),
    status_id int not null default 2,
    city_id int null,
    constraint fk_doctors_status foreign key (status_id) references status (status_id),
    constraint fk_doctors_cities foreign key (city_id) references cities (city_id)  
    constraint fk_doctors_specializations foreign key (specialization_id) references specializations (specialization_id);
    
    #constraint fk_doctors_cities foreign key (doctor_id) references cities (city_id)  

);
##  alter table doctors modify specialization int null;  -- when specialization as a string tha
##  alter table doctors add constraint fk_doctors_specializations foreign key (specialization_id) references specializations (specialization_id);
## ~~~~~~~~~~~~~~~~~~~~ Query ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
alter table doctors change column city_id city_id int default 7;
#update doctors set city_id=7;
#alter table doctors change column experience experience varchar(20);
alter table doctors add column gender varchar(20);
alter table doctors add column service_time_id int;
#select doctor_id,name,contact_no,address,password,status_id,d.city_id,city,specialization,experience,profile_pic,gender,service_time_id FROM doctors AS d INNER JOIN cities AS c where email=? AND d.city_id=c.city_id
#select specialization from doctors;
alter table doctors add column hospital_id int;
alter table doctors add constraint fk_doctors_hospitals foreign key (hospital_id) references hospitals (hospital_id);
alter table doctors add column logo varchar(100) null;
## #########################################################################################
## #########################################################################################

create table admissions(
    admission_id int auto_increment primary key,
    patient_id int not null,
    disease_id int not null,
    admission_data date not null ,
    current_total_bill int not null default 0,
    medical_problem varchar(500) not null,
    doctor_id int not null,
    bed_id int not null,
    release_date date ,
    release_status_id int ,
    constraint fk_admissions_patients foreign key (patient_id) references patients(patient_id),
    constraint fk_admissions_diseases foreign key (disease_id) references diseases(disease_id),
    constraint fk_admissions_doctors foreign key (doctor_id) references doctors(doctor_id),
    constraint fk_admissions_release_status foreign key (release_status_id) references release_status(release_status_id)

);

-- alter table admissions change column disease_id disease_id int;
-- alter table admissions change column admission_date admission_date date;
-- alter table admissions change column medical_problem medical_problem varchar(500);
-- alter table admissions change column doctor_id doctor_id int;
-- alter table admissions change column bed_id bed_id int;




-- --------------------- Query --------------------------------------
-- insert into admissions (patient_id) value=?
-- select admission_id from admissions where patient_id=?

## #########################################################################################
## #########################################################################################

create table hospitals(
    hospital_id int auto_increment primary key,
    name varchar(55) not null,
    contact_no varchar(10) null,
    address varchar(400) null,
    email varchar(50) not null unique,
    password varchar(100) not null,
    city_id int not ,
    activation_code varchar(100),
    status_id int not null,
    start_date Date,
    description varchar(600);
    logo varchar(100);
    
    constraint fk_hospitals_cities foreign key (city_id) references cities(city_id),
    constraint fk_hospitals_status foreign key (status_id) references status (status_id)
);

#alter table hospitals change column contact_no contact_no varchar(10);
#alter table hospitals change column address address varchar(400);
#alter table hospitals change column city_id city_id int;
#alter table hospitals change column status_id status_id int default 2;
#alter table hospitals add column description varchar(600);

# ------------------- Query ---------------------------

-- select hospital_id,name,contact_no,address,password,status_id,h.city_id,city\r\n"
-- 	+ " FROM hospitals AS h INNER JOIN cities AS c where email=? AND h.city_id=c.city_id";

# update hospitals set name=?,description=?,contact_no=?,city_id=?,start_date=?,address=? where email=?
#select hospital_id,name from hospitals
## #########################################################################################
## #########################################################################################

create table hospital_pics(
    hospital_pic_id int auto_increment primary key,
    hospital_id int not null,
    pic_type_id int not null,
    pic_path varchar(100) not null,
    constraint fk_hospital_pics_hospitals foreign key (hospital_id) references hospitals(hospital_id),
    constraint fk_hospital_pics_pic_types foreign key (pic_type_id) references pic_types(pic_type_id)
);

-- ------------------------Query ------------------------------------

-- insert into hospital_pics (hospital_id,pic_type_id,pic_path) values (?,?,?);

 
## #########################################################################################
## #########################################################################################

create table hospital_facilities(
    hospital_facilities_id int auto_increment primary key,
    facility_type_id int not null,
    hospital_id int not null,
    constraint fk_hospital_facilities_hospitals foreign key (hospital_id) references hospitals(hospital_id),
    constraint fk_hospital_facilities_facility_types foreign key (facility_type_id) references facility_types(facility_type_id)
);

## #########################################################################################
## #########################################################################################
create table application_status(
	application_status_id int auto_increment primary key,
	application_status varchar(50) not null
);

## ------------------------ Query ----------------------------
insert into application_status (application_status) value ('waiting'),('approved'),('rejected');


## #########################################################################################
## #########################################################################################

create table applications(
	application_id int auto_increment primary key,
	doctor_id int not null,
	hospital_id int not null,
	doctor_license_file varchar(70) not null,
	constraint fk_applications_doctors foreign key (doctor_id) references doctors(doctor_id),
	constraint fk_applications_hospitals foreign key (hospital_id) references hospitals(hospital_id)
);

## ------------------------- Query ------------------------------
alter table applications add column application_status_id int default 1;
alter table applications add constraint fk_applications_applications_status_id foreign key (application_status_id)
references application_status (application_status_id);
-- select * from applications where application_status_id=1

## #########################################################################################
## #########################################################################################
create table tests(
    test_id int auto_increment primary key,
    test_type_id int not null,
    admission_id int not null,
    constraint fk_tests_admissions foreign key (admission_id) references admissions(admission_id),
    constraint fk_tests_test_types foreign key (test_type_id) references test_types(test_type_id)
);

-- alter table tests change column test_type_id 
alter table tests add column date date,
alter table tests add column file_name varchar(100) not null;
--select date,test_type,file_name from tests as t inner join test_types as ty where t.test_type_id=ty.test_type_id and admission_id=? order by date

## #########################################################################################
## #########################################################################################

create table pescriptions(
    pescription_id int auto_increment primary key,
    medicine_id int not null,
    admission_id int not null,
    test_id int not null,
    constraint fk_pescriptions_medicines foreign key (medicine_id) references medicines(medicine_id),
    constraint fk_pescriptions_admissions foreign key (admission_id) references admissions(admission_id),
    constraint fk_pescriptions_tests foreign key (test_id) references tests(test_id)
);

## #########################################################################################
## #########################################################################################

create table doctor_time_slots(
	doctor_time_slot_id int auto_increment primary key,
	time_slot time not null,
	doctor_id int not null,
	constraint fk_doctor_time_slots_doctors foreign key (doctor_id) references doctors(doctor_id)
);

## #########################################################################################
## #########################################################################################

create table slot_status(
	slot_status_id int auto_increment primary key,
	slot_status int default 1,
	slot_date date not null,
	doctor_time_slot_id int not null,
	constraint fk_slot_status_doctor_time_slots foreign key (doctor_time_slot_id) references doctor_time_slots (doctor_time_slot_id)
	
);
## 1- vacant 2- booked
##select time_slot from doctor_time_slots where doctor_id=6 and time_slot not in(
##select time_slot from slot_status as s inner join doctor_time_slots as dts
##where (s.doctor_time_slot_id=dts.doctor_time_slot_id and dts.doctor_id=6 )
##AND(s.slot_status=2)
##);

## #########################################################################################
## #########################################################################################

create table appointments(
	appointment_id int auto_increment primary key,
	patient_name varchar(30) not null,
	patient_mobile_no int not null,
	slot_status_id int not null,
	appointment_status int default 1
);
alter table appointments change column patient_mobile_no patient_mobile_no varchar(10) not null;
## appointment_status 1 - not visited , 2- visited

