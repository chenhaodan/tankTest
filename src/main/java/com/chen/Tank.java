package com.chen;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject{

    private int x ;
    private int y ;
    private int oldX;
    private int oldY;
    private Dir dir;
    private boolean moving = true;
    private boolean living = true;
    private Group group;
    private Rectangle rect = null;

    private Random random = new Random();

    public final static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public final static int HEIGHT = ResourceMgr.goodTankD.getHeight();
    public final static int SPEED = 2;

    public Tank(int x, int y, Dir dir,GameModel gm,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect = new Rectangle(x,y,Tank.WIDTH,Tank.HEIGHT);
        if(group == Group.GOOD){
            moving = false;
        }
        GameModel.getInstance().add(this);
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,50,50);
//        g.setColor(color);

        if(group == Group.BAD){
            switch (dir){
                case LEFT:
                    g.drawImage(ResourceMgr.badTankL,x,y,null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.badTankU,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.badTankR,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.badTankD,x,y,null);
                    break;
            }
        }else {
            switch (dir){
                case LEFT:
                    g.drawImage(ResourceMgr.goodTankL,x,y,null);
                    break;
                case UP:
                    g.drawImage(ResourceMgr.goodTankU,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(ResourceMgr.goodTankR,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(ResourceMgr.goodTankD,x,y,null);
                    break;
            }
        }


        move();
        rect.x = x;
        rect.y = y;


    }


    private void move() {
        if(!living) GameModel.getInstance().gameObjects.remove(this);
        if(moving){
            oldX = x;
            oldY = y;
            switch (dir){
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

        if(Group.BAD == group){
            if(random.nextInt(10) > 8){
                this.fire();
            }

            if(random.nextInt(100) > 90){
                changeDir();
            }
        }
        
        checkBound();

    }

    private void checkBound() {
        if(x < 0 ) x = 2;
        if(y < 0 ) y = 2;
        if(x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        if(y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void changeDir() {
        int randomIndex = random.nextInt(4);
        dir = Dir.values()[randomIndex];
    }

    public void fire() {
        int bX = x;
        int bY = y;
        if(dir == Dir.LEFT || dir == Dir.RIGHT){
            bX = x + Tank.WIDTH/2 - Bullet.WIDTH / 2;
            bY = y + Tank.HEIGHT/2 - Bullet.HEIGHT / 2 + 5;
        }else {
            bX = x + Tank.HEIGHT/2 - Bullet.HEIGHT / 2;
            bY = y + Tank.WIDTH/2 - Bullet.WIDTH / 2;
        }

        GameModel.getInstance().gameObjects.add(new Bullet(bX,bY,dir,group));
    }

    public void fire(FireStratege fireStratege) {
        fireStratege.fire(this);
    }

    public void die() {
        living = false;
    }
}
