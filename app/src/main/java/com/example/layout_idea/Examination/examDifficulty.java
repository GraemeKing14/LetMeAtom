package com.example.layout_idea.Examination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.layout_idea.HomePage;
import com.example.layout_idea.R;
import com.example.layout_idea.SharedPrefs;

import org.w3c.dom.Text;

public class examDifficulty extends AppCompatActivity {

    private static final int Request_Code_Quiz_Easy = 1;
    private static final int Request_Code_Quiz_Medium = 1;
    private static final int Request_Code_Quiz_Hard = 1;

    public static final String shared_Prefs = "quizSharedPrefs";
    public static final String easy_High_score = "easyHigh_score";
    public static final String med_High_score = "medHigh_score";
    public static final String hard_High_score = "hardHigh_score";

    SharedPrefs sharedPref;
    private Button easy;
    private Button medium;
    private Button hard;
    private ImageButton backButton;

    private TextView easyScore;
    private TextView medScore;
    private TextView hardScore;

    private int easyHighScore;
    private int medHighScore;
    private int hardHighScore;


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
        setContentView(R.layout.activity_exam_difficulty);
        setUpUi();
        startEasyQuiz();
        startMediumQuiz();
        startHardQuiz();
        loadEasyHighScore();
        loadMediumHighScore();
        loadHardHighScore();
    }

    public void setUpUi() {
        /** A method to set up the User Interface. **/
        backButton = findViewById(R.id.returntoMenu);
        easyScore = findViewById(R.id.easyHS);
        medScore = findViewById(R.id.medHS);
        hardScore = findViewById(R.id.hardHS);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(examDifficulty.this, HomePage.class));
            }
        });
    }


    public void startHardQuiz() {
        /** A method to add functionality to the hard button. **/
        hard = findViewById(R.id.hardButton);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(examDifficulty.this, HardQuiz.class), Request_Code_Quiz_Hard);
            }
        });
    }

    public void loadHardHighScore() {
        /** A method which loads the users high score for the hard quiz. **/
        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        hardHighScore = prefs.getInt(hard_High_score, 0);
        hardScore.setText("Highscore: " + hardHighScore);
    }

    public void updateHighScoreHard(int newHardHighScore) {
        /** A method which updates the users high score the hard quiz. **/
        hardHighScore = newHardHighScore;
        hardScore.setText("Highscore: " + hardHighScore);

        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(hard_High_score, hardHighScore);
        editor.apply();

    }


    public void startMediumQuiz() {
        /** A method to add functionality to the medium button. **/
        medium = findViewById(R.id.mediumButton);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(examDifficulty.this, MediumQuiz.class), Request_Code_Quiz_Medium);
            }
        });

    }

    public void loadMediumHighScore() {
        /** A method which loads the users high score for the medium quiz. **/
        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        medHighScore = prefs.getInt(med_High_score, 0);
        medScore.setText("Highscore: " + medHighScore);
    }

    public void updateHighScoreMed(int newMedHighScore) {
        /** A method which updates the users high score for the medium quiz. **/
        medHighScore = newMedHighScore;
        medScore.setText("Highscore: " + medHighScore);

        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(med_High_score, medHighScore);
        editor.apply();

    }


    public void startEasyQuiz() {
        /** A method which adds functionality to the easy button. **/
        easy = findViewById(R.id.easyButton);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(examDifficulty.this, EasyQuiz.class), Request_Code_Quiz_Easy);
            }
        });
    }

    public void loadEasyHighScore() {
        /** A method which loads the users high score for the easy quiz. **/
        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        easyHighScore = prefs.getInt(easy_High_score, 0);
        easyScore.setText("Highscore: " + easyHighScore);
    }

    public void updateHighScoreEasy(int newEasyHighScore) {
        /** A method which updates the users high score for the easy quiz. **/
        easyHighScore = newEasyHighScore;
        easyScore.setText("Highscore: " + easyHighScore);

        SharedPreferences prefs = getSharedPreferences(shared_Prefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(easy_High_score, easyHighScore);
        editor.apply();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /** A method which retrieves the users resultant high scores from each quiz screen
        and updates them if the conditions are met. **/
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Request_Code_Quiz_Easy) {
            if (resultCode == RESULT_OK) {
                int easyScoreNumber = data.getIntExtra(EasyQuiz.easy_Score, 0);
                if (easyScoreNumber > easyHighScore) {
                    updateHighScoreEasy(easyScoreNumber);
                }
            }
        }

        if (requestCode == Request_Code_Quiz_Hard) {
            if (resultCode == RESULT_OK) {
                int hardScoreNumber = data.getIntExtra(HardQuiz.hard_Score, 0);
                if (hardScoreNumber > hardHighScore) {
                    updateHighScoreHard(hardScoreNumber);
                }
            }
        }

        if (requestCode == Request_Code_Quiz_Medium) {
            if (resultCode == RESULT_OK) {
                int medScoreNumber = data.getIntExtra(MediumQuiz.medium_Score, 0);
                if (medScoreNumber > medHighScore) {
                    updateHighScoreMed(medScoreNumber);
                }
            }
        }
    }

}