package com.kot32.warmenglish.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kot32 on 15/5/29.
 */
public class SystemStatus {

    private SystemStatus(){

    }

    public static boolean checkIsFirstComeIn(Context context){
        SharedPreferences preferences=context.getSharedPreferences("system", Context.MODE_PRIVATE);
         return preferences.getBoolean("isFirstCome",true);
    }

    public static void setFirstComeIn(Context context){
        SharedPreferences preferences=context.getSharedPreferences("system", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isFirstCome",false);
        editor.commit();
    }


}
