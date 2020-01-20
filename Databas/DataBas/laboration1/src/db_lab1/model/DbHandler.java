package db_lab1.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

import db_lab1.representation.Author;
import db_lab1.representation.Book;
import db_lab1.representation.Review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler{

	static Connection conn;
	static String usr;
	static String pwd;
	
	
	public DbHandler() {
		conn = null;
		usr = "root";
		pwd = "root";
		
	}
	
	
	public static void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static boolean connect() {
		
		String database = "laboration1"; // the name of the specific database 
        String server
                = "jdbc:mysql://localhost/"
                		+ database
                		+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(server, usr, pwd);
            System.out.println("Connected!");

        } catch (Exception e) {
            System.out.println("Database error, " + e.toString());
            return false;
        }

    	return true;
	}
	
	
	public ArrayList<Book> searchBooksbyIsbn(int keyword){
		System.out.println("Keyword: " + keyword);
		ArrayList<Book> searchresult = new ArrayList<>();
		try {
			if(!connect()) return null;
			
			String query = "select * from t_Book where position( ? IN t_Book.Isbn) > 0;";
			PreparedStatement searchBooks = conn.prepareStatement(query);
			searchBooks.setInt(1, keyword);
			ResultSet result = searchBooks.executeQuery();
			
			result.last();
			int rows = result.getRow();
			System.out.println("\nSearched for " + keyword + " and found " + result.getRow() + " results...");
			result.first();
			
			System.out.print("\tISBN\t\tReleaseYear\t\tTitle");
			while(rows > 0) {
				//searchresult.add(new Book(0, query, query, null));
				System.out.print("\nFound: ");
				searchresult.add(new Book(result.getInt(1), result.getString(2), result.getString(3)));
				for(int n = 1; n <= result.getMetaData().getColumnCount();n++) {
					System.out.print("\t[" + result.getObject(n) + "]");
					
				}
				result.next();
				rows--;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return searchresult;
	}
	
	public ArrayList<Book> searchBooksbyTitle(String keyword){
		System.out.println("Keyword: " + keyword);
		ArrayList<Book> searchresult = new ArrayList<>();
		try {
			if(!connect()) return null;
			
			String query = "select * from t_Book where position( ? IN t_Book.title) > 0;";
			PreparedStatement searchBooks = conn.prepareStatement(query);
			searchBooks.setString(1, keyword);
			ResultSet result = searchBooks.executeQuery();
			
			result.last();
			int rows = result.getRow();
			System.out.println("\nSearched for " + keyword + " and found " + result.getRow() + " results...");
			result.first();
			
			System.out.print("\tISBN\t\tReleaseYear\t\tTitle");
			while(rows > 0) {
				//searchresult.add(new Book(0, query, query, null));
				System.out.print("\nFound: ");
				searchresult.add(new Book(result.getInt(1), result.getString(2), result.getString(3)));
				for(int n = 1; n <= result.getMetaData().getColumnCount();n++) {
					System.out.print("\t[" + result.getObject(n) + "]");
					
				}
				result.next();
				rows--;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return searchresult;
	}

	public ArrayList<Author> searchAuthorByName(String keyword){
		System.out.println("Keyword: " + keyword);
		ArrayList<Author> searchresult = new ArrayList<>();
		try {
			if(!connect()) return null;
			
			String query = "select * from t_Author where position( ? IN t_Author.namn) > 0;";
			PreparedStatement searchBooks = conn.prepareStatement(query);
			searchBooks.setString(1, keyword);
			ResultSet result = searchBooks.executeQuery();
			
			result.last();
			int rows = result.getRow();
			System.out.println("\nSearched for " + keyword + " and found " + result.getRow() + " results...");
			result.first();
			
			System.out.print("\tID\t\tName\t\t");
			while(rows > 0) {
				//searchresult.add(new Book(0, query, query, null));
				System.out.print("\nFound: ");
				searchresult.add(new Author(result.getString(1)));
				for(int n = 1; n <= result.getMetaData().getColumnCount();n++) {
					System.out.print("\t[" + result.getObject(n) + "]");
					
				}
				result.next();
				rows--;
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return searchresult;
	}
	
	public void addAuthor(Author newAuthor) {
		String query = "insert into T_Author(Namn) values(?)";
		
		System.out.println("Adding author...");
		try {
			if(!connect()) return;
			
			PreparedStatement addAuthor = conn.prepareStatement(query);
			addAuthor.setString(1, newAuthor.getName());
			addAuthor.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("...Author added");
			//Update UI?
		}
	}
	
	public void addReview(Review newReview) {
		String query = "insert into T_Review(Namn) values(?)";
		
		System.out.println("Adding author...");
		try {
			if(!connect()) return;
			
			PreparedStatement addReview = conn.prepareStatement(query);
			addReview.setInt(1, newReview.getScore());
			addReview.setString(2, newReview.getMessage());
			addReview.setInt(3, newReview.getWrittenFor().getIsbn());
			addReview.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("...Author added");
			//Update UI?
		}
	}
	
	
	
	public void addBook(Book newBook) {
		
		String query = "insert into T_book(Isbn, title, releaseYr) values(?,?,?)";
		
		boolean success = true;
		
		try {
			if(!connect()) return;
			
			conn.setAutoCommit(false);
			
			PreparedStatement addBook = conn.prepareStatement(query);
			addBook.setString(2, newBook.getTitle());
			addBook.setInt(1, newBook.getIsbn());
			addBook.setString(3, newBook.getRelease());
			addBook.executeUpdate();
			
			if(newBook.getAuthors()!= null) {
				for(int n = 0; n < newBook.getAuthors().size(); n++) {
					addAuthor(newBook.getAuthors().get(n));
				}
				//Add to RT
			}
			
		} catch (SQLException e) {
			success = false;
		
			e.printStackTrace();

		} finally {	
			try {
				if (success) {
					conn.commit();
				}
				else {
					conn.rollback();
				}
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				//UpdateUI
				
			}
		}
	}

	public void selectBook() {
		
		
		
	}
	
}
