package com.chen;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void imageTest() throws IOException {
        BufferedImage image = ImageIO.read(new File("D:/project/tankTest/src/main/java/images/bulletD.gif"));
        assertNotNull(image);

        BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif"));
        assertNotNull(image2);
    }
}
