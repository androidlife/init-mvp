package com.training.lft.initmvp.list;

import java.util.List;

/**
 * Created by laaptu on 3/24/16.
 */
public interface FindItemInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}
