package AgroGrow;

import java.util.*;
import java.lang.Runtime; // to use the runtime class

public class Chart extends Farm {
    public Scanner sc = new Scanner(System.in);

    public Chart() {
        if (expenses.size() > 0) {
            try {
                /*
                 * runtime class allow the program to interface with the environment in which
                 * application is running
                 * getRuntime helps to get instance associated with the program
                 * exec method helps to open certain process and run the commands
                 * /c will run the command specified
                 * /k is used so that the terminal opened will not be terminated and the string
                 * provide will run
                 */
                Runtime.getRuntime()
                        .exec("cmd /c start cmd.exe /K \"javac PieChart.java && appletviewer PieChart.java\"");
            } catch (Exception e) {
                System.out.println("Error occurred " + e);
            }
        } else {
            System.out.println("Add expenses to view data");
        }
        // expenses.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
