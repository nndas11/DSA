package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


// -  So in the Comparator, we compare two values for sorting and returns 1 when we want to sort and -1 when we don't want to sort.
// -  So we want to write when we want to sort depending on the logic.
// -  We can use lambda expression for the comparator because comparator is a functional interface.
// -  With Wrapper class we can use collection.sort() directly because these wrapper classes implements the "Comparable" interface
// -  and overrides the "compareTo" method which becomes the basic logic for sorting. This can be overridden again by providing the Comparator.
// -  We can't use Collections.sort(), with user-defined classes because they don't implement the "Comparable" interface.
// -  So two ways: 1. Implement the Comparable interface by the user defined class and give default logic in the "compareTo" method.
// -  2. Provide the interface.




public class ComparatorStudy {
    public static void main(String[] args) {

//        Comparable

        List<Integer> list = new ArrayList<>();
        list.add(52);
        list.add(23);
        list.add(39);
        list.add(86);

        Collections.sort(list, (a, b) -> a%10 > b%10 ? 1 : -1);

        System.out.println(list);

        List<Student> students = new ArrayList<>();
        students.add( new Student(21,"Nihad"));
        students.add( new Student(19,"Rahul"));
        students.add( new Student(20,"Raju"));
        students.add( new Student(11,"Ram"));


//        Collections.sort(students); -> NOT POSSIBLE -> Because the Student Class does not implement the Comparable interface, so we need to provide the Comparator.
        Collections.sort(students, (a,b) -> a.age > b.age ? 1 : -1);
        System.out.println(students);



        List<studentWithComparable> students1 = new ArrayList<>();
        students1.add( new studentWithComparable(21,"Nihad"));
        students1.add( new studentWithComparable(19,"Rahul"));
        students1.add( new studentWithComparable(20,"Raju"));
        students1.add( new studentWithComparable(11,"Ram"));

        Collections.sort(students1);
        System.out.println(students1);
    }
}


class Student{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class studentWithComparable implements Comparable<studentWithComparable>{

    int age;
    String name;

    public studentWithComparable(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(studentWithComparable that) {
        return Integer.compare(that.age, this.age);
//       return this.age - that.age;
    }

}
