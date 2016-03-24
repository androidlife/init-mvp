package com.training.lft.initmvp.login;

/**
 * Created by laaptu on 3/23/16.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    //binding to view is needed and binding to interactor is also needed
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        //right now binding is done here
        this.loginView = loginView;
        //interactor or to say model interactor add later
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String uname, String pwd) {
        loginView.showProgress(true);
        loginInteractor.login(uname, pwd, this);

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onUsernameError(String error) {
        loginView.setUnameError(error);

    }

    @Override
    public void onPasswordError(String error) {
        loginView.setPwdError(error);


    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();

    }
}
