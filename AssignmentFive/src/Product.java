
//Assignment #: Arizona State University Assignment #5
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00-7:15pm
//  Description: Product creates the methods that clothing and food will
//				 be created with.  It is the parent class and provides the
//				 basis for its inheritors.

import java.text.*;

public abstract class Product {

	protected String productId;
	protected int quantity;
	protected double unitPrice;
	protected double totalCost;
	NumberFormat Format = NumberFormat.getCurrencyInstance();

	public Product(String id, int num, double unit) {  //default constructor
		productId = "?";
		quantity = 0;
		unitPrice = 0.0;
		totalCost = 0.0;
	}

	public String getProductId() {  //returns product ID
		return productId;
	}

	public String toString() {  //formats toString to display given information
		return "\nProduct ID:\t\t" + getProductId() + "\nQuantity:\t\t" + quantity + "\nUnit Price:\t\t"
				+ Format.format(unitPrice) + "\nTotal Cost\t\t" + Format.format(totalCost) + "\n";
	}

	public void computeTotalCost() {  //compute the total cost

	}

}
