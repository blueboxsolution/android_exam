package com.bbx.androidexam.common;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by macbookair on 28/09/2017.
 */

public class Util {

    Context context;

    public Util(Context context){
        this.context = context;
    }

    public String computeAge(String birthdate){

        int month = Integer.parseInt(birthdate.substring(0,2));
        int day = Integer.parseInt(birthdate.substring(3,5));
        int year = Integer.parseInt(birthdate.substring(6,10));

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageStr = ageInt.toString();

        return ageStr;
    }
}
