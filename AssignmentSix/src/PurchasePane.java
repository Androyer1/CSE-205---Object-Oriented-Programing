// Assignment #: Arizona State University CSE205 #6
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: PurchasePane displays a list of available laptops
//  from which a user can select to buy. It also shows how many
//  laptops are selected and what is the total amount.


import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class PurchasePane extends VBox
{
   //GUI components
   private ArrayList<Laptop> laptopList, selectedList;

   //laptopLV for top ListView; selectedLV for bottom ListView
   private ListView<Laptop> laptopLV, selectedLV;

   //declare all other necessary GUI variables here
   //----
   private int quantity = 0;
   private double amount = 0;
   private Label qty;
   private Label amt;
   private Label available;
   private Label selected;
   private Button pick;
   private Button remove;
   

 //constructor
   public PurchasePane(ArrayList<Laptop> list)
   {
   	  //initialize instance variables
      this.laptopList = list;
      this.selectedList = new ArrayList<Laptop>();
      

      //set up the layout
      //----
      this.available = new Label("Available Laptops");
      this.selected = new Label("Selected Laptops");
      available.setTextFill(Color.web("#0000FF"));
      selected.setTextFill(Color.web("#0000FF"));
      
      laptopLV = new ListView<Laptop>();
      laptopLV.getSelectionModel().selectFirst();
      laptopLV.setPrefHeight(125);
      for(Laptop lpt: laptopList) {	//adds any existing items in laptopList to the ListView
    	  laptopLV.getItems().add(lpt);
      }
      
      this.pick = new Button("Pick a Laptop");
      this.remove = new Button("Remove a Laptop");
      
      selectedLV = new ListView<Laptop>();
      selectedLV.getSelectionModel().selectFirst();
      selectedLV.setPrefHeight(125);
      
      this.qty = new Label("Qty Selected: 0");
      this.amt = new Label("Total Amt: 00");
      qty.setTextFill(Color.web("#0000FF"));
      amt.setTextFill(Color.web("#0000FF"));
      
   	 //PurchasePane is a VBox - add the components here
   	 //----
      GridPane buttons = new GridPane();
      buttons.setAlignment(Pos.CENTER);
      buttons.setHgap(20);
      buttons.setVgap(20);
      buttons.setPadding(new Insets(20));
      buttons.add(pick, 0, 0);
      buttons.add(remove, 1, 0);
      
      GridPane amounts = new GridPane();
      amounts.setAlignment(Pos.CENTER);
      amounts.setHgap(20);
      amounts.setVgap(20);
      amounts.add(qty, 0, 0);
      amounts.add(amt, 1, 0);
      
      this.getChildren().addAll(available, laptopLV, buttons, selected, selectedLV, amounts);
      
	  //Step #3: Register the button with its handler class
	  //----
     pick.setOnAction(new ButtonHandler2());
     remove.setOnAction(new ButtonHandler2());

   } //end of constructor

 //This method refresh the ListView whenever there's new laptop added in InputPane
 //you will need to update the underline ObservableList object in order for the ListView
 //object to show the updated laptop list
 public void updateLaptopList(Laptop newLaptop)
 {
	 laptopList.add(newLaptop);
	 for(Laptop lap: laptopList) {
		 if(!laptopLV.getItems().contains(lap)) {	//adds the laptop to the list if it is not a duplicate
			 laptopLV.getItems().add(lap);	
		 }
	 }
 }

//Step #2: Create a ButtonHandler class
 private class ButtonHandler2 implements EventHandler<ActionEvent>
 {
  	//Override the abstract method handle()
    public void handle(ActionEvent e)
    {
		//When "Pick a Laptop" button is pressed and a laptop is selected from
		//the top list
    	
        if (!laptopLV.getSelectionModel().isEmpty() && ((Button)e.getSource()).getText() == "Pick a Laptop")
        {
        	boolean duplicate = false;
        	for(Laptop lap: selectedList) {	//checks to see if the item has already been selected
        		if(laptopLV.getSelectionModel().getSelectedItem().equals(lap)) {
        			duplicate = true;
        		}
        	}
        	if(!duplicate) {
        		quantity++;
        		amount += laptopLV.getSelectionModel().getSelectedItem().getPrice();
        		selectedList.add(laptopLV.getSelectionModel().getSelectedItem());
        		selectedLV.getItems().add(laptopLV.getSelectionModel().getSelectedItem());	//adds item to selected list
        	}
        }
        //when "Remove a Laptop" button is pushed and a laptop is selected from
        //the bottom list
        else if (!selectedLV.getSelectionModel().isEmpty() && ((Button)e.getSource()).getText() == "Remove a Laptop")
         {
        	quantity--;
        	amount -= selectedLV.getSelectionModel().getSelectedItem().getPrice();
        	selectedList.remove(selectedLV.getSelectionModel().getSelectedItem());
        	selectedLV.getItems().remove(selectedLV.getSelectionModel().getSelectedItem());	//removes item from selected list
         }
        else if(!selectedLV.getSelectionModel().isEmpty() && ((Button)e.getSource()).getText() == "Pick a Laptop") 
        {
        	//do nothing if the bottom list is selected and pick a laptop is pressed
        }
        
        else if(!laptopLV.getSelectionModel().isEmpty() && ((Button)e.getSource()).getText() == "Remove a Laptop") 
        {
        	//do nothing if the top list is selected and remove a laptop is pressed
        }
        
        else
        {
        	//do nothing for any other case
        }
        
     
      	 //update the QtySelect and AmtSelect labels
      	 //----''
        qty.setText("Qty Selected: " + quantity);	//updates quantity
        amt.setText("Total Amt: " + amount);	//updates total
       }
   } //end of ButtonHandler class
} //end of PurchasePane class