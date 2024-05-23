package com.cloudpos.one2two;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.debug("+onResume()" + this.getClass().getSimpleName());

        AidlControl.getInstance().startLockTaskMode(this, this.getTaskId());

        Logger.debug("-onResume()");
    }

    public void goto2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
