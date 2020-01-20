package db_lab1.representation;

import java.util.ArrayList;

public class AuthorWriting {
	
	private ArrayList<Author> authors;
	private int bookIsbn;
	
	public AuthorWriting(ArrayList<Author> author, int isbn){
		bookIsbn = isbn;
		authors = author;
		
	}
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	public void setAuthor(ArrayList<Author> author) {
		this.authors = author;
	}
	public int getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	

}
