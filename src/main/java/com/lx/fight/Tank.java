package com.lx.fight;

import com.lx.fight.enums.Direction;

public interface Tank {
    void fire(Bullet bullet);
    void setDirection(Direction direction);
}
