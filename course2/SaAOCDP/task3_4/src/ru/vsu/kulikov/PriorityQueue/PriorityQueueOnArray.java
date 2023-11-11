package ru.vsu.kulikov.PriorityQueue;

import ru.vsu.kulikov.AbstractPriorityQueue;

public class PriorityQueueOnArray implements AbstractPriorityQueue {
    Node[] heap;
    private int size;

    public PriorityQueueOnArray (int maxSize) {
        heap = new Node[maxSize];
        size = 0;
    }

    public void printArray() {
        System.out.println("\n--------------- array ---------------");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i].value + " (p = " + heap[i].priority + ") ");
        }
        System.out.println();
        System.out.println("------------------------------------\n");
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void bubbleSort() {
        int i = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (heap[j].priority < heap[j + 1].priority) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            i += 1;
        }
    }

    @Override
    public void insert(int x, int p) {
        if (size >= heap.length) {
            System.out.println("Heap overflow");
            return;
        }
        size += 1;
        heap[size - 1] = new Node(x, p);
        bubbleSort();
    }

    @Override
    public void increase(int x, int p) {
        for (int i = 0; i < size; i++) {
            if (heap[i].value == x && heap[i].priority < p) {
                heap[i].priority = p;
                bubbleSort();
            }
        }
    }

    @Override
    public int extractMax() {
        if (size < 1) {
            throw new NullPointerException("Heap empty");
        }
        int max = heap[0].value;
        for (int i = 0; i < size; i++) {
            heap[i] = heap[i + 1];
        }
        size -= 1;
//        heap[0] = heap[size - 1];
//        size -= 1;
//        bubbleSort();
        return max;
    }
}
