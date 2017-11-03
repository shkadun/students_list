import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student(1, 15,"Anna", "Annushkina");

            students.add(new Student(1, 15,"Anna", "Annushkina"));
            students.add(new Student(2, 17,"Ivan", "Ivanov"));
            students.add(new Student(3, 24,"Petr", "Petrov"));
            students.add(new Student(4, 19,"Pavel", "Pavlov"));
            students.add(new Student(5, 20,"Vladimir", "Vladimirov"));
            students.add(new Student(6, 21,"Olga", "Olgina"));
            students.add(new Student(7, 22,"Mihail", "Mihajlov"));
            students.add(new Student(8, 27,"Anton", "Antonov"));
            students.add(new Student(9, 14,"Aleksander", "Aleksandrov"));
            students.add(new Student(10, 16,"Vadim", "Vadimov"));


        System.out.println("Before sorting: ");
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).id + " First and Last Name: "  + " " + students.get(i).name + " " + students.get(i).lastName + ". Age: " + students.get(i).age);
        }
        Collections.sort(students, new AgeComparator());
        System.out.println();

        System.out.println("After sorting by age: ");
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).id + " First and Last Name: "  + " " + students.get(i).name + " " + students.get(i).lastName + ". Age: " + students.get(i).age);
        }
        System.out.println();

        System.out.println("Enter letter for sorting lastnames( 'A', 'I', 'P', 'V', 'O', 'M':)");
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String letter = reader.readLine();

        int a = 0;

        for(int i = 0; i < students.size(); i++) {
            if (students.get(i).lastName.substring(0, 1).toUpperCase().equals(letter.toString().toUpperCase())) {
                a++;
                System.out.println(students.get(i).id + " First and Last Name: " + " " + students.get(i).name + " " + students.get(i).lastName + ". Age: " + students.get(i).age);
            }
        }
        if (a == 0)
        {
            System.out.println("There are no students with last name from " + "'" + letter + "'");
        }




        // if (students.getLastName().substring(0, 1).toUpperCase().equals(letter.toString().toUpperCase()))
          //  students.stream().forEach(student -> System.out.println(String.format("ID: %s Student: %s %s Age: %s", student.getId(), student.getName(), student.getLastName(), student.getAge())));

        //else {
            //for (int i = 0; i < students.size(); i++) {
          //  }
           // System.out.println("There are no students with last name from " + letter);

        //}

        System.out.println();
        System.out.println("Average age of students: " + average(students));

    }



    public static class Student {
        public int id;
        public int age;
        public String name;
        public String lastName;

        public Student(int id, int age, String name, String lastName) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.lastName = lastName;
        }

        public int getAge()
        {
            return age;
        }
        public int getId()
        {
            return id;
        }
        public String getName()
        {
            return name;
        }
        public String getLastName() {
            return lastName;
        }


        public Student()
        {

        }
        public int compareTo(Student student) {
            return Comparators.AGE.compare(this, student);
        }

        public static class Comparators {
            public static Comparator<Student> AGE = Comparator.comparing(student -> student.age);

            public static Comparator<Student> LAST_NAME = Comparator.comparing(student -> student.lastName);

            public static Comparator<Student> FIRST_NAME = Comparator.comparing(student -> student.name);
        }

    }
    static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.getAge() > s2.getAge()) {
                return 1;
            } else if (s1.getAge() < s2.getAge()) {
                return -1;
            }
            return 0;
        }
    }
    static double average (ArrayList<Student> students) {

        double sum = 0;

        for(int i=0;i<students.size();i++) {
            sum+=students.get(i).age;
        }

        return sum/students.size();
    }
}
