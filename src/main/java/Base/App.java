/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        double[] numArray = new double[3];
        getNumbers(numArray);
        double largestNum = findLargest(numArray);
        printOutput(largestNum);
    }
    public static void getNumbers(double numArray[]) {

        String[] ordinalArray = new String[]  {"first", "second", "third"};
        for (int i = 0; i < 3; i++)
        {
            System.out.printf("Please enter the %s number: ", ordinalArray[i]);
            String input = in.nextLine();
            numArray[i] = Double.parseDouble(input);
            Boolean validFlag = false;
            while (!validFlag)
            {
                try {
                    Double.parseDouble(input);
                    validFlag = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number: ");
                    input = in.nextLine();
                }
            }
        }
    }

    public static double findLargest(double numArray[])
    {
        double largest = numArray[0];
        if (numArray[0] == numArray [1] && numArray [1] == numArray [2])
        {
            System.exit(0);
        }
        for (int i = 0; i < 2; i++)
        {
            if (numArray[i+1] > numArray[i] && numArray[i+1] > largest)
            {
                largest = numArray[i+1];
            }
        }
        return largest;
    }

    public static void printOutput(double largestNum)
    {
        DecimalFormat decFormat = new DecimalFormat("#,###.##");
        String numFormatted = decFormat.format(largestNum);
        System.out.println("The largest number is " + numFormatted);
    }
}