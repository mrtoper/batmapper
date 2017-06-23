package com.glaurung.batMap.gui;

public class Color {
    int r; int g; int b;
    transient java.awt.Color awtColor;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.awtColor = new java.awt.Color(r,g,b);
    }

    public java.awt.Color getAwtColor() { return awtColor; }
}
