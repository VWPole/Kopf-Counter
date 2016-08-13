package com.kugeltec.kopfcounter;

import android.content.SharedPreferences;
import android.widget.TextView;

/**
 * Created by Karol on 13.08.2016.
 */
public class Count {
    TextView kCountText;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private int count;

    Count(TextView kCountText, SharedPreferences sharedPref) {
        this.kCountText = kCountText;
        this.sharedPref = sharedPref;
        editor = sharedPref.edit();
        count = sharedPref.getInt("count", 0);
        kCountText.setText(count + "");
    }

    public void add() {
        count++;
        kCountText.setText(count + "");
        editor.putInt("count", count);
        editor.commit();
    }
}
