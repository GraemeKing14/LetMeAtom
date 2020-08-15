package com.example.layout_idea;

public class Questions {
    // A class which allows the creation of a question object to be added to Questions database.
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;

    public Questions() {
        // Blank constructor.

    }

    public Questions(String question, String option1, String option2, String option3, String option4, int answerNr) {
        // Constructor which accepts inputs.
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        // Method to get the question content.
        return question;
    }

    public void setQuestion(String question) {
        // Method to set the question content.
        this.question = question;
    }

    public String getOption1() {
        // Method to return the first option.
        return option1;
    }

    public void setOption1(String option1) {
        // Method to set the first option.
        this.option1 = option1;
    }

    public String getOption2() {
        // Method to return the second option.
        return option2;
    }

    public void setOption2(String option2) {
        // Method to set the second option.
        this.option2 = option2;
    }

    public String getOption3() {
        // Method to return the third option.
        return option3;
    }

    public void setOption3(String option3) {
        // Method to set the third option.
        this.option3 = option3;
    }

    public String getOption4() {
        // Method to get the fourth option.
        return option4;
    }

    public void setOption4(String option4) {
        // Method to set the fourth option.
        this.option4 = option4;
    }

    public int getAnswerNr() {
        // Method to get the answer number.
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        // Method to set the answer number.
        this.answerNr = answerNr;
    }
}
