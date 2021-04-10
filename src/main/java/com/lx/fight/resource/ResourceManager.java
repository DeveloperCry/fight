package com.lx.fight.resource;

import com.lx.fight.common.ResourceUtils;
import com.lx.fight.enums.ResourceEnum;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
   public static Map<ResourceEnum, BufferedImage> images = new HashMap<>();

   static {
       images.put(ResourceEnum.TANK_UP, ResourceUtils.getImage(ResourceEnum.TANK_UP));
       images.put(ResourceEnum.TANK_DOWN, ResourceUtils.getImage(ResourceEnum.TANK_DOWN));
       images.put(ResourceEnum.TANK_RIGHT, ResourceUtils.getImage(ResourceEnum.TANK_RIGHT));
       images.put(ResourceEnum.TANK_LEFT, ResourceUtils.getImage(ResourceEnum.TANK_LEFT));

       images.put(ResourceEnum.BULLET_UP, ResourceUtils.getImage(ResourceEnum.BULLET_UP));
       images.put(ResourceEnum.BULLET_DOWN, ResourceUtils.getImage(ResourceEnum.BULLET_DOWN));
       images.put(ResourceEnum.BULLET_RIGHT, ResourceUtils.getImage(ResourceEnum.BULLET_RIGHT));
       images.put(ResourceEnum.BULLET_LEFT, ResourceUtils.getImage(ResourceEnum.BULLET_LEFT));
   }
}
