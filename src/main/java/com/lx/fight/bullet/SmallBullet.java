package com.lx.fight.bullet;

import com.lx.fight.AbsBullet;
import com.lx.fight.constant.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SmallBullet extends AbsBullet {
    private static final Integer SPEED = 5;

    private Direction direction;
    private Boolean living = true;

    private int locationX;
    private int locationY;
    private int wight;
    private int height;

    public SmallBullet(Integer x, Integer y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    public SmallBullet(Integer x, Integer y, boolean isMain, Direction direction) {
        super(x, y, isMain);
        this.direction = direction;
    }

    @Override
    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public Boolean getLiving() {
        return this.living;
    }

    @Override
    public void paint(Graphics g) {
        locationX = super.getX();
        locationY = super.getY();
        BufferedImage image = ResourceManager.getImage(ResourceCategory.BULLET, this.direction);
        switch (this.direction) {
            case UP:
                locationX = super.getX() - image.getWidth()/2;
                break;
            case DOWN:
                locationX = super.getX() - image.getWidth()/2;
                break;
            case RIGHT:
                locationY = super.getY() - image.getHeight()/2;
                break;
            case LEFT:
                locationY = super.getY() - image.getHeight()/2;
                break;
            default:
                break;
        }
        this.wight = image.getWidth();
        this.height = image.getHeight();
        g.drawImage(image, locationX, locationY, null);
        this.move();
    }

    @Override
    public void move() {
        switch (direction) {
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

        if (super.getX() < 0 || super.getY() < 0 || super.getX() > TankConstants.FRAME_WIGHT || super.getY() > TankConstants.FRAME_HEIGHT) {
            this.living = false;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(this.locationX, this.locationY, this.wight, this.height);
    }
}
