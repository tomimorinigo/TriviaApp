package trivia;

public class User {
    // Attributes
    private String name;
    private int score;

    // Constructor
    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score; 
    }

    // Methods
    public void printUser() {
        System.out.println(this.name + " - Puntaje: " + this.score);
    }
}
