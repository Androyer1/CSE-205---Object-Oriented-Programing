
// Assignment #: Arizona State University CSE205 #8
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: This class uses merge sort to sort the foodList with the specified
//				 comparator.

import java.util.*;

public class Sorts {

	private static ArrayList<Food> food;
	private static Comparator<Food> comparor;

	public static void sort(ArrayList<Food> foodList, Comparator<Food> xComparator) {
		food = foodList;
		comparor = xComparator;
		food = mergeSort(food);	//sets foodList to the new sorted food
	}

	public static ArrayList<Food> mergeSort(ArrayList<Food> temp) {
		//create temporary arrays for the left and right sides
		ArrayList<Food> left = new ArrayList<Food>();
		ArrayList<Food> right = new ArrayList<Food>();
		int mid;
		if (temp.size() == 1) {

		} else {
			mid = temp.size() / 2;
			for (int i = 0; i < mid; i++) {	  //creates the left array
				left.add(temp.get(i));
			}
			for (int i = mid; i < temp.size(); i++) {	//creates the right array
				right.add(temp.get(i));
			}
			//uses recursion to split up the arrays into its smallest pieces
			left = mergeSort(left);
			right = mergeSort(right);
			//merges the arrays
			merge(left, right, temp);
		}
		return temp;
	}

	public static void merge(ArrayList<Food> lft, ArrayList<Food> rght, ArrayList<Food> tmp) {
		int left = 0;
		int right = 0;
		int temp = 0;

		while (left < lft.size() && right < rght.size()) {	//while there is still space in the left and right arrays
			if (comparor.compare(lft.get(left), rght.get(right)) < 0) {		//if the left food is smaller than the right food
				tmp.set(temp, lft.get(left));	//set the left food to the actual array
				left++;
			} else {
				tmp.set(temp, rght.get(right));	//set the right food to the actual array
				right++;
			}
			temp++;
		}

		ArrayList<Food> rest;
		int index;
		if (left >= lft.size()) {	//if there is no more space in the left array
			rest = rght;
			index = right;
		} else {	//if there is no more space in the right array
			rest = lft;
			index = left;
		}

		for (int i = index; i < rest.size(); i++) {	//add the rest from the array that has items still in it
			tmp.set(temp, rest.get(i));
			temp++;
		}

	}

}
