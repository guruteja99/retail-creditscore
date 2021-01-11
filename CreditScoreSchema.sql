create database retailbanking;

use retailbanking;

create table creditScoreDetails(
creditId int auto_increment,
userId bigint,
months varchar(10),
creditScore int,
primary key(creditId));

insert into creditScoreDetails(userId,months,creditScore) values
(646343436437,"March",600);



