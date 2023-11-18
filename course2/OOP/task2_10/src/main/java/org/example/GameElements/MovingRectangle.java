package org.example.GameElements;

import org.example.GameField;

import java.awt.*;

public class MovingRectangle {
    public int x, y, width, height;
    public boolean inLand;
    private int moveX, moveY;

    public boolean leftKeyPressed = false;
    public boolean rightKeyPressed = false;
    public boolean upKeyPressed = false;
    public boolean downKeyPressed = false;

    public MovingRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    public boolean checkLandBounds() {
//
//    }

    public void moveRectangle() {
        moveX = moveY = 0;

        if (leftKeyPressed && x > 0) {
            moveX -= 4;
        }
        if (rightKeyPressed && (x < GameField.WIDTH - width)) {
            moveX += 4;
        }
        if (upKeyPressed && y > 0 + height) {
            moveY -= 4;
        }
        if (downKeyPressed && y < GameField.HEIGHT - height) {
            moveY += 4;
        }
        // Apply gravity
        if (y < GameField.HEIGHT - height) {
            moveY += 1;
        }
        if (!GameField.checkOutOfBounds(
                new int[]{x + moveX, x + moveX, x + width + moveX, x + width + moveX},
                new int[]{y + height + moveY, y + moveY, y + moveY, y + height + moveY})) {
            x += moveX;
            y += moveY;
        }
    }

    // метод, который возвращает угол наклона поверхности, на который находится прямоугольник. Для этого можно
    // считать две ближайшие к углам прямоугольника точки обьекта Landscape, тогда выражение будет иметь вид:
    // angle = arctg((y2 - y1)/(x2 - x1))

    public void draw(Graphics2D g2d) {
        g2d.fillRect(x, y, width, height);
        //g2d.rotate;
    }
}