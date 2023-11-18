package org.example.GameElements;

import java.awt.*;

public class Tank {
    private int x, y, width, height, velocity, hp, damage;
    private final Color clr;

    public Tank(int x, int y, int width, int height, int velocity, int hp, int damage, Color clr) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        this.hp = hp;
        this.damage = damage;
        this.clr = clr;
    }

    public void move() {
    }
}
