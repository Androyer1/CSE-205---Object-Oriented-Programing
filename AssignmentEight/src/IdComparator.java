
// Assignment #: Arizona State University CSE205 #8
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: This class sorts 2 foods by their Id's
import java.util.*;

public class IdComparator implements Comparator<Food> {

	public int compare(Food first, Food second) {	//compares the two foods by Id
		if (first.getId() > second.getId()) {
			return 1;
		} else if (first.getId() < second.getId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
