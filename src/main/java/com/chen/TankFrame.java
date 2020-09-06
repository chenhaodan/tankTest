package com.chen;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TankFrame extends Frame {

    public final static int GAME_WIDTH = 800 , GAME_HEIGHT = 1000;

    int x = 100 , y = 200;
    Dir dir = Dir.DOWN;
    GameModel gm = new GameModel();


    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offImageScreen = null;

    @Override
    public void update(Graphics g) {
        if(offImageScreen == null){
            offImageScreen = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics imageScreen = offImageScreen.getGraphics();
        Color color = imageScreen.getColor();
        imageScreen.setColor(Color.BLACK);
        imageScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        paint(imageScreen);
        imageScreen.setColor(color);
        g.drawImage(offImageScreen,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }

    public class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL =true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    gm.getMainTank().fire(new FireSingleStratege());
                    break;
                case KeyEvent.VK_SHIFT:
                    gm.getMainTank().fire(new FireDirStratege());
                    break;
                default:
                    break;
            }

            setMainDir();
        }

        private void setMainDir() {
            Tank tank = gm.getMainTank();
            if(!bL && !bU && !bR && !bD){
                tank.setMoving(false);
            }else {
                tank.setMoving(true);
                if(bL) tank.setDir(Dir.LEFT);
                if(bU) tank.setDir(Dir.UP);
                if(bR) tank.setDir(Dir.RIGHT);
                if(bD) tank.setDir(Dir.DOWN);
            }


        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                default:
                    break;
            }

            setMainDir();
        }
    }
}
