package com.lx.fight;

import com.lx.fight.enums.Direction;

public abstract class AbsExplode extends AbsPaint implements Lifecycle {
    private boolean living = true;

    public AbsExplode(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public Boolean getLiving() {
        return this.living;
    }

    @Override
    protected Direction getDirection() {
        return null;
    }

    @Override
    protected int getSpeed() {
        return 0;
    }
}
