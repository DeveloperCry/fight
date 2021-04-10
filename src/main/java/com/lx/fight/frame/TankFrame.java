package com.lx.fight.frame;

import com.lx.fight.Bullet;
import com.lx.fight.Tank;
import com.lx.fight.tank.MainTank;
import com.lx.fight.enums.Direction;

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
    private List<Bullet> bullets = new ArrayList<>();
    private List<Tank> enemies = new ArrayList<>();
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
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullets:" + bullets.size(), 10, 60);
        g.setColor(c);
        tank.paint(g);

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (!bullet.getLiving()) {
                iterator.remove();
                continue;
            }
            bullet.paint(g);
        }

        Iterator<Tank> enemiesIterator = enemies.iterator();
        while (enemiesIterator.hasNext()) {
            Tank enemy = enemiesIterator.next();
            enemy.paint(g);
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

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }
}
