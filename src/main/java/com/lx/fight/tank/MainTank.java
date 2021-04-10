package com.lx.fight.tank;

import com.lx.fight.Tank;
import com.lx.fight.bullet.SmallBullet;
import com.lx.fight.enums.Direction;
import com.lx.fight.enums.ResourceEnum;
import com.lx.fight.frame.TankFrame;
import com.lx.fight.resource.ResourceManager;

import java.awt.*;

public class MainTank implements Tank {
    private Integer x;
    private Integer y;
    private Boolean moving = Boolean.FALSE;
    private Direction direction;
    private TankFrame frame;

    private static final Integer SPEED = 10;

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

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.GREEN);
//        g.fillRect(this.x, this.y, 10, 20);
        switch (this.direction) {
            case UP:
                g.drawImage(ResourceManager.images.get(ResourceEnum.TANK_UP), this.x, this.y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.images.get(ResourceEnum.TANK_DOWN), this.x, this.y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.images.get(ResourceEnum.TANK_RIGHT), this.x, this.y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.images.get(ResourceEnum.TANK_LEFT), this.x, this.y, null);
                break;
            default:
                break;
        }
        this.move();
    }


    @Override
    public void fire() {
        int locationX = this.x;
        int locationY = this.y;
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
