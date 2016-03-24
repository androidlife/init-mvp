package com.training.lft.initmvp.list;

import android.widget.ListView;
import android.widget.ProgressBar;

import com.training.lft.initmvp.BaseActivity;
import com.training.lft.initmvp.R;

import java.util.List;

import butterknife.Bind;

/**
 * Created by laaptu on 3/24/16.
 */
public class MainActivity extends BaseActivity implements MainView {
    @Bind(R.id.list)
    ListView listView;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void setItems(List<String> items) {

    }

    @Override
    public void showMessage(String message) {

    }
}
