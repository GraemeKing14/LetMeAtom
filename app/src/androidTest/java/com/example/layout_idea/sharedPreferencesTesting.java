package com.example.layout_idea;
import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.layout_idea.Examination.examDifficulty;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;
/** A testing class for checking that features that are reliant on shared preferences
 work as expected. **/
@RunWith(AndroidJUnit4.class)
public class sharedPreferencesTesting {

    private SharedPrefs sP;

    /** A test to ensure that the dark mode toggle functions as expected. **/
    @Test
    public void checkDarkMode() {
        Context context = ApplicationProvider.getApplicationContext();
        sP = new SharedPrefs(context);
        sP.setNightMode(true);
        assertEquals(sP.loadNightMode(), true);
        sP.setNightMode(false);
        assertNotEquals(sP.loadNightMode(), true);
    }
}
