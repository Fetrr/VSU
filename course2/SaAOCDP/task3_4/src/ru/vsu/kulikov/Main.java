package ru.vsu.kulikov;

import ru.vsu.kulikov.PriorityQueue.PriorityQueueOnArray;
import ru.vsu.kulikov.PriorityQueue.PriorityQueueOnBinaryTree;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- Task 1 --------------");

        PriorityQueueOnBinaryTree queueOnBinaryTree = new PriorityQueueOnBinaryTree(100);

        queueOnBinaryTree.insert(14, 14);
        queueOnBinaryTree.insert(3, 3);
        queueOnBinaryTree.insert(9, 9);
        queueOnBinaryTree.insert(1, 16);
        queueOnBinaryTree.insert(16, 1);
        queueOnBinaryTree.insert(8, 8);
        queueOnBinaryTree.insert(4, 4);
        queueOnBinaryTree.insert(2, 2);
        queueOnBinaryTree.insert(7, 7);
        queueOnBinaryTree.insert(10, 10);

        queueOnBinaryTree.printTree();
        queueOnBinaryTree.printArray();

        System.out.println("-------------- Task 2 --------------");

        PriorityQueueOnArray queueOnArray = new PriorityQueueOnArray(100);

        queueOnArray.insert(14, 14);
        queueOnArray.insert(3, 3);
        queueOnArray.insert(9, 9);
        queueOnArray.insert(1, 1);
        queueOnArray.insert(16, 16);
        queueOnArray.insert(8, 8);
        queueOnArray.insert(4, 4);
        queueOnArray.insert(2, 2);
        queueOnArray.insert(7, 7);
        queueOnArray.insert(10, 10);

        queueOnArray.printArray();

        queueOnArray.increase(14, 17);
        queueOnArray.printArray();

        System.out.println(queueOnArray.extractMax());
        queueOnArray.printArray();

        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mw.setSize(800, 600);
        mw.setTitle("Algorithm complexity on graphs");
        mw.setVisible(true);
    }
}
