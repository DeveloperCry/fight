package com.lx.fight.entity;

import com.lx.fight.enums.Direction;
import lombok.Data;

@Data
public class Tank {
    private Integer x;
    private Integer y;
    private Direction dir;

    private static final Integer SPEED = 10;



}
