package com.lx.fight;

import com.lx.fight.enums.Direction;

import java.awt.*;

public abstract class AbsPaint {

    private Integer x;
    private Integer y;

    public AbsPaint(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);

    protected void move() {
        switch (getDirection()) {
            case UP:
                y -= getSpeed();
                break;
            case DOWN:
                y += getSpeed();
                break;
            case LEFT:
                x -= getSpeed();
                break;
            case RIGHT:
                x += getSpeed();
                break;
            default:
                break;
        }
    }

    protected abstract Direction getDirection();
    protected abstract int getSpeed();

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
