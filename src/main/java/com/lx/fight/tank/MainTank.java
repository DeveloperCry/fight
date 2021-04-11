package com.lx.fight.tank;

import com.lx.fight.AbsTank;
import com.lx.fight.bullet.SmallBullet;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.AudioManager;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainTank extends AbsTank {
    private static final Integer SPEED = 10;

    private Boolean moving = Boolean.FALSE;
    private Direction direction;
    private TankFrame frame;

    private int width;
    private int height;

    public MainTank(Integer x, Integer y, Direction direction, TankFrame frame) {
        super(x, y);
        this.direction = direction;
        this.frame = frame;
    }

    @Override
    public void move() {
        if (!this.moving) {
            return;
        }
        super.move();
    }

    @Override
    protected Direction getDirection() {
        return this.direction;
    }

    @Override
    protected int getSpeed() {
        return SPEED;
    }

    @Override
    protected int getWidth() {
        return this.width;
    }

    @Override
    protected int getHeight() {
        return this.height;
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage image = ResourceManager.getImage(ResourceCategory.MAIN_TANK, this.direction);
        g.drawImage(image, super.getX(), super.getY(), null);
        this.width = image.getWidth();
        this.height = image.getHeight();

        this.move();
    }


    public void fire() {
        int locationX = super.getX();
        int locationY = super.getY();
        BufferedImage image = ResourceManager.getImage(ResourceCategory.MAIN_TANK, this.direction);
        switch (this.direction) {
            case UP:
                locationX = super.getX() + image.getWidth()/2;
                break;
            case DOWN:
                locationX = super.getX() + image.getWidth()/2;
                locationY = super.getY() + image.getHeight();
                break;
            case RIGHT:
                locationX = super.getX() + image.getWidth();
                locationY = super.getY() + image.getHeight()/2;
                break;
            case LEFT:
                locationY = super.getY() + image.getHeight()/2;
                break;
            default:
                break;
        }
        frame.addBullet(new SmallBullet(locationX, locationY, Boolean.TRUE, this.direction));
        new Thread(()->new AudioManager("tank_fire.wav").play()).start();
    }

    public void changeDirection(boolean bL, boolean bU, boolean bR, boolean bD) {
        if (!bL && !bU && !bR && !bD) {
            this.moving = false;
        } else {
            if (bL) {
                this.direction = Direction.LEFT;
            }
            if (bU) {
                this.direction = Direction.UP;
            }
            if (bR) {
                this.direction = Direction.RIGHT;
            }
            if (bD) {
                this.direction = Direction.DOWN;
            }
            this.moving = true;
        }
    }
}
