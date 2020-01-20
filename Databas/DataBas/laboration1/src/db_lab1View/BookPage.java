package db_lab1View;


import java.util.ArrayList;
import java.util.List;

import javax.swing.event.HyperlinkEvent.EventType;

import com.mysql.cj.util.StringUtils.SearchMode;

import db_lab1.model.BookApp;
import db_lab1.representation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookPage extends VBox{
	
	Scene scene;
	
    private TableView<Book> booksTable;
    private ObservableList<Book> booksInTable; // the data backing the table view
    
    private TableView<Author> authorTable;
    private ObservableList<Author> authorInTable; // the data backing the table view

    private ComboBox<SearchMode> searchModeBox;
    private TextField searchField;
    private Button searchButton;

    private MenuBar menuBar;
    BorderPane mainPane;
	
    
	public BookPage() {
		//TextField
		//ComboBox

	}
	
	
	public void displayBooks(List<Book> books) {
		
		if(books == null) {
			System.out.println("Cannot display stuff...");
			return;
		}
		
		mainPane.setCenter(booksTable);
        booksInTable.clear();
        booksInTable.addAll(books);


        
    }
	public void displayAuthor(List<Author> authors) {
		
		if(authors == null) {
			System.out.println("Cannot display stuff...");
			return;
		}
		
		mainPane.setCenter(authorTable);	
        authorInTable.clear();
        authorInTable.addAll(authors);

    }
	
	public void start(PageController control) {
		
		control.setView(this);
        booksInTable = FXCollections.observableArrayList();
        authorInTable = FXCollections.observableArrayList();
        
        initBooksTable();
        initAuthorTable();
		initSearchView(control);
        initMenus(control);

        FlowPane bottomPane = new FlowPane();
        bottomPane.setHgap(10);
        bottomPane.setPadding(new Insets(10, 10, 10, 10));
        //bottomPane.getChildren().addAll(searchModeBox, searchField, searchButton);

        
        mainPane = new BorderPane();
        mainPane.setCenter(authorTable);
        mainPane.setBottom(bottomPane);
        mainPane.setPadding(new Insets(10, 10, 10, 10));        

        mainPane.setTop(menuBar);;
        this.getChildren().addAll(mainPane);
        
        VBox.setVgrow(mainPane, Priority.ALWAYS);

        
	}
	private void initMenus(PageController control) {

        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				javafx.application.Platform.exit();
			}        	
        });
        
        fileMenu.getItems().addAll(exitItem);

        Menu searchMenu = new Menu("Search");
        MenuItem titleItem = new MenuItem("Title");
        titleItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				control.onSearchBook(true, Popup.titleSearch());
			}
        });
        
        MenuItem isbnItem = new MenuItem("ISBN");
        isbnItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				control.onSearchBook(false, Popup.IsbnSearch());
			}
        });
        MenuItem authorItem = new MenuItem("Author");
        authorItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				control.onSearchAuthor(Popup.authorSearch());
			}
        });
        searchMenu.getItems().addAll(titleItem, isbnItem, authorItem);

        Menu manageMenu = new Menu("Manage");
        MenuItem addItem = new MenuItem("Add");
        addItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				switch (Popup.addWhat().charAt(0)) {
				case 'A':
					
				break;
				case 'B':
					control.addBook(Popup.addBook());
				break;
				case 'R':
				
				break;
				default:
					break;
				}
				
			}        	
        });
        
        manageMenu.getItems().addAll(addItem);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, searchMenu, manageMenu);
		
	}

	private void initBooksTable() {
        booksTable = new TableView<>();
        booksTable.setEditable(false); // don't allow user updates (yet)

        
        // define columns
        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        TableColumn<Book, String> isbnCol = new TableColumn<>("ISBN");
        TableColumn<Book, String> publishedCol = new TableColumn<>("Published");
        booksTable.getColumns().addAll(titleCol, isbnCol, publishedCol);
        // give title column some extra space
        titleCol.prefWidthProperty().bind(booksTable.widthProperty().multiply(0.5));

        // define how to fill data for each cell, 
        // get values from Book properties
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        publishedCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("release"));
        
        // associate the table view with the data
        booksTable.setItems(booksInTable);
		
	}
	
	private void initAuthorTable() {
		authorTable = new TableView<>();
        authorTable.setEditable(false); // don't allow user updates (yet)

        // define columns
        TableColumn<Author, String> authorIDCol = new TableColumn<>("AuthorID");
        TableColumn<Author, String> nameCol = new TableColumn<>("Name");
        authorTable.getColumns().addAll(authorIDCol, nameCol);

        authorIDCol.setCellValueFactory(new PropertyValueFactory<>("authorID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        // associate the table view with the data
        authorTable.setItems(authorInTable);
		
	}

	private void initSearchView(PageController controller) {
        searchField = new TextField();
        searchField.setPromptText("Search for...");
        searchModeBox = new ComboBox<>();
        searchModeBox.getItems().addAll(SearchMode.values());
        //searchModeBox.setValue(SearchMode.Title);
        searchButton = new Button("Search");
        
        // event handling (dispatch to controller)
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String searchFor = searchField.getText();
                SearchMode mode = searchModeBox.getValue();
                controller.onSearchSelected(searchFor, mode);
            }
        });
    }
	
	
}