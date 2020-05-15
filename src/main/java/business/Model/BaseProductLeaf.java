package business.Model;

import java.io.Serializable;

import business.Observable;

public class BaseProductLeaf implements MenuItem, Serializable, Observable {

	
	/**
	 * 
	 */
	private String name;
	private int price;
	private static final long serialVersionUID = 1L;

	
	public BaseProductLeaf() {
		
	}
	
	public BaseProductLeaf(String name, int price) {
		this.setName(name);
		this.setPrice(price);
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

	@Override
	public int computePrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String tooString() {
		return "Name: " + this.getName() + " Price: " + this.getPrice() + "\n";		
		// TODO Auto-generated method stub
		
	}
	

}
