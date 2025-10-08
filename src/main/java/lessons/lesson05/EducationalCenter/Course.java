package lessons.lesson05.EducationalCenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String courseID;
    private String courseName;
    private List<Student> students;
    private Teacher teacher;
    private Map<Integer, Attendance> attendance = new HashMap<>();
    private Map<Integer, Integer> grades = new HashMap<>();

    public Course(String courseID, String courseName, Teacher teacher) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacher = teacher;
    }
    public void addStudent(Student student) {
        students.add(student);
        attendance.put(student.getStudentID(), new Attendance());
        grades.put(student.getStudentID(), 0);
        System.out.println("Student " + student.getStudentID() + " has been added");
    }
    public void markAttendance(int studentId, boolean isPresent) {
        if (attendance.containsKey(studentId)) {
            attendance.get(studentId).addRecord(isPresent);
            System.out.println("Student with id: " + studentId + " attended");
        }
    }
    public void assignGrade(int studentId, int grade) {
        if (grades.containsKey(studentId)) {
            grades.put(studentId, grade);
            System.out.println("Grade " + grade + " Assigned to student with id: " + studentId);
        }
    }
    public void showCourseInfo() {
        System.out.println("\n=== course: " + courseName + " ===");
        teacher.display();
        System.out.println("students: ");
        for (Student s : students) {
            s.display();
        }
    }

    public void showGrades() {
        System.out.println("\n=== Grades " + courseName + " ===");
        for (Student s : students) {
            System.out.println("Student with id:"+s.getStudentID() + " → " + grades.get(s.getStudentID()));
        }
    }
}
