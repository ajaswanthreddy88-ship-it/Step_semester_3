class Student {

    // Instance fields
    String name;
    double attendance;

    // Shared by all Student objects
    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {

        System.out.println(
            "College: " + collegeName
        );

        System.out.println(
            "Student Count: " + studentCount
        );
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 =
            new Student("Ravi", 85.5);

        Student s2 =
            new Student("Anitha", 91.0);

        Student.printCollegeInfo();
    }
}
