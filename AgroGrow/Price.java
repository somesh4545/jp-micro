package AgroGrow;

import java.util.*;
import java.io.*;

public class Price extends Farm {
    // creating a hashmap for storing prices values
    public HashMap<String, String[]> priceChart = new HashMap<String, String[]>();
    public Farm farm;

    // creating a instance of farm class
    public Price() {
        farm = new Farm();
    }

    // method to get crop name and quantity and calling addCropDetails method of
    // farm class
    public void addDetails() {
        System.out.print("\nEnter your crop name and total Kg's per acre: ");
        String name = sc.next();
        long quantity = sc.nextLong();
        int x = farm.getArea();
        farm.addCropDetails(name, quantity * x);
    }

    // method to show the price of the entered ccrop to user
    public void showPriceChart() {
        String name = cropName;
        
        try {
            // opening the pricelist file
            BufferedReader reader = new BufferedReader(new FileReader("D:\\jpMicro\\data\\priceList.txt"));
            String line = reader.readLine().toLowerCase().toString();
            while (line != null) {
                String[] arr = line.split(" ");
                // ex line: name tomato region jalna minPrice 1200 maxPrice 1500
                // so when we apply split method at 1 index we will check if it matches the
                // given crop name
                if (arr[1].equals(name.toLowerCase())) {
                    // from 3 index we will get location and using 5 and 7 index will get low and
                    // max price
                    String location = arr[3];
                    String[] price = { arr[5], arr[7] };
                    priceChart.put(location, price);

                }
                line = reader.readLine();
            }
	    // checking if there is any data in priceChart or not
            if(priceChart.size() == 0) 
		System.out.println("Either crop name is wrong or the details are not available");
            else{
		System.out.println("Price of " + name + " per kg is:");
		// printing the price list by traversing the price chart hashmap
            	priceChart.forEach((k, v) -> System.out.println("Location: " + k + " price " + Arrays.toString(v)));
	    }
	    
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
