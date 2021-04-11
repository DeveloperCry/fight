package com.lx.fight;

import com.lx.fight.constant.TankConstants;

import java.awt.*;

public abstract class AbsTank extends AbsPaint implements Shape, Lifecycle {

    private boolean living = true;
    public AbsTank(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    protected void move() {
        switch (getDirection()) {
            case UP:
                if (super.getY() > TankConstants.FRAME_MENU_HEIGHT) {
                    super.setY(super.getY() - getSpeed());
                }
                break;
            case DOWN:
                if (super.getY() < TankConstants.FRAME_HEIGHT - getHeight()) {
                    super.setY(super.getY() + getSpeed());
                }
                break;
            case LEFT:
                if (super.getX() > 0) {
                    super.setX(super.getX() - getSpeed());
                }
                break;
            case RIGHT:
                if (super.getX() < TankConstants.FRAME_WIDTH - getHeight()) {
                    super.setX(super.getX() + getSpeed());
                }
                break;
            default:
                break;
        }
    }

    protected abstract int getWidth();
    protected abstract int getHeight();

    @Override
    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public Boolean getLiving() {
        return this.living;
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(super.getX(), super.getY(), getWidth(), getHeight());
    }
}
