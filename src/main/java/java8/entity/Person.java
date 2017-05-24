package java8.entity;

public class Person {

    public int no;
    private String name;
    public int age;

    public Person(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public int getNo() {
        return no;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
