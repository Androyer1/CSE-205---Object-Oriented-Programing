//Assignment #: Arizona State University Assignment #5
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00-7:15pm
//  Description: Clothing is a product.  It assigns a product as clothing and gives
//				 the product all specifications such as product ID etc.  It computes
//				 the total cost when called from the unit price and quantity.

public class Clothing extends Product {

	private String size;
	private String color;

	public Clothing(String id, int num, double unit, String siz, String colr) {  //default constructor
		super(id, num, unit);
		productId = id;
		quantity = num;
		unitPrice = unit;
		size = siz;
		color = colr;
	}

	public String getProductId() {  //returns product ID
		return super.getProductId();
	}

	public String toString() {  //formats the toString to print out given information with the Product class
		return "\nClothing:" + super.toString() + "Size:\t\t\t" + size + "\nColor:\t\t\t" + color + "\n";
	}

	public void computeTotalCost() {  //computes the total cost
		totalCost = unitPrice * quantity;
	}

}
