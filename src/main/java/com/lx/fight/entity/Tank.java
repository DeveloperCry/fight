package com.lx.fight.entity;

import com.lx.fight.enums.Direction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
public class Tank {
    private Integer x;
    private Integer y;
    private Direction dir;

    private static final Integer SPEED = 10;

    public void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
            case DOWN:
                y += SPEED;
            case LEFT:
                x -= SPEED;
            case RIGHT:
                x += SPEED;
        }
    }

    public void fire() {

    }

    public void paint(Graphics g) {
        g.fillRect(200, 200, 40, 40);
    }



}
