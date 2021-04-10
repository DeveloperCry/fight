package com.lx.fight.common;

import com.lx.fight.Main;
import com.lx.fight.enums.ResourceEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * TODO
 *
 * @author xiong.liu
 * @date 2021-4-9 22:13
 */
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
}
