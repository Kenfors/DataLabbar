package db_lab1.representation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Book {
	
	private int isbn;
	private String title;
	private String release;
	private ArrayList<String> genres;
	private ArrayList<Author> authors;
	
	public Book(int isbnIn, String titleIn, String releaseIn, ArrayList<String> genresIn) {
		setIsbn(isbnIn);
		setTitle(titleIn);
		setRelease(releaseIn);
		setGenres(genresIn);
		
	}
	
	public Book(int isbnIn, String titleIn, String releaseIn, ArrayList<String> genresIn, ArrayList<Author> authors) {
		setIsbn(isbnIn);
		setTitle(titleIn);
		setRelease(releaseIn);
		setGenres(genresIn);
		setAuthors(authors);
		
	}
	public Book(int isbnIn, String titleIn, String releaseIn) {
		setIsbn(isbnIn);
		setTitle(titleIn);
		setRelease(releaseIn);
		setGenres(null);
		setAuthors(null);
		
	}

	public int getIsbn() {return isbn;}
	public void setIsbn(int isbn) {this.isbn = isbn;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getRelease() {return release;}
	public void setRelease(String releaseIn) {this.release = releaseIn;}
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	
	
}
