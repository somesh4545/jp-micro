package AgroGrow;

import java.util.*;

public class Farm {
    public Scanner sc = new Scanner(System.in);
    // creating the static variables
    public static int acre = 0;
    public static String cropName = "";
    public static long quantity = 0;
    public static HashMap<String, Long> expenses = new HashMap<String, Long>();

    // method to add area
    public void addArea() {
        if (acre == 0) {
            System.out.print("\nEnter your Farm in acre: ");
            acre = sc.nextInt();
        }
    }

    // method to add expense to expenses map
    public void addExpense(String name, long amount) {
        expenses.put(name, amount);
    }

    // method to add crop name and quantity
    public void addCropDetails(String name, long qty) {
        if (acre == 0)
            addArea();
        if (quantity == 0 || cropName == "") {
            cropName = name;
            quantity = qty;
        }
    }

    // method to show the crop details
    public void showDetails() {
        System.out.println("\n" + acre + " " + cropName);
        getExpenses();
    }

    // method to return area of farm
    public int getArea() {
        return acre;
    }

    // method to print the expenses
    public void getExpenses() {
        expenses.forEach((k, v) -> {
            System.out.println(k + " " + v + " expe");
        });
    }
}
