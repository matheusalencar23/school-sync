create table users (
	id int not null auto_increment primary key,
	username varchar(100) not null unique,
	password varchar(100) not null,
	user_role enum('ADMIN', 'STUDENT', 'TEACHER') not null,
	person_id int not null,
	foreign key (person_id) references people(id) on delete cascade
);

create table people (
	id int not null auto_increment primary key,
	cpf varchar(11) not null unique,
	name varchar(250) not null,
	birth_date date not null
);

create table students (
	id int not null auto_increment primary key,
	person_id int not null unique,
	foreign key (person_id) references people(id) on delete cascade
);

create table teachers (
	id int not null auto_increment primary key,
	person_id int not null unique,
	foreign key (person_id) references people(id) on delete cascade
);

create table classes (
	id int not null auto_increment primary key,
	title varchar(50) not null,
	description varchar(250) not null,
	teacher_id int,
	foreign key (teacher_id) references teachers(id) on delete set null
);

create table classes_students (
	id int not null auto_increment primary key,
	class_id int not null,
	student_id int not null,
	foreign key (class_id) references classes(id) on delete cascade,
	foreign key (student_id) references students(id) on delete cascade
);