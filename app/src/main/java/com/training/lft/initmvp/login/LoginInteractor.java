package com.training.lft.initmvp.login;

/**
 * Created by laaptu on 3/23/16.
 */
public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError(String error);

        void onPasswordError(String error);

        void onSuccess();
    }

    void login(String uname, String pwd, OnLoginFinishedListener listener);
}
