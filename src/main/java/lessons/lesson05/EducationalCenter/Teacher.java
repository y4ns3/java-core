package lessons.lesson05.EducationalCenter;

public class Teacher extends Person {
    private String id;
    private String specialization;

    public Teacher(String firstName,
                   String lastName,
                   String id,
                   String specialization) {
        super(firstName,lastName);
        this.id = id;
        this.specialization = specialization;
    }

    @Override
    public void display() {
        System.out.println("Teacher : id is: " + id+"\n Full name is: "+firstName+" "+lastName
                         +"\nspecialization is: "+specialization);
    }

}
