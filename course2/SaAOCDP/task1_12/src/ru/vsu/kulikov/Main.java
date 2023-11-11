//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.vsu.kulikov;

public class Main {

    public static void arrayOut(String arr_name, int[] array) {
        System.out.print(arr_name + ": \t[");

        for(int i = 0; i < array.length - 1; ++i) {
            System.out.print(array[i] + "; ");
        }

        System.out.println(array[array.length - 1] + "]");
    }

    public static void arrayOut(String arr_name, long[] array) {
        System.out.print(arr_name + ": \t[");

        for(int i = 0; i < array.length - 1; ++i) {
            System.out.print(array[i] + "; ");
        }

        System.out.println(array[array.length - 1] + "]");
    }

    private static int mostFrequentNum(int[] array) {
        int k = 0;
        int num = array[0];
        int countOfNum = 0;

        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length; ++j) {
                if (array[i] == array[j]) {
                    ++k;
                }
            }
            if (k >= countOfNum) {
                num = array[i];
                countOfNum = k;
            }
            k = 0;
        }
        return num;
    }

    public static void warmUp(int repeats, int len, int range) {
        int[] array = new int[len];
        for (int i = 0; i < repeats; ++i) {
            for(int j = 0; j < len; ++j) {
                array[j] = (int)(Math.random() * (double)(range + 1));
            }
            mostFrequentNum(array);
        }
    }

    private static int[] timetable(int repeats, int min_len, int step, int range, boolean arr_out) {
        int[] coords = new int[repeats * 2];
        int[] coord_X = new int[repeats];
        int[] coord_y = new int[repeats];

        warmUp(10, 1000, 1000);

        for(int curr_step = 0; curr_step < repeats; ++curr_step) {
            int len = min_len + step * curr_step;
            int[] array = new int[len];

            for(int i = 0; i < len; ++i) {
                array[i] = (int)(Math.random() * (double)(range + 1));
            }

            long m = System.nanoTime();
            int most_freq_num = mostFrequentNum(array);
            long time = System.nanoTime() - m;
            if (arr_out) {
                arrayOut("array", array);
                System.out.println("most frequent number: \t" + most_freq_num);
            }

            System.out.println("array lenght: " + len + "\ntime: " + time + " ");
            System.out.println("--------------------------------");
            if (repeats <= 1) {
                return null;
            }

            coord_X[curr_step] = (len + step - min_len) * 800 / (min_len + (step * repeats - 1) - min_len);
            coord_y[curr_step] = (int)time;
        }

        long[] coord_Y = new long[coord_y.length];
        long old_min = (long)coord_y[0];
        long old_range = (long)(coord_y[coord_y.length - 1] - coord_y[0]);
        System.out.println("" + old_min + " " + old_range);

        int i;
        for(i = 0; i < coord_y.length; ++i) {
            coord_Y[i] = ((long)coord_y[i] - old_min) * 600L / old_range;
        }

        for(i = 0; i < repeats; ++i) {
            coords[i * 2] = coord_X[i];
            coords[i * 2 + 1] = (int)coord_Y[i];
        }

        arrayOut("X", coord_X);
        arrayOut("Y", coord_Y);
        arrayOut("coords", coords);
        return coords;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.paintGraph(timetable(20, 1000, 1000, 1000, false));
    }
}
