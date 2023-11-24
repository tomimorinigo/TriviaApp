package trivia;

import java.util.ArrayList;
import java.util.List;

public class Question {
    // Attributes
    private String question;
    private String answer;
    private String category;
    private List<String> options = new ArrayList<String>();

    // Constructor
    public Question(String question, String answer, String category, List<String> options) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.options = options;
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getOptions() {
        return options;
    }

    // Setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer; 
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    // Methods
    public void printQuestion() {
        System.out.println(this.question);
        for (int i = 0; i < this.options.size(); i++) {
            System.out.println(i + 1 + ". " + this.options.get(i));
        }
    }
}
