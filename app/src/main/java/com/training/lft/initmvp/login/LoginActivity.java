package com.training.lft.initmvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.training.lft.initmvp.BaseActivity;
import com.training.lft.initmvp.R;

import butterknife.Bind;

public class LoginActivity extends BaseActivity implements LoginView {

    @Bind(R.id.progress)
    ProgressBar progressBar;
    @Bind(R.id.username)
    EditText uname;
    @Bind(R.id.password)
    EditText pwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * ####LoginView or view interaction start
     */
    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void setUnameError(String errorMsg) {
        uname.setError(errorMsg);

    }

    @Override
    public void setPwdError(String errorMsg) {
        pwd.setError(errorMsg);

    }

    @Override
    public void navigateToHome() {

    }

    /**
     * ####LoginView or view interaction end
     */
}
