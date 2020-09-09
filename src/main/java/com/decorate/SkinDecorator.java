package com.decorate;

import com.chen.GameObject;

import java.awt.*;

public class SkinDecorator extends Decorator {

    public SkinDecorator(GameObject go){
        super(go);

    }

    @Override
    public void paint(Graphics g) {
        x = go.x;
        y = go.y;
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(x,y,getWidth()+ 2,getHeight()+2);
        g.setColor(color);
        go.paint(g);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
