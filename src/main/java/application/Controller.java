package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	
	public Button AddButton;
	
	public TextField textFldName;
	
	
	
	public void handleButtonClick(){
		System.out.println("sasaas");
		System.out.println(textFldName.getText());
		AddButton.setText("stop");
	}
	
	
	public void getBProdName(){
		
		System.out.println(textFldName.getText());
		
	}
	

}
