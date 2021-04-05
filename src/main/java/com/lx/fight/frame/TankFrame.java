package com.lx.fight.frame;

import com.lx.fight.listener.TankKeyListener;
import com.lx.fight.listener.TankWindowListener;

import java.awt.*;

public class TankFrame extends Frame {

    public TankFrame(String title, Integer locationX, Integer locationY, Integer wight, Integer height) throws HeadlessException {
        super(title);
        super.setSize(wight, height);
        super.setLocation(locationX, locationY);

        super.setVisible(true);
        super.addWindowListener(new TankWindowListener());
        super.addKeyListener(new TankKeyListener());
    }
}
