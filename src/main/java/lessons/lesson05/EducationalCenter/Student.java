package lessons.lesson05.EducationalCenter;

public class Student extends Person {
    private int studentID;
    public Student(String firstName, String lastName, int studentID) {
        super(firstName, lastName);
        this.studentID = studentID;
    }
    @Override
    public void display(){
        System.out.println("Student ID: " + studentID + "\nFirst Name: " + firstName + "\nLast Name: " + lastName);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
