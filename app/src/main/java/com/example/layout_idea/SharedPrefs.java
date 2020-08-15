package com.example.layout_idea;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    /** A class which holds information regarding user choices for the dark mode function. **/
    SharedPreferences mySharedPref;

    public SharedPrefs(Context context) {
        /** Simple constructor setting the preferences to private. **/
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setNightMode(Boolean state) {
        /** A method to set toggle night mode on or off. **/
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Nightmode",state);
        editor.commit();
    }

    public boolean loadNightMode() {
        /** A method to check the state of the night mode boolean. **/
        Boolean state = mySharedPref.getBoolean("Nightmode",false);
        return state;
    }


}
