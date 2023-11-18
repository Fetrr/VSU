package org.example;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final GameField gameField;

    public MainWindow() throws HeadlessException {
        gameField = new GameField();
        this.add(gameField);
    }
}
