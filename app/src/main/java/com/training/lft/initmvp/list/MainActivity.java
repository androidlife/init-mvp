package com.training.lft.initmvp.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresentImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress(true);
        mainPresenter.onResume();

    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void setItems(List<String> items) {
        showProgress(false);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainPresenter.onItemClick(position);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
