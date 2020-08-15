package com.example.layout_idea;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

/** A testing class to error test both databases. Aims to check both databases
 have been created correctly and can accept and return entries. **/
@RunWith(AndroidJUnit4.class)
public class DatabaseTests {

    private DatabaseHelper db;
    private QuizDatabaseHelper qDb;

    /** Checks database names. Ensures the createDatabase function correctly. **/
    @Test
    public void checkDatabaseName() {
        Context context = ApplicationProvider.getApplicationContext();
        db = new DatabaseHelper(context);
        qDb = new QuizDatabaseHelper(context);
        assertEquals("userInfo.db", db.getDatabaseName());
        assertEquals("Questions.db", qDb.getDatabaseName());
    }

    /** Checks database versions. Ensures they have been created properly. **/
    @Test
    public void checkDatabaseVersion() {
        Context context = ApplicationProvider.getApplicationContext();
        db = new DatabaseHelper(context);
        qDb = new QuizDatabaseHelper(context);
        assertEquals(db.getReadableDatabase().getVersion(), 1);
        assertEquals(qDb.getReadableDatabase().getVersion(), 1);
    }

    /** Checks length of quiz database. Ensures that questions are added and retrieved correctly. **/
    @Test
    public void checkDatabaseLength() {
        Context context = ApplicationProvider.getApplicationContext();
        qDb = new QuizDatabaseHelper(context);
        assertEquals(qDb.getAllQuestionsHard().size(), 10);
        assertEquals(qDb.getAllQuestionsEasy().size(), 10);
        assertEquals(qDb.getAllQuestionsMedium().size(), 10);
        assertNotEquals(qDb.getAllQuestionsEasy().size(), 11);
    }

    /** Adds a user to the userInfo database and ensures that said user has been added to the db.
     Also checks that the system returns false when a user is not registered to system.**/
    @Test
    public void testAddedUserExists() {
        Context context = ApplicationProvider.getApplicationContext();
        db = new DatabaseHelper(context);
        db.addUser("Kostas", "12345");
        assertEquals(db.checkUser("Kostas","12345"), true);
        assertEquals(db.checkUser("Kost","12345"), false);
    }
}
