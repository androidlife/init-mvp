package com.training.lft.initmvp.list;

import java.util.List;

/**
 * Created by laaptu on 3/24/16.
 */
public interface MainView {
    void showProgress(boolean show);

    void setItems(List<String> items);

    void showMessage(String message);
}
