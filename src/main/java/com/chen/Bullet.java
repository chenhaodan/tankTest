package com.chen;

import java.awt.*;

public class Bullet extends GameObject{

//    private int x , y;
    private Dir dir;
    public final static int SPEED = 10;
    public final static int WIDTH = ResourceMgr.bulletD.getWidth() ;
    public final static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean live = true;
    private Group group;
    private Rectangle rect = null;

    public Bullet(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x,y,WIDTH,HEIGHT);
//        GameModel.getInstance().add(this);
    }


    public void paint(Graphics g) {
        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(color);


        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();
        rect.x = x;
        rect.y = y;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        if(x <0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
        if(!live){
            GameModel.getInstance().gameObjects.remove(this);
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean collideWith(Tank tank) {
        if(group != tank.getGroup()){
            rect.setLocation(x,y);
            Rectangle tankRect = tank.getRect();
            if(rect.intersects(tankRect)){
                die();
                tank.die();
                int eX = tank.getX() + Tank.WIDTH / 2 - Explore.WIDTH / 2;
                int eY = tank.getY() + Tank.HEIGHT / 2 - Explore.HEIGHT / 2;
                new Explore(eX,eY);
                return false;
            }
        }
        return true;
    }

    public void die() {
        live = false;
    }

    public Rectangle getRect() {
        return rect;
    }
}
