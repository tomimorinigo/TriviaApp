package trivia;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private String answer;
    private String category;
    private List<String> options = new ArrayList<String>();

    public Question(String question, String answer, String category, List<String> options) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.options = options;
    }

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

    public String toString() {
        return "Question: " + question + "\nOptions: " + options;
    }
}
