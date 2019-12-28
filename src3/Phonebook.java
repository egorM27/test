import java.util.ArrayList;
import java.util.List;

public class Phonebook{

    String name;
    Integer number;

    public Phonebook(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public static void main(String[] args) {

        List<Phonebook> phonebook = new ArrayList<>();

        phonebook.add(new Phonebook("Ivanov", 1001));
        phonebook.add(new Phonebook("Kozlov", 1002));
        phonebook.add(new Phonebook("Petrov", 1003));
        phonebook.add(new Phonebook("Ivanov", 1004));
        phonebook.add(new Phonebook("Vasechkin", 1005));
        phonebook.add(new Phonebook("Petrov", 1006));

        /*
        Через foreach код был бы лаконичней
         */
        for(int i = 0; i < phonebook.size(); i++){

            if(phonebook.get(i).name.equals("Petrov")){
                System.out.println(phonebook.get(i).name + " " + phonebook.get(i).number);
            }
        }
    }
}
