package com.chen;

import com.factory.BaseExplore;

import java.awt.*;

public class Explore extends GameObject{
//    private int x ;
//    private int y ;
    private int step = 0;
    public final static int WIDTH = ResourceMgr.exploere[0].getWidth();
    public final static int HEIGHT = ResourceMgr.exploere[0].getHeight();


    public Explore(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().add(this);
        //TODO 爆炸声音
//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g){
        if(step < 16){
            g.drawImage(ResourceMgr.exploere[step],x,y,null);
            step++;
        }else {
            GameModel.getInstance().gameObjects.remove(this);
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }


}
