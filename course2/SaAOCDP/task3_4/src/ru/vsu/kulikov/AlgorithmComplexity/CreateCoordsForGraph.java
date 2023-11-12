package ru.vsu.kulikov.AlgorithmComplexity;


public class CreateCoordsForGraph {
    private int[] coordsX, coordsY;

    public int[] getCoordsX() {
        return coordsX;
    }

    public int[] getCoordsY() {
        return coordsY;
    }

    public void warmUp(int repeats, int len, int range) {
        int[] array = new int[len];

        for(int j = 0; j < len; ++j) {
            array[j] = (int)(Math.random() * (double)(range + 1));
        }

        for (int i = 0; i < repeats; ++i) {
            // target method
        }
    }

    public void arrayPrint(String arr_name, Object[] array) {
        System.out.print(arr_name + ": \t[");

        for(int i = 0; i < array.length - 1; ++i) {
            System.out.print(array[i] + "; ");
        }

        System.out.println(array[array.length - 1] + "]");
    }

    private void timetable(int repeats, int min_len, int step, int valueRange, boolean arr_out) {
        coordsX = new int[repeats];
        coordsY = new int[repeats];

        warmUp(10, 1000, 1000);

        for(int curr_step = 0; curr_step < repeats; ++curr_step) {
            int len = min_len + step * curr_step;
            Integer[] array = new Integer[len];

            /**
             * Filling array with random values
             */
            for(int i = 0; i < len; ++i) {
                array[i] = (int)(Math.random() * (double)(valueRange + 1));
            }

            /**
             * Get time complexity
             */
            long m = System.nanoTime();
            // target method
            long time = System.nanoTime() - m;

            /**
             * Print array if needed
             */
            if (arr_out) {
                arrayPrint("array", array);
            }

            /**
             * Printing result of calculating complexity
             */
            System.out.println("array lenght: " + len + "\ntime: " + time + " ");
            System.out.println("--------------------------------");

            /**
             * Adding coordinates X and Y to arrays
             */
            // oldRange[oldMin .. oldMax] -> newRange[newMin .. newMax]
            //
            // convert = (value - oldMin) * newMax / oldRangeOfValues
            coordsX[curr_step] = len;
            coordsY[curr_step] = (int)time;

//            coord_X[curr_step] = (len + step - min_len) * 800 / (min_len + (step * repeats - 1) - min_len);
//            coord_y[curr_step] = (int)time;
        }

        /**
         * Convert Y coordinates to window size
         */
//        int[] coord_Y = new int[coord_y.length];
//        int old_min = coord_y[0]; // min element = first element because time increases
//        int old_range = (coord_y[coord_y.length - 1] - coord_y[0]); // old range = max element - min element
//
//        for(int i = 0; i < coord_y.length; ++i) {
//            coord_Y[i] = (coord_y[i] - old_min) * 600 / old_range;
//        }
    }
}
