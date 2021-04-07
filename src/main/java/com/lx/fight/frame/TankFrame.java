package com.lx.fight.frame;

import com.lx.fight.tank.NormalTank;
import com.lx.fight.enums.Direction;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    private Integer locationX;
    private Integer locationY;
    private Integer wight;
    private Integer height;
    private String title;
    private NormalTank tank = new NormalTank(200, 200, Direction.DOWN);
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
        tank.paint(g);
        tank.move();
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
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    setMainTankDir();
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    setMainTankDir();
                    break;

                case KeyEvent.VK_CONTROL:
//                    tank.fire();
                    break;

                default:
                    break;
            }

            setMainTankDir();

        }

        private void setMainTankDir() {

            if (!bL && !bU && !bR && !bD) {
                tank.setMoving(false);
            } else {
                if (bL) {
                    tank.setDirection(Direction.LEFT);
                }
                if (bU) {
                    tank.setDirection(Direction.UP);
                }
                if (bR) {
                    tank.setDirection(Direction.RIGHT);
                }
                if (bD) {
                    tank.setDirection(Direction.DOWN);
                }
                tank.setMoving(true);
            }
        }
    }
}
