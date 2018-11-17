
// Assignment #: Arizona State University CSE205 #8
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: This class sorts 2 foods by their category and then name

import java.util.*;

public class CategAndNameComparator implements Comparator<Food> {
	
	public int compare(Food first, Food second) {	//compares the two foods by category and name
		if (first.getCategory().compareTo(second.getCategory()) == 0)	//if the two foods have the same category, sort by name
			return first.getName().compareTo(second.getName());
		else
			return first.getCategory().compareTo(second.getCategory());
	}

}
