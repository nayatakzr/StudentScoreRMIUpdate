import java.io.Serializable;
public class Exam  implements Serializable {
    private String name;
    private double score;

    private double coefficient;

    public Exam(String name, double score, double coefficient) {
        this.name = name;
        this.score = score;
        this.coefficient = coefficient;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
}