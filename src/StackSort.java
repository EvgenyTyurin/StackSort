import java.util.Stack;

/**
 * Sort a stack using only second one and an integer buff
 */

public class StackSort {

    public static void main(String[] args) {
        // Init unsorted stack
        Stack<Integer> unsortedStack = new Stack<>();
        unsortedStack.push(4);
        unsortedStack.push(2);
        unsortedStack.push(1);
        unsortedStack.push(3);
        unsortedStack.push(5);
        // Init stack for sorted elements
        Stack<Integer> sortedStack = new Stack<>();
        System.out.println("Unsorted: " + unsortedStack); // [4, 2, 1, 3, 5]
        // All elements from unsorted stack must go to sorted stack
        while (!unsortedStack.isEmpty()) {
            // Element is first or in right order - go to sorted
            if (sortedStack.isEmpty() || unsortedStack.peek() <= sortedStack.peek()) {
                sortedStack.push(unsortedStack.pop());
            } else {
                // Remember element from unsorted
                Integer i = unsortedStack.pop();
                // All from sorted < element go back to unsorted
                while (!sortedStack.empty() && sortedStack.peek() < i ) {
                    unsortedStack.push(sortedStack.pop());
                }
                // Element go to sorted
                sortedStack.push(i);
            }
        }
        System.out.println("Sorted: " + sortedStack); // [5, 4, 3, 2, 1]
    }

}
