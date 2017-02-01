package com.termlog.alexzandr.coloreddialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

    private static final boolean AUTO_HIDE = true;

    private static final int AUTO_HIDE_DELAY_MILLIS = 500;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Holo Style");
            builder.setMessage("This dialog has style from Holo Theme");
            builder.setNegativeButton("no", null);
            builder.setNeutralButton("ignore", null);
            builder.setPositiveButton("yes", null);
            builder.show();
        }
    };

    private final Runnable mStartActivityRunnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(MainActivity.this, AppCompatStyleActivity.class));
        }
    };

    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    private final View.OnTouchListener mStartActivityTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                startActivity(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.show_holo_dialog).setOnTouchListener(mDelayHideTouchListener);
        findViewById(R.id.start_app_compat_activity).setOnTouchListener(mStartActivityTouchListener);
    }

    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    private void startActivity(int delayMillis) {
        mHideHandler.removeCallbacks(mStartActivityRunnable);
        mHideHandler.postDelayed(mStartActivityRunnable, delayMillis);
    }
}
