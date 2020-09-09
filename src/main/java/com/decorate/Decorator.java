package com.decorate;

import com.chen.GameObject;

public abstract class Decorator extends GameObject {
    GameObject go;

    public Decorator(GameObject go){
        this.go = go;
    }

}
