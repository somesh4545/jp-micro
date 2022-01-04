import java.util.*; //utils library is required for using scanner in this program

import AgroGrow.Crop; // user-defined package containing methods to get details related to the crop
import AgroGrow.Expenses; // user-defined package containg methods for adding and storing expresnes
import AgroGrow.Price; // user-defined package containg methods for getting pricing details
import AgroGrow.Chart; // user-defined package containg method to open applet viewer in new tab

public class Main {

    public static void main(String args[]) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to AGROGROW, a companion for your agriculture!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner sc = new Scanner(System.in);
        int query = 0;
        Crop c = new Crop();
        do {
            // list of options to take input from user
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Crop related details: ");
            System.out.println("2. Add expenses: ");
            System.out.println("3. Price comparison chart: ");
            System.out.println("4. Data in graph: ");
            System.out.println("5. To exit: ");
            System.out.print("Enter your request: ");
            query = sc.nextInt();
            switch (query) {
                case 1:
                    c.showOptions(); // calling the showOptions from the crop package
                    break;
                case 2:
                    // creating and calling method of expense package
                    Expenses exp = new Expenses();
                    exp.showOptions();
                    break;
                case 3:
                    // creating thr price objects and calling methods
                    Price price = new Price();
                    price.addDetails();
                    price.showPriceChart();
                    break;
                case 4:
                    // creating the instance of chart class
                    Chart chart = new Chart();
                    break;
                case 5:
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    System.out.println("Program finished successfully");
                    break;
                default:
                    System.out.println("Wrong key pressed");
                    break;
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } while (query != 5);
        sc.close();
    }
}