package ru.vsu.kulikov;

import ru.vsu.kulikov.PriorityQueue.*;

public interface AbstractPriorityQueue {
    void insert(int x, int p);
    void increase(int x, int p);
    int extractMax();
}
