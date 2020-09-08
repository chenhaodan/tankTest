package com.chen;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        String colliders = (String) PropertyMgr.get("colliders");
        String[] cs = colliders.split(";");
        for (String clazz : cs){
            try {
                add((Collider)Class.forName(clazz).getConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        add(new BulletTankCollider()).add(new TankTankCollider());
    }

    public ColliderChain add(Collider c){
        colliders.add(c);
        return this;
    }

    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        for(Collider collider : colliders){
            if(!collider.collideWith(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
