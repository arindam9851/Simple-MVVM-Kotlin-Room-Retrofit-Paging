package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall;

import android.app.ProgressDialog;
import android.content.Context;

public class AppUtils {
    private static AppUtils appUtilityInstance;
    static ProgressDialog progress;
    public static AppUtils getInstance() {
        if (appUtilityInstance == null) {
            appUtilityInstance = new AppUtils();
        }
        return appUtilityInstance;
    }
    public  void showProgressDialog(Context context) {
        try {
            if (context != null) {
                hideProgressDialog(context);
                progress = new ProgressDialog(context, R.style.Widget_ProgressBar_Small);
                progress.setCancelable(false);
               /* if(progress.getWindow()!=null)
                progress.getWindow().setGravity(Gravity.BOTTOM);
               */
                progress.setIndeterminateDrawable(context.getResources()
                        .getDrawable(R.drawable.progressbar));
                progress.show();
            }
        } catch (Exception e) {

        }

    }
    public  void hideProgressDialog(Context context) {

        if (progress != null && progress.isShowing() && context != null) {
            progress.dismiss();
        }


    }
}
