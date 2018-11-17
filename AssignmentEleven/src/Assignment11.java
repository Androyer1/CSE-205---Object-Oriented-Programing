// Assignment #: Arizona State University CSE205 #11
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: Assignment 11 class displays a menu of choices to a user
//        		 and performs the chosen task. It will keep asking a user to
//      		 enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
{
   public static void main (String[] args)throws IOException
   {
      char input1;
      String inputInfo;
      String line = new String();
   
      printMenu();
   
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader stdin = new BufferedReader(isr);
   
      do  // will ask for user input
      {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);
      
         if (line.length() == 1)
         {
           // matches one of the case statements
            switch (input1)
            {
               case 'E':   //Enter String
                  System.out.print("Please enter a string.\n");
                  inputInfo = stdin.readLine().trim();
                  System.out.print(InfixToPostfixConverter.convertToPostfix(inputInfo)+"\n");
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


  /** The method printMenu displays the menu to a user**/
   public static void printMenu()
   {
      System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "E\t\tEnter String\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
   }
}