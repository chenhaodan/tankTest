package com.factory;

import com.chen.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RectResourceMgr {
    static BufferedImage goodTankL , goodTankU , goodTankR , goodTankD;
    static BufferedImage badTankL , badTankU , badTankR , badTankD;
    static BufferedImage bulletL , bulletU , bulletR ,bulletD;
    static BufferedImage[] exploere;
    static {
        try {
            exploere = new BufferedImage[11];
            goodTankU = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);

            badTankU = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);

            bulletL = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            for (int i = 0 ; i < 11 ; i++){
                exploere[i] = ImageIO.read(RectResourceMgr.class.getClassLoader().getResourceAsStream("images/"+ i + ".gif"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
