package com.lx.fight;

import com.lx.fight.constant.TankConstants;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.AudioManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame(TankConstants.FRAME_TITLE, TankConstants.FRAME_LOCATION_X, TankConstants.FRAME_LOCATION_Y,
                TankConstants.FRAME_WIDTH, TankConstants.FRAME_HEIGHT);
        tankFrame.start();

        new Thread(()-> new AudioManager("war1.wav").loop()).start();

        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
