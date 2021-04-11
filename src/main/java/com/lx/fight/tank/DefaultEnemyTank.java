package com.lx.fight.tank;

import com.lx.fight.AbsTank;
import com.lx.fight.bullet.DefaultBullet;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.ResourceManager;
import com.lx.fight.util.RandomUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DefaultEnemyTank extends AbsTank {
    private static final Integer SEED = 20;
    private static final Integer SPEED = 2;

    private Direction direction = Direction.DOWN;
    private TankFrame frame;

    private int locationX;
    private int locationY;
    private int width;
    private int height;

    public DefaultEnemyTank(Integer x, Integer y, TankFrame frame) {
        super(x, y);
        this.frame = frame;
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
    public void paint(Graphics g) {
        if (!super.getLiving()) {
            return;
        }
        int random = RandomUtils.getNextInt(SEED);
        this.direction = Direction.values()[random % 4];
        BufferedImage image = ResourceManager.getImage(ResourceCategory.DEFAULT_ENEMY_TANK, this.direction);
        g.drawImage(image, super.getX(), super.getY(), null);
        this.width = image.getWidth();
        this.height = image.getHeight();

        super.move();
        this.fire();
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(locationX, locationY, this.width, this.height);
    }

    public void fire() {
        int i = RandomUtils.getNextInt(SEED);
        if (i % 6 != 0) {
            return;
        }
        BufferedImage image = ResourceManager.getImage(ResourceCategory.DEFAULT_ENEMY_TANK, this.direction);
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
        frame.addBullet(new DefaultBullet(locationX, locationY, this.direction));
    }


    @Override
    protected int getWidth() {
        return this.width;
    }

    @Override
    protected int getHeight() {
        return this.height;
    }
}
