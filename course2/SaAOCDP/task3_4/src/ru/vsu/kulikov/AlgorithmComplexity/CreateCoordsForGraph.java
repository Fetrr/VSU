package ru.vsu.kulikov.AlgorithmComplexity;


import ru.vsu.kulikov.PriorityQueue;
import ru.vsu.kulikov.PriorityQueueRealizations.*;

public class CreateCoordsForGraph {
    private static int[] coordsX, coordsY;
    private static int nPoints;
    PriorityQueue pq = new PriorityQueueOnArray(100000000);

    public int[] getCoordsX() {
        return coordsX;
    }

    public int[] getCoordsY() {
        return coordsY;
    }

    public int getnPoints() {
        return nPoints;
    }

    public void warmUp(int repeats, int len, int range) {
        int[] array = new int[len];

        for(int i = 0; i < len; ++i) {
            array[i] = (int)(Math.random() * (double)(range + 1));
            pq.insert(array[i], i);
        }
        for (int i = 0; i < repeats; ++i) {
            pq.extractMax();
        }
        pq.clean();
    }

    public void arrayPrint(String arr_name, Object[] array) {
        System.out.print(arr_name + ": \t[");

        for(int i = 0; i < array.length - 1; ++i) {
            System.out.print(array[i] + "; ");
        }

        System.out.println(array[array.length - 1] + "]");
    }

    public void timetable(int repeats, int min_len, int step, int valueRange, boolean arr_out) {
        nPoints = repeats;
        coordsX = new int[nPoints];
        coordsY = new int[nPoints];

        warmUp(10, 1000, 1000);

        for(int i = 0; i < min_len; ++i) {
            pq.insert(i*100, i);
        }

        //rep = 3, minLen = 5, step = 1, valRange = 10
        for(int curr_step = 0; curr_step < repeats; ++curr_step) {
            /**
             * Filling queue with random values
             */
            int len = step * curr_step;
            for(int i = 0; i < step - 1; ++i) {
//                pq.insert((int)(Math.random() * (double)(valueRange + 1)),
//                        (int)(Math.random() * (double)(valueRange + 1)));
                pq.insert(i*100, i);
            }
            pq.insert(1234567, 10001);


            /**
             * Get time complexity
             */
            long m = System.nanoTime();

            // target method
            // pq.extractMax();
            pq.increase(1234567, 10002);

            long time = System.nanoTime() - m;

            /**
             * Print queue if needed
             */
            if (arr_out) {
                pq.printQueue();
            }

            /**
             * Printing result of calculating complexity
             */
            System.out.println("array lenght: " + len + "\ntime: " + time + " ");
            System.out.println("--------------------------------");

            /**
             * Adding coordinates X and Y to arrays
             */
            coordsX[curr_step] = len;
            coordsY[curr_step] = (int)time;
        }
        pq.clean();
    }
}
