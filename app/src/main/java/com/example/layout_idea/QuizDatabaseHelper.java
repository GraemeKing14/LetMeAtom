package com.example.layout_idea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.layout_idea.QuestionsContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    // A class used to create the Questions database. Inherits attributes
    // from the SQLiteOpenHelper class.

    private static final String Database_name = "Questions.db";
    private static final int Database_version = 1;

    private SQLiteDatabase db;

    public QuizDatabaseHelper(Context context) {
        // A simple constructor for the database
        super(context, Database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // A method which creates the database according to specifications.
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

    public void fillQuestionsTable() {
        // A method to fill the database with questions for the quiz.

        //Hard Questions
        Questions q1 = new Questions("The redshift of a distant galaxy is 0·014. According to Hubble’s law, the distance of the galaxy from Earth is? ", " 9·66 × 10e-12 m", " 9·32 × 10e27 m", "1·83 × 10e24 m", "1·30 × 10e26 m ", 3);
        addQuestion(q1);
        Questions q2 = new Questions("A ray of monochromatic light passes from air into water. The wavelength of this light in air is 589 nm. The speed of this light in water is? ", " 2·56 × 10e2 m/s ", "4·52 × 10e2 m/s", "4·78 × 10e2 m/s", "1·52 × 10e2 m/s", 2);
        addQuestion(q2);
        Questions q3 = new Questions("A car is moving at a speed of 2·0 m s−1. The car now accelerates at 4·0 m s−2 until it reaches a speed of 14 m s−1. The distance travelled by the car during this acceleration is", "1.5m", "18m", "24m", "25m", 3);
        addQuestion(q3);
        Questions q4 = new Questions("A spacecraft is travelling at 0·10c relative to a star. \nAn observer on the spacecraft measures the speed of light emitted by the star to be?", "0.90c", "1.00c", "1.01c", "0.99c", 2);
        addQuestion(q4);
        Questions q5 = new Questions("Measurements of the expansion rate of the Universe lead to the conclusion that the rate of expansion is increasing. Present theory proposes that this is due to? ", "Redshift", "Dark Matter", "Dark Energy", "Gravity", 3);
        addQuestion(q5);
        Questions q6 = new Questions("A block of wood slides with a constant velocity down a slope. The slope makes an angle of 30º with the horizontal axis. The mass of the block is 2·0 kg. The magnitude of the force of friction acting on the block is?" , "1.0N", "2.0N", "9.0N", "9.8N", 4);
        addQuestion(q6);
        Questions q7 = new Questions("A planet orbits a star at a distance of 3·0 × 10e9 m. The star exerts a gravitational force of 1·6 × 10e27 N on the planet. The mass of the star is 6·0 × 10e30 kg. The mass of the planet is? ", "2.4 x 10e14 kg", "3.6 x 10e25 kg", "1.2 x 10e16 kg", "1.6 x 10e26 kg", 2);
        addQuestion(q7);
        Questions q8 = new Questions("Radiation of frequency 9·00 × 10e15 Hz is incident on a clean metal surface. The maximum kinetic energy of a photoelectron ejected from this surface is 5·70 × 10e−18 J. The work function of the metal is?", "2.67 x 10e-19 J", "9.10 x 10e-1 J", "1.60 x 10e-18 J", "4.80 x 10e-2 J", 1);
        addQuestion(q8);
        Questions q9 = new Questions("The irradiance of light from a point source is 32 W m−2 at a distance of 4·0 m from the source. The irradiance of the light at a distance of 16 m from the source is? ", "1.0 W m-2", "8.0 W m-2", "4.0 W m-2", "2.0 W m-2", 4);
        addQuestion(q9);
        Questions q10 = new Questions("A person stands on a weighing machine in a lift. When the lift is at rest, the reading on the weighing machine is 700 N. The lift now descends and its speed increases at a constant rate. The reading on the weighing machine...", "Is a constant value higher than 700N. ", "Is a constant value lower than 700N. ", "Continually increases from 700 N. ", "Continually decreases from 700 N. ", 2);
        addQuestion(q10);

        //Medium Questions
        Questions q11 = new Questions("What is Newtons Second Law of Motion?", "F = ma", "m = Fa", "F = a/m", "Every action has an equal and opposite reaction", 1);
        addQuestion(q11);
        Questions q12 = new Questions("In s = vt, what does s stand for?", "Distance", "Speed", "Sin", "Displacement", 4);
        addQuestion(q12);
        Questions q13 = new Questions("An object reaches terminal velocity when...", "Forward force is greater than the frictional force.", "All forces acting on that object are equal.", "Acceleration starts decreasing.", "Acceleration is greater than 0", 2);
        addQuestion(q13);
        Questions q14 = new Questions("An Elastic Collision is where?", "There is no loss of Kinetic Energy.", "There is a small loss in Kinetic Energy.", "There is an increase in Kinetic Energy.", "Some Kinetic Energy is transferred to another type.", 1);
        addQuestion(q14);
        Questions q15 = new Questions("The speed of light is?", "Different for all observers.", "The same for all observers. ", "The same speed regardless of the medium it is travelling through. ", "Equal to the speed of sound.", 2);
        addQuestion(q15);
        Questions q16 = new Questions("What is redshift?", "Light moving to us, shifting to red. ", "A dodgy gear change. ", "Light moving away from us shifting to longer wavelengths.", "Another word for dark energy. ", 3);
        addQuestion(q16);
        Questions q17 = new Questions("Which law allows us to estimate the age of the universe?", "Newtons 3rd Law ", "The Hubble-Lemaitre Law ", "Planck's Law ", "Wien's Law ", 2);
        addQuestion(q17);
        Questions q18 = new Questions("The standard model...", "Models how time interacts with space. ", "Describes how entropy works. ", "Is the 2nd Law of Thermodynamics. ", "Describes the fundamental particles of the universe and how they interact", 4);
        addQuestion(q18);
        Questions q19 = new Questions("The photoelectric effect gives evidence for?", "The wave model of light. ", "The particle model of light. ", "The speed of light. ", "The frequency of light. ", 2);
        addQuestion(q19);
        Questions q20 = new Questions("AC is a current which...", "Doesn't change direction. ", "Is often called variable current. ", "Is sneaky. ", "Changes direction and instantaneous value with time. ", 4);
        addQuestion(q20);

        //Easy Questions
        Questions q21 = new Questions("What properties does light display?", "Wave", "Particle", "Both", "Neither", 3);
        addQuestion(q21);
        Questions q22 = new Questions("In V = IR, what does V stand for?", "Velocity", "Voltage", "Viscosity", "Volume", 2);
        addQuestion(q22);
        Questions q23 = new Questions("The abbreviation rms typically stands for?", "Round mean sandwich. ", "Random manic speed. ", "Root manic speed. ", "Root mean squared. ", 4);
        addQuestion(q23);
        Questions q24 = new Questions("Path Difference = ", "= (m/λ) or (m + ½)/λ where m = 0,1,2…", "= mλ or (m + ½) λ where m = 0,1,2…", "= λ / m or (λ + ½) / m where m = 0,1,2…", " = mλ or (m + ½) λ where m = 0.5,1.5,2.5,…", 2);
        addQuestion(q24);
        Questions q25 = new Questions("How many types of quark are there?", "6", "4 ", "8", "2", 1);
        addQuestion(q25);
        Questions q26 = new Questions("A neutrino is a type of?", "Baryon", "Gluon", "Lepton", "Quark", 3);
        addQuestion(q26);
        Questions q27 = new Questions("A moving charge produces:", "A weak field", "An electric field", "A strong field", "Another moving charge", 2);
        addQuestion(q27);
        Questions q28 = new Questions("What contains nuclear fusion reactors?", "A magnetic field", "An electric field", "A pool of water", "Large amounts of padding", 1);
        addQuestion(q28);
        Questions q29 = new Questions("What is the critical angle of a surface?", "The incident angle where the angle of refraction is 45 degrees.", "The incident angle where the angle of refraction is 90 degrees.", "The incident angle where the angle of refraction is 135 degrees.", "The incident angle where the angle of refraction is 180 degrees.", 2);
        addQuestion(q29);
        Questions q30 = new Questions("Which is not a type of Lepton?", "Electron", "Tau", "Gluon", "Muon", 3);
        addQuestion(q30);
    }

    private void addQuestion(Questions question) {
        // A method to take values and insert them into the table.
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
        // A method to drop the table if the version is upgraded.
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.Table_name);
        onCreate(db);

    }

    public List<Questions> getAllQuestionsHard() {
        // A method to return all hard questions in the database.
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.Table_name + " WHERE _id BETWEEN 1 AND 10", null);

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

    public List<Questions> getAllQuestionsMedium() {
        // A method to return all medium questions in the database.
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.Table_name + " WHERE _id BETWEEN 11 AND 20", null);

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

    public List<Questions> getAllQuestionsEasy() {
        // A method to return all easy questions from database.
        List<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.Table_name + " WHERE _id BETWEEN 21 AND 30", null);

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
