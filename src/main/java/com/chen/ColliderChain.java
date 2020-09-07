package com.chen;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    private List<Collider> colliders = new LinkedList<>();

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
