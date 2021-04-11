package com.lx.fight.resource;

import com.lx.fight.constant.ResourceConstants;
import com.lx.fight.constant.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.util.ImageUtils;
import com.lx.fight.util.ResourceUtils;
import com.lx.fight.enums.ResourceEnum;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private static Map<ResourceEnum, BufferedImage> images = new HashMap<>();

    static {
        BufferedImage mainImage = ResourceUtils.getImage(ResourceConstants.MAIN_TANK);
        BufferedImage defaultEnemyImage = ResourceUtils.getImage(ResourceConstants.DEFAULT_ENEMY_TANK);
        BufferedImage defaultBulletImage = ResourceUtils.getImage(ResourceConstants.DEFAULT_BULLET);

        images.put(ResourceEnum.MAIN_TANK_UP, mainImage);
        images.put(ResourceEnum.MAIN_TANK_DOWN, ImageUtils.rotateImage(mainImage, ResourceConstants.REVOLVE_180));
        images.put(ResourceEnum.MAIN_TANK_RIGHT, ImageUtils.rotateImage(mainImage, ResourceConstants.REVOLVE_90));
        images.put(ResourceEnum.MAIN_TANK_LEFT, ImageUtils.rotateImage(mainImage, ResourceConstants.REVOLVE_NEGATIVE_90));

        images.put(ResourceEnum.DEFAULT_ENEMY_TANK_UP, ImageUtils.rotateImage(defaultEnemyImage, ResourceConstants.REVOLVE_180));
        images.put(ResourceEnum.DEFAULT_ENEMY_TANK_DOWN, defaultEnemyImage);
        images.put(ResourceEnum.DEFAULT_ENEMY_TANK_RIGHT, ImageUtils.rotateImage(defaultEnemyImage, ResourceConstants.REVOLVE_NEGATIVE_90));
        images.put(ResourceEnum.DEFAULT_ENEMY_TANK_LEFT, ImageUtils.rotateImage(defaultEnemyImage, ResourceConstants.REVOLVE_90));

        images.put(ResourceEnum.BULLET_UP, defaultBulletImage);
        images.put(ResourceEnum.BULLET_DOWN, ImageUtils.rotateImage(defaultBulletImage, ResourceConstants.REVOLVE_180));
        images.put(ResourceEnum.BULLET_RIGHT, ImageUtils.rotateImage(defaultBulletImage, ResourceConstants.REVOLVE_90));
        images.put(ResourceEnum.BULLET_LEFT, ImageUtils.rotateImage(defaultBulletImage, ResourceConstants.REVOLVE_NEGATIVE_90));
    }

    public static BufferedImage getImage(ResourceCategory category, Direction direction) {
        String resourceKey = category + TankConstants.UNDERLINE + direction;
        return images.get(Enum.valueOf(ResourceEnum.class, resourceKey));
    }
}
