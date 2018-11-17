
// Assignment #: Arizona State University CSE205 #8
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: This class defines a GroceryStore

import java.io.*;
import java.util.ArrayList;

public class GroceryStore implements Serializable {
	private static final long serialVersionUID = 5032628731504404707L;
	private ArrayList<Food> foodList;

	public GroceryStore() {
		foodList = new ArrayList<Food>();
	}

	public int idExists(int foodId) {	//returns index of Id of the food if it exists
		for (Food fd : foodList) {
			if (fd.getId() == foodId) {
				return foodList.indexOf(fd);	
			}
		}
		return -1;
	}

	public int categAndNameExists(String nCategory, String nName) {	    //returns index of category and name of the food if it exist 
		for (Food fd : foodList) {
			if (fd.getCategory().equals(nCategory) && fd.getName().equals(nName)) {
				return foodList.indexOf(fd);
			}
		}
		return -1;
	}

	public boolean addFoodById(String category, String name, int id) {		//adds the food if its Id doesn't exists already
		if (idExists(id) == -1) {
			Food fd = new Food(category, name, id);
			foodList.add(fd);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeById(int id) {		//removes the food by Id if the Id exists
		if (idExists(id) == -1) {
			return false;
		} else {
			for (Food fd : foodList) {
				if (fd.getId() == id) {
					foodList.remove(foodList.indexOf(fd));
					return true;
				}
			}
			return false;
		}
	}

	public boolean removeByCategAndName(String category, String name) {		//removes the food by category and name if it exists
		if (categAndNameExists(category, name) == -1) {
			return false;
		} else {
			for (Food fd : foodList) {
				if (fd.getCategory().equals(category) && fd.getName().equals(name)) {
					foodList.remove(foodList.indexOf(fd));
					return true;
				}
			}
			return false;
		}
	}

	public void sortByCategAndName() {		//sorts by category and name
		CategAndNameComparator compareCategAndName = new CategAndNameComparator();
		Sorts.sort(foodList, compareCategAndName);
	}

	public void sortById() {		//sorts by Id
		IdComparator compareId = new IdComparator();
		Sorts.sort(foodList, compareId);
	}

	public String listFood() {	//Prints out the food in foodList
		String list = "";
		if (foodList.size() < 0) {
			return "\nno food\n\n";
		} else {

			for (Food f1 : foodList) {
				list += f1.toString();
			}
			return list;
		}
	}

	public void closeGroceryStore() {	//closes the GroceryStore
		foodList.clear();
	}

}
