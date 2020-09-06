package com.factory;

import com.chen.*;

public class DefaultFactory extends GameFactory {
    @Override
    public BaseExplore createExplore(int x, int y, TankFrame tf) {
        return new Explore(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        return new Bullet(x,y,dir,tf,group);
    }
}
