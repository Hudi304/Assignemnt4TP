package business.Model;

import java.sql.Date;

public class Order {

	private int orderID;
	private Date date;
	private int table;
	
	
	
	public Order(){
		
	}
	
	
	public int hashCode() {
		int result = 53;
		
		result = result * 59 + orderID;
		result = result * 59 + date.hashCode();
		result = result * 59 + table;

		return orderID;
	}

	
	
	
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	
}
