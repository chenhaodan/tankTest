//package com.factory;
//
//import com.chen.Dir;
//import com.chen.Group;
//import com.chen.TankFrame;
//
//public class RectFactory extends GameFactory {
//    @Override
//    public BaseExplore createExplore(int x, int y, TankFrame tf) {
//        return new RectExplore(x,y,tf);
//    }
//
//    @Override
//    public BaseBullet createBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
//        return new RectBullet(x,y,dir,tf,group);
//    }
//}
