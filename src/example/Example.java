package example;

import java.util.List;

public class Example {
    // ------------------------------------
    // Getting as many cases as possible
    //      - Diverse types
    //      - Diverse access
    //      - Static attributes / methods
    //      - Collection
    //      - Method with return type
    //      - Method with argument
    // ------------------------------------

    private String name;
    private double grade;
    public Integer age;
    private List<Float> stats;
    public static int cpt = 0;

    // Constuctors
    public Example(String name, double grade, Integer age, List<Float> stats) {
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.stats = stats;
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

    public List<Float> getStats() {
        return stats;
    }

    public void setStats(List<Float> stats) {
        this.stats = stats;
    }

    // Methods
    private void Hello(int random){
        System.out.println("Hello");
    }

    private String Bye() {
        return "Bye";
    }
}
