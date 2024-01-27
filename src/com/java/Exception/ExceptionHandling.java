package com.java.Exception;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    // Attempt to read a numerator and denominator from the user
                    System.out.print("Enter the numerator: ");
                    int numerator = scanner.nextInt();

                    System.out.print("Enter the denominator: ");
                    int denominator = scanner.nextInt();

                    // Attempt to perform division
                    double result = divide(numerator, denominator);

                    // Display the result
                    System.out.println("Result: " + result);

                    // If everything is successful, break out of the loop
                    break;
                } catch (InputMismatchException e) {
                    // Handle the case where the user enters invalid input
                    System.out.println("Invalid input! Please enter valid integers.");
                    scanner.nextLine(); // Consume the invalid input
                } catch (ArithmeticException e) {
                    // Handle the case where division by zero occurs
                    System.out.println("Error: Division by zero is not allowed.");
                } catch (Exception e) {
                    // Handle other unexpected exceptions
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                } finally {
                    // This block will be executed regardless of whether an exception occurred or not
                    System.out.println("Finally block executed");
                }
            }

            // Close the scanner (good practice to release resources)
            scanner.close();

            // Continue with the rest of the program...
            System.out.println("Program continues after the try-catch block.");
        }

        private static double divide(int numerator, int denominator) {
            // Perform division and handle potential ArithmeticException
            if (denominator == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return (double) numerator / denominator;
        }
    }


