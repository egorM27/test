import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MyArrayList {

    public static void main(String[] args) {
        /*
        Для удобства заполнения листа (вместо 20 строк add)
         */
        String[] simpleArr = {"qwe","w","e","r","t","y","q","w","e","r","t","y","a","s","d","f","g","h"};
        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, simpleArr);
        simpleArr = null;

        printUniqueWords(arrayList);
    }

    public static void printUniqueWords(List arr){
        /*
        Копия листа с целью сохранения/неприкосновенности исходных данных
         */
        List<String> tempArr = new ArrayList<>(arr);

        for (int i=0; i<tempArr.size(); i++){

            int check = 1;
            System.out.print("Word " + tempArr.get(i));

            for (int j=i+1; j<tempArr.size(); j++) {

                while (tempArr.get(i).equals(tempArr.get(j))) {
                    tempArr.remove(j);
                    check++;
                }
            }
            System.out.println(" - " + check + " time");
        }
        tempArr.clear();
    }

}
