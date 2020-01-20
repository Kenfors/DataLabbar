package db_lab1.model;

import db_lab1View.BookPage;
import db_lab1View.PageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Lab1 extends Application {
	
	private DbHandler db; //Interface for DB
	private BookPage gui; //The View
	private BookApp model;
	private PageController controller;

    public static void main(String[] args) {
        launch(args);
    	
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	controller = new PageController();
    	model = new BookApp();
    	model.start();
    	controller.setModel(model);
    	gui = new BookPage();
    	gui.start(controller);
    	
        Scene scene = new Scene(gui, 800, 600);

        primaryStage.setTitle("Books Database Client");
        // add an exit handler to the stage (X) ?
        primaryStage.setOnCloseRequest(event -> {
            try {
                model.disconnect();
            } catch (Exception e) {}
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    	
        
        //controller.selectBooks();
    	//model.addBook(9876345, "Djungelboken", "1940-08-12");
    	//model.addAuthor("Karl Karlsson");
    	//model.searchBooksbyTitle("a");
    	//model.select("select * from T_Author");
        //model.searchBooksbyIsbn(1, gui);
    	
        controller.onSearchBook(false, 1);
        
        
        
        
        
    }
    
}
