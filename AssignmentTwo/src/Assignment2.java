// Assignment #: 2
// 		   Name: Andrew Miller
//    StudentID: Your ASU Student ID
//      Lecture: MW 6:00-7:15pm
//  Description: (1)This class reads the numbers input in the console and prints out four
//			     calculations: The sum of the positive integers, the minimum number, the number
//				 of negative integers, and the sum of numbers divisible by 3.

import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		int sumPos = 0;
		int min = Integer.MAX_VALUE;
		int numNeg = 0;
		int sumDiv = 0;
		int num = -1;

		while (num != 0) {

			num = console.nextInt();

			if (num < min) {
				min = num;
			}

			if (num % 2 == 0) {
				sumPos += num;
			}

			if (num < 0) {
				numNeg++;
			}

			if (num % 3 == 0) {
				sumDiv += num;
			}
		}

		System.out.print("The minimum integer is " + min + "\n" + "The sum of positive even integers is " + sumPos
				+ "\n" + "The count of negative integers is " + numNeg + "\n" + "The sum of numbers divisible by 3 is "
				+ sumDiv);
	}

}
