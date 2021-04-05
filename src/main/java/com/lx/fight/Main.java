package com.lx.fight;

import com.lx.fight.common.TankConstants;
import com.lx.fight.frame.TankFrame;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame(TankConstants.FRAME_TITLE, TankConstants.FRAME_LOCATION_X, TankConstants.FRAME_LOCATION_Y,
                TankConstants.FRAME_WIGHT, TankConstants.FRAME_HEIGHT);
    }
}
