package AgroGrow;

import java.util.*;
import java.io.*;

public class Expenses extends Farm implements Options {
    public Scanner sc = new Scanner(System.in);

    // method to print the available options (implememting the method
    // from the Options class)
    public void options() {
        System.out.println("\n1. Add expense: ");
        System.out.println("2. Exit: ");
        System.out.print("Enter your request: ");
    }

    // function to add expenses to txt file by using the write method of
    // BufferedWriter
    public void addToFiles(String name, long cost) {
        try {
            String fileName = "D:\\jpMicro\\data\\expensesData.txt";
            String str = name + " " + cost + "\n";
            BufferedWriter file = new BufferedWriter(
                    new FileWriter(fileName, true));
            file.write(str);
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // implemetating the showOptions method of the Options interface
    public void showOptions() {
        Farm farm = new Farm();
        farm.addArea();
        int query = 0;
        do {
            options();
            query = sc.nextInt();
            // taking the input from the user and if it is 1 we will ask the user to enter
            // the expense name and the cost associated with it
            if (query != 2) {
                System.out.print("\nEnter expense name and cost per acre: ");
                String name = sc.next();
                long cost = sc.nextLong();
                // getting the farm area and multipling with the cost
                int x = farm.getArea();
                // adding the expense to expenses map stored in the farm class and calling the
                // add function to file
                expenses.put(name, cost * x);
                addToFiles(name, cost * x);
            }

        } while (query != 2);

    }
}
