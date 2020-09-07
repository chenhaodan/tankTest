package com.chen;

public class BulletTankCollider extends Collider{
    @Override
    public void collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet)o1;
            Tank tank = (Tank) o2;
            bullet.collideWith(tank);
        }else if(o2 instanceof Bullet && o1 instanceof Tank){
            collideWith(o2,o1);
        }
    }
}
