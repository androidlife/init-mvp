package com.training.lft.initmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.training.lft.initmvp.MainApplication;

/**
 * Created by laaptu on 3/23/16.
 */
public class PrefHelper {

    private static PrefHelper instance;
    private SharedPreferences sharedPref;
    private static final String PREF_NAME = "MVP";
    private static final String UNAME = "uname";
    private static final String PWD = "pwd";

    private PrefHelper() {
        sharedPref = MainApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static PrefHelper getInstance() {
        if (instance == null) {
            instance = new PrefHelper();
        }
        return instance;
    }


    public void loginOrRegister(String uname, String pwd, StatusCallback statusCallback) {
        Status status = new Status();
        if (TextUtils.isEmpty(uname)) {
            status.status = Status.ERROR_UNAME;
            status.msg = "Username empty ";
            statusCallback.onResult(status);
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            status.status = Status.ERROR_PWD;
            status.msg = "Password Empty";
            statusCallback.onResult(status);
            return;
        }

        if (sharedPref.getString(UNAME, null) == null) {
            //need to register this
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(UNAME, uname);
            editor.putString(PWD, pwd);
            editor.apply();
            status.status = Status.SUCCESS_REGISTER;
            status.msg = "Successfully registered";
            statusCallback.onResult(status);
            return;
        }

        if (sharedPref.getString(UNAME, "").equals(uname)) {
            status.status = Status.ERROR_UNAME;
            status.msg = "Username doesn't exist";
            statusCallback.onResult(status);
            return;
        }

        if (sharedPref.getString(PWD, "").equals(pwd)) {
            status.status = Status.ERROR_PWD;
            status.msg = "Password doesn't match";
            statusCallback.onResult(status);
            return;
        }

        status.status = Status.SUCCESS_LOGIN;
        status.msg = "Sucess login";
        statusCallback.onResult(status);
    }
}
