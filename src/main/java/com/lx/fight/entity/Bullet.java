package com.lx.fight.entity;

import com.lx.fight.enums.Direction;

public class Bullet {

    private Integer x;
    private Integer y;
    private Direction dir;

    private static final Integer SPEED = 5;

    public void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
            case DOWN:
                y += SPEED;
            case LEFT:
                x -= SPEED;
            case RIGHT:
                x += SPEED;
        }
    }
}
