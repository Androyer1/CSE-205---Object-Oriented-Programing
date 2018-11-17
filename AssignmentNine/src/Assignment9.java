
// Assignment #: ASU CSE205 Assignment #9
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00 pm
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the largest number, the count of even numbers (includes both postive and negative),
//  the number of -1 inside the array, and also compute the sum of numbers at
//  odd indexes (i.e. 0, 2, 4, ...), using recursion.

import java.io.*;
import java.util.*;

public class Assignment9 {
	/******************************************************************************
	 *** Complete the main() method. See above program description for details.
	 ******************************************************************************/
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int num;
		int place = 0;
		int[] list = new int[100];
		num = scan.nextInt();
		while (num != 0) {		//adds ints to the array while 0 has not been entered
			list[place] = num;
			place++;
			if (place > 100)
				break;
			num = scan.nextInt();
		}
		int max = findMax(list, 0, place);
		int even = countEven(list, 0, place);
		int negativeOne = countNegativeOne(list, place);
		int sumAtOdd = computeSumAtOddIndexes(list, place);
		System.out.print("The largest number is " + max + "\nThe total number of even integers is " + even
				+ "\nThe total number of -1 is " + negativeOne + "\nThe sum of numbers at odd indexes is " + sumAtOdd
				+ "\n");
		scan.close();
	}

	/*************************************************************************************
	 *** (1)Complete the method. The method finds the largest number in the partial
	 * array range from startIndex to endIndex
	 *************************************************************************************/
	public static int findMax(int[] numbers, int startIndex, int endIndex) {
		if (startIndex < endIndex)
			return Math.max(numbers[endIndex], findMax(numbers, startIndex, endIndex - 1));
		else
			return numbers[endIndex];
	}

	/**************************************************************************************
	 *** (2)Complete the method. The method counts the number of even integers in the
	 * partial array range from startIndex to endIndex
	 *************************************************************************************/
	public static int countEven(int[] numbers, int startIndex, int endIndex) {
		int evenNum = 0;
		if (startIndex >= endIndex)
			return 0;
		if (numbers[startIndex] % 2 == 0)
			evenNum++;
		return evenNum + countEven(numbers, startIndex + 1, endIndex);
	}

	/*************************************************************************************
	 *** (3)Complete the method. The method counts the number of -1 inside an array
	 * with "count" numbers, index ranges from 0 to count-1
	 *************************************************************************************/
	public static int countNegativeOne(int[] numbers, int count) {
		int negative = 0;
		if (count <= 0)
			return 0;
		if (numbers[count - 1] == -1)
			negative++;
		return negative + countNegativeOne(numbers, count - 1);
	}

	/**************************************************************************************
	 *** (4)Complete the method. The method computes the sum of numbers at index 1, 3,
	 * 5, ... inside a partial array with "count" numbers inside, index ranges from
	 * 0 to count-1
	 ***************************************************************************************/
	public static int computeSumAtOddIndexes(int[] numbers, int count) {
		int sum = 0;
		if (count - 1 <= 0)
			return 0;
		else if ((count - 1) % 2 == 1) {
			if (count == 1)
				sum += numbers[count];
			else
				sum += numbers[count - 1];
		} else
			sum += numbers[count - 2];
		return sum + computeSumAtOddIndexes(numbers, count - 2);
	}

}// end of class Assignment9