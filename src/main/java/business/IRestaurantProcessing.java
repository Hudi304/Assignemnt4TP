package business;

import business.Model.Order;

public interface IRestaurantProcessing {

	//todo  Design by contract ??
	
	// administrator 
	
	public void createNewMenuItem();
	
	public void editMenuItem();
	
	public void deleteMenuItem();
	
	
	// waiter 
	
	public void createOrder();
	
	public int computePrice(Order order);
	
	public void generateBill(String path);
	
	
}
