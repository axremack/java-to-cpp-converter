package example;

import java.util.List;

public class Example {
    private String name;
    private double grade;
    public Integer age;

    // Constuctors
    public Example(String name, double grade, Integer age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public Example(String name) {
        this.name = name;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    // Methods
    private void Hello(int random){
        System.out.println("Hello");
    }

    private String Bye() {
        return "Bye";
    }
}
