package com.cloudpos.one2two;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.debug("+onResume()" + this.getClass().getSimpleName());

        this.stopLockTask();  //if not call method, jumping to this activity is also pinned.

        Logger.debug("-onResume()");
    }

    public void back(View view) {
        finish();
    }
}
