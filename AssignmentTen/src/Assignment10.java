// Assignment #: Arizona State University CSE205 #10
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00 pm
//  Description: The Assignment 10 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class Assignment10
{
   public static void main(String[] args)
   {
      char input1;
       String inputInfo = new String();
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
           System.out.print("\nWhat action would you like to perform?\n");
           line = stdin.readLine().trim();  //read a line
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
           {
             switch (input1)
             {
               case 'L':  // List the LinkedList size
                 System.out.print("The current size is " + list1.size() + "\n");
                 break;

               case 'C':   //Search a string and return its index
                 System.out.print("Please enter a string to search:\n");
                 inputInfo = stdin.readLine().trim();
                 operation2=list1.searchElement(inputInfo);
                 if (operation2 > -1)
                   System.out.print(inputInfo + " found at index " + operation2 + "\n");
                 else
                   System.out.print(inputInfo + " not found\n");
                 break;

               case 'I':   //Insert a String at a specified index
                 System.out.print("Please enter a string to add:\n");
                 String str1 = stdin.readLine().trim();
                 System.out.print("Please enter an index to add:\n");
                 inputInfo = stdin.readLine().trim();
                 int addIndex = Integer.parseInt(inputInfo);
                 list1.insertElement(addIndex, str1);
                 System.out.print(str1 + " is inserted at index " + addIndex + "\n");
                 break;

               case 'G':   //Get the string at a specified index
                 System.out.print("Please enter an index to search:\n");
                 inputInfo = stdin.readLine().trim();
                 int searchIndex = Integer.parseInt(inputInfo);
                 System.out.print("string at index " + searchIndex + " is " + list1.getElement(searchIndex) + "\n");
                 break;

                case 'S':   //Set a new element at specified index
                 System.out.print("Please enter a new string to set:\n");
                 String str2 = stdin.readLine().trim();
                 System.out.print("Please enter an index to set:\n");
                 inputInfo = stdin.readLine().trim();
                 int setIndex = Integer.parseInt(inputInfo);
                 list1.setElement(setIndex, str2);
                 System.out.print(str2 + " is set at index " + setIndex + "\n");
                 break;

               case 'R':   //Remove an element at a specified index
                 System.out.print("Please enter an index to remove:\n");
                 inputInfo = stdin.readLine().trim();
                 int removeIndex = Integer.parseInt(inputInfo);
                 list1.removeElement(removeIndex);
                 System.out.print("string at index " + removeIndex + " is removed\n");
                 break;

                case 'H':   //Count the number of occurences of a specific element
                 System.out.print("Please enter a string to count:\n");
                 inputInfo = stdin.readLine().trim();
                 int counter1 =list1.countHowMany(inputInfo);
                 System.out.print("There are " + counter1 + " " + inputInfo + " found inside the linked list\n");
                 break;

                case 'D':   //Remove all occurences/duplicates of a given element
                 System.out.print("Please enter a string to remove:\n");
                 inputInfo = stdin.readLine().trim();
                 list1.removeDuplicate(inputInfo);
                 System.out.print(inputInfo + " is removed from the linked list\n");
                 break;

                case 'F':   //Insert a given element a number of times at the front of the linked list
                 System.out.print("Please enter a string to insert in front of the list:\n");
                 String str3 = stdin.readLine().trim();
                 System.out.print("Please enter the number of times you want to insert:\n");
                 inputInfo = stdin.readLine().trim();
                 int times = Integer.parseInt(inputInfo);
                 list1.insertAtFront(str3, times);
                 System.out.print(str3 + " is inserted " + times + " times in front of the linked list\n");
                 break;

               case 'B':   //insert a given element before the first occurence of another element
                 System.out.print("Which string do you want to insert before:\n");
                 String str4 = stdin.readLine().trim();
                 System.out.print("Please enter the string you want to insert:\n");
                 inputInfo = stdin.readLine().trim();
                 list1.insertInFront(str4, inputInfo);
                 System.out.print(inputInfo + " is inserted before " + str4 + "\n");
                 break;

                case 'E':   //Append a given element a number of times at the end of the linked list
                 System.out.print("Please enter a string to append at the end:\n");
                 String str5 = stdin.readLine().trim();
                 System.out.print("Please enter the number of times you want to append:\n");
                 inputInfo = stdin.readLine().trim();
                 int times2 = Integer.parseInt(inputInfo);
                 list1.appendAtEnd(str5, times2);
                 System.out.print(str5 + " is appended " + times2 + " times at end of the linked list\n");
                 break;

               case 'A':   //Append a given element after the first occurence of another element
                 System.out.print("Which string do you want to append after:\n");
                 String str6 = stdin.readLine().trim();
                 System.out.print("Please enter the string you want to append:\n");
                 inputInfo = stdin.readLine().trim();
                 list1.appendAfter(str6, inputInfo);
                 System.out.print(inputInfo + " is appended after " + str6 + "\n");
                 break;

                case 'V':   //Reverse the first few element of the linked list
                 System.out.print("Please enter the number of elements you want to reverse:\n");
                 inputInfo = stdin.readLine().trim();
                 int reverseNum = Integer.parseInt(inputInfo);
                 list1.reverse(reverseNum);
                 System.out.print("The first " + reverseNum + " elements are reversed\n");
                 break;

               case 'P':   //print all strings inside the linked list
                 System.out.print(list1.toString());
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
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "L\t\tList Current Size\n" +
                        "C\t\tSearch Element\n" +
                        "I\t\tInsert Element by Index\n" +
                        "G\t\tGet Element by Index\n" +
                        "S\t\tSet Element by Index\n" +
                        "R\t\tRemove Element by Index\n" +
                        "H\t\tCount How Many\n" +
                        "D\t\tRemove Duplicates\n" +
                        "F\t\tInsert at the Front\n" +
                        "B\t\tInsert Before\n" +
                        "E\t\tAppend at the End\n" +
                        "A\t\tAppend After\n" +
                        "V\t\tReverse First Few\n" +
                        "P\t\tPrint Linked List\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");

    } //end of printMenu()
}