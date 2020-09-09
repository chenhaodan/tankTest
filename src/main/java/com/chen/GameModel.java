package com.chen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private final static GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    List<GameObject> gameObjects = new ArrayList<>();
    Collider collider = new ColliderChain();
    Tank tank ;

    private GameModel(){
    }

    public static GameModel getInstance(){
        return INSTANCE;
    }


    private void init(){
        tank = new Tank(100,200,Dir.DOWN,this,Group.GOOD);
        int initCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        for(int i = 0 ; i < initCount ; i++){
            new Tank(200 + i * 100,200,Dir.DOWN,this,Group.BAD);
        }

        add(new Wall(100,300,30,200));

    }


    public void add(GameObject go){
        gameObjects.add(go);
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.BLUE);
        g.setColor(color);

        for(int i = 0 ; i < gameObjects.size() ; i++){
            gameObjects.get(i).paint(g);
        }

        for(int i = 0 ; i < gameObjects.size() ; i++){
            for (int j = i+1 ; j < gameObjects.size() ; j++){
                GameObject go1 = gameObjects.get(i);
                GameObject go2 = gameObjects.get(j);
                collider.collideWith(go1,go2);
            }

        }

//        for (int i = 0 ; i < bullets.size() ; i++){
//            for (int j = 0 ; j < enemy.size() ; j++){
//                bullets.get(i).collideWith(enemy.get(j));
//            }
//        }

    }

    public Tank getMainTank() {
        return tank;
    }
}
