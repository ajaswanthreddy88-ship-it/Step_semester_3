class AttendanceSheet {
    private String[] students;
    private int presentCount;

    // Constructor
    AttendanceSheet(int maximumStudents) {
        students = new String[maximumStudents];
        presentCount = 0;
    }

    // Mark student present
    void markPresent(String name) {

        // Check duplicate
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return;
            }
        }

        // Add student
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    // Return number of present students
    int getPresentCount() {
        return presentCount;
    }

    // Check whether student is present
    boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count = " + sheet.getPresentCount());

        System.out.println("Ben present = " + sheet.isPresent("Ben"));

        System.out.println("Chen present = " + sheet.isPresent("Chen"));
    }
}
