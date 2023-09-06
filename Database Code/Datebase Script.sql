show databases;

create database library_ms;
use library_ms;

create table users(
id int primary key auto_increment,
username varchar(50),
password varchar(50),
name varchar(50),
email varchar(50),
contact varchar(20)
);
-- delete from users;
describe users;
-- drop table users;


create table book_details(
book_id int primary key not null auto_increment,
book_name varchar(255),
author varchar(100),
category varchar(255),
quantity int
);
describe book_details ;
-- drop table book_details;



create table student_details(
	student_id int not null primary key auto_increment,
	name varchar(255),
	session varchar(255),
	degree varchar(255),
	department varchar(255),
	phone_no varchar(255)
);

-- drop table student_details ;






create table issue_book_details(
	id int primary key auto_increment not null,
	book_id int,
	book_name varchar(255),
	student_id int,
	student_name varchar(255),
	issue_date date,
	due_date date,
	status varchar(255),
	phone_no varchar(255),
	foreign key(book_id) references book_details(book_id),
	foreign key(student_id) references student_details(student_id)
);

-- drop table issue_book_details ;

describe users;
describe student_details ;
describe issue_book_details ;
