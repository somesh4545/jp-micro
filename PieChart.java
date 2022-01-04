import java.util.*;
// importing packages required for the applet
import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class PieChart extends Applet implements ActionListener {
    // declaring the values
    int i = 1, total = 0, start_angle = 0, total_expenses = 0;

    // boolean values to keep check on form submssion and profit occurrence
    boolean form_submit = false, profit = false;

    // creating a array to store color for the applte
    Color[] data_clr;

    // hashmap to store the data of the expenses
    HashMap<String, Integer> data = new HashMap<String, Integer>();

    // declaring a submit button and textfiled for the amount earned
    Button submit;
    TextField amount_earned;

    public void init() {
        // initialize the color array
        data_clr = new Color[] { Color.red, Color.magenta, Color.blue, Color.gray,
                Color.orange, Color.black };

        // creating a label to ask the user
        Label label = new Label("Enter the amount earned: ");

        // creating the textfiled and sumit button
        amount_earned = new TextField("", 8);
        submit = new Button("Submit");

        // reading the expenses from the expenses data file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\jpMicro\\data\\expensesData.txt"));
            String st;

            while ((st = reader.readLine()) != null) {
                // spliting the line and storing the name and cost in the data hashmap
                // adding the cost to both total and total_expenses so to differentiate if users
                // changes value in futrue case
                String[] arr = st.split(" ");
                String name = arr[0];
                int cost = Integer.parseInt(arr[1]);
                data.put(name, cost);
                total += cost;
                total_expenses += cost;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        submit.addActionListener(this);

        add(label);
        add(amount_earned);
        add(submit);
    }

    public void actionPerformed(ActionEvent a) {
        String str = a.getActionCommand();
        // on submitting the form
        if (str == "Submit") {
            int total_earned = Integer.parseInt(amount_earned.getText());
            // getting the total_earned from the textfiled and coverting it into int
            // if total was greater than total_earned then it is a loss and storing
            // total_earned
            if (total > total_earned) {
                data.put("Earned", total_earned);
                total = total_expenses + total_earned;
                data.remove("Profit");
                profit = false;
            }
            // else it is a profit and assing profit true
            else {
                data.put("Profit", total_earned - total_expenses);
                data.remove("Earned");
                total = total_earned;
                profit = true;
            }
            form_submit = true;
        }
        repaint();
    }

    public void paint(Graphics g) {
        i = 0;

        // setting the font and font size
        Font myFont = new Font("Courier New", 1, 19);
        g.setFont(myFont);

        // if form_submit is true, we will run this block
        if (form_submit == true) {
            // printing loss and profit statements
            if (profit == true) {
                g.setColor(Color.green);
                g.drawString("Congrats! you are having a profit", 100, 80);
            } else {
                g.setColor(Color.red);
                g.drawString("Sorry you suffered a loss :(", 100, 80);
            }
            // writing a code for drawing a pie chart
            // declaring the start_angle
            start_angle = 0;

            // traversing the data hashmap
            data.forEach((k, v) -> {

                // creating a loading animation using Thread class
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    System.out.println("Error occurred ");
                }

                // if we find any key with profit name we will set color as green else the color
                // from the array
                if (k.equals("Profit") == true) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(data_clr[i]);
                }

                // to print the labels on the right side of chart
                g.drawString(" " + k + " - " + v, 450, 200 + 25 * i);
                g.drawRect(440, 185 + 25 * i, 15, 15);
                g.fillRect(440, 185 + 25 * i, 15, 15);

                // finding the arc_angle for the given value
                int arc_angle = (v * 360 / total);

                // drawing the arc and filling it
                g.drawArc(100, 100, 300, 300, start_angle, arc_angle);
                g.fillArc(100, 100, 300, 300, start_angle, arc_angle);

                // re initializing the start_angle to the arc_angle since it will be new start
                start_angle += arc_angle;
                i++;
                // System.out.println(k);
            });
        }
    }
}
/* <applet code="PieChart.class" height="500" width="700"></applet> */