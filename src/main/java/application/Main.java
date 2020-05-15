package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/AdminGUI.fxml"));
			Parent root = loader.load();
		
			//scene.getStylesheets().add(getClass().getResource("sample.fxml").toExternalForm());
			 
		     primaryStage.setTitle("Admin Controller");
		     primaryStage.setScene(new Scene(root, 600, 275));
		     primaryStage.show();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
