package com.lx.fight.enums;

/**
 * TODO
 *
 * @author xiong.liu
 * @date 2021-4-9 22:14
 */
public enum ResourceEnum {
    TANK_UP("TANK_UP", "tankU.gif"),
    TANK_DOWN("TANK_DOWN", "tankD.gif"),
    TANK_RIGHT("TANK_RIGHT", "tankR.gif"),
    TANK_LEFT("TANK_LEFT", "tankL.gif"),

    BULLET_UP("BULLET_UP", "bulletU.gif"),
    BULLET_DOWN("BULLET_DOWN", "bulletD.gif"),
    BULLET_RIGHT("BULLET_RIGHT", "bulletR.gif"),
    BULLET_LEFT("BULLET_LEFT", "bulletL.gif"),
    ;

    private String label;
    private String img;

    ResourceEnum(String label, String img) {
        this.label = label;
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
