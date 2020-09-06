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
    Tank tank = new Tank(100,200,Dir.DOWN,this,Group.GOOD);

    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> enemy = new ArrayList<Tank>();
    List<Explore> explores = new ArrayList<>();
//    Bullet b = new Bullet(200,200,Dir.DOWN);

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
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.drawString("子弹个数" + bullets.size(),10,100);
        g.drawString("坦克个数" + enemy.size(),10,150);
        g.drawString("爆炸个数" + explores.size(),10,200);
        g.setColor(color);
        tank.paint(g);
        for(int i = 0 ; i < bullets.size() ; i++){
            bullets.get(i).paint(g);
        }

        for(int i = 0 ; i < enemy.size() ; i++){
            enemy.get(i).paint(g);
        }

        for (int i = 0 ; i < explores.size() ; i++){
            explores.get(i).paint(g);
        }

        for (int i = 0 ; i < bullets.size() ; i++){
            for (int j = 0 ; j < enemy.size() ; j++){
                bullets.get(i).collideWith(enemy.get(j));
            }
        }


//        b.paint(g);
//        x += 20;
//        y += 20;
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
                    tank.fire(new FireSingleStratege());
                    break;
                case KeyEvent.VK_SHIFT:
                    tank.fire(new FireDirStratege());
                    break;
                default:
                    break;
            }

            setMainDir();
        }

        private void setMainDir() {

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
