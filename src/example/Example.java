package example;

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
    public static int cpt = 0;

    // Methods
    public Example(String name, double grade) {
        this.name = name;
        this.grade = grade;
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
}
