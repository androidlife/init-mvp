package com.training.lft.initmvp.login;

/**
 * Created by laaptu on 3/23/16.
 */
public interface LoginPresenter {
    void validateCredentials(String uname, String pwd);

    void onDestroy();
}
