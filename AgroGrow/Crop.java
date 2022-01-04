package AgroGrow;

import java.util.*;
import java.io.*; // used for file scanning and io exception handling

public class Crop implements Options {
    public Scanner sc = new Scanner(System.in);
    // hashmap to store the details of the crop
    public HashMap<Integer, String> details = new HashMap<Integer, String>();

    // method to display the options available in the class (implememting the method
    // from the Options class)
    public void options() {
        System.out.println("\n1. Information: ");
        System.out.println("2. Ideal conditions: ");
        System.out.println("3. Soil requirement: ");
        System.out.println("4. Yield: ");
        System.out.println("5. Investment: ");
        System.out.println("6. To exit: ");
    }

    // method in which we open our crop data file and search for the crop name
    public boolean getInfo(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\jpMicro\\data\\cropData.txt"));
            String line = reader.readLine().toLowerCase().toString();
            while (line != null) {
                // if we find the crop name in the file, we will store the next 4 lines inside
                // the details hashmap and return true
                if (line.equals(name.toLowerCase())) {
                    for (int i = 0; i < 5; i++) {
                        line = reader.readLine();
                        details.put(i, line);
                    }
                    reader.close();
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // if we don't find the name we will return false
        return false;
    }

    // implemetating the showOptions method of the Options interface
    public void showOptions() {
        System.out.print("\nEnter crop name: ");
        String cropName = sc.next();
        // checking the cropname exists or not
        boolean result = getInfo(cropName);
        String line;
        if (result == true) {
            int query = 0;
            do {
                // asking the user the request and based on the request running the switch case
                options();
                System.out.print("Enter your request: ");
                query = sc.nextInt();
                switch (query) {
                    case 1:
                        System.out.print("\nInformation about crop: ");
                        line = details.get(0);
                        System.out.println(line);
                        break;
                    case 2:
                        System.out.print("\nIdeal conditions required are: ");
                        line = details.get(1);
                        System.out.println(line);
                        break;
                    case 3:
                        System.out.print("\nSoil requiremts are: ");
                        line = details.get(2);
                        System.out.println(line);
                        break;
                    case 4:
                        System.out.print("\nYeild: ");
                        line = details.get(3);
                        System.out.println(line);
                        break;
                    case 5:
                        System.out.print("\nInvestment: ");
                        line = details.get(4);
                        System.out.println(line);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Incorrect query");
                        break;
                }
            } while (query != 6);
        } else {
            System.out.println("No crop found with cropname: " + cropName);
        }

    }
}
