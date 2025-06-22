create database hotelmanagementsystem;

show databases;

use hotelmanagementsystem;

create table login(username varchar(25), password varchar(25));

insert into login values('admin', '12345');

create table employee(employee_name varchar(25), age varchar(10), gender varchar(15), job_title varchar(30), salary varchar(15), phone varchar(15), email varchar(40), sin varchar(20));

create table room(room_number varchar(10), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));

create table driver(driver_name varchar(20), age varchar(10), gender varchar(15), car_company varchar(20), car_model varchar(20), is_available varchar(20), location varchar(40));

create table customer(idType varchar(20), idNo varchar(30), cust_name varchar(30), gender varchar(15), country varchar(20), room varchar(10), checkin_time varchar(80), deposit varchar(20));

create table department(dept_name varchar(30), budget varchar(30));


insert into employee values('Gurjot','24','Female','Manager','150000','9998887776665','gurjot@gmail.com','999999999');

insert into room values('101', 'Available', 'Clean', '2500', 'Single Bed');
insert into room values('102', 'Available', 'Clean', '2500', 'Single Bed');
insert into room values('103', 'Available', 'Clean', '2500', 'Single Bed');
insert into room values('104', 'Available', 'Clean', '2500', 'Single Bed');
insert into room values('105', 'Available', 'Clean', '2500', 'Single Bed');
insert into room values('106', 'Available', 'Clean', '3500', 'Double Bed');
insert into room values('107', 'Available', 'Clean', '3500', 'Double Bed');
insert into room values('108', 'Available', 'Clean', '3500', 'Double Bed');
insert into room values('109', 'Available', 'Clean', '3500', 'Double Bed');
insert into room values('110', 'Available', 'Clean', '3500', 'Double Bed');

insert into driver values('Leo', '35', 'Male', 'Audi', 'A3', 'Yes', 'Toronto, ON');
insert into driver values('Cathy', '38', 'Female', 'Toyota', 'RAV4', 'Yes', 'Calgary, AB');
insert into driver values('John', '40', 'Male', 'Honda', 'Civic', 'Yes', 'Mississauga, ON');
insert into driver values('Amy', '20', 'Female', 'Volkswagen', 'Jetta', 'Yes', 'St. Albert, AB');
insert into driver values('Catherine', '25', 'Female', 'Mercedes', 'C300', 'Yes', 'Toronto, ON');

insert into department values('Front Office','500000');
insert into department values('Housekeeping', '40000');
insert into department values('Food and Beverage', '23000');
insert into department values('Kitchen or Food Production', '540000');
insert into department values('Security', '320000');



select * from login;
select * from department;
describe employee;
select * from employee;
select * from room;
select * from driver;
select * from customer;

ALTER TABLE driver RENAME COLUMN branch TO brand;
ALTER TABLE driver RENAME COLUMN name TO driver_name;
ALTER TABLE employee RENAME COLUMN name TO employee_name;
ALTER TABLE customer RENAME COLUMN name TO cust_name;

#SET SQL_SAFE_UPDATES = 0;
update room set availability = 'Available' where room_number = '101';
update room set price = '2500' where room_number = '101';
update room set bed_type='Single Bed' where room_number='101';
#SET SQL_SAFE_UPDATES = 1;