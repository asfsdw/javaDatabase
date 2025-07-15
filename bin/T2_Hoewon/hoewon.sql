desc hoewon;
show tables;

create table hoewon(
	idx			int not null auto_increment primary key,
	name		varchar(20) not null,
	age			int default 20,
	gender	char(2) default '여자',
	address	varchar(30)
);

insert into hoewon values(default, '홍길동', 25, '남자', '서울');
insert into hoewon values(default, '김말숙', 35, '여자', '청주');
insert into hoewon values(default, '이기자', 45, '남자', '서울');
insert into hoewon values(default, '오하늘', 22, default, '제주');
insert into hoewon values(default, '소나무', 29, '남자', '부산');
insert into hoewon values(default, '강감찬', 33, '남자', '광주');
insert into hoewon values(default, '아톰', 43, default, '서울');
insert into hoewon values(default, '비톰', 28, '남자', '청주');
insert into hoewon values(default, '김연아', 32, '여자', '청주');
insert into hoewon values(default, '고인돌', 37, '남자', '부산');
insert into hoewon values(default, '대나무', 42, '여자', '제주');

select * from hoewon;

delete from hoewon;
drop table hoewon;

select * from hoewon where name = '홍길동';