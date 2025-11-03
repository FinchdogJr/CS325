import java.util.Scanner;

/**
 * CS 325 Data Structures - Lab 8: Guessing Game Binary Search
 * Student: Lukas Finch
 * Professor: Prof. Lehman
 * Due: Monday, November 3
 * 
 * This pirate-themed AI bot uses binary search to guess a number between 1 and the user-provided upper limit.
 * It predicts the max guesses (ceiling of log2(n)), tracks guess count, and detects inconsistent user responses.
 * Ahoy! Fair winds and accurate guesses!
 */
public class PirateGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ahoy, matey! Welcome to the CS325 Pirate AI Bot Guessing Game!");
        System.out.println("Ye be thinkin' of a number, and I'll guess it faster than a cannonball flies.\n");

        System.out.print("Enter the largest number (the upper limit o' yer treasure map): ");
        int upper = sc.nextInt();
        while (upper < 1) {
            System.out.print("Arrr! That be no good. Give me a proper upper limit (1 or higher): ");
            upper = sc.nextInt();
        }

        System.out.println("\nShiver me timbers! Pick a secret number betwixt 1 and " + upper + ", but keep it hush-hush from this ol' pirate!");
        
        // Calculate ceiling of log2(upper) for max guesses
        int maxGuesses = 0;
        int n = upper;
        while (n > 0) {
            n /= 2;
            maxGuesses++;
        }
        // Precise adjustment for powers of 2
        if (upper > 0 && (upper & (upper - 1)) != 0) {
            maxGuesses++; // Not a power of 2, add one more
        }
        // For upper=1, log2(1)=0, but we need 1 guess
        if (upper == 1) maxGuesses = 1;

        System.out.println("I be swearin' on Davy Jones' locker, I can guess yer number in " + maxGuesses + " tries or less!\n");

        int low = 1;
        int high = upper;
        int guessCount = 0;
        boolean found = false;

        while (low <= high && !found) {
            guessCount++;
            int mid = low + (high - low) / 2; // Safe mid calculation, arr!

            System.out.print("Guess #" + guessCount + ": Be yer number " + mid + "? (y/n): ");
            String yn = sc.next().toLowerCase();
            
            if (yn.equals("y")) {
                System.out.println("Arrr! I nailed it! Yer number be " + mid + "!");
                System.out.println("Guessed it in " + guessCount + " tries, just like I boasted. Fair winds to ye!");
                found = true;
            } else if (yn.equals("n")) {
                System.out.print("Higher or lower than " + mid + "? (h/l): ");
                String hl = sc.next().toLowerCase();
                
                if (hl.equals("h")) {
                    if (mid >= high) {
                        System.out.println("Blimey! Ye be feedin' me false winds. That can't be higher! Ye scallywag, game over!");
                        return;
                    }
                    low = mid + 1;
                } else if (hl.equals("l")) {
                    if (mid <= low) {
                        System.out.println("Walk the plank! Ye said lower, but that be impossible. Ye ain't playin' fair!");
                        return;
                    }
                    high = mid - 1;
                } else {
                    System.out.println("Arrr? Ye speak gibberish! Stick to h or l, or I'll make ye swab the deck.");
                    guessCount--; // Don't count invalid input as a guess
                }
            } else {
                System.out.println("Yarr! Answer with y or n, ye landlubber!");
                guessCount--; // Don't count invalid input
            }

            // Extra cheat detection: if range empties without finding
            if (low > high) {
                System.out.println("Out o' possible numbers! Ye must've changed yer mind mid-voyage. No fair!");
                found = true; // End loop
            }
        }
    }
}