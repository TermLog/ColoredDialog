package com.termlog.alexzandr.coloreddialog;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by AlexZandR on 2/2/17.
 *
 */

public class Utils {

    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_YELLOW = 2;

    public static void changeToTheme(Activity activity, int theme) {
        if (theme != sTheme) {
            sTheme = theme;
            activity.finish();
            activity.startActivity(new Intent(activity, activity.getClass()));
            activity.overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        }
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.GeneralSettings);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.GeneralSettings_Blue);
                break;
            case THEME_YELLOW:
                activity.setTheme(R.style.GeneralSettings_Yellow);
                break;
        }
    }

}
