package com.training.lft.initmvp.login;

/**
 * Created by laaptu on 3/21/16.
 * View or views needs to define protocols,
 * meaning view is responsible for inputting,showing data and handling user interactions.
 * Let us assume View is a model ( not MVP model, but a sexy model).
 * To date the model, the model defines certain protocols
 * ( like need to pick her up at 8:00, not to message her, not to keep staring at her body, order a good food).
 * These are the only protocols by which you can interact with sexy model. So view needs to define its protocol
 */
public interface LoginView {
    void showProgress(boolean show);

    void setUnameError(String errorMsg);

    void setPwdError(String errorMsg);

    void navigateToHome();

}
