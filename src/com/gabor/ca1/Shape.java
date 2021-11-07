package com.gabor.ca1;

import javax.swing.*;
import java.awt.*;

/**
 * Here I am declaring an abstract class Shape.
 * All particular shapes will inherit the attributes and operations that are created here.
 * Abstract classes usually would have at least one abstract method. I have created a couple of these here as:
 * drawShape(Graphics g), drawBoundingBox(Graphics graphicsContext), rotateNinetyDegrees(), public abstract void moveTenUnits().
 * The subclasses may override these on the appropriate way the relevant shape would require.
 */
public abstract class Shape extends JFrame {

    protected Color color;
    protected  boolean filled;
    protected int xCenter, yCenter;
    protected int xLeft, yBottom, xRight, yTop;
    protected boolean isMovable = false;
    protected boolean isRotatable = false;


    /**
     * This constructor initializing xCenter and yCenter.
     */
    Shape() { this(0,0); }


    /**
     * This constructor invokes the xCenter and yCenter attributes and also initializing the color attribute.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     */
    Shape(int xCenter, int yCenter){ this(Color.black, xCenter,yCenter); }


    /**
     * This constructor invokes the color, xCenter and yCenter attributes and also initializing the filled attribute.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     */
    Shape(Color color, int xCenter, int yCenter){ this(color, xCenter, yCenter, false); }


    /**
     * This constructor invokes the color, xCenter, yCenter and filled attributes.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    Shape(Color color, int xCenter, int yCenter, boolean filled)
    {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.filled = filled;
    }


    /**
     * This abstract method invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing techniques for each type of shapes.
     * @param g: Allows the application to draw onto the relevant component.
     */
    public abstract void drawShape (Graphics g);


    /**
     * This abstract method invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing techniques for the Bounding box of each type of shapes.
     * @param graphicsContext: Allows the application to draw onto the relevant component.
     */
    public abstract void drawBoundingBox(Graphics graphicsContext);


    /**
     * This abstract method will allow shapes to implement their own rotation method.
     */
    public abstract void rotateNinetyDegrees();


    /**
     * This abstract method will allow shapes to implement their own move method.
     */
    public abstract void moveTenUnits();
}
