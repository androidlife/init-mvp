package com.training.lft.initmvp.list;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by laaptu on 3/24/16.
 */
public class ApiFetcher {
    private static ApiFetcher instance;

    private ApiFetcher() {
    }

    public static ApiFetcher getInstance() {
        if (instance == null)
            instance = new ApiFetcher();
        return instance;
    }

    public void fetchFromApi(final FindItemInteractor.OnFinishedListener listener) {
        String url = "https://httpbin.org/get";
        final ArrayList<String> items = new ArrayList<>();
        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                for (int i = 0; i < 20; i++)
                    items.add("Success " + String.valueOf(i));
                listener.onFinished(items);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                for (int i = 0; i < 10; i++)
                    items.add("Error " + String.valueOf(i));
                listener.onFinished(items);
            }
        });

    }

}
