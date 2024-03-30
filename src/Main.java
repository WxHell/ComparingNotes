import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,20,-50,30,2};
        for (Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n",five,
                    (val == 0 ? "==" : (val<0) ? "<" : ">"),i,val);
        }

        String banana = "Banana";
        String[] fruit ={"apple","banana","pear","BANANA"};
        for (String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n",banana,
                    (val==0 ? "==" : (val < 0) ? "<" : ">"),s,val);//BURDA İKİ KELİMİYEİ KARŞILAŞTIRIP FARKINI VERİR
        }
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A:"+ (int) 'A' + " "+"a:"+(int)'a');
        System.out.println("B:"+ (int) 'B' + " "+"b:"+(int)'b');
        System.out.println("P:"+ (int) 'P' + " "+"p:"+(int)'p');

        Student John =new Student("John");
        Student [] students={new Student("Henry"),new Student("Malik"),
                new Student("John")};
        Arrays.sort(students);//hata verir fakat Comparabledan türetirsek sıralama yapar bunu da
        //sınıfa implements Comparable yaparak yapabiliriz.override method ile
        System.out.println(Arrays.toString(students));

        System.out.println("result = "+John.compareTo(new Student("Ronaldo")));
        Comparator<Student>gpaSorter=new StudentGPAComparator();
        Arrays.sort(students,gpaSorter.reversed());//büyükten küçüğe sıralar.
        System.out.println(Arrays.toString(students));
    }
}
class StudentGPAComparator implements Comparator<Student>{
    public int compare(Student o1,Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa+o2.name);
    }
}
class Student implements Comparable<Student>{
    private static int LAST_ID=1000;
    private static Random random = new Random();
     String name;
    private int id;
    protected double gpa;
    public Student(String name){
        this.name=name;
        id=LAST_ID ++;
        gpa = random.nextDouble(1.00,4.00);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;//student türüne dönüşüyor.
//        return name.compareTo(other.name);//alfabetik sıralama sağlar
//    }


}