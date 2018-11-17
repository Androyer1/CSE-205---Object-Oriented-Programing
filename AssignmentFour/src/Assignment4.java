// Assignment : Arizona State U. CSE205 #4
// Name: Andrew Miller
// StudentID: 1214962229
// Lecture: MW 6:00-7:15pm
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String brandName, modelName;
       double price, cpuSpeed;
       int ramSize;

       String line = new String();

       // instantiate a Laptop object
       Laptop laptop1 = new Laptop(); 

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);


       do  // will ask for user input
        {
         System.out.print("What action would you like to perform?\n");
         line = scan.nextLine();

         if (line.length() == 1)
          {
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           // matches one of the case statement
           switch (input1)
            {
             case 'A':   //Add the laptop
               System.out.print("Please enter the laptop information:\n");
               System.out.print("What is the laptop\'s brand?\n");
               brandName = scan.nextLine();
        	   laptop1.setBrand(brandName);

               System.out.print("What is the laptop\'s model?\n");
               modelName = scan.nextLine();

               System.out.print("What is the laptop\'s CPU speed(in GHz)?\n");
               cpuSpeed = Double.parseDouble(scan.nextLine());

               System.out.print("What is the laptop\'s RAM size(in GB)?\n");
               ramSize = Integer.parseInt(scan.nextLine());

               laptop1.setModel(modelName, cpuSpeed, ramSize);

               System.out.print("How much is the laptop\'s price?\n");
               //price = scan.nextDouble();
               price = Double.parseDouble(scan.nextLine());
               laptop1.setPrice(price);

               break;
             case 'D':   //Display Pet
               System.out.print(laptop1);
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
          }
         else
          {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd a Laptop\n" +
                        "D\t\tDisplay the Laptop\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}