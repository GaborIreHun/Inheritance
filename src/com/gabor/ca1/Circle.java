package com.gabor.ca1;

import java.awt.*;

/**
 * This is a subclass of Shape that empowering itself to be drawn on the screen.
 * It inherits all attributes and operations from the Shape class.
 * It relies on java.awt.Graphics object to perform the drawing.
 **/
public class Circle extends Shape {
    private int radius;

    /**
     * This constructor is using super() to invoke the superclass constructor.
     * It is also initializing radius.
     **/
    public Circle() {
        super();
        radius = 200;
    }

    /**
     * This constructor is using super() to invoke the superclass constructor
     * and also invokes radius and boolean and also defines its own radius.
     * @param radius: The radius of the circle.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    public Circle(int radius, boolean filled) {
        super();
        this.radius = radius;
    }

    /**
     * This constructor is using super() to invoke the superclass constructor
     * with color, xCenter, yCenter and filled parameters and also defines its own radius, xLeft, xRight, yTop and yBottom.
     * @param radius: The radius of the circle.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    public Circle(int radius, Color color, int xCenter, int yCenter, boolean filled) {
        super(color, xCenter, yCenter, filled);
        this.radius = radius;
        this.xLeft = this.xCenter;
        this.xRight = this.xCenter + radius*2;
        this.yTop = this.yCenter;
        this.yBottom = this.yCenter + radius*2;
    }


    /**
     * : Getter method returning the value of the radius attribute.
     * @return: radius
     */
    public int getRadius() { return radius; }

    /**
     * Setter method for the above getter method to protect the radius instance variable,
     * however allow a value to be assigned to it.
     * @param radius: The radius of the circle.
     */
    public void setRadius(int radius) { this.radius = radius; }


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
    public void setxLeft(int xLeft) { this.xLeft = xLeft;}


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
    public void setxRight(int xRight) { this.xRight = xRight; }

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
    public void setyBottom(int yBottom) { this.yBottom = yBottom; }

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
    public void setyTop(int yTop) { this.yTop = yTop; }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the circle shape.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the filling of the shape.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(this.color);

        if (this.filled == true) {
            g.fillOval(xCenter, yCenter, radius*2, radius*2);
        }
        else {
            g.drawOval(xCenter, yCenter, radius*2, radius*2);
        }
    }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the circle shape's Bounding box.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the type of drawn lines.
     * @param g2: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawBoundingBox(Graphics g2) {
        Graphics2D g2d = (Graphics2D) g2;
        g2.setColor(Color.black);
        g2d.setColor(Color.black);
        final float dash[] = { 2.0f };
        final BasicStroke dashed = new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash,
                0.0f);
        g2d.setStroke(dashed);
        g2d.drawRect(xCenter,yCenter,radius*2,radius*2);
    }


    /**
     * This class makes no use of this particular abstract method of the superclass as yet.
     */
    @Override
    public void rotateNinetyDegrees() {}


    /**
     * This class makes no use of this particular abstract method of the superclass as yet.
     */
    @Override
    public void moveTenUnits() {}
}
