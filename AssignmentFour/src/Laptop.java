// Assignment : Arizona State U. CSE205 #4
// Name: Andrew Miller
// StudentID: 1214962229
// Lecture: MW 6:00-7:15pm
// Description: This class contains mutator and accessor methods 
//        as well as a toString method to convert all values into strings.
//        This class creates a laptop and gives it a brandName, model, and price.

import java.text.DecimalFormat;

public class Laptop {
	
	private String brandName;
	private Model model;
	private double price;
	private String pattern = "#0.00";
	private String dollars = "$0.00";
	private DecimalFormat decimalFormat = new DecimalFormat(pattern);
	private DecimalFormat dollarFormat = new DecimalFormat(dollars);
	
	public Laptop() {
		brandName = "unknown";
		price = 0.00;
	}
	
	public String getBrand() {
		return brandName;
	}
	
	public Model getModel() {
		return model;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setBrand(String newBrand) {
		brandName = newBrand;
	}
	
	public void setModel(String newModel, double newCPU, int newRAM) {
		model = new Model();
		model.setModel(newModel);
		model.setCPU(newCPU);
		model.setRAM(newRAM);
	}
	
	public void setPrice(double newPrice) {
		String format = decimalFormat.format(newPrice);
		price = Double.parseDouble(format);
	}
	
	public String toString() {
		return "\nBrand:\t" + getBrand() + "\n"
				+ getModel()
				+ "Price:\t" + dollarFormat.format(getPrice()) + "\n\n";
	}
}
