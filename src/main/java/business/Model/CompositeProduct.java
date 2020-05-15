package business.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct implements MenuItem, Serializable {
	
	//atribute

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	
	private List<BaseProductLeaf> components;
	
	
	public void removeComp(BaseProductLeaf comp) {
		this.getComponents().remove(comp);
	}
	
	public void addComp(BaseProductLeaf comp) {
		this.getComponents().add(comp);
	}
	
	public  CompositeProduct(){
		this.setName(null);
		this.setPrice(0);
		components = new ArrayList<>();
	}
	
	public CompositeProduct(String name){
		this.setPrice(0);
		this.setName(name);
		components = new ArrayList<>();
	}
	
	public CompositeProduct(String name, int price){
		this.setName(name);
		this.setPrice(price);
		components = new ArrayList<>();
	}
	
	public CompositeProduct(String name, int price, List<BaseProductLeaf> comp){
		this.setName(name);
		this.setPrice(price);
		this.setComponents(components);
	}
	
	
	public int computePrice() {
		int tPrice = 0 ;
		for (BaseProductLeaf comp : components) {
			tPrice += comp.getPrice();
		}
		return tPrice;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<BaseProductLeaf> getComponents() {
		return components;
	}
	public void setComponents(List<BaseProductLeaf> components) {
		this.components = components;
	}

	@Override
	public String tooString() {
		
		String str = "CPName: " + this.getName() + " Price: "+  this.getPrice() + " \n";
		
		for (BaseProductLeaf comp : components) {
			str += "   " + comp.tooString();
		}
		return str;
		// TODO Auto-generated method stub
		
	}


	
	
}
