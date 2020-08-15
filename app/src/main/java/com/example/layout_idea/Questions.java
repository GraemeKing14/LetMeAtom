package com.example.layout_idea;

/** A class which allows the creation of a question object to be added to Questions database. **/
public class Questions {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;

    /** A simple constructor. **/
    public Questions() {
    }

    /** Constructor which accepts inputs. **/
    public Questions(String question, String option1, String option2, String option3, String option4, int answerNr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
    }

    /** Method to get the question content. **/
    public String getQuestion() {
        return question;
    }

    /** Method to set the question content. **/
    public void setQuestion(String question) {
        this.question = question;
    }

    /** Method to return the first option. **/
    public String getOption1() {
        return option1;
    }

    /** Method to set the first option. **/
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /** Method to return the second option. **/
    public String getOption2() {
        return option2;
    }

    /** Method to set the second option. **/
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /** Method to return the third option. **/
    public String getOption3() {
        return option3;
    }

    /** Method to set the third option. **/
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /** Method to get the fourth option. **/
    public String getOption4() {
        return option4;
    }

    /** Method to set the fourth option. **/
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /** Method to get the answer number. **/
    public int getAnswerNr() {
        return answerNr;
    }

    /** Method to set the answer number. **/
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
