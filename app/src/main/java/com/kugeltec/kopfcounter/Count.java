package com.kugeltec.kopfcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Karol on 13.08.2016.
 */
public class Count {
    private TextView kCountText;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private DataOpenHelper db;
    private int count;

    Count(TextView kCountText, SharedPreferences sharedPref, Context context) {
        this.kCountText = kCountText;
        this.sharedPref = sharedPref;
        db = new DataOpenHelper(context);
        editor = sharedPref.edit();
        count = sharedPref.getInt("count", 0);
        kCountText.setText(count + "");
    }

    public void add(Enum.Places place) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        db.putData(date, place.getId());
        count++;
        kCountText.setText(count + "");
        editor.putInt("count", count);
        editor.commit();
    }


}
