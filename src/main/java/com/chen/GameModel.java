package com.chen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank tank = new Tank(100,200,Dir.DOWN,this,Group.GOOD);

    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> enemy = new ArrayList<Tank>();
    List<Explore> explores = new ArrayList<>();

    public GameModel(){
        int initCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        for(int i = 0 ; i < initCount ; i++){
            enemy.add(new Tank(200 + i * 60,200,Dir.DOWN,this,Group.BAD));
        }
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.drawString("子弹个数" + bullets.size(),10,100);
        g.drawString("坦克个数" + enemy.size(),10,150);
        g.drawString("爆炸个数" + explores.size(),10,200);
        g.setColor(color);
        tank.paint(g);
        for(int i = 0 ; i < bullets.size() ; i++){
            bullets.get(i).paint(g);
        }

        for(int i = 0 ; i < enemy.size() ; i++){
            enemy.get(i).paint(g);
        }

        for (int i = 0 ; i < explores.size() ; i++){
            explores.get(i).paint(g);
        }

        for (int i = 0 ; i < bullets.size() ; i++){
            for (int j = 0 ; j < enemy.size() ; j++){
                bullets.get(i).collideWith(enemy.get(j));
            }
        }

    }

    public Tank getMainTank() {
        return tank;
    }
}
