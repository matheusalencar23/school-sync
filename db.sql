-- criando tabela de pessoas e inserindo dados

create table people (
	id int not null auto_increment primary key,
	cpf varchar(11) not null unique,
	name varchar(250) not null,
	birth_date date not null
);

insert into people (cpf, name, birth_date)
values ('56072023134', 'Aline Antonella Adriana Rodrigues', '1979-09-01');

insert into people (cpf, name, birth_date)
values ('41170344216', 'Leandro Benedito Julio Gonçalves', '1986-12-09');

insert into people (cpf, name, birth_date)
values ('05905305420', 'Cauê José Monteiro', '2010-05-16');

insert into people (cpf, name, birth_date)
values ('30663255120', 'Emilly Yasmin Rocha', '2010-04-25');

insert into people (cpf, name, birth_date)
values ('55049996775', 'Rayssa Allana Araújo', '2010-08-02');

-- criando tabela de usuários e inserindo dados

create table users (
	id int not null auto_increment primary key,
	username varchar(100) not null unique,
	password varchar(100) not null,
	user_role enum('ADMIN', 'STUDENT', 'TEACHER') not null,
	person_id int not null,
	foreign key (person_id) references people(id) on delete cascade
);

insert into users (username, password, user_role, person_id)
values ('aline.antonella', '$2a$12$uySSZdNc8kW3lGQyaZn.iuXLBmiVIedhDqr0P9I.61gfuTIlWcbV6', 'TEACHER', 1);

insert into users (username, password, user_role, person_id)
values ('leandro.benedito', '$2a$12$uySSZdNc8kW3lGQyaZn.iuXLBmiVIedhDqr0P9I.61gfuTIlWcbV6', 'TEACHER', 2);

insert into users (username, password, user_role, person_id)
values ('caue.jose', '$2a$12$uySSZdNc8kW3lGQyaZn.iuXLBmiVIedhDqr0P9I.61gfuTIlWcbV6', 'STUDENT', 3);

insert into users (username, password, user_role, person_id)
values ('emilly.yasmin', '$2a$12$uySSZdNc8kW3lGQyaZn.iuXLBmiVIedhDqr0P9I.61gfuTIlWcbV6', 'STUDENT', 4);

insert into users (username, password, user_role, person_id)
values ('rayssa.allana', '$2a$12$uySSZdNc8kW3lGQyaZn.iuXLBmiVIedhDqr0P9I.61gfuTIlWcbV6', 'STUDENT', 5);

-- criando tabela de professores e inserindo dados

create table teachers (
	id int not null auto_increment primary key,
	specialization varchar(100) not null,
	department varchar(100) not null,
	user_id int not null,
	foreign key (user_id) references users(id) on delete cascade
);

insert into teachers (specialization, department, user_id) 
values ('História', 'Ciências Humanas', 1);

insert into teachers (specialization, department, user_id) 
values ('Física', 'Ciências Exatas', 2);

-- criando tabela de estudantes e inserindo dados

create table students (
	id int not null auto_increment primary key,
	code varchar(10) not null,
	user_id int not null,
	foreign key (user_id) references users(id) on delete cascade
);

insert into students (code, user_id)
values ('87054', 3);

insert into students (code, user_id)
values ('12562', 4);

insert into students (code, user_id)
values ('97961', 5);