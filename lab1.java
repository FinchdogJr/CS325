// CS 325 Data Structures - Lukas Finch
//
// fall 2025
// lab1.java
//
// Lab #1 - (20 points) - Due: 9.29.2025 (5 pm)
// Java Intro 
// Fall 2025
//
// Read the comments below and update the code to complete each task.
// Post and upload solutions to your GitHub account and share link to file.
// Use AI with caution, you must be able to write Java code without AI

class lab1 {

	public static void main(String[] args) {
		// #0
		// add your first and last name to the comments
		// note: all code should automatically adjust via variables
		// goal is learn (or review) basic Java syntax and commands

		// #1
		// create variables and set to values as shown.
		// add a new last_name variable.

		// first_name of type String
		String first_name = "Lukas";

		// (*** last_name of type String)
        String last_name = "Finch";
        // age of type int
		int age = 21;

		// gpa of type double
		double gpa = 3.8;

		// #2
		// print the following message with the variables from #1
		// your code must use the values set in #1,
		// test your code by changing the values above to your first, last, age and gpa.
		// note that the age should automatically adjust to +20

		// (*** add last name)
		System.out.println(first_name + " " + last_name + " is a student at Huntington University,");
		System.out.println("This student is " + age + " years old and has a gpa of " + gpa + ".");
		int new_age = age + 20; // (*** fix to add 20 to age)
		System.out.println("In twenty years the student will be " + new_age + " years old.");
		System.out.println();

		// #3
	// modify the following loop to calculate and print the square root
	// of the numbers 3 to 100 using 2 decimal places
	// hint: use Math.sqrt()
	// ie 3, 3.16, 3.32, ... 10.00

	for (int x = 3; x <= 100; x++) {
		double sqrt = Math.sqrt(x);              
		System.out.printf("%.2f, ", sqrt);   
	}
	System.out.println();
	System.out.println();


		// #4
		// use a while loop to display all values from 1 to 1000 that are
		// evenly divisible by variable N (ie. int N = 3;)
		// if N is set to 3, your code displays 3, 6, 9, ... 999
		// if N is set to 4, your code displays 4, 8, 12 ... 1000
		// hint: use mod % ... if divisible by 2, then print
		int N = 3;

		int x = 1;
		while (x <= 1000) {
			if (x % N == 0)
				System.out.printf("%d, ", x);
			x++;
		}
		System.out.println();
		System.out.println();

		// #5
		// use if statements to determine and display the honor roll
		// status based on gpa from #1
		//
		// 3.75 to 4.0 dean's list - high honors
		// 3.5 to 3.74 dean's list - honors
		// 3.25 to 3.49 dean's list
		//

		if (gpa >= 3.75 && gpa <= 4.0) {
			System.out.println("dean's list - high honors");
			System.out.println();
		} else if (gpa >= 3.5 && gpa <= 3.74) {
			System.out.println("dean's list - honors");
			System.out.println();
		} else if (gpa >= 3.25 && gpa <= 3.49) {
			System.out.println("dean's list");
			System.out.println();
		}

	// #6
	// create one dimensional array of ten integers
	// calculate and display the largest integer

	  int values[] = { 17, 8, 24, 16, 42, 3, 99, 56, 71, 28 };

        int largest = values[0]; 
        for (int i = 1; i < values.length; i++) {
            if (values[i] > largest) {
                largest = values[i];
            }
        }

        System.out.println("Largest is " + largest);
        System.out.println();
    

		// #7
		// create a static method called allSame that takes three integers
		// and returns true if they are all the same value
		// and false if they are not all the same value
		// demonstrate your method with three method calls
		      // method call #1
        System.out.println(allSame(10, 10, 10));  // true

        // method call #2
        int value1 = 9;
        int value2 = 9;
        int value3 = 5;
        if (allSame(value1, value2, value3)) {
            System.out.println(value1 + ", " + value2 + ", " + value3 + " are all the same");
        } else {
            System.out.println(value1 + ", " + value2 + ", " + value3 + " are NOT all the same");
        }

        // method call #3
        System.out.println(allSame(3, 3, 7));  // false

     System.out.println();

		// #8
		// create a static method getAverage that return the getAverage values
		// for all items in a one dimensional array
		// demonstrate your method using the array from #7
		System.out.println("Average of values[] = " + getAverage(values));
		System.out.println();

		// #9
		// copy code into a file called lab1.java
		// compile and run your code from the command line.
		// create a screen capture of your compiling and running the
		// program code from a command line similar to the screenshot shown in Moodle
		//
		// create a GitHub account and upload a link to your lab1.java code in Moodle

	}// main

	// (*** add a third variable c)
	public static boolean allSame(int a, int b, int c) {
		return (a == b && b == c);
	}

	// (*** modify to calculate average)
	public static double getAverage(int[] temp) {
		int sum = 0;

		for (int i = 0; i < temp.length; i++) {
			sum = sum + temp[i];
		}

		return (double) sum / temp.length;
	}

}// class Main
