package com.gabor.ca1;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class for controlling own shapes created.
 */
public class ShapesManager{
    protected boolean displayName;
    protected boolean displayBoundingBox;


    private ArrayList<Shape> shapes;

    /**
     * Constructor to initialize an instance of ShapesManager as a new arraylist.
     */
    public ShapesManager() { shapes = new ArrayList<>(); }

    /**
     * Method for adding shapes to the above arraylist.
     * @param shapeToAdd: Created shapes to be stored in the above arraylist.
     */
    public void addShape(Shape shapeToAdd) { shapes.add(shapeToAdd); }

    /**
     * Getter method to make the added shapes available to other classes.
     * @return: shapes
     */
    public ArrayList<Shape> getShapes() { return shapes; }

    /**
     * Method for displaying the names of the shapes and also the Bounding Box if their value is set to true.
     * @param g: Allows the application to draw onto the relevant component.
     */
    public void drawShape(Graphics g) {
        for (Shape currentShape : shapes)
        {
            currentShape.drawShape(g);
            // displaying names
            if (displayName == true) {
                g.drawString(currentShape.getClass().getSimpleName(), currentShape.xCenter, currentShape.yCenter);
            }
            // Displaying Bounding Box
            if (displayBoundingBox == true) {
                currentShape.drawBoundingBox(g);
            }
        }

    }

    /**
     * Setter method to allow the change of the name display value.
     * @param displayName: Boolean value for displaying the name of the shapes.
     */
    public void setDisplayName(boolean displayName) { this.displayName = displayName; }

    /**
     * Setter method to allow the change of the Bounding Box display value.
     * @param displayBoundingBox: Boolean value for displaying the Bounding Box.
     */
    public void setDisplayBoundingBox(boolean displayBoundingBox) { this.displayBoundingBox = displayBoundingBox; }
}
