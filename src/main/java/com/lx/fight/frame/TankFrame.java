package com.lx.fight.frame;

import com.lx.fight.entity.Tank;
import com.lx.fight.listener.TankKeyListener;
import com.lx.fight.listener.TankWindowListener;

import java.awt.*;

public class TankFrame extends Frame {

    private Integer locationX;
    private Integer locationY;
    private Integer wight;
    private Integer height;
    private String title;
    private Tank tank = new Tank();
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
        super.addWindowListener(new TankWindowListener());
        super.addKeyListener(new TankKeyListener(tank.getDir()));
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
        gOffScreen.fillRect(locationX, locationY, wight, height);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
