package com.lx.fight.bullet;

import com.lx.fight.Bullet;
import com.lx.fight.Shape;
import com.lx.fight.constant.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceEnum;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SmallBullet implements Bullet, Shape {
    private static final Integer SPEED = 5;

    private Integer x;
    private Integer y;
    private Direction direction;
    private Boolean living = true;

    private int locationX;
    private int locationY;
    private int wight;
    private int height;


    public SmallBullet(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean getLiving() {
        return this.living;
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.RED);
//        g.fillRect(this.x, this.y, 5, 5);
        locationX = this.x;
        locationY = this.y;
        String resourceKey = TankConstants.BULLET + TankConstants.UNDERLINE + this.direction;
        BufferedImage image = ResourceManager.images.get(Enum.valueOf(ResourceEnum.class, resourceKey));
        switch (this.direction) {
            case UP:
                locationX = this.x - ResourceManager.images.get(ResourceEnum.BULLET_UP).getWidth()/2;
                break;
            case DOWN:
                locationX = this.x - ResourceManager.images.get(ResourceEnum.BULLET_DOWN).getWidth()/2;
                break;
            case RIGHT:
                locationY = this.y - ResourceManager.images.get(ResourceEnum.BULLET_RIGHT).getHeight()/2;
                break;
            case LEFT:
                locationY = this.y - ResourceManager.images.get(ResourceEnum.BULLET_LEFT).getHeight()/2;
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

        if (x < 0 || y < 0 || x > TankConstants.FRAME_WIGHT || y > TankConstants.FRAME_HEIGHT) {
            this.living = false;
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(this.locationX, this.locationY, this.wight, this.height);
    }
}
