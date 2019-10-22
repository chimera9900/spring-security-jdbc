create table user(
	id int auto_increment not null,
	email varchar(100) not null unique ,
	password varchar(255) not null,
	firstName varchar(100) not null,
	lastName varchar(100) not null,
	primary key (id)
);

create table roles(
	id int auto_increment not null,
	role varchar(100) not null,
	email varchar(100) not null,
	foreign key(email) references user(email)
	on delete cascade on update cascade
	
);

create unique index idx_unq on roles (role, email); 




