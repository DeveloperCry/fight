package com.lx.fight.listener;

import com.lx.fight.enums.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankKeyListener implements KeyListener {
    private Direction direction;

    public TankKeyListener(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                this.direction = Direction.UP;
            case KeyEvent.VK_DOWN:
                this.direction = Direction.DOWN;
            case KeyEvent.VK_LEFT:
                this.direction = Direction.LEFT;
            case KeyEvent.VK_RIGHT:
                this.direction = Direction.RIGHT;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
