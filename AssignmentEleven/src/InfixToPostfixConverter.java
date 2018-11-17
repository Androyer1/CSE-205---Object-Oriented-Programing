
// Assignment #: Arizona State University CSE205 #11
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: This is a utility class that provide a static method that
//				 takes an infix string, checked and determine if parentheses
//				 are matching, if matching, returns a postfix string.

import java.util.Stack;

public class InfixToPostfixConverter {
	// **********************************************************************
	// The precedence method determines the precedence between two operators.
	// If the first operator is of higher or equal precedence than the second
	// operator, it returns true, otherwise it returns false.
	// ***********************************************************************
	public static boolean precedence(char first, char second) {
		if (second == '(' || second == ')') { // parenthesis takes precedence
			return false;
		}
		if ((first == '*' || first == '/') && (second == '+' || second == '-')) {
			return false;
		} else {
			return true;
		}
	}

	// *************************************************************************
	// The static convertToPostfix method will convert the infixString
	// into the corresponding postfix string. Check the algorithm on
	// assignment #11's description page. Mark each case clearly inside the code
	// *************************************************************************
	public static String convertToPostfix(String infixString) {
		// initialize the resulting postfix string
		String postfixString = "";

		// initialize the stack
		Stack<Character> stack1 = new Stack<Character>();

		// Obtain the character at index i in the string
		for (int i = 0; i < infixString.length(); i++) {
			char currentChar = infixString.charAt(i);

			// Case A:
			if (Character.isLetter(currentChar)) // if the character is a letter, add it to the postfix
				postfixString = postfixString + currentChar;

			// Case B:
			else if (currentChar == '(') { // if the character is a '(', add it to the stack
				stack1.push(currentChar);

			}

			// Case C:
			else if ((currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-')
					&& stack1.isEmpty()) { // if the character is an operator and the stack is empty, add the operator
											// to the stack
				stack1.push(currentChar);
			}

			// Case D:
			else if ((currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-')
					&& !stack1.isEmpty()) { // if the character is an operator and the stack is not empty, pop the stack
											// and append it to
											// the string while the stack is not empty and topStack has precedence over
											// the character
				while (!stack1.isEmpty() && precedence(currentChar, stack1.peek())) {
					postfixString = postfixString + stack1.pop();
				}
				stack1.push(currentChar);
			}

			// Case E:
			else if (currentChar == ')') { // if the character is a ')' and the stack is not empty,
											// pop the entire
											// stack and append them until there is a '('
				if (!stack1.isEmpty()) {
					while (!stack1.isEmpty() && stack1.peek() != '(') {
						postfixString = postfixString + stack1.pop();
					}
					if (stack1.isEmpty() || stack1.peek() != '(') {
						return "No matching open parenthesis error";
					} else {
						stack1.pop();
					}
				}
				else {
					return "No matching open parenthesis error";
				}
			}

		} // end of for loop

		// Case F:
		while (!stack1.isEmpty()) { // if there are any operators left in the stack, append them to the Postfix
									// string
			if (stack1.peek() == '(') {
				return "No matching close parenthesis error";
			} else {
				postfixString = postfixString + stack1.pop();
			}
		}

		return "The Postfix Expression is: " + postfixString;

	}// end of convertToPostfix method

}// end of the InfixToPostfixConverter class