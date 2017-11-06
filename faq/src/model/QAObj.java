package model;

/**
 * Created by xkc on 11/4/15.
 */
public class QAObj {
    private String question;
    private String answer;

    public QAObj(){}
    public QAObj(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
