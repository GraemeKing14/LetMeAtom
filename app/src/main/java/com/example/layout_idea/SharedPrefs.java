package com.example.layout_idea;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    SharedPreferences mySharedPref;

    public SharedPrefs(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setNightMode(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Nightmode",state);
        editor.commit();
    }

    public boolean loadNightMode() {
        Boolean state = mySharedPref.getBoolean("Nightmode",false);
        return state;
    }


}
