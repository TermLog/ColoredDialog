package com.termlog.alexzandr.coloreddialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MultiDialogStylesActivity extends AppCompatActivity {

    private AlertDialog mDialog;

    private final View.OnClickListener mShowDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showAlertDialog(v.getId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_dialog_styles);
        findViewById(R.id.show_app_compat_dialog).setOnClickListener(mShowDialog);
        findViewById(R.id.dif_buttons).setOnClickListener(mShowDialog);
        findViewById(R.id.single_theme).setOnClickListener(mShowDialog);
    }

    public void showAlertDialog(int id) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
        AlertDialog.Builder builder;
        String title;
        String message;
        switch (id) {
            case R.id.single_theme:
                builder = new AlertDialog.Builder(this, R.style.ForDifferentAlert);
                title = "New Buttons Color";
                message = "Buttons have color different than application theme";
                break;
            case R.id.dif_buttons:
                builder = new AlertDialog.Builder(this, R.style.ForDifferentButton);
                title = "Colored Buttons";
                message = "Each button has its own color. That does not match the color of theme";
                break;
            case R.id.show_app_compat_dialog:
            default:
                builder = new AlertDialog.Builder(this);
                title = "App Theme Color";
                message = "Buttons have color, that matches the color of theme";
                break;
        }
        mDialog = builder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .setNeutralButton("Ignore", null)
                .show();
    }
}
