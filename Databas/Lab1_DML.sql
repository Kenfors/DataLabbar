/*
	DML for lab 1
    - Fills tables with test-data

*/




insert into T_Author(namn) values ("Donald Trump");
insert into T_Author(namn) values ("Leo Nardo");
insert into T_Author(namn) values ("Karl Enfors");
insert into T_Author(namn) values ("Jonas Granit");

insert into T_Genre(TypeName) values ("Horror");
insert into T_Genre(TypeName) values ("Drama");
insert into T_Genre(TypeName) values ("Fantasy");
insert into T_Genre(TypeName) values ("Thriller");
insert into T_Genre(TypeName) values ("Crime");
insert into T_Genre(TypeName) values ("Sci-fi");
insert into T_Genre(TypeName) values ("Adventure");

insert into T_Book(Isbn, ReleaseYr, Title) values (1231237, DATE("2005-11-22"), "Poker Strategies");
insert into T_Book(Isbn, ReleaseYr, Title) values (2222237, DATE("1940-07-11"), "For Whom the Bell Tolls");
insert into T_Book(Isbn, ReleaseYr, Title) values (9285638, DATE("1994-08-18"), "Fiesta");
insert into T_Book(Isbn, ReleaseYr, Title) values (7395726, DATE("2006-01-06"), "Don Quixote");


insert into T_Review(Score, Message, Isbn) values (3, "Thought me alot...", (select Isbn from t_book where title = "Poker Strategies"));
insert into T_Review(Score, Message, Isbn) values (1, "I lost money because of this :(", (select Isbn from t_book where title = "Poker Strategies"));
insert into T_Review(Score, Message, Isbn) values (5, "Great strats!", (select Isbn from t_book where title = "Poker Strategies"));
insert into T_Review(Score, Message, Isbn) values (4, "A Classic", (select Isbn from t_book where title = "Don Quixote"));
insert into T_Review(Score, Message, Isbn) values (3, "Hemmingway is great", (select Isbn from t_book where title = "For Whom the Bell Tolls"));
insert into T_Review(Score, Message, Isbn) values (3, "Funny!", (select Isbn from t_book where title = "Fiesta"));

create user 'client'@'localhost' identified by '123456';
create user 'admin'@'localhost' identified by '123456';


/*
	Grant user rights to user "client".

*/
UPDATE mysql.user SET Grant_priv='Y', Super_priv='Y' WHERE User='root';
FLUSH PRIVILEGES;

UPDATE mysql.user SET Select_priv='Y', Insert_priv='Y', Update_priv='Y' WHERE User='client';


/*
	Add data to join-tables
*/
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Donald Trump" && t_book.Isbn = 1231237;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Donald Trump" && t_book.Isbn = 2222237;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Leo Nardo" && t_book.Isbn = 7395726;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "karl Enfors" && t_book.Isbn = 8283657;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Jonas Granit" && t_book.Isbn = 9285638;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Karl Karlsson" && t_book.Isbn = 9876345;
insert into rt_writing(authorID, Isbn) select t_author.authorID, t_book.Isbn from t_author, t_book where t_author.namn LIKE "Leo Nardo" && t_book.Isbn = 9876345;

insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Horror" && t_book.Isbn = 1231237;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Adventure" && t_book.Isbn = 2222237;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Crime" && t_book.Isbn = 7395726;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Horror" && t_book.Isbn = 7395726;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Fantasy" && t_book.Isbn = 8283657;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Thriller" && t_book.Isbn = 9285638;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Sci-fi" && t_book.Isbn = 9876345;
insert into rt_bookgenres(TypeID, Isbn) select t_genre.TypeID, t_book.Isbn from t_genre, t_book where t_genre.TypeName LIKE "Fantasy" && t_book.Isbn = 9876345;



#Big join.
select Title, t_book.Isbn, ReleaseYr, namn, typename 
from (t_genre inner join 
		(rt_bookgenres inner join 
			(t_author inner join 
				(rt_writing inner join 
					t_book on rt_writing.Isbn = t_book.Isbn) on t_author.authorID = rt_writing.authorID) 
				on rt_bookgenres.Isbn LIKE t_book.Isbn) 
			on t_genre.TypeID = rt_bookgenres.TypeID) where t_book.Isbn = 7395726;

/*
delete from t_author;
delete from t_book;
delete from t_review;
delete from rt_bookgenres;
delete from rt_writing;
*/


