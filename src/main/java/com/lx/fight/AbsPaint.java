package com.lx.fight;

import java.awt.*;

public abstract class AbsPaint {

    private Integer x;
    private Integer y;

    public AbsPaint(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paint(Graphics g);

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
