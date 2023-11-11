package ru.vsu.kulikov.PriorityQueue;

import ru.vsu.kulikov.AbstractPriorityQueue;

public class PriorityQueueOnBinaryTree implements AbstractPriorityQueue {
    private int size;
    private Node[] heap;

    public PriorityQueueOnBinaryTree(int maxSize) {
        heap = new Node[maxSize];
        size = 0;
    }

    /******************************************************************************/

    public void printTree() {
        System.out.println("\n--------------- tree ---------------");
        printTree(0, 0, "root");
        System.out.println("------------------------------------\n");
    }

    private String repeatString(int n, String str) {
        String temp = str;
        str = "";
        for (int i = 0; i < n; i++) {
            str += temp;
        }
        return str;
    }

    private void printTree(int i, int level, String position) {
        if (i < size) {
            System.out.println(repeatString(level, "   ") + position + "_" + level + ": " +
                    heap[i].value + " (p = " + heap[i].priority + ") ");
            printTree(2 * i + 1, level + 1, "left");
            printTree(2 * i + 2, level + 1, "right");
        }
    }

    public void printArray() {
        System.out.println("\n--------------- array ---------------");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i].value + " (p = " + heap[i].priority + ") ");
        }
        System.out.println();
        System.out.println("------------------------------------\n");
    }

    /******************************************************************************/

    public void heapifyUp(int i) {
        int parentIndex = i/2;
        while (i > 0 && heap[parentIndex].priority < heap[i].priority) {
            swap(i, i/2);
            i = parentIndex;
            parentIndex = i/2;
        }
    }

    public void heapifyDown(int i) {
        while (i < size) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int largest = i;
            if (left < size && heap[i].priority < heap[left].priority) {
                largest = left;
            } else if (right < size && heap[i].priority < heap[right].priority) {
                largest = right;
            }
            if (largest != i) {
                swap(largest, i);
                i = largest;
            }
            else break;
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public void insert(int x, int p) {
        if (size >= heap.length) {
            System.out.println("Heap overflow");
            return;
        }
        size += 1;
        heap[size - 1] = new Node(x, p);
        heapifyUp(size - 1);
    }

    @Override
    public void increase(int x, int p) {
        for (int i = 0; i < size; i++) {
            if (heap[i].value == x && heap[i].priority < p) {
                heap[i].priority = p;
                heapifyUp(i);
            }
        }
    }

    @Override
    public int extractMax() {
        if (size < 1) {
            throw new NullPointerException("Heap empty");
        }
        int max = heap[0].value;
        heap[0] = heap[size - 1];
        size -= 1;
        heapifyDown(0);
        return max;
    }
}

