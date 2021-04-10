package com.lx.fight.explode;

import com.lx.fight.AbsExplode;
import com.lx.fight.constant.ExplodeConstants;
import com.lx.fight.resource.ExplodeManager;

import java.awt.*;

public class NormalExplode extends AbsExplode {
    private int step = 0;
    private boolean living = true;

    public NormalExplode(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics g) {
        if (step >= ExplodeConstants.NORMAL_EXPLODE_COUNT - 1) {
            this.living = false;
        }
        g.drawImage(ExplodeManager.getNormalExplode(step++), super.getX(), super.getY(), null);
    }

    @Override
    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public Boolean getLiving() {
        return this.living;
    }
}
