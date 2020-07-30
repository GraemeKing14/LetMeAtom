package com.example.layout_idea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.layout_idea.QuestionsContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final String Database_name = "Questions.db";
    private static final int Database_version = 1;

    private SQLiteDatabase db;

    public QuizDatabaseHelper(Context context) {
        super(context, Database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.Table_name + " ( " +
                QuestionsTable._ID + " Integer PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.Column_Question + " TEXT, " +
                QuestionsTable.Column_Option1 + " TEXT, " +
                QuestionsTable.Column_Option2 + " TEXT, " +
                QuestionsTable.Column_Option3 + " TEXT, " +
                QuestionsTable.Column_Option4 + " TEXT, " +
                QuestionsTable.Column_Answer_Nr + " Integer" +
                ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions("What properties do light display?", "Wave", "Particle", "Both", "Neither", 3);
        addQuestion(q1);
        Questions q2 = new Questions("In V = IR, what does V stand for?", "Velocity", "Voltage", "Viscosity", "Volume", 2);
        addQuestion(q2);
        Questions q3 = new Questions("A car is moving at a speed of 2·0 m s−1. The car now accelerates at 4·0 m s−2 until it reaches a speed of 14 m s−1. The distance travelled by the car during this acceleration is", "1.5m", "18m", "24m", "25m", 3);
        addQuestion(q3);
        Questions q4 = new Questions("A spacecraft is travelling at 0·10c relative to a star. \nAn observer on the spacecraft measures the speed of light emitted by the star to be?", "0.90c", "1.00c", "1.01c", "0.99c", 2);
        addQuestion(q4);
        Questions q5 = new Questions("How many types of quark are there?", "6", "4 ", "8", "2", 1);
        addQuestion(q5);
        Questions q6 = new Questions("A neutrino is a type of?", "Baryon", "Gluon", "Lepton", "Quark", 3);
        addQuestion(q6);
        Questions q7 = new Questions("A moving charge produces:", "A weak field", "An electric field", "A strong field", "Another moving charge", 2);
        addQuestion(q7);
        Questions q8 = new Questions("What contains nuclear fusion reactors?", "A magnetic field", "An electric field", "A pool of water", "Large amounts of padding", 1);
        addQuestion(q8);
        Questions q9 = new Questions("What is the critical angle of a surface?", "The incident angle where the angle of refraction is 45 degrees.", "The incident angle where the angle of refraction is 90 degrees.", "The incident angle where the angle of refraction is 135 degrees.", "The incident angle where the angle of refraction is 180 degrees.", 2);
        addQuestion(q9);
        Questions q10 = new Questions("Which is not a type of Lepton?", "Electron", "Tau", "Gluon", "Muon", 3);
        addQuestion(q10);
    }

    private void addQuestion(Questions question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.Column_Question, question.getQuestion());
        cv.put(QuestionsTable.Column_Option1, question.getOption1());
        cv.put(QuestionsTable.Column_Option2, question.getOption2());
        cv.put(QuestionsTable.Column_Option3, question.getOption3());
        cv.put(QuestionsTable.Column_Option4, question.getOption4());
        cv.put(QuestionsTable.Column_Answer_Nr, question.getAnswerNr());
        db.insert(QuestionsTable.Table_name, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.Table_name);
        onCreate(db);

    }

    public List<Questions> getAllQuestions() {
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.Table_name, null);

        if (c.moveToFirst()){
            do {
                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.Column_Question)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.Column_Option1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.Column_Option2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.Column_Option3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.Column_Option4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.Column_Answer_Nr)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
