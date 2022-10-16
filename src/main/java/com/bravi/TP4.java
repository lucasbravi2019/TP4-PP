package com.bravi;

import com.bravi.dispositivos.Pantalla;

import javax.swing.*;
import java.awt.*;

public class TP4 {

    public static final int HALF_WIDTH = 1280 / 2;
    public static final int HALF_HEIGHT = 720 / 2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pantalla");
        frame.setLocationRelativeTo(frame);
        frame.setContentPane(new Pantalla().getAppGui());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        int xPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x - HALF_WIDTH;
        int yPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y - HALF_HEIGHT;
        frame.setLocation(xPoint, yPoint);
    }

}
