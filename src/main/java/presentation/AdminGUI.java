package presentation;

import java.net.URL;
import java.text.spi.BreakIteratorProvider;
import java.util.ResourceBundle;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.prng.BasicEntropySourceProvider;

import business.Model.BaseProductLeaf;
import business.Model.CompositeProduct;
import business.Model.MenuItem;
import business.Model.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class AdminGUI implements IAdminGUI, Initializable {

	public Restaurant restaurant;
	public CompositeProduct compPorod;

	public TextField textFldName;
	public TextField textFldPrice;
	public Button AddButton;
	
	
	public TextField textFldCName;
	public TextField textFldCPrice;
	public ComboBox<String> comboBox;
	
	public TreeView<String> treeView = new TreeView<>();
	public TreeItem treeRoot;
	public TreeItem<String> treeItems;
	
	public Button addBProd;
	public Button saveCompProd;
	
	public Button saveToFile;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		compPorod  = new CompositeProduct();
	}
	
	//constructor gol
	//TODO refresh MenuTable 
		public void saveRestToFile(){
			restaurant.writeMenuToFile();
		}
	
		public void refreshComboBox(){
			comboBox.getItems().clear();
			for (BaseProductLeaf bp : restaurant.getMenu()) {
				comboBox.getItems().add(bp.getName() + " " + bp.getPrice() + " lei");
			}
		}

		public void addBasicProduct(){
			AddButton.setText("Controlez din admin controller");
			BaseProductLeaf bProd = new BaseProductLeaf(textFldName.getText(),Integer.parseInt(textFldPrice.getText()));
			restaurant.addBasicproduct(bProd);
			restaurant.printBMenu();
			restaurant.printCMenu();
			refreshComboBox();
		}
		
		public void addBProdToCompProd(){
			
			String strBProdFromComboBox = comboBox.getValue().toString();
			String splitCB[] = strBProdFromComboBox.split("\\s");
			
			
			
			// basic Product
			BaseProductLeaf bProd =  new BaseProductLeaf(splitCB[0],Integer.parseInt(splitCB[1]));
			
			//System.out.println(splitCB[0] + " " + Integer.parseInt(splitCB[1]) );
			System.out.println(bProd.getName() + bProd.getPrice());
			
			// construieste obiectul daca instanta de CPord din GUI e goala
			if(compPorod.getName() ==  null || compPorod.getPrice() == 0){
				compPorod.setName(textFldCName.getText());
				compPorod.setPrice(Integer.parseInt(textFldCPrice.getText()));
				compPorod.getComponents().add(bProd);
				treeRoot = new TreeItem(compPorod.getName() + " " + compPorod.getPrice() + " lei");
				TreeItem child  = new TreeItem(bProd.getName() + " " + bProd.getPrice() + " lei");
				treeRoot.setExpanded(true);
				treeRoot.getChildren().add(child);
				//treeItems.getChildren().add(new TreeItem(bProd.getName() + " " + bProd.getPrice() + " lei"));
				treeView.setRoot(treeRoot);
				
			}else{
				TreeItem child  = new TreeItem(bProd.getName() + " " + bProd.getPrice() + " lei");
				treeRoot.getChildren().add(child);
				compPorod.getComponents().add(bProd);
				compPorod.setPrice(compPorod.getPrice() + bProd.getPrice());
				String CPprice = compPorod.getPrice() +"";
				textFldCPrice.setText(CPprice);
				
			}
			
			//System.out.println(comboBox.getValue().toString());
			
			System.out.println(compPorod.getName() +" nr of components" + compPorod.getComponents().size());
			
			
			
		}
		
		public void saveCompProd(){
			System.out.println("o intrat bine ");
			CompositeProduct cProd;
			try {
				 cProd = new CompositeProduct(textFldCPrice.getText(),Integer.parseInt(textFldCPrice.getText()));
			}catch (Exception e) {
				System.out.println("null" + "null");
				// TODO: handle exception
			}
		
			System.out.println(comboBox.getValue().toString());
			//System.out.println(bProducts.set);
			refreshComboBox();
		}
		
		public void getBProdName(){
			System.out.println(textFldName.getText());
		}



	@Override
	public void addBaseProduct(BaseProductLeaf bProd) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteBaseProduct(BaseProductLeaf bProd) {
		// TODO Auto-generated method stub
	}

	@Override
	public void editBaseProduct(BaseProductLeaf bProd) {
		// TODO Auto-generated method stub
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public CompositeProduct getCompPorod() {
		return compPorod;
	}

	public void setCompPorod(CompositeProduct compPorod) {
		this.compPorod = compPorod;
	}

	
	
	
	
}
