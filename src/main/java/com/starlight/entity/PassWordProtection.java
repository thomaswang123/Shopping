package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/9.
 *
 * 密保类
 */

public class PassWordProtection {
    private int id ;
    private String  question ;
    private String  answer ;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
