// Assignment #: Arizona State University CSE205 #6
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: The Laptop class represent a laptop with information
//  such as its brand, model, CPU, RAM and price.

import java.text.DecimalFormat;

public class Laptop
{
   private String brand, model;	//brand & model of the laptop
   private double CPU, RAM;		//CPU in GHz, RAM in GB
   private double price;

   //Constructor. It initializes all instance variables to their default values.
   public Laptop()
   {
     brand = new String("?");
     model = new String("?");
     CPU = 0.0;
     RAM = 0.0;
     price = 0.0;
   }

   //Overloaded constructor, used to initialize all instance varibles
   public Laptop(String nBrand, String nModel, double CPU, double RAM, double nPrice)
   {
      brand = nBrand;
      model =nModel;
      this.CPU = CPU;
      this.RAM = RAM;
      price = nPrice;
   }

   //Accessor method of the instance variable brand
   public String getBrand()
   {
     return brand;
   }

   //Accessor method of the instance variable model
   public String getModel()
   {
     return model;
   }

   //Accessor method of the instance variable CPU
   public double getCPU()
   {
     return CPU;
   }

   //Accessor method of the instance variable RAM
   public double getRAM()
   {
     return RAM;
   }

   //Accessor method of the instance variable price
   public double getPrice()
   {
     return price;
   }

   //Mutator method of the instance variable brand
   public void setBrand(String nBrand)
   {
     brand = nBrand;
   }

   //Mutator method of the instance variable model
   public void setModel(String nModel)
   {
     model = nModel;
   }
   //Mutator method of the instance variable price
   public void setPrice(double nPrice)
   {
     price = nPrice;
   }

   //toString method creates a string containing values of
   //instance variables using the specified format and returns it
   public String toString()
   {
     DecimalFormat fmt1 = new DecimalFormat("0.0");
     DecimalFormat fmt2 = new DecimalFormat("$0.00");

     String result = "Brand:\t" + brand +
     				 "\nModel:\t" + model +
      				 "\nCPU:\t\t" + fmt1.format(CPU) +
  					 "\nRAM:\t" + fmt1.format(RAM) +
                     "\nPrice:\t" + fmt2.format(price) + "\n\n";
     return result;
  }
} //end of the Laptop class