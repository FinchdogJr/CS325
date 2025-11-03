import java.util.Scanner;

/**
 * CS 325 Data Structures - Lab 8: Guessing Game Binary Search
 * Lukas Finch
 * Prof. Lehman
 * Due: Monday, November 3, 5:00 pm
 * * This pirate-themed AI bot uses binary search to guess a number between 1 and the user-provided upper limit.
 * It predicts the max guesses (ceiling of log2(n)), tracks guess count, and detects inconsistent user responses.
 * Ahoy! Fair winds and accurate guesses!
 */
public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ahoy, matey! Welcome to the CS325 Pirate AI Bot Guessing Game!");
        System.out.println("Ye be thinkin' of a number, and I'll guess it faster than a cannonball flies.\n");

        System.out.print("Enter the largest number (the upper limit o' yer treasure map): ");
        int upper = sc.nextInt();
        
        // Input validation
        while (upper < 1) {
            System.out.print("Arrr! That be no good. Give me a proper upper limit (1 or higher): ");
            upper = sc.nextInt();
        }

        System.out.println("\nShiver me timbers! Pick a secret number betwixt 1 and " + upper + ", but keep it hush-hush from this ol' pirate!");
        
        // Calculate ceiling of log2(upper) for max guesses
        int maxGuesses = 0;
        int tempUpper = upper;
        
        // Loop to find the smallest power of 2 greater than or equal to 'upper'
        int powerOfTwo = 1;
        while (powerOfTwo < tempUpper) {
            powerOfTwo *= 2;
            maxGuesses++;
        }
        
        // Handle case where upper=1
        if (upper == 1) {
            maxGuesses = 1;
        } else if (maxGuesses == 0 && upper > 1) {
            // Should not happen for upper > 1, but safety check
            maxGuesses = 1;
        }

        System.out.println("I be swearin' on Davy Jones' locker, I can guess yer number in " + maxGuesses + " tries or less!\n");

        int low = 1;
        int high = upper;
        int guessCount = 0;
        boolean found = false;

        // Main binary search loop
        while (low <= high && !found) {
            guessCount++;
            // Calculate midpoint: safer than (low + high) / 2 to prevent overflow on massive numbers
            int mid = low + (high - low) / 2; 

            System.out.print("Guess #" + guessCount + ": Be yer number " + mid + "? (y,n): ");
            String yn = sc.next().toLowerCase();
            
            // --- User confirms guess ---
            if (yn.equals("y")) {
                System.out.println("Arrr! I nailed it! Yer number be " + mid + "!");
                System.out.println("Guessed it in " + guessCount + " tries, just like I boasted. Fair winds to ye!");
                found = true;
            } 
            // --- User denies guess ---
            else if (yn.equals("n")) {
                System.out.print("Higher or lower than " + mid + "? (h/l): ");
                String hl = sc.next().toLowerCase();
                
                if (hl.equals("h")) {
                    // Check for inconsistency: if the current guess is already the highest boundary
                    if (mid >= high) {
                        System.out.println("Blimey! Ye be feedin' me false winds. That can't be higher! Ye scallywag, game over!");
                        break; 
                    }
                    low = mid + 1; // Set new lower boundary
                } else if (hl.equals("l")) {
                    // Check for inconsistency: if the current guess is already the lowest boundary
                    if (mid <= low) {
                        System.out.println("Walk the plank! Ye said lower, but that be impossible. Ye ain't playin' fair!");
                        break; 
                    }
                    high = mid - 1; // Set new upper boundary
                } else {
                    // Handle invalid h/l response
                    System.out.println("Arrr? Ye speak gibberish! Stick to h or l, or I'll make ye swab the deck. Stopping.");
                    break;
                }
            } 
            // --- Invalid y/n response ---
            else {
                System.out.println("Yarr! Answer with y or n, ye landlubber! Stopping.");
                break;
            }

            // --- Extra cheat detection: check if bounds have crossed ---
            if (low > high) {
                System.out.println("Out o' possible numbers! Ye must've changed yer mind mid-voyage. No fair! Stopping.");
                break;
            }
        }
        
        sc.close();
    }
}
