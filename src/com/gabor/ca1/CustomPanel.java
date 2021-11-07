package com.gabor.ca1;

import javafx.geometry.BoundingBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {

    protected boolean rightMousePressed;
    protected boolean leftMousePressed;

    public boolean getLeftMousePressed() {
        return leftMousePressed;
    }
    public boolean getRightMousePressed() {
        return rightMousePressed;
    }


    private ShapesManager shapesManager;

    /**
     * Constructor to aid the unique drawing techniques and appropriate actions on relevant events.
     * @param shapesManager: Instance of the ShapesManager object
     */
    public CustomPanel(ShapesManager shapesManager) {

        this.shapesManager = shapesManager;

        // MouseAdapter allows tracking mouse events
        addMouseListener(new MouseAdapter() {

            /**
             * Overridden method of the MouseEvents to allow unique behaviours.
             * @param e: Instance of the MouseEvent object.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int modifiers = e.getModifiersEx();

                // If left mouse button is clicked set value of leftMousePressed to true
                if ((modifiers & InputEvent.BUTTON1_DOWN_MASK) == InputEvent.BUTTON1_DOWN_MASK) {
                    System.out.printf("Left button is pressed");
                    leftMousePressed = true;
                }

                if ((modifiers & InputEvent.BUTTON2_DOWN_MASK) == InputEvent.BUTTON2_DOWN_MASK) {
                    System.out.printf("Middle button is pressed");
                }

                // If right mouse button is clicked set value of rightMousePressed to true
                if ((modifiers & InputEvent.BUTTON3_DOWN_MASK) == InputEvent.BUTTON3_DOWN_MASK) {
                    System.out.printf("Right button is pressed");
                    rightMousePressed = true;
                }

                // if left mouse button is pressed loop through shapes
                if (leftMousePressed) {
                    for (Shape currentShape : shapesManager.getShapes()) {
                        // if the point of the click was within the current shape toggle color.
                        if (currentShape.xLeft <= e.getX() && (currentShape.xRight >= e.getX()) && (currentShape.yTop <= e.getY()) && (currentShape.yBottom >= e.getY())) {
                            if (currentShape.filled) {
                                currentShape.filled = false;
                                repaint();

                            } else {
                                currentShape.filled = true;
                                repaint();
                            }
                        }
                    }
                    leftMousePressed = false;
                }

                // if right mouse button is pressed loop through shapes
                if (rightMousePressed) {
                    for (Shape currentShape : shapesManager.getShapes()) {
                        // if the point of the click was within the current shape move if movable, rotate if rotatable.
                        if (currentShape.xLeft <= e.getX() && (currentShape.xRight >= e.getX()) && (currentShape.yTop <= e.getY()) && (currentShape.yBottom >= e.getY())) {
                            if (currentShape.isMovable) {
                                currentShape.moveTenUnits();
                                repaint();
                            }
                            if (currentShape.isRotatable == true) {
                                currentShape.rotateNinetyDegrees();
                                repaint();
                            }
                            rightMousePressed = false;
                        }
                    }
                }
            }
        });
    }


    /**
     * Overridden method of the JComponent object. Allowing to custom draw to the panel.
     * @param g: Allows the application to draw onto the relevant component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        //The superclass does some important work in the method we've overridden, so we
        //should invoke it.

        super.paintComponent(g);

        shapesManager.drawShape(g);
    }
}
