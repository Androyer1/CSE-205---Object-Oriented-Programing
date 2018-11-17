//Assignment #: Arizona State University Assignment #5
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00-7:15pm
//  Description: Food is a product.  It assigns a product as a food and gives
//				 the product all specifications such as product ID etc.  It computes
//				 the total cost when called from the unit price and quantity and formats
//				 the results with 2 decimal places.

import java.text.NumberFormat;

public class Food extends Product {

	private String name;
	private double damageRate;
	private String expirationDate;
	NumberFormat percent = NumberFormat.getPercentInstance();
	
	public Food(String id, int num, double unit, String food, double damage, String expiration)  //default constructor
	{
		super(id, num, unit);
		productId = id;
		quantity = num;
		unitPrice = unit;
		name = food;
		damageRate = damage;
		expirationDate = expiration;
	}
	
	public String getProductId()  //returns product ID
	{
		return super.getProductId();
	}
	
	public String toString()  //formats toString to print out given information with the Product class
	{
		percent.setMinimumFractionDigits(2);
		percent.setMaximumFractionDigits(2);
		return "\nFood:"
				+ super.toString()
				+ "Food Name:\t\t" + name
				+ "\nDamage Rate:\t\t" + percent.format(damageRate)
				+ "\nExpiration Date:\t" + expirationDate + "\n";
	}
	
	public void computeTotalCost()  //computes the total cost
	{
		totalCost = (unitPrice * quantity)*(1 + damageRate);
	}
	
}
