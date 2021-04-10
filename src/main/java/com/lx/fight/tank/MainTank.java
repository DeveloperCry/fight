package com.lx.fight.tank;

import com.lx.fight.Shape;
import com.lx.fight.bullet.SmallBullet;
import com.lx.fight.constant.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceCategory;
import com.lx.fight.enums.ResourceEnum;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MainTank implements Shape {
    private static final Integer SPEED = 10;

    private Integer x;
    private Integer y;
    private Boolean moving = Boolean.FALSE;
    private Direction direction;
    private TankFrame frame;

    private int wight;
    private int height;

    public MainTank(Integer x, Integer y, Direction direction, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.frame = frame;
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
            default:
                break;
        }
    }

    public void paint(Graphics g) {
        BufferedImage image = ResourceManager.getImage(ResourceCategory.TANK, this.direction);
        g.drawImage(image, this.x, this.y, null);
        this.wight = image.getWidth();
        this.height = image.getHeight();

        this.move();
    }


//    @Override
    public void fire() {
        int locationX = this.x;
        int locationY = this.y;
        BufferedImage image = ResourceManager.getImage(ResourceCategory.TANK, this.direction);
        switch (this.direction) {
            case UP:
                locationX = this.x + image.getWidth()/2;
                locationY = this.y;
                break;
            case DOWN:
                locationX = this.x + image.getWidth()/2;
                locationY = this.y + image.getHeight();
                break;
            case RIGHT:
                locationX = this.x + image.getWidth();
                locationY = this.y + image.getHeight()/2;
                break;
            case LEFT:
                locationX = this.x;
                locationY = this.y + image.getHeight()/2;
                break;
            default:
                break;
        }
        frame.addBullet(new SmallBullet(locationX, locationY, this.direction));
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

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.wight, this.height);
    }
}
