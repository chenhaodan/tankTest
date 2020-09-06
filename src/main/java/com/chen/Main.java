package com.chen;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        int initCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        for(int i = 0 ; i < initCount ; i++){
            f.enemy.add(new Tank(200 + i * 60,200,Dir.DOWN,f,Group.BAD));
        }
        while (true){
            Thread.sleep(50);
            f.repaint();


        }

    }
}
