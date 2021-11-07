package com.gabor.ca1;

import java.awt.*;

/**
 * This is a subclass of Shape that empowering itself to be drawn on the screen.
 * It inherits all attributes and operations from the Shape class and also implements Movable interface.
 * It relies on java.awt.Graphics object to perform the drawing.
 */
public class Rectangle extends Shape implements Movable{
    private int width;
    private int length;
    private Movable movable;


    /**
     * This constructor is using super() to invoke the superclass constructor.
     * It is also initializing width, length, nPoints and isMovable.
     */
    public Rectangle() {
        super();
        width = 200;
        length = 100;
        this.isMovable = true;
    }


    /**
     * This constructor is defining an instance of Movable.
     * @param movable: Instance of the Movable interface.
     */
    public Rectangle(Movable movable) { this.movable = movable; }


    /**
     * This constructor is defining width, length and initializing isMovable.
     * @param width: The width of the Rectangle.
     * @param length: The length of the Rectangle.
     */
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
        this.isMovable = true;
    }


    /**
     * This constructor is using super() to invoke the superclass constructor
     * with color, xCenter, yCenter and filled parameters. It is also defining
     * width, length and initializing xLeft, yBottom, xRight, yTop and isMovable.
     * @param width: The width of the Rectangle.
     * @param length: The length of the Rectangle.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    public Rectangle(int width, int length, Color color, int xCenter, int yCenter ,boolean filled) {
        super(color, xCenter, yCenter, filled);
        this.width = width;
        this.length = length;
        this.xLeft = this.xCenter;
        this.yBottom = this.yCenter + length;
        this.xRight = this.xCenter + width;
        this.yTop = this.yCenter;
        this.isMovable = true;
    }

    /**
     * Getter method returning the value of the width attribute.
     * @return: width
     */
    public int getWidth() { return width; }

    /**
     * Setter method for the above getter method to protect the width attribute,
     * however allow a value to be assigned to it.
     * @param width: The width of the Rectangle.
     */
    public void setWidth(int width) { this.width = width; }

    /**
     * Getter method returning the value of the length attribute.
     * @return: length
     */
    public int getLength() { return length; }

    /**
     * Setter method for the above getter method to protect the length attribute,
     * however allow a value to be assigned to it.
     * @param length: The length of the Rectangle.
     */
    public void setLength(int length) { this.length = length; }

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
     * @return
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
     * Setter method for the Movable's instance.
     * @param movable: Instance of the Movable interface.
     */
    public void setMovable(Movable movable) { this.movable = movable; }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the Rectangle shape.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the filling of the shape.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(this.color);

        if (this.filled == true) {
            g.fillRect(xCenter, yCenter, width, length);
        }
        else {
            g.drawRect(xCenter, yCenter, width, length);
        }
    }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the Rectangle
     * shape's Bounding box.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the type of drawn lines.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawBoundingBox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g2d.setColor(Color.black);
        final float dash[] = { 2.0f };
        final BasicStroke dashed = new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash,
                0.0f);
        g2d.setStroke(dashed);
        g2d.drawRect(xCenter, yCenter, width, length);
    }


    /**
     * This is an overridden version of the Shape classes abstract method.
     * This will allow with appropriate overriding to implement unique moving technique for the Rectangle
     * shape and its Bounding box.
     */
    @Override
    public void moveTenUnits() {
        this.xCenter += 10;
        this.xLeft += 10;
        this.xRight += 10;
    }


    /**
     * This class makes no use of this particular abstract method of the superclass as yet.
     */
    @Override
    public void rotateNinetyDegrees() {}
}
