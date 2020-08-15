package com.example.layout_idea;

import android.content.Context;
import android.content.SharedPreferences;

/** A class which holds information regarding user choices for the dark mode function. **/
public class SharedPrefs {
    SharedPreferences mySharedPref;

    /** Simple constructor setting the preferences to private. **/
    public SharedPrefs(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    /** A method to set toggle night mode on or off. **/
    public void setNightMode(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Nightmode",state);
        editor.commit();
    }

    /** A method to check the state of the night mode boolean. **/
    public boolean loadNightMode() {
        Boolean state = mySharedPref.getBoolean("Nightmode",false);
        return state;
    }


}
