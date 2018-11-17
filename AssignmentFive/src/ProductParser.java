//Assignment #: Arizona State University Assignment #5
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00-7:15pm
//  Description: ProductParser takes in a string with words separated
//				 by "/".  It then decides if the string is a food or
//				 clothing.  Once it has decided it then creates the 
//				 new food/clothing and adds the info for it

public class ProductParser {

	private static String id;
	private static int quant;
	private static double price;
	private static String size;
	private static String color;
	private static String food;
	private static double damage;
	private static String expire;

	public static Product parseStringToProduct(String lineToParse) { //parses the string and assigns it as clothing or food
		String[] parts = lineToParse.split("/");
		parts[0] = parts[0].toLowerCase();

		if (parts[0].equals("clothing")) {
			id = parts[1];
			quant = Integer.parseInt(parts[2]);
			price = Double.parseDouble(parts[3]);
			size = parts[4];
			color = parts[5];
			Clothing clothes = new Clothing(id, quant, price, size, color);
			return clothes;
		}

		else if (parts[0].equals("food")) {
			id = parts[1];
			quant = Integer.parseInt(parts[2]);
			price = Double.parseDouble(parts[3]);
			food = parts[4];
			damage = Double.parseDouble(parts[5]);
			expire = parts[6];
			Food fd = new Food(id, quant, price, food, damage, expire);
			return fd;
		}

		else {
			return null;
		}
	}

}
