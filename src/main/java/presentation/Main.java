package presentation;
	
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import business.Model.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application implements Initializable {
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	
	}
	
	

	@Override
	public void start(Stage primaryStage) {
		
		

		Restaurant restaurant = new Restaurant();
		restaurant.readToFromFile();
		// Admin
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/AdminGUI.fxml"));
			Parent root = loader.load();
			 
			AdminGUI adGUI = loader.getController();
			adGUI.setRestaurant(restaurant);
			
		    primaryStage.setTitle("Admin Controller");
		    primaryStage.setScene(new Scene(root, 630, 400));
		    adGUI.refreshComboBox();
		    primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//waiter	
//		try {
//			
//				Stage waiterStage = new Stage();
//				FXMLLoader loader = new FXMLLoader();
//				loader.setLocation(getClass().getResource("/WaiterGUI.fxml"));
//				Parent root = loader.load();
//				
//				//WaiterGUI wtGUI = loader.getController();
//				//wtGUI.setRestaurant(restaurant);
//				
//				waiterStage.setTitle("Waiter Controller");
//				waiterStage.setScene(new Scene(root, 600, 400));
//				waiterStage.show();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
			
			restaurant.writeMenuToFile();
		}
	
	public static void main(String[] args) {
		
		launch(args);
	}

	
	
	
}