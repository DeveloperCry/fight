package com.lx.fight.tank;

import com.lx.fight.Shape;
import com.lx.fight.Tank;
import com.lx.fight.bullet.SmallBullet;
import com.lx.fight.constant.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceEnum;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.ResourceManager;
import com.lx.fight.util.RandomUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormalEnemyTank implements Tank, Shape {
    private static final Integer SEED = 20;
    private static final Integer SPEED = 2;

    private Integer x;
    private Integer y;
    private Boolean living = Boolean.TRUE;
    private Direction direction = Direction.DOWN;
    private TankFrame frame;

    private int locationX;
    private int locationY;
    private int wight;
    private int height;

    public NormalEnemyTank(Integer x, Integer y, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;
    }

    public void move() {
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

    @Override
    public void paint(Graphics g) {
        if (!this.living) {
            return;
        }
        int random = RandomUtils.getNextInt(SEED);
        this.direction = Direction.values()[random % 4];
        String resourceKey = TankConstants.TANK + TankConstants.UNDERLINE + this.direction;
        BufferedImage image = ResourceManager.images.get(Enum.valueOf(ResourceEnum.class, resourceKey));
        g.drawImage(image, this.x, this.y, null);
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
        switch (this.direction) {
            case UP:
                locationX = this.x + ResourceManager.images.get(ResourceEnum.TANK_UP).getWidth()/2;
                locationY = this.y;
                break;
            case DOWN:
                locationX = this.x + ResourceManager.images.get(ResourceEnum.TANK_DOWN).getWidth()/2;
                locationY = this.y + ResourceManager.images.get(ResourceEnum.TANK_DOWN).getHeight();
                break;
            case RIGHT:
                locationX = this.x + ResourceManager.images.get(ResourceEnum.TANK_RIGHT).getWidth();
                locationY = this.y + ResourceManager.images.get(ResourceEnum.TANK_RIGHT).getHeight()/2;
                break;
            case LEFT:
                locationX = this.x;
                locationY = this.y + ResourceManager.images.get(ResourceEnum.TANK_LEFT).getHeight()/2;
                break;
            default:
                break;
        }
        frame.addBullet(new SmallBullet(locationX, locationY, this.direction));
    }
}
