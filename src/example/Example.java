package example;

import java.util.List;

public class Example {
    // ------------------------------------
    // Getting as many cases as possible
    //      - Diverse types
    //      - Diverse access
    //      - Static attributes / methods
    // ------------------------------------

    // Attributes
    private String name;
    private double grade;
    private List<Float> stats;
    public static int cpt = 0;

    // Methods
    public Example(String name, double grade, List<Float> stats) {
        this.name = name;
        this.grade = grade;
        this.stats = stats;
    }

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

    public List<Float> getStats() {
        return stats;
    }

    public void setStats(List<Float> stats) {
        this.stats = stats;
    }
}
