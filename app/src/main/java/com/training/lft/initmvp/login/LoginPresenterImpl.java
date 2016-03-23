package com.training.lft.initmvp.login;

/**
 * Created by laaptu on 3/23/16.
 */
public class LoginPresenterImpl implements LoginPresenter {

    //binding to view is needed and binding to interactor is also needed
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        //right now binding is done here
        this.loginView = loginView;
        //interactor or to say model interactor add later
    }

    @Override
    public void validateCredentials(String uname, String pwd) {
        loginView.showProgress(true);

    }

    @Override
    public void onDestroy() {

    }
}
