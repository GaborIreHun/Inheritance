package com.gabor.ca1;


import javax.swing.*;
import java.awt.*;

/**
 * Class for main method it relies on java.awt.Graphics object to perform the drawing.
 */
public class WindowCreator {

    public static void main(String[] args) {

        // creating new instance of the ShapesManager
        ShapesManager shapesManager = new ShapesManager();

        // setting the displayName value
        shapesManager.setDisplayName(true);
        // setting the displayBoundingBox value
        shapesManager.setDisplayBoundingBox(true);

        // Creating Shapes
        shapesManager.addShape(new Rectangle(100, 150, Color.orange, 100, 200, true));
        shapesManager.addShape(new Square(100, Color.red, 400, 100, true));
        shapesManager.addShape(new Circle(40, Color.blue, 20, 50, true));
        shapesManager.addShape(new Quadrilateral(new int[]{800, 780, 700, 685, 740}, new int[]{300, 450, 480, 330, 100}, 5, Color.green, 800, 300, true));
        shapesManager.addShape(new Quadrilateral(new int[]{150, 350, 350, 150}, new int[]{300, 300, 500, 500}, 4, Color.darkGray, 150, 300, true));


        //Create and configure our JFrame (window)
        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Class:Software Development 2021/22 CA1:Inheritance");
        customWindow.setVisible(true);

    }
}
