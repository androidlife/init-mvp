package com.training.lft.initmvp.login;

import com.training.lft.initmvp.utils.PrefHelper;
import com.training.lft.initmvp.utils.RestHelper;
import com.training.lft.initmvp.utils.Status;
import com.training.lft.initmvp.utils.StatusCallback;

/**
 * Created by laaptu on 3/23/16.
 */
public class LoginInteractorImpl implements LoginInteractor, StatusCallback {
    @Override
    public void login(String uname, String pwd, OnLoginFinishedListener listener) {

    }

    private void makeLoginUsingDb(String uname, String pwd) {
        PrefHelper prefHelper = PrefHelper.getInstance();
        prefHelper.loginOrRegister(uname, pwd, this);
    }

    private void makeLoginUsingRestAPI(String uname, String pwd) {
        RestHelper restHelper = RestHelper.getInstance();
        restHelper.loginOrRegister(uname,pwd,this);
    }

    @Override
    public void onResult(Status status) {

    }
}
