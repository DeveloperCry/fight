package com.lx.fight.explode;

import com.lx.fight.AbsExplode;
import com.lx.fight.constant.ExplodeConstants;
import com.lx.fight.resource.AudioManager;
import com.lx.fight.resource.ExplodeManager;

import java.awt.*;

public class NormalExplode extends AbsExplode {
    private int step = 0;


    public NormalExplode(int x, int y) {
        super(x, y);
        new Thread(()->new AudioManager("explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        if (step >= ExplodeConstants.NORMAL_EXPLODE_COUNT - 1) {
            super.setLiving(false);
        }
        g.drawImage(ExplodeManager.getNormalExplode(step++), super.getX(), super.getY(), null);
    }


}
