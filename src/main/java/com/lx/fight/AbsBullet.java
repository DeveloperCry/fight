package com.lx.fight;


public abstract class AbsBullet extends AbsPaint implements Shape, Lifecycle{
    private boolean isMain = false;

    public AbsBullet(Integer x, Integer y) {
        super(x, y);
    }

    public AbsBullet(Integer x, Integer y, boolean isMain) {
        super(x, y);
        this.isMain = isMain;
    }

    /**
     * 子弹移动
     */
    public abstract void move();

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
