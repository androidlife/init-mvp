package com.training.lft.initmvp.list;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by laaptu on 3/24/16.
 */
public class DbFetcher {
    private DbFetcher() {

    }

    private static DbFetcher instance;

    public static DbFetcher getInstance() {
        if (instance == null)
            instance = new DbFetcher();
        return instance;
    }

    private ArrayList<String> listItems;

    public void fetchItems(final FindItemInteractor.OnFinishedListener listener) {
        listItems = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            listItems.add("Item " + String.valueOf(i));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(listItems);
            }
        }, 1000);
    }
}
