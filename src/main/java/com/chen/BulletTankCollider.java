package com.chen;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet)o1;
            Tank tank = (Tank) o2;
            return !bullet.collideWith(tank);
        }else if(o2 instanceof Bullet && o1 instanceof Tank){
            return collideWith(o2,o1);
        }
        return true;
    }
}
