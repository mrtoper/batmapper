package com.glaurung.batMap.gui;

import java.awt.Color;

public class RoomColors {

    public static Color NORMAL = null;
    public static Color RED = new Color( 255, 0, 0 );
    public static Color YELLOW = new Color( 255, 255, 0 );
    public static Color BLUE = new Color( 0, 0, 255 );
    public static Color PINK = new Color( 255, 0, 255 );
    public static Color PURPLE = new Color( 160, 32, 240 );
    public static Color ORANGE = new Color( 255, 165, 0 );
    public static Color BROWN = new Color( 139, 69, 19 );
    public static Color TURQUOISE = new Color( 64, 224, 208 );
    public static Color IVORY = new Color( 255, 255, 240 );

    private static String[] colorNameList = { "normal", "red", "yellow", "blue", "pink", "purple", "orange", "brown", "turquoise", "ivory" };
    private static Color[] colorList = { NORMAL, RED, YELLOW, BLUE, PINK, PURPLE, ORANGE, BROWN, TURQUOISE, IVORY };


    public static String[] getColorNames() {
        return colorNameList;
    }

    public static Color[] getColors() {
        return colorList;
    }

    public static int getIndex( String color ) {
        if (color == null) {
            return 0;
        } else if (color.equals("red")) {
            return 1;
        } else if (color.equals("yellow")) {
            return 2;
        } else if (color.equals("blue")) {
            return 3;
        } else if (color.equals("pink")) {
            return 4;
        } else if (color.equals("purple")) {
            return 5;
        } else if (color.equals("orange")) {
            return 6;
        } else if (color.equals("brown")) {
            return 7;
        } else if (color.equals("turquoise")) {
            return 8;
        } else if (color.equals("ivory")) {
            return 9;
        } else {
            return 0;
        }
    }

    public static int getIndex( Color color ) {
        if (color == null) {
            return 0;
        } else if (color.equals( RED )) {
            return 1;
        } else if (color.equals( YELLOW )) {
            return 2;
        } else if (color.equals( BLUE )) {
            return 3;
        } else if (color.equals( PINK )) {
            return 4;
        } else if (color.equals( PURPLE )) {
            return 5;
        } else if (color.equals( ORANGE )) {
            return 6;
        } else if (color.equals( BROWN )) {
            return 7;
        } else if (color.equals( TURQUOISE )) {
            return 8;
        } else if (color.equals( IVORY )) {
            return 9;
        } else {
            return 0;
        }
    }
}
