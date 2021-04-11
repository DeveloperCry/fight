package com.lx.fight.frame;

import com.lx.fight.AbsBullet;
import com.lx.fight.AbsExplode;
import com.lx.fight.AbsTank;
import com.lx.fight.explode.NormalExplode;
import com.lx.fight.tank.MainTank;
import com.lx.fight.enums.Direction;
import com.lx.fight.tank.DefaultEnemyTank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {

    private Integer locationX;
    private Integer locationY;
    private Integer wight;
    private Integer height;
    private String title;
    private MainTank tank = new MainTank(200, 200, Direction.UP, this);
    private List<AbsBullet> bullets = new ArrayList<>();
    private List<AbsTank> enemies = new ArrayList<>();
    private List<AbsExplode> explodes = new ArrayList<>();
    Image offScreenImage = null;

    public TankFrame(String title, Integer locationX, Integer locationY, Integer wight, Integer height) throws HeadlessException {
        this.title = title;
        this.locationX = locationX;
        this.locationY = locationY;
        this.wight = wight;
        this.height = height;
    }

    public void start() {
        super.setTitle(title);
        super.setSize(wight, height);
        super.setLocation(locationX, locationY);
        super.setResizable(false);

        super.setVisible(true);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        super.addKeyListener(new MyKeyListener());

        for (int i = 0; i < 5; i ++) {
            this.enemies.add(new DefaultEnemyTank(100  + i * 100, 100, this));
        }
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:" + bullets.size(), 10, 50);
        g.drawString("敌方数量:" + enemies.size(), 10, 70);
        g.setColor(c);
        tank.paint(g);

        Iterator<AbsBullet> bulletItr = bullets.iterator();
        while (bulletItr.hasNext()) {
            AbsBullet bullet = bulletItr.next();
            if (!bullet.getLiving()) {
                bulletItr.remove();
                continue;
            }
            bullet.paint(g);
        }

        Iterator<AbsTank> enemiesItr = enemies.iterator();
        while (enemiesItr.hasNext()) {
            AbsTank enemy = enemiesItr.next();
            if (!enemy.getLiving()) {
                enemiesItr.remove();
                continue;
            }
            enemy.paint(g);
        }

        Iterator<AbsExplode> explodeItr = this.explodes.iterator();
        while (explodeItr.hasNext()) {
            AbsExplode explode = explodeItr.next();
            if (!explode.getLiving()) {
                explodeItr.remove();
                continue;
            }
            explode.paint(g);

        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                AbsBullet absBullet = bullets.get(i);
                AbsTank absTank = enemies.get(j);
                if (absTank.getLiving() && absBullet.getLiving()) {
                    boolean isCollide = absBullet.getRectangle().intersects(absTank.getRectangle());
                    if (isCollide && absBullet.isMain()) {
                        absBullet.setLiving(false);
                        absTank.setLiving(false);
                        this.explodes.add(new NormalExplode(absTank.getX(), absTank.getY()));
                    }
                }
            }
        }
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(wight, height);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, wight, height);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            tank.changeDirection(bL, bU, bR, bD);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            tank.changeDirection(bL, bU, bR, bD);
        }
    }

    public void addBullet(AbsBullet bullet) {
        this.bullets.add(bullet);
    }
}
