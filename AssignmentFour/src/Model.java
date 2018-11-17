// Assignment : Arizona State U. CSE205 #4
// Name: Andrew Miller
// StudentID: 1214962229
// Lecture: MW 6:00-7:15pm
// Description: The Model class describes the model of a laptop. It contains
//        accessor and mutator methods for the modelName, cpuSpeed, and
//        ramSize.

import java.text.DecimalFormat;
import java.math.BigDecimal;

public class Model {
	
	private String modelName;
	private double cpuSpeed = 0.0;
	private int ramSize = 0;
	private String pattern = "#0.##";
	private DecimalFormat decimalFormat = new DecimalFormat(pattern);
	
	public Model() {
		modelName = "?";
		cpuSpeed = 0.0;
		ramSize = 0;
	}
	
	public String getModel() {
		return modelName;
	}
	
	public double getCPU() {
		return cpuSpeed;
	}
	
	public int getRAM() {
		return ramSize;
	}
	
	public void setModel(String newModel) {
		modelName = newModel;
	}
	
	public void setCPU(double newCPU) {
		cpuSpeed = newCPU;
	}
	
	public void setRAM(int newRam) {
		ramSize = newRam;
	}
	
	public String toString() {
		return "Model:\t" + getModel() + "\n"
				+ "CPU:\t" + decimalFormat.format(getCPU()) + "GHz\n"
				+ "RAM:\t" + getRAM() + "GB\n";
	}
}
