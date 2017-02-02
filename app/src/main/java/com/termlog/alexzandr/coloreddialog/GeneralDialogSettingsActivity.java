package com.termlog.alexzandr.coloreddialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AlexZandR on 2/2/17.
 *
 */

public class GeneralDialogSettingsActivity extends AppCompatActivity {

    private AlertDialog mDialog;

    private final View.OnClickListener mShowDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showAlertDialog();
        }
    };

    private final View.OnClickListener mNavigateNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(GeneralDialogSettingsActivity.this, MultiDialogStylesActivity.class));
        }
    };

    private final View.OnClickListener mSetDefault = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDefaultTheme();
        }
    };

    private final View.OnClickListener mSetBlue = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setBlueTheme();
        }
    };

    private final View.OnClickListener mSetYellow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setYellowTheme();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_general_dialog_settings);
        findViewById(R.id.show_app_compat_dialog).setOnClickListener(mShowDialog);
        findViewById(R.id.start_next_activity).setOnClickListener(mNavigateNext);
        findViewById(R.id.button_set_default).setOnClickListener(mSetDefault);
        findViewById(R.id.button_set_blue).setOnClickListener(mSetBlue);
        findViewById(R.id.button_set_yellow).setOnClickListener(mSetYellow);
    }

    public void showAlertDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String title = "General Accent Color";
        String message = "Buttons use accentColor from the activity theme";

        mDialog = builder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .setNeutralButton("Ignore", null)
                .show();
    }

    private void setDefaultTheme() {
        setTheme(R.style.GeneralSettings);
        initView();
    }

    private void setBlueTheme() {
        setTheme(R.style.GeneralSettings_Blue);
        initView();
    }

    private void setYellowTheme() {
        setTheme(R.style.GeneralSettings_Yellow);
        initView();
    }
}
