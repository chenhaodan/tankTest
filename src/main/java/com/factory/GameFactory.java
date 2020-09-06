package com.factory;

import com.chen.Dir;
import com.chen.Group;
import com.chen.TankFrame;

public abstract class GameFactory {

    public abstract BaseExplore createExplore(int x, int y,TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group);
}
