package db_lab1View;

import java.util.List;

import com.mysql.cj.util.StringUtils.SearchMode;

import db_lab1.model.BookApp;
import db_lab1.representation.*;

public class PageController {
	

    private BookPage booksView; // view
    private BookApp booksDb; // model
    

    public PageController() {
    	
    }
    
    public void setModel(BookApp currentModel) {	
    	this.booksDb = currentModel;
    	
    }
    public void setView(BookPage currentModel) {	
    	this.booksView = currentModel;
    	
    }
    
    public void selectBooks() {
    	booksDb.searchBooksbyTitle("", booksView);
    }
    
    public void onSearchBook(boolean forTitle, Object keyword) {
    	
    	if(forTitle) {
    		booksDb.searchBooksbyTitle((String) keyword, booksView);
    		return;	
    	}
    	booksDb.searchBooksbyIsbn((int)keyword, booksView);
    	
    }
    
    public void onSearchAuthor(String keyword) {
    	booksDb.searchAuthorbyName(keyword, booksView);
    }
    
    public void onAdd() {
    	
    	
    }

    protected void onSearchSelected(String searchFor, SearchMode mode) {
    	/*
    	try {
            if (searchFor != null && searchFor.length() > 1) {
                List<Book> result = null;
                switch (mode) {
                    case Title:
                        result = booksDb.searchBooksbyTitle(searchFor);
                        break;
                    case ISBN:
                        // ...
                        break;
                    case Author:
                        // ...
                        break;
                    default:
                }
                
                if (result == null || result.isEmpty()) {
                    booksView.showAlertAndWait(
                            "No results found.", INFORMATION);
                } else {
                    booksView.displayBooks(result);
                }
            } else {
                booksView.showAlertAndWait(
                        "Enter a search string!", WARNING);
            }
        } catch (Exception e) {
            booksView.showAlertAndWait("Database error.",ERROR);
        }
        */
    }

    // TODO:
    // Add methods for all types of user interaction (e.g. via  menus).
	public void addBook(String title, int Isbn, String[] authorFname, String[] authorLname) {
		
		//Make runnable to UI thread.
		//Add book, author and relations
		//...->Update UI
		
		
	}
	public void addBook(Book bookToAdd) {
		booksDb.addBook(bookToAdd);
	}
	
	
	

}
