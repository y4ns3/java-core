package lessons.lesson05.EducationalCenter;


abstract class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

public abstract void display();
}
