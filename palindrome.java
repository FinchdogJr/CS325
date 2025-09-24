/// palindrome.java 
//
// fall 2025
// lab4b assignment
//
//  *** Lukas Finch
//
// Use for palindrome.java

public class palindrome {
    
    public static void main(String[] args) {

        //single call to test
        System.out.println( palindrome("racecar") ); //true
        System.out.println( palindrome("sass") ); //false

        //uncomment to test additional words
        /*
        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca", "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println( words[i] + " IS a palindrome");
            else
                System.out.println( words[i] + " IS NOT a palindrome");
        }
        */
        
    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

        //assume status is true
        boolean status = true;

		// *** add code here
        // create stack and queue sized to word length
        StackCharArray stack = new StackCharArray(word.length());
        QueueCharArray queue = new QueueCharArray(word.length());

        // add all letters to both the stack and the queue
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            stack.push(c); // Pushes character onto the LIFO stack
            queue.add(c);  // Adds character to the FIFO queue
        }

        // Compare characters by removing from opposite ends of the word.
        // The stack provides characters from the end of the word backward,
        // while the queue provides them from the beginning forward.
        while (!stack.empty() && status) { // Continues as long as the stack has items
            if (stack.top() != queue.front()) { // Compares top of stack with front of queue
                status = false;
            } else {
                stack.pop();      // Removes from the top of the stack
                queue.remove();   // Removes from the front of the queue
            }
        }

        return status;
        
    }// palindrome method

}//class