package com.chen;

import com.decorate.SkinDecorator;
import com.decorate.TailDecorator;

public class FireSingleStratege implements FireStratege{

    @Override
    public void fire(Tank tank) {
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
        GameModel.getInstance().gameObjects.add(new TailDecorator(new SkinDecorator(new Bullet(bX,bY,dir,group))));
    }
}
