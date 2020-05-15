package presentation;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import business.Model.BaseProductLeaf;
import business.Model.Restaurant;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

public class WaiterGUI implements  IWaiterGUI, Initializable  {
	
	public Restaurant restaurant;

	public ComboBox<String> tableCB;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public TreeView<String> CurrentOrder;
	
	public TableView Menu;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
	}

	@Override
	public void createNewOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMenuItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computeBill() {
		// TODO Auto-generated method stub
		
	}

	

}
