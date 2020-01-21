public class Threads {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        /*
        Один поток
         */

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println((System.currentTimeMillis() - a) + " мс - Один поток");

        /*
        Два потока
         */

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long c = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println((System.currentTimeMillis() - c) + " мс - Два потока");

        /*
        Один поток с разделением массива :)
         */

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long b = System.currentTimeMillis();

        float[] arrR1 = new float[HALF];
        float[] arrR2 = new float[HALF];

        System.arraycopy(arr, 0, arrR1, 0, HALF);
        System.arraycopy(arr, HALF, arrR2, 0, HALF);

        for (int i = 0; i < arrR1.length; i++) {
            arrR1[i] = (float) (arrR1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < arrR2.length; i++) {
            arrR2[i] = (float) (arrR2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(arrR1, 0, arr, 0, HALF);
        System.arraycopy(arrR2, 0, arr, HALF, HALF);

        System.out.println((System.currentTimeMillis() - b) + " мс - Один поток с разделением массива");

    }

}