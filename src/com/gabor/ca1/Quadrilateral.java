package com.gabor.ca1;

import java.awt.*;
import java.util.*;

/**
 * This is a subclass of Shape that empowering itself to be drawn on the screen.
 * It inherits all attributes and operations from the Shape class and also implements Rotatable interface.
 * It relies on java.awt.Graphics object to perform the drawing and also on java.util.* in an aim to help organize information.
 **/
public class Quadrilateral extends Shape implements Rotatable{
    private int xPoints[];
    private int yPoints[];
    private int nPoints;

    /**
     * This constructor is using super() to invoke the superclass constructor.
     * It is also initializing xPoints, yPoints, nPoints and isRotatable.
     **/
    public Quadrilateral() {
        super();
        int xPoints[] = {500, 480, 400, 385, 440};
        int yPoints[] = {300, 450, 480, 330, 100};
        int nPoints = 5;
        isRotatable = true;
    }

    /**
     * This constructor is defining xPoints, yPoints, nPoints.
     * @param xPoints: The array of the x points of the Quadrilateral.
     * @param yPoints: The array of the y points of the Quadrilateral.
     * @param nPoints: The number of the vertices.
     */
    public Quadrilateral(int[] xPoints, int[] yPoints, int nPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
    }

    /**
     * This constructor is using super() to invoke the superclass constructor
     * with color, xCenter, yCenter and filled parameters.
     * It is also initializing the same attributes as above and defining
     * xLeft, xRight, yBottom, yTop and isRotatable.
     * @param xPoints: The array of the x points of the Quadrilateral.
     * @param yPoints: The array of the y points of the Quadrilateral.
     * @param nPoints: The number of the vertices.
     * @param color: The color of the shape.
     * @param xCenter: The x point of the relative center point of drawing.
     * @param yCenter: The y point of the relative center point of drawing.
     * @param filled: Describing if the relevant shape is filled or not.
     */
    public Quadrilateral(int[] xPoints, int[] yPoints, int nPoints, Color color, int xCenter, int yCenter, boolean filled) {
        super(color, xCenter, yCenter, filled);
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
        int[] xValues = new int[xPoints.length];
        System.arraycopy(xPoints, 0, xValues, 0, xPoints.length);
        Arrays.sort(xValues);
        this.xLeft = xValues[0];
        this.xRight = xValues[xValues.length-1];
        int[] yValues = new int[yPoints.length];
        System.arraycopy(yPoints, 0, yValues, 0, yPoints.length);
        Arrays.sort(yValues);
        this.yBottom = yValues[yValues.length-1];
        this.yTop = yValues[0];
        isRotatable = true;
    }

    /**
     * Getter method returning the value of the xPoints attribute.
     * @return: xPoints
     */
    public int[] getxPoints() { return xPoints; }

    /**
     * Setter method for the above getter method to protect the xPoints attribute,
     * however allow a value to be assigned to it.
     * @param xPoints: The array of the x points of the Quadrilateral.
     */
    public void setxPoints(int[] xPoints) { this.xPoints = xPoints; }

    /**
     * Getter method returning the value of the yPoints attribute.
     * @return: yPoints
     */
    public int[] getyPoint() { return yPoints; }

    /**
     * Setter method for the above getter method to protect the yPoints attribute,
     * however allow a value to be assigned to it.
     * @param yPoints: The array of the y points of the Quadrilateral.
     */
    public void setyPoints(int[] yPoints) { this.yPoints = yPoints; }

    /**
     * Getter method returning the value of the nPoints attribute.
     * @return: nPoints
     */
    public int getnPoints() { return nPoints; }

    /**
     * Setter method for the above getter method to protect the nPoints attribute,
     * however allow a value to be assigned to it.
     * @param nPoints: The number of the vertices.
     */
    public void setnPoints(int nPoints) { this.nPoints = nPoints; }

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
     * Getter method returning the value of the xLeft attribute.
     * @return: xLeft
     */
    public int getxLeft(){ return xLeft; }

    /**
     * Setter method for the above getter method to protect the xLeft attribute,
     * however allow a value to be assigned to it.
     * @param xLeft: The smallest x value between the points of the shape.
     */
    public void setxLeft(int xLeft) { this.xLeft = xLeft; }

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
    public int getyTop(){ return yTop; }

    /**
     * Setter method for the above getter method to protect the yTop attribute,
     * however allow a value to be assigned to it.
     * @param yTop: The smallest y value between the points of the shape.
     */
    public void setyTop(int yTop) { this.yTop = yTop; }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the Quadrilateral shape.
     * It is making use of methods to assign the relevant color and use the appropriate version of drawing
     * in regard to the filling of the shape.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(this.color);

        if (this.filled == true) {
            g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);
        }
        else {
            g.drawPolygon(this.xPoints, this.yPoints, this.nPoints);
        }
    }


    /**
     * This is an overridden version of the Shape classes abstract method that invokes the Graphics abstract class.
     * This will allow with appropriate overriding to implement unique drawing technique for the Quadrilateral
     * shape's Bounding box.
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
        g2d.drawRect(xLeft, yTop, xRight-xLeft, yBottom-yTop);
    }


    /**
     * This is an overridden version of the Shape classes abstract method.
     * This will allow with appropriate overriding to implement unique rotating technique for the Quadrilateral
     * shape and its Bounding box.
     */
    @Override
    public void rotateNinetyDegrees() {
        for (int i = 0; i < this.xPoints.length; i++) {
            int[] xPcopy = new int[xPoints.length];
            System.arraycopy(xPoints, 0, xPcopy, 0, xPoints.length);
            xPoints[i] = (int)Math.round(Math.cos(1.571)*(xPoints[i]-xCenter)-Math.sin(1.571)*(yPoints[i]-yCenter)+xCenter);
            yPoints[i] = (int)Math.round(Math.sin(1.571)*(xPcopy[i]-xCenter)-Math.cos(1.571)*(yPoints[i]-yCenter)+yCenter);
        }
        int[] xValues1 = new int[xPoints.length];
        System.arraycopy(xPoints, 0, xValues1, 0, xPoints.length);
        Arrays.sort(xValues1);
        this.xLeft = xValues1[0];
        this.xRight = xValues1[xValues1.length-1];
        int[] yValues1 = new int[yPoints.length];
        System.arraycopy(yPoints, 0, yValues1, 0, yPoints.length);
        Arrays.sort(yValues1);
        this.yBottom = yValues1[yValues1.length-1];
        this.yTop = yValues1[0];
    }


    /**
     * This class makes no use of this particular abstract method of the superclass as yet.
     */
    @Override
    public void moveTenUnits() {}
}
