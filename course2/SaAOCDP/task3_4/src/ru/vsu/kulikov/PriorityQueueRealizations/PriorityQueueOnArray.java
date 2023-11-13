package ru.vsu.kulikov.PriorityQueueRealizations;

import ru.vsu.kulikov.PriorityQueue;

public class PriorityQueueOnArray implements PriorityQueue {
    Node[] array;
    private final int maxSize;
    private int size;

    public PriorityQueueOnArray (int maxSize) {
        this.maxSize = maxSize;
        array = new Node[maxSize];
        size = 0;
    }

    public void printQueue() {
        System.out.println("\n--------------- array ---------------");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i].value + " (p = " + array[i].priority + ") ");
        }
        System.out.println();
        System.out.println("------------------------------------\n");
    }

    private void swap(int i, int j) {
        Node temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void bubbleSort() {
//        int i = 0;
//        boolean swapped = true;
//        while (swapped) {
//            swapped = false;
//            for (int j = 0; j < size - i - 1; j++) {
//                if (array[j].priority < array[j + 1].priority) {
//                    swap(j, j + 1);
//                    swapped = true;
//                }
//            }
//            i += 1;
//        }
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (array[j].priority < array[j + 1].priority) {
                    swap(i, j);
                }
            }
        }
    }

    @Override
    public void insert(int x, int p) {
        if (size >= array.length) {
            System.out.println("Heap overflow");
            return;
        }
        size += 1;
        array[size - 1] = new Node(x, p);
        bubbleSort();
    }

    @Override
    public void increase(int x, int p) {
        for (int i = 0; i < size; i++) {
            if (array[i].value == x && array[i].priority < p) {
                array[i].priority = p;
                bubbleSort();
            }
        }
    }

    @Override
    public int extractMax() {
        if (size < 1) {
            throw new NullPointerException("Heap empty");
        }
        int max = array[0].value;
        for (int i = 0; i < size; i++) {
            array[i] = array[i + 1];
        }
        size -= 1;
//        heap[0] = heap[size - 1];
//        size -= 1;
//        bubbleSort();
        return max;
    }

    public void clean() {
        array = new Node[maxSize];
        size = 0;
    }
}
