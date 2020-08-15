package com.example.layout_idea.Examination;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.layout_idea.DatabaseHelper;
import com.example.layout_idea.Questions;
import com.example.layout_idea.QuizDatabaseHelper;
import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

import java.util.Collections;
import java.util.List;

public class HardQuiz extends AppCompatActivity {

    SharedPrefs sharedPref;
    private QuizDatabaseHelper dbQuestions;
    private TextView question;
    private TextView questionScore;
    private TextView questionNumber;
    private RadioGroup rg;
    private RadioButton answerA;
    private RadioButton answerB;
    private RadioButton answerC;
    private RadioButton answerD;
    private Button nextButton;
    private ImageButton exitQuiz;

    private ColorStateList defaultButton;

    private List<Questions> questionsList;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;

    private int score;
    private boolean answered;

    public static final String hard_Score = "hardScore";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPrefs(this);
        if(sharedPref.loadNightMode()==true) {
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_quiz);
        setUpUi();
        showNextQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered) {
                    if (answerA.isChecked() || answerB.isChecked() || answerC.isChecked() || answerD.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(HardQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });

    }

    public void setUpUi() {
        /** A method to set up the user interface. **/
        question = findViewById(R.id.questionContent);
        questionScore = findViewById(R.id.questionScore);
        exitQuiz = findViewById(R.id.returntoMenu);
        questionNumber = findViewById(R.id.questionNumber);
        rg = findViewById(R.id.radioGroup);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);
        nextButton = findViewById(R.id.nextButton);

        defaultButton = answerA.getTextColors();

        dbQuestions = new QuizDatabaseHelper(this);
        questionsList = dbQuestions.getAllQuestionsHard();
        questionCountTotal = questionsList.size();
        Collections.shuffle(questionsList);

        exitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HardQuiz.this, examDifficulty.class));
            }
        });
    }

    public void showNextQuestion() {
        /** A method to show the next question to the user. **/
        answerA.setTextColor(defaultButton);
        answerB.setTextColor(defaultButton);
        answerC.setTextColor(defaultButton);
        answerD.setTextColor(defaultButton);
        rg.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionsList.get(questionCounter);

            question.setText(currentQuestion.getQuestion());
            answerA.setText(currentQuestion.getOption1());
            answerB.setText(currentQuestion.getOption2());
            answerC.setText(currentQuestion.getOption3());
            answerD.setText(currentQuestion.getOption4());

            questionCounter++;
            questionNumber.setText("Question:" + questionCounter + "/" + questionCountTotal);
            answered = false;
            nextButton.setText("Confirm");
        } else {
            finishQuiz();
        }
    }

    public void checkAnswer() {
        /** A method which checks if the user entered response is correct or not. **/
        answered = true;

        RadioButton rbSelected = findViewById(rg.getCheckedRadioButtonId());
        int answerNr = rg.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            questionScore.setText("Score: " + score);
        }
        showSolution();
    }

    public void showSolution() {
        /** A method which highlights the right and wrong answers to the user. **/
        answerA.setTextColor(Color.RED);
        answerB.setTextColor(Color.RED);
        answerC.setTextColor(Color.RED);
        answerD.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                answerA.setTextColor(Color.GREEN);
                question.setText("Answer A is Correct!");
                break;
            case 2:
                answerB.setTextColor(Color.GREEN);
                question.setText("Answer B is Correct!");
                break;
            case 3:
                answerC.setTextColor(Color.GREEN);
                question.setText("Answer C is Correct!");
                break;
            case 4:
                answerD.setTextColor(Color.GREEN);
                question.setText("Answer D is Correct!");
                break;
        }

        if (questionCounter < questionCountTotal) {
            nextButton.setText("Next");
        } else {
            nextButton.setText("Finish");
        }
    }

    public void finishQuiz() {
        /** A method which finishes the quiz and relays information to the examDifficulty class. **/
        Intent resultIntent = new Intent();
        resultIntent.putExtra(hard_Score, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}