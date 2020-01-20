package db_lab1.model;


import java.util.ArrayList;

import db_lab1.representation.Author;
import db_lab1.representation.Book;
import db_lab1.representation.Review;
import db_lab1View.BookPage;
import db_lab1View.PageController;

public class BookApp extends Thread{
	
	private String usrName;
	private String usrPwd;
	private AppState state;
	private DbHandler db;
	
	
	
	/* TODO....
	 * *********
	 * Funktionalitet
	 * 		- Object motsvarar tabller CHECK
	 * 		- Rollback för transaktioner (Spara Old -> KOntrollera -> Spara eller rollback) CHECK
	 * 		Klient:
	 * 			Lägga till via Dialog.
	 * 			- Lägga till böcker (INSERT)
	 * 			- Lägga till författare
	 * 			- Lägga till reviews
	 * 				- Till bok
	 * 		
	 * 			- Sökning
	 * 				
	 * 			- Transaktioner
	 * 				* Auto commit off
	 * 				* Commit när allt genomförts som det ska.
	 * 			
	 * 			- Genre som multivärde attribut (arraylist) istället för ....
	 * 
	 * 			-Combobox
	 * 
	 * */
	
	
	
	public BookApp() {
		setUserName(null);
		setUserPassword(null);
		state = AppState.STATE_Login;
		db = new DbHandler();
		db.connect();
	}
	

	public String getUserName() {return usrName;}
	public void setUserName(String usrName) { this.usrName = usrName;}
	public String getUserPassword() {	return usrPwd;}
	public void setUserPassword(String usrPwd) {this.usrPwd = usrPwd;}
	public AppState getAppState() {return state;}
	
	public void run() {
		
	}
	
	public void searchBooksbyTitle(String keyword, BookPage gui) {
		
		//System.out.println(db.searchBooksbyTitle(keyword));
		
		javafx.application.Platform.runLater(
			new Runnable() {
				public void run() {
					ArrayList<Book> search = db.searchBooksbyTitle(keyword);
					
					if(search == null) {
						System.out.println("Nothing found...");
						return;
					}
					
					gui.displayBooks(search);
			}
		});
	}
	
	public void searchBooksbyIsbn(int keyword, BookPage gui) {
		
		//System.out.println(db.searchBooksbyTitle(keyword));
		
		javafx.application.Platform.runLater(
			new Runnable() {
				public void run() {
					ArrayList<Book> search = db.searchBooksbyIsbn(keyword);
					
					if(search == null) {
						System.out.println("Nothing found...");
						return;
					}
					
					gui.displayBooks(search);
			}
		});
	}
	
	public void searchAuthorbyName(String keyword, BookPage gui) {
		
		//System.out.println(db.searchBooksbyTitle(keyword));
		
		javafx.application.Platform.runLater(
			new Runnable() {
				public void run() {
					ArrayList<Author> search = db.searchAuthorByName(keyword);
					if(search == null) {
						System.out.println("Nothing found...");
						return;
					}
					
					gui.displayAuthor(search);
			}
		});
	}
	
	
	public boolean addBook(int isbn, String title, String release, ArrayList<Author> newAuthor, ArrayList<String> genres) {
		Book newBook = new Book(isbn, title, release, genres, newAuthor);
		db.addBook(newBook);
		return true;
	}
	public boolean addBook(Book newBook) {
		db.addBook(newBook);
		return true;
	}
	
	/*Add review.
	 * 
	 * @returns attempt was successul
	 * */
	public boolean addReview(String message, int score, Book reviewFor) {
		
		if(score > 5) {
			score = 5;
		}
		if(score < 0) {
			score = 0;
		}
		Review newReview = new Review(message, score, reviewFor);
		
		
		return false;
	}

	/*Add Author.
	 * 
	 * @returns attempt was successul
	 * */
	public boolean addAuthor(String name) {

		Author newAuthor = new Author(name);
		db.addAuthor(newAuthor);
		
		
		return false;
	}	
	

	/*Enumeration for states app may be in.
	 * Restrict some app-functionality 
	 * depending on this state.
	 * 
	 * */
	public enum AppState{
		STATE_Login,
		STATE_Client,
		STATE_Admin,
		STATE_MAX
	}


	public void disconnect() {
		
		db.disconnect();

	}
	
	
	
	
}
