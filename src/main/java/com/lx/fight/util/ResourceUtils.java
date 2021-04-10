package com.lx.fight.util;

import com.lx.fight.enums.ResourceEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceUtils {

    public static BufferedImage getImage(ResourceEnum resourceEnum) {
        try {
            BufferedImage image = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/" + resourceEnum.getImg()));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getImage(String name) {
        try {
            BufferedImage image = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/" + name));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
