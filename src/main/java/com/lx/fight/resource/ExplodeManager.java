package com.lx.fight.resource;

import com.lx.fight.constant.ExplodeConstants;
import com.lx.fight.util.ResourceUtils;

import java.awt.image.BufferedImage;

public class ExplodeManager {
    private static BufferedImage[] normalExplodes = new BufferedImage[ExplodeConstants.NORMAL_EXPLODE_COUNT];

    static {
        for (int i = 0; i < ExplodeConstants.NORMAL_EXPLODE_COUNT; i++) {
            normalExplodes[i] = ResourceUtils.getImage("e" + (i + 1) + ".gif");
        }
    }

    public static BufferedImage getNormalExplode(int index) {
        return normalExplodes[index];
    }
}
