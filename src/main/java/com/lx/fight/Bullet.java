package com.lx.fight;

import com.lx.fight.enums.Direction;

import java.awt.*;

public interface Bullet {

    /**
     * 子弹是否存活
     *
     * @return
     */
    boolean getLiving();

    /**
     * 绘制子弹
     * @param g 画板
     */
    void paint(Graphics g);

    /**
     * 子弹移动
     */
    void move();


}
