package com.chen;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        while (true){
            Thread.sleep(50);
            f.repaint();


        }

    }
}
