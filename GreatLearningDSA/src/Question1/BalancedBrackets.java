package Question1;

import java.util.*;

public class BalancedBrackets {

	// function to check if brackets are balanced
		static boolean areBracketsBalanced(String bracketExpression) {

			// Using ArrayDeque is faster than using Stack class
			Deque<Character> stack = new ArrayDeque<Character>();

			// Traversing the Expression
			for (int i = 0; i < bracketExpression.length(); i++) {
				char character = bracketExpression.charAt(i);

				if (character == '(' || character == '[' || character == '{') {
					// Push the element in the stack
					stack.push(character);
					continue;
				}

				// If current character is not opening
				// bracket, then it must be closing. So stack
				// cannot be empty at this point.
				if (stack.isEmpty())
					return false;
				char check;

				switch (character) {
				case ')':
					check = stack.pop();
					if (check == '{' || check == '[')
						return false;
					break;

				case '}':
					check = stack.pop();
					if (check == '(' || check == '[')
						return false;
					break;

				case ']':
					check = stack.pop();
					if (check == '(' || check == '{')
						return false;
					break;
				}
			}

			// Check Empty Stack
			return (stack.isEmpty());
		}

		// Driver Code
		public static void main(String[] args) {

			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter the String of Brackets : ");

				String expression = sc.nextLine();

				// Function call
				if (areBracketsBalanced(expression))
					System.out.println("The entered String has Balanced Brackets.");
				else
					System.out.println("The entered Strings do not contain Balanced Brackets.");
			}
		}
	}	

