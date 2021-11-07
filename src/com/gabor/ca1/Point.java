package com.gabor.ca1;

/**
 * Class to aid the storing of point coordinates.
 **/
public class Point {
    private int x;
    private int y;

    /**
     * Constructor defining x and y.
     * @param x: The x value of the point.
     * @param y: The y value of the point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method to make x available to other classes.
     * @return: x
     */
    public int getX() { return x; }

    /**
     * Setter method for the x attribute, defining x.
     * @param x: The x value of the point.
     */
    public void setX(int x) { this.x = x; }

    /**
     * Getter method to make x available to other classes.
     * @return: y
     */
    public int getY() { return y; }

    /**
     * Setter method for the y attribute, defining y.
     * @param y: The y value of the point.
     */
    public void setY(int y) { this.y = y; }
}
