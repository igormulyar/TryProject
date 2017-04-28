package other.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by TRUST on 28.04.2017.
 */
public class Sorting {

    public List<Student> iMulyarInsertionSort(List<Student> list, Comparator<Student> comparator){
        for (int i = 1; i < list.size(); i++){
            Student studToInsert = list.remove(i);
            for (int j = i-1; j >= 0; j--){
                if (comparator.compare(studToInsert, list.get(j)) > 0){
                    /*if (j == 0){
                        list.add(j, studToInsert);
                        break;
                    }*/
                    list.add(j+1, studToInsert);
                    break;
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        /*new Sorting().iMulyarInsertionSort(new ArrayList<Student>(), (o1, o2) -> 0);*/

        List<Student> list  = new ArrayList<>();
        list.add(new Student("Ivan", "The First", 0));
        list.add(new Student("Ivan", "The Second", 1));
        list.add(new Student("Ivan", "The Third", 2));
        list.add(new Student("Ivan", "The Fourth", 3));
        list.add(new Student("Ivan", "The Fifth", 4));

        Student tempStud = list.remove(3);
        System.out.println("Student in index 3 removed. tempStud = "+tempStud.toString());

        System.out.println("The list now are: " + list.toString());

        list.add(0, tempStud);

        System.out.println("list after adding the tempStud to the index 1: " + list.toString());
    }



}
