package db_lab1View;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db_lab1.representation.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

public class Popup {

	
	
	public static String titleSearch() {
		TextInputDialog dialog = new TextInputDialog("titlename...");
		dialog.setTitle("Search...");
		dialog.setHeaderText("Search in book titles");
		dialog.setContentText("Search for:");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			return result.get();
		}
		else
			return "";
	}
	
	public static int IsbnSearch() {
		TextInputDialog dialog = new TextInputDialog("ISBN number...");
		dialog.setTitle("Search...");
		dialog.setHeaderText("Search by ISBN");
		dialog.setContentText("Search for:");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
				return Integer.parseInt(result.get());				
		}
		return -1;
	}
	
	public static String authorSearch() {
		TextInputDialog dialog = new TextInputDialog("author");
		dialog.setTitle("Search...");
		dialog.setHeaderText("Search in author names");
		dialog.setContentText("Search for:");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			return result.get();
		}
		else
			return "";
	}
	
	public static String addWhat() {
		List<String> choices = new ArrayList<>();
		choices.add("Author");
		choices.add("Review");
		choices.add("Book");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("Book", choices);
		dialog.setTitle("");
		dialog.setHeaderText("Add to database");
		dialog.setContentText("Entity: ");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			return result.get();
		}

		return "";
	}
	
	public static Book addBook() {
		Book newBook = null;
		Dialog<Book> d = new Dialog<>();
		d.setTitle("Add...");
		d.setHeaderText("Type fields for new book");
		GridPane fields = new GridPane();
		fields.setHgap(10);
		fields.setVgap(10);
		fields.setPadding(new Insets(0, 10, 0, 10));
		
		TextField BookTitle = new TextField();
		BookTitle.setPromptText("Title");
		fields.add(BookTitle, 0, 1);
		
		
		
		d.showAndWait();
		
		
		return newBook;
	}
	
	
}
