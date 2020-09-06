package com.factory;

import com.chen.ResourceMgr;
import com.chen.TankFrame;

import java.awt.*;

public class RectExplore extends BaseExplore {
    private int x ;
    private int y ;
    TankFrame tf;
    private int step = 0;
    public final static int WIDTH = RectResourceMgr.exploere[0].getWidth();
    public final static int HEIGHT = RectResourceMgr.exploere[0].getHeight();

    public RectExplore(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {
        if(step < 11){
            g.drawImage(RectResourceMgr.exploere[step],x,y,null);
            step++;
        }else {
            tf.explores.remove(this);
        }
    }
}
