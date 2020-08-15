package com.example.layout_idea;

import android.provider.BaseColumns;

public final class QuestionsContract {
    /** A class which holds information for the quiz database. Functions as a contract, hence name. **/
    private QuestionsContract() {
        /** Constructor for the class. **/
    }

    public static class QuestionsTable implements BaseColumns {
        /** A class which stores database details as strings. Implements the BaseColumns interface. **/
        public static final String Table_name = "Quiz_Questions";
        public static final String Column_Question = "Question";
        public static final String Column_Option1 = "Option1";
        public static final String Column_Option2 = "Option2";
        public static final String Column_Option3 = "Option3";
        public static final String Column_Option4 = "Option4";
        public static final String Column_Answer_Nr = "answer_nr";
    }
}
