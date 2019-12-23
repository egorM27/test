package lesson2;

import java.lang.reflect.Array;

public class Main {
    private static final int SIZE_ARR = 4;

    public static void main(String[] args) {

        String[][] arr = {{"0","7","3","17"}, {"12","4","6","10"}, {"7","0","1","12"}, {"8","1","2","3"}};

        doIt(arr);

    }

    private static void doIt(String arr[][]) {

        for (int i = 0; i < arr.length; i++) {
            
            if (arr.length > SIZE_ARR || arr[i].length > SIZE_ARR) {

                try {
                    throw new MySizeArrayException();
                } catch (MySizeArrayException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (!checkString(arr[i][j])) {

                    try {
                        throw new MyArrayDataException("", i, j);
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                        return;
                    }

                }

                sum += Integer.parseInt(arr[i][j]);
            }
        }

        System.out.println("Сумма всех элеметов массива = " + sum);
    }

    public static boolean checkString (String string){

        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
