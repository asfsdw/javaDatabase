show tables;
desc texas_holdem
select * from texas_holdem;

create table texas_Holdem(
	idx int auto_increment primary key,
	name varchar(10) not null,
	point int default 10000
);

insert into texas_holdem values (default,'홍길동',default);

drop table texas_holdem;
delete from texas_holdem where name = '홍길동';
select * from texas_holdem where point;
select point from texas_holdem;
