package com.chen;

import java.awt.*;

public class Wall extends GameObject {

    int x ;
    int y;
    int width , height;
    Rectangle rect ;

    public Wall(int x , int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x,y,width,height);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.GRAY);
        g.drawRect(x,y,30,200);
        g.setColor(color);
    }

    public boolean collideWith(Bullet bullet) {
            rect.setLocation(x,y);
            Rectangle bRect = bullet.getRect();
            if(rect.intersects(bRect)){
                bullet.die();
                return false;
            }

        return true;
    }
}
