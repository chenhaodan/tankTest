package com.chen;

public class FireDirStratege implements FireStratege {
    @Override
    public void fire( Tank tank) {
        int x = tank.getX();
        int y = tank.getY();
        Dir dir = tank.getDir();
        Group group = tank.getGroup();
        int bX = x;
        int bY = y;
        if(dir == Dir.LEFT || dir == Dir.RIGHT){
            bX = x + Tank.WIDTH/2 - Bullet.WIDTH / 2;
            bY = y + Tank.HEIGHT/2 - Bullet.HEIGHT / 2 + 5;
        }else {
            bX = x + Tank.HEIGHT/2 - Bullet.HEIGHT / 2;
            bY = y + Tank.WIDTH/2 - Bullet.WIDTH / 2;
        }
        new Bullet(bX,bY,Dir.LEFT,group);
        new Bullet(bX,bY,Dir.UP,group);
        new Bullet(bX,bY,Dir.RIGHT,group);
        new Bullet(bX,bY,Dir.DOWN,group);

    }
}
