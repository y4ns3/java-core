package lessons.lesson03.person;

public class Person {
    private int age;
    private String name;

    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public void introduce(){
        System.out.printf("My name is %s. I'm %d years old.",name,age);
    }
    public int getAge() {
        return age;
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
