package com.chen;

public class FireDirStratege implements FireStratege {
    @Override
    public void fire(TankFrame tf, Tank tank) {
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
//        tf.bullets.add(new Bullet(bX,bY,Dir.LEFT,tf,group));
//        tf.bullets.add(new Bullet(bX,bY,Dir.UP,tf,group));
//        tf.bullets.add(new Bullet(bX,bY,Dir.RIGHT,tf,group));
//        tf.bullets.add(new Bullet(bX,bY,Dir.DOWN,tf,group));
        tf.bullets.add(tf.gf.createBullet(bX,bY,Dir.LEFT,tf,group));
        tf.bullets.add(tf.gf.createBullet(bX,bY,Dir.UP,tf,group));
        tf.bullets.add(tf.gf.createBullet(bX,bY,Dir.RIGHT,tf,group));
        tf.bullets.add(tf.gf.createBullet(bX,bY,Dir.DOWN,tf,group));
    }
}
