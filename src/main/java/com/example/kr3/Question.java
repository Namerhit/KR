package com.example.kr3;

import java.util.List;

public class Question {
    private static int nextQuestionNumber = 1;

    private int questionNumber;
    private String questionText;
    private List<String> keywords;
    private boolean answered;

    public Question(String questionText, List<String> keywords) {
        this.questionNumber = nextQuestionNumber++;
        this.questionText = questionText;
        this.keywords = keywords;
        this.answered = false;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean containsAllKeywords(List<String> searchKeywords) {
        return keywords.containsAll(searchKeywords);
    }
}
