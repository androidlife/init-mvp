package com.training.lft.initmvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.training.lft.initmvp.BaseActivity;
import com.training.lft.initmvp.R;
import com.training.lft.initmvp.list.MainActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @Bind(R.id.progress)
    ProgressBar progressBar;
    @Bind(R.id.username)
    EditText uname;
    @Bind(R.id.password)
    EditText pwd;

    private LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImpl(this);

    }

    @OnClick({R.id.button})
    public void onClick(View view) {
        loginPresenter.validateCredentials(uname.getText().toString(), pwd.getText().toString());
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
        showProgress(false);
        uname.setError(errorMsg);

    }

    @Override
    public void setPwdError(String errorMsg) {
        showProgress(false);
        pwd.setError(errorMsg);

    }

    @Override
    public void navigateToHome() {
        showProgress(false);
        Toast.makeText(this, "Success login", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));

    }

    /**
     * ####LoginView or view interaction end
     */
}
