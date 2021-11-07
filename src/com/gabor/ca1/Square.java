package com.gabor.ca1;

import java.awt.*;

/**
 * This is a subclass of both Shape and Rectangle that empowering itself to be drawn on the screen.
 * It inherits all attributes and operations from the Shape and Rectangle classes
 * and also implements Movable interface through inheritance.
 * It relies on java.awt.Graphics object to perform the drawing.
 */
public class Square extends Rectangle {
    private int side;


    /**
     * This constructor is using super() to invoke the superclass constructor.
     * It is also initializing side.
     */
    public Square() {
        super();
        this.side = 100;
    }


    /**
     * This constructor is using super() to invoke the Rectangle superclass constructor with side parameter.
     * It is also defining side.
     * @param side: The width of the square.
     */
    public Square(int side) {
        super(side,side);
        this.side = side;
    }


    /**
     * This constructor is using super() to invoke the superclass constructor
     * using side, side, color, xCenter, yCenter and filled parameters.
     * It is also initializing xLeft, xRight, yBottom and yTop.
     * @param side: The width of the square.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    public Square(int side, Color color, int xCenter, int yCenter, boolean filled) {
        super(side, side, color, xCenter, yCenter, filled);
        this.side = side;
        this.xLeft = this.xCenter;
        this.yBottom = this.yCenter + this.side;
        this.xRight = this.xCenter + this.side;
        this.yTop = this.yCenter;
    }


    /**
     * Getter method returning the value of the side attribute.
     * @return: side
     */
    public double getSide() { return side; }

    /**
     * Setter method for the above getter method to protect the side attribute,
     * however allow a value to be assigned to it.
     * @param side: The width of the square.
     */
    public void setSide(int side) { this.side = side; }


    /**
     * Getter method returning the value of the xLeft attribute.
     * @return: xLeft
     */
    public int getxLeft() { return xLeft; }

    /**
     * Setter method for the above getter method to protect the xLeft attribute,
     * however allow a value to be assigned to it.
     * @param xLeft: The smallest x value between the points of the shape.
     */
    public  void setxLeft(int xLeft) { this.xLeft = xLeft; }


    /**
     * Getter method returning the value of the xRight attribute.
     * @return: xRight
     */
    public int getxRight() { return xRight; }

    /**
     * Setter method for the above getter method to protect the xRight attribute,
     * however allow a value to be assigned to it.
     * @param xRight: The largest x value between the points of the shape.
     */
    public  void setxRight(int xRight) { this.xRight = xRight; }


    /**
     * Getter method returning the value of the yBottom attribute.
     * @return: yBottom
     */
    public int getyBottom() { return yBottom; }

    /**
     * Setter method for the above getter method to protect the yBottom attribute,
     * however allow a value to be assigned to it.
     * @param yBottom: The largest y value between the points of the shape.
     */
    public  void setyBottom(int yBottom) { this.yBottom = yBottom; }


    /**
     * Getter method returning the value of the yTop attribute.
     * @return: yTop
     */
    public int getyTop() { return yTop; }

    /**
     * Setter method for the above getter method to protect the yTop attribute,
     * however allow a value to be assigned to it.
     * @param yTop: The smallest y value between the points of the shape.
     */
    public  void setyTop(int yTop) { this.yTop = yTop; }


    /**
     * Overridden setter method of the Rectangle's width attribute to define the side.
     * @param side: The width of the square.
     */
    @Override
    public void setWidth(int side) { setSide(side); }


    /**
     * Overridden setter method of the Rectangle's width attribute to define the side.
     * @param side: The width of the square.
     */
    @Override
    public void setLength(int side) { setSide(side); }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the Square shape.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the filling of the shape.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(this.color);

        if (this.filled == true) {
            g.fillRect(xCenter, yCenter, getWidth(), getWidth());
        }
        else {
            g.drawRect(xCenter, yCenter, getWidth(), getWidth());
        }
    }
}

