import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
* The Selection Sort program will read a set of integers between 0 and 100.
* It will populate the set of integers into an array.
* It will then sort the arrays using the selection sort algorithm.
* It will write the sorted array to the output file.
*
* @version 1.0
* @since 2025-04-14
*/

final class SelectSort {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private SelectSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the select sort method.
     *
     * @param arrayInt array of integers
     * @return sorted array
     */

    public static int[] selectSort(final int[] arrayInt) {

        // Get array size
        int arraySize = arrayInt.length;

        // Selection sort algorithm
        // Start of the selection sort algorithm
        // Iterate through the array to sort it
        for (int pass = 0; pass < (arraySize - 1); pass++) {

            // Set the minimum index to the pass number
            int indexMin = pass;

            // Iterate through the unsorted part of the array to find the min
            for (int counter = pass + 1; counter < arraySize; counter++) {

                // if the current number is less than the current minimum
                if (arrayInt[counter] < arrayInt[indexMin]) {
                    // Set the min's index equal to the counter
                    indexMin = counter;
                }
            }

            // If the min is not already in correct position
            if (indexMin != pass) {

                // swap the min with the current number
                int temp = arrayInt[indexMin];
                arrayInt[indexMin] = arrayInt[pass];
                arrayInt[pass] = temp;
            }
        }

        // return the sorted array
        return arrayInt;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // pass the relative path to the input file as a parameter
        File file = new File("./input.txt");

        // Create a file object
        FileWriter myWriter = new FileWriter("./output.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // Greeting and instructions
        System.out.println("Welcome to the select sort program!");
        System.out.print("This program gets a set of integers");
        System.out.println(" from 'input.txt'.");
        System.out.println("It then sorts the integers using selection sort.");
        System.out.println("The sorted set will be written to 'output.txt'.");

        // Read the line from the file
        String line = scanner.nextLine();

        // Split the line into an array of strings
        String[] arrayNumStr = line.split(" ");

        // Declare array of integers
        int[] arrayNumInt = new int[arrayNumStr.length];

        // Loop through the array of strings to convert the strings to ints
        for (int counter = 0; counter < arrayNumStr.length; counter++) {

            // Convert the number from a string to an integer
            arrayNumInt[counter] = Integer.parseInt(arrayNumStr[counter]);
        }

        // Get the sorted array by calling the select sort function
        int[] arrayNumber = selectSort(arrayNumInt);

        // Add the sorted array to the output string,
        // One number at a time, separated by spaces
        for (int num : arrayNumber) {
            // Display each number, separated by a space
            outputStr += (num + " ");
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Close the file writer
        myWriter.close();

        // Added a blank line for spacing
        System.out.println("");

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");

        // Close the scanner
        scanner.close();
    }
}
