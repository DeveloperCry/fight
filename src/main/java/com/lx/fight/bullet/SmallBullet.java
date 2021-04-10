package com.lx.fight.bullet;

import com.lx.fight.Bullet;
import com.lx.fight.common.TankConstants;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceEnum;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;

public class SmallBullet implements Bullet {

    private Integer x;
    private Integer y;
    private Direction direction;
    private Boolean living = true;

    private static final Integer SPEED = 5;

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
        int locationX = this.x;
        int locationY = this.y;
        switch (this.direction) {
            case UP:
                locationX = this.x - ResourceManager.images.get(ResourceEnum.BULLET_UP).getWidth()/2;
                g.drawImage(ResourceManager.images.get(ResourceEnum.BULLET_UP), locationX, locationY, null);
                break;
            case DOWN:
                locationX = this.x - ResourceManager.images.get(ResourceEnum.BULLET_DOWN).getWidth()/2;
                g.drawImage(ResourceManager.images.get(ResourceEnum.BULLET_DOWN), locationX, locationY, null);
                break;
            case RIGHT:
                locationY = this.y - ResourceManager.images.get(ResourceEnum.BULLET_RIGHT).getHeight()/2;
                g.drawImage(ResourceManager.images.get(ResourceEnum.BULLET_RIGHT), locationX, locationY, null);
                break;
            case LEFT:
                locationY = this.y - ResourceManager.images.get(ResourceEnum.BULLET_LEFT).getHeight()/2;
                g.drawImage(ResourceManager.images.get(ResourceEnum.BULLET_LEFT), locationX, locationY, null);
                break;
            default:
                break;
        }
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
}
