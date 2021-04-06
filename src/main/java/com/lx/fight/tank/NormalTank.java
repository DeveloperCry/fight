package com.lx.fight.tank;

import com.lx.fight.Bullet;
import com.lx.fight.Tank;
import com.lx.fight.enums.Direction;

import java.awt.*;

public class NormalTank implements Tank {
    private Integer x;
    private Integer y;
    private Boolean moving = Boolean.FALSE;
    private Direction direction;

    private static final Integer SPEED = 10;

    public NormalTank(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        if (!this.moving) {
            return;
        }
        switch (this.direction) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, 20, 20);
    }


    @Override
    public void fire(Bullet bullet) {

    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }


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

    public Direction getDirection() {
        return direction;
    }

    public Boolean getMoving() {
        return moving;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }
}
