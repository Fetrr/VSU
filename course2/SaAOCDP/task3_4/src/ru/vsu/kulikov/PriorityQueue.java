package ru.vsu.kulikov;

public interface PriorityQueue {
    void insert(int x, int p);
    void increase(int x, int p);
    int extractMax();
    void printQueue();
    void clean();
}
