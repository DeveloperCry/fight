package com.lx.fight;


import java.awt.*;

public abstract class AbsBullet extends AbsPaint implements Shape, Lifecycle{
    private boolean isMain = false;
    private Rectangle rectangle = new Rectangle();

    public AbsBullet(Integer x, Integer y) {
        super(x, y);
    }

    public AbsBullet(Integer x, Integer y, boolean isMain) {
        super(x, y);
        this.isMain = isMain;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();

    @Override
    public Rectangle getRectangle() {
        rectangle.x = super.getX();
        rectangle.y = super.getY();
        rectangle.width = this.getWidth();
        rectangle.height = this.getHeight();
        return rectangle;
    }
}
