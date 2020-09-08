package com.chen;

public class WallBulletCollider implements Collider {
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet)o1;
            Wall wall = (Wall) o2;
            return !wall.collideWith(bullet);
        }else if(o2 instanceof Bullet && o1 instanceof Wall){
            return collideWith(o2,o1);
        }
        return true;
    }



}
