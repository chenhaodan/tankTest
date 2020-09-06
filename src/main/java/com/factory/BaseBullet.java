package com.factory;

import com.chen.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collideWith(Tank tank);
}
