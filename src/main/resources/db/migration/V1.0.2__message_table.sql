create table message(
	id int auto_increment not null,
	text varchar(255) not null,
	created datetime not null default CURRENT_TIMESTAMP,
	to_user varchar(100) not null,
	from_user varchar(100) not null,
	foreign key (to_user) references user(email),
	foreign key (from_user) references user(email),
	primary key(id)
)