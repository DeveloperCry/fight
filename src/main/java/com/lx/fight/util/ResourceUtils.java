package com.lx.fight.util;

import com.lx.fight.enums.ResourceEnum;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceUtils {

//    public static BufferedImage getImage(ResourceEnum resourceEnum) {
//        try {
//            BufferedImage image = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/" + resourceEnum.getImg()));
//            return image;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static BufferedImage getImage(String name) {
        try {
            BufferedImage image = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/" + name));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AudioInputStream getAudio(String fileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ResourceUtils.class.getClassLoader().getResource("audio/" + fileName));
            return audioInputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
