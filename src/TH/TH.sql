show tables;
desc texas_holdem

create table Texas_Holdem(
	idx int auto_increment primary key,
	name varchar(10) not null,
	point int default 100
);

