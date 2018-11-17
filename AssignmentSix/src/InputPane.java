// Assignment #: Arizona State University CSE205 #6
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: InputPane generates a pane where a user can enter
//  a laptop information and create a list of available laptops.

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class InputPane extends HBox
{
	//GUI components
   private ArrayList<Laptop> laptopList;
   private TextArea laptops;
   private Label response;
   private Label brand;
   private Label model;
   private Label cpu;
   private Label ram;
   private Label price;
   private TextField tBrand;
   private TextField tModel;
   private TextField tCPU;
   private TextField tRAM;
   private TextField tPrice;
   private Button enter;

   //The relationship between InputPane and PurchasePane is Aggregation
   private PurchasePane purchasePane;
   //----

	//constructor
	public InputPane(ArrayList<Laptop> list, PurchasePane pPane)
	{
		this.laptopList = list;
		this.purchasePane = pPane;
		

		//Step #1: initialize each instance variable and set up the layout
		//----
		this.response = new Label("");
		this.brand = new Label("Brand");
		this.model = new Label("Model");
		this.cpu = new Label("CPU(GHz)");
		this.ram = new Label("RAM(GB)");
		this.price = new Label("Price($)");
		this.enter = new Button("Enter a Laptop Info.");
		
		this.tBrand = new TextField();
		this.tModel = new TextField();
		this.tCPU = new TextField();
		this.tRAM = new TextField();
		this.tPrice = new TextField();
		

		//create a GridPane hold those labels & text fields
		//consider using .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
		//----
		GridPane left = new GridPane();
		left.setAlignment(Pos.TOP_LEFT);
		left.setHgap(5);
		left.setVgap(5);
		left.setPadding(new Insets(20));
		

   		//Set up the layout for the left half of the InputPane.
   		//----
		response.setTextFill(Color.web("#FF0000"));
		left.add(response, 0, 1, 2, 1);
		left.add(brand, 0, 2);
		left.add(tBrand, 1, 2);
		left.add(model, 0, 3);
		left.add(tModel, 1, 3);
		left.add(cpu, 0, 4);
		left.add(tCPU, 1, 4);
		left.add(ram, 0, 5);
		left.add(tRAM, 1, 5);
		left.add(price, 0, 6);
		left.add(tPrice, 1, 6);
		left.add(enter, 1, 7);


   		//the right half of the InputPane is simply a TextArea object
   		//Note: a ScrollPane will be added to it automatically when there are no
   		//enough space
		GridPane right = new GridPane();
		laptops = new TextArea();
		laptops.setText("No Laptops");
		laptops.setPrefColumnCount(29);
		laptops.setPrefRowCount(22);
		right.add(laptops, 0, 0);

   		//Add the left half and right half to the InputPane
   		//Note: InputPane extends from HBox
   		//----
		this.getChildren().addAll(left, right);

 	  //Step #3: register source object with event handler
 	  //----
		enter.setOnAction(new ButtonHandler());

	} //end of constructor

  //Step #2: Create a ButtonHandler class
  //ButtonHandler listens to see if the button "Enter a Laptop Info." is pushed or not,
  //When the event occurs, it get a laptop's brand, model, CPU, RAM and price
  //Information from the relevant text fields, then create a new Laptop object and add it inside
  //the laptopList. Meanwhile it will display the laptop's information inside the text area.
  //It also does error checking in case any of the textfields are empty or wrong data was entered.
    private class ButtonHandler implements EventHandler<ActionEvent>
   	 {
   	    //Override the abstract method handle()
   	    public void handle(ActionEvent e)
        {
			//declare any necessary local variables here
			//---
   	    	double cpu;
   	    	double ram;
   	    	double price;
   	    	
			//when a text field is empty and the button is pushed
			if ( tBrand.getText().isEmpty() ||
					tModel.getText().isEmpty() ||
					tCPU.getText().isEmpty() ||
					tRAM.getText().isEmpty() ||
					tPrice.getText().isEmpty())
			{
				//handle the case here
				response.setText("Please fill all fields");
				
			}
			else	//for all other cases
         	{
				try {
					boolean duplicate = false;
					cpu = Double.parseDouble(tCPU.getText());
					ram = Double.parseDouble(tRAM.getText());
					price = Double.parseDouble(tPrice.getText());
					Laptop test = new Laptop(tBrand.getText(), tModel.getText(), cpu, ram, price);
					for(Laptop lap: laptopList) {	//tests if the laptop is already in the list
						if(test.getBrand().equals(lap.getBrand()) &&
								test.getModel().equals(lap.getModel()) &&
								test.getCPU() == lap.getCPU() &&
								test.getRAM() == lap.getRAM()) {
							response.setText("Laptop not added - duplicate");
							duplicate = true;
						}
					}
					if(!duplicate) {
						laptopList.add(test);	//adds the laptop if it is not a duplicate
						response.setText("Laptop added.");
						purchasePane.updateLaptopList(test);	//updates the laptoplist in PurchasePane
						
						laptops.setText("");
						for(int i = 0; i < laptopList.size(); i += 2) {
							laptops.setText(laptops.getText() + laptopList.get(i).toString());	//prints the laptops in the textArea
						}
					
						//resets the text boxes to blank if a laptop is added
						tBrand.setText("");
						tModel.setText("");
						tCPU.setText("");
						tRAM.setText("");
						tPrice.setText("");
					}

				}
				catch(NumberFormatException exception) {	//catches if the inputs for cpu, ram, and price are not numbers
					response.setText("Incorrect data format");
				}
            }
      } //end of handle() method
   } //end of ButtonHandler class

}