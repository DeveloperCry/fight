package com.lx.fight;

import com.lx.fight.enums.Direction;

import java.awt.*;

public abstract class AbsBullet extends AbsPaint implements Shape, Lifecycle{

    public AbsBullet(Integer x, Integer y) {
        super(x, y);
    }

    /**
     * 子弹移动
     */
    public abstract void move();


}
