package com.decorate;

import com.chen.GameObject;

import java.awt.*;

public class TailDecorator extends Decorator {

    public TailDecorator(GameObject go){
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        x = go.x;
        y = go.y;
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(x,y,x+2,y +2);
        g.setColor(color);
        go.paint(g);

        go.paint(g);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
