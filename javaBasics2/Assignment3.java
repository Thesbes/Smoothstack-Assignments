package javaBasics2;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Assignment3 extends JPanel{


    //Hex codes for colors
    /*
    static String RED = "#FF0000";
    String ORANGE = "";
    String YELLOW = "";
    String GREEN = "";
    String BLUE = "";
    String PURPLE = "";
    String BLACK = "";
    */

    public void paint(Graphics g, String Color)
    {
        String hexColor = new String(Color);
    }

    public static void main(String[] args) {
        
        //Set frame/background
        JFrame f = new JFrame("myFirstShape");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(300,300);
        f.getContentPane().setBackground(Color.CYAN);

        //Not really understanding the details of the assignment at this point
        //Will continue later -- 5/23/2021
    }
}
