/*
	DDL queries for lab1
	- Creates all req. tables

*/
create table T_Author (
	namn 	varchar(24) 	NOT NULL,
	authorID	int			PRIMARY KEY auto_increment

);
create table T_Genre (
	TypeID		int		not null auto_increment primary key,
    TypeName	varchar(24)	unique

);
create table T_Book (
	Isbn 		int 			primary key,
    ReleaseYr	date			not null,
    Title		varchar(24)		not null

);
create table T_Review (
	ReviewNo 	integer auto_increment,
	Score		integer,
    Message		varchar(255),
    Isbn		int		references T_Book(Isbn),
    primary key (ReviewNo, Isbn),
    check (Score > 0 and Score <=5)

);

create table RT_BookGenres(
	TypeID		int		references T_Genre(TypeID),
    Isbn		int		references T_Book(Isbn)

);
create table RT_writing(
	authorID	int		references t_author(authorID),
    Isbn		int		references t_book(Isbn)

);




/*
drop table rt_writing;
drop table rt_bookgenres;
drop table t_author;
drop table t_book;
drop table t_review;
drop table t_test;
drop table t_genre;
*/