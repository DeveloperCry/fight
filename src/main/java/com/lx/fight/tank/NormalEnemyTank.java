package com.lx.fight.tank;

import com.lx.fight.AbsTank;
import com.lx.fight.bullet.SmallBullet;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.ResourceManager;
import com.lx.fight.util.RandomUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormalEnemyTank extends AbsTank {
    private static final Integer SEED = 20;
    private static final Integer SPEED = 2;

    private Boolean living = Boolean.TRUE;
    private Direction direction = Direction.DOWN;
    private TankFrame frame;

    private int locationX;
    private int locationY;
    private int wight;
    private int height;

    public NormalEnemyTank(Integer x, Integer y, TankFrame frame) {
        super(x, y);
        this.frame = frame;
    }

    public void move() {
        switch (this.direction) {
            case UP:
                super.setY(super.getY() - SPEED);
                break;
            case DOWN:
                super.setY(super.getY() + SPEED);
                break;
            case LEFT:
                super.setX(super.getX() - SPEED);
                break;
            case RIGHT:
                super.setX(super.getX() + SPEED);
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!this.living) {
            return;
        }
        int random = RandomUtils.getNextInt(SEED);
        this.direction = Direction.values()[random % 4];
        BufferedImage image = ResourceManager.getImage(ResourceCategory.TANK, this.direction);
        g.drawImage(image, super.getX(), super.getY(), null);
        this.wight = image.getWidth();
        this.height = image.getHeight();

        this.move();
        this.fire();
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(locationX, locationY, this.wight, this.height);
    }

    public void fire() {
        int i = RandomUtils.getNextInt(SEED);
        if (i % 6 != 0) {
            return;
        }
        BufferedImage image = ResourceManager.getImage(ResourceCategory.TANK, this.direction);
        switch (this.direction) {
            case UP:
                locationX = super.getX() + image.getWidth()/2;
                locationY = super.getY();
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
                locationX = super.getX();
                locationY = super.getY() + image.getHeight()/2;
                break;
            default:
                break;
        }
        frame.addBullet(new SmallBullet(locationX, locationY, this.direction));
    }

    @Override
    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public Boolean getLiving() {
        return this.living;
    }
}
