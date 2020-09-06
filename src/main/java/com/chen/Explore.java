package com.chen;

import com.factory.BaseExplore;

import java.awt.*;

public class Explore {
    private int x ;
    private int y ;
    TankFrame tf;
    private int step = 0;
    public final static int WIDTH = ResourceMgr.exploere[0].getWidth();
    public final static int HEIGHT = ResourceMgr.exploere[0].getHeight();


    public Explore(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        //TODO 爆炸声音
//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g){
        if(step < 16){
            g.drawImage(ResourceMgr.exploere[step],x,y,null);
            step++;
        }else {
            tf.explores.remove(this);
        }
    }
}
