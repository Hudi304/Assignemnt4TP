package business.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
	
	//ceva hashmap<Order List<MenuItem >>
	
	public String FilePath = "E:\\JavaProjects\\Assignment4\\src\\main\\resources\\restaurant.ser";
	
	
	private List<BaseProductLeaf> bMenu = new ArrayList<>();
	private List<CompositeProduct> cMenu = new ArrayList<>();
	 
	
	private List<MenuItem> Menu = new ArrayList<>();
	
	private  HashMap<Order, List<MenuItem>> orders = new HashMap<Order, List<MenuItem>>();
	// key, value
	
			public Restaurant() {
//				BaseProductLeaf  bProd = new BaseProductLeaf("branza",12);
//				bMenu.add(bProd);
//				BaseProductLeaf  bProd1 = new BaseProductLeaf("rosii",2);
//				bMenu.add(bProd1);
//				BaseProductLeaf  bProd2 = new BaseProductLeaf("castraveti",3);
//				bMenu.add(bProd2);
//				BaseProductLeaf  bProd3 = new BaseProductLeaf("ceapa",5);
//				bMenu.add(bProd3);
//				// get everythign from file to here
//				CompositeProduct cProd = new CompositeProduct("Pizza", 50);
//				cProd.addComp(bProd);
//				cProd.addComp(bProd1);
//				cProd.addComp(bProd2);
//				cProd.addComp(bProd3);
//				cMenu.add(cProd);
			}

	public List<BaseProductLeaf> getbMenu() {
		return bMenu;
	}
	public void setbMenu(List<BaseProductLeaf> bMenu) {
		this.bMenu = bMenu;
	}
	public List<CompositeProduct> getcMenu() {
		return cMenu;
	}
	public void setcMenu(List<CompositeProduct> cMenu) {
		this.cMenu = cMenu;
	}

	public void printBMenu(){
		System.out.println("Menu:");
		for (BaseProductLeaf baseProductLeaf : bMenu) {
			System.out.println("   " + baseProductLeaf.getName() + " " + baseProductLeaf.getPrice());
		}
	}
	public void printCMenu(){
		System.out.println("Menu:");
		for (CompositeProduct cp : cMenu) {
			System.out.println("   " + cp.getName() + " " + cp.getPrice());
		}
	}
	
	public void writeMenuToFile(){
		try {
			 
            FileOutputStream fileOut = new FileOutputStream(FilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bMenu);
            objectOut.writeObject(cMenu);
            objectOut.close(); 
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	
	public void readToFromFile(){
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream fileIn = new FileInputStream(FilePath); 
	            ObjectInputStream in = new ObjectInputStream(fileIn); 
	            
	            
	            bMenu = (List<BaseProductLeaf>)in.readObject();
	            cMenu = (List<CompositeProduct>)in.readObject();  
	            in.close(); 
	            fileIn.close(); 
	              
	            System.out.println("Object has been deserialized "); 
	           
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
	
	public List<BaseProductLeaf> getMenu() {
		return bMenu;
	}
	public void addBasicproduct(BaseProductLeaf bProd){
		bMenu.add(bProd);
	}
	public HashMap<Order, List<MenuItem>> getOrders() {
		return orders;
	}
	public void setOrders(HashMap<Order, List<MenuItem>> orders) {
		this.orders = orders;
	}
}
