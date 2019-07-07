CREATE DATABASE Egar_HW
go
USE Egar_HW
go

/*
 1.��� �������� ������(5 ������)
*/

CREATE TABLE post(
	[postnumber] [nchar](6) NULL,
	[sname] [nchar](20) NULL,
	[rating] [int] NULL,
	[sity] [nchar](20) NULL,
) ON [PRIMARY]


CREATE TABLE det(
    [detnumber] [nchar](6) NULL,
	[name] [nchar](20) NULL,
	[color] [nchar](20) NULL,
	[weight] int NULL,
	[sity] [nchar](20) NULL
) ON [PRIMARY]


CREATE TABLE prod(
	[prodnumber] [nchar](10) NULL,
	[name] [nchar](20) NULL,
	[sity] [nchar](20) NULL
) ON [PRIMARY]


CREATE TABLE sale(
	id int identity(1,1)  not NULL,
	[postnumber] [nchar](6) NULL,
	[detnumber] [nchar](6) NULL,
	[prodnumber] [nchar](6) NULL,
	[qamount] [int] NULL
) ON [PRIMARY]

CREATE TABLE bike(
	[id] [int] not NULL,
	[name] [nchar](55) NULL,
	[type] [nchar](55) NULL,
	[�ate_of_issue] [nchar](12) NULL,
	[cost] [int] NULL
) 


/*
2.��������������� Alter table ��� ���������� ����� ��� FK
*/

ALTER TABLE sale ADD
datepost datetime NULL
GO
sp_Help sale
go

/*
3.��������� ������� �������(��� ������������ �� ����� 3 �����, ��� ��������� �� ����� 5 �����).
*/

/*
���������� ������� post
*/
insert into post values('S1','����',20,'������')
insert into post values('S2','�����',10,'�����')
insert into post values('S3','�����',30,'�����')
insert into post values('S4','�����',20,'������')
insert into post values('S5','�����',30,'�����')

/*
���������� ������� det
*/
insert into det values('P1','�����','�������',12,'������')
insert into det values('P2','����','�������',17,'�����')
insert into det values('P3','����','�������',17,'���')
insert into det values('P4','����','�������',14,'������')
insert into det values('P5','�������','�������',12,'�����')
insert into det values('P6','����','�������',19,'������')

/*
���������� ������� prod
*/
insert into prod values('J1','������� ����','�����')
insert into prod values('J2','����������','���')
insert into prod values('J3','�����������','�����')
insert into prod values('J4','�������','�����')
insert into prod values('J5','������-����','������')
insert into prod values('J6','��������','����')
insert into prod values('J7','�����','������')

/*
���������� ������� sale
*/
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S1','P1','J1',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S1','P1','J4',700)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J1',400)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J2',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J3',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J4',500)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J5',600)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J6',400)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P3','J7',800)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S2','P5','J2',100)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S3','P3','J1',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S3','P4','J2',500)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S4','P6','J3',300)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S4','P6','J7',300)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P2','J2',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P2','J4',100)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P5','J5',500)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P5','J7',100)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P6','J2',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P1','J4',100)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P3','J4',200)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P4','J4',800)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P5','J4',400)
insert into sale (postnumber, detnumber, prodnumber, qamount) values('S5','P6','J4',500)

/*
���������� ������� bike
*/
insert into bike (id,name,type,�ate_of_issue,cost) values(1,'aventon','fixed-gear','2018',700)
insert into bike (id,name,type,�ate_of_issue,cost) values(2,'cinelli','fixed-gear','2017',900)
insert into bike (id,name,type,�ate_of_issue,cost) values(1,'bear-bike','fixed-gear','2019',350)


/*
 4.�������� ������� ��� �������� � ��������� ������� �� ������-���� ��������(��������� ���������� ������, ��������� between ��� ��� ��� �����, in, ��� ��������� <, >, =,) 
*/

/*
��������� ������� � ������� 
*/

update post set rating = rating + 10
where rating between 10 and 30

update det set color = '�������'
where detnumber in (select detnumber from sale where postnumber = 'S1')

update post set rating = rating - 10
where rating < (select rating from post where postnumber = 's4')

/*
�������� �������
*/

DELETE FROM prod WHERE prodnumber between 'J2' and 'J6'


/*
5.������� 2 ������� �� ���������� ������ �� �����-���� ���������. � 1 ������� � �������������� �����������
*/

select name, detnumber
from det
where detnumber in (
select distinct detnumber
from sale
where prodnumber in (select prodnumber from prod where sity = '������'))

select prodnumber
from sale
where postnumber = 'S1'

select detnumber, prodnumber, sum(qamount)
from sale
group by detnumber, prodnumber

select s.qamount, p.sname 
from sale s, post p
where p.postnumber = s.postnumber

/*
6.������ ��� �������� ���� ��������� ������
*/

