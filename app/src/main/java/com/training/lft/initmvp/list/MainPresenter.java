package com.training.lft.initmvp.list;

/**
 * Created by laaptu on 3/24/16.
 */
public interface MainPresenter {
    void onResume();

    void onItemClick(int position);

    void onPause();
}
