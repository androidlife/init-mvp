package com.training.lft.initmvp.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by laaptu on 3/23/16.
 */
public class RestHelper {

    public static RestHelper instance;

    private AsyncHttpClient asyncHttpClient;

    private RestHelper() {
        asyncHttpClient = new AsyncHttpClient();
    }

    public static RestHelper getInstance() {
        if (instance == null)
            instance = new RestHelper();
        return instance;
    }

    public void loginOrRegister(String uname, String pwd, final StatusCallback statusCallback) {
        String url = "https://httpbin.org/get?uname='%s'&pwd='%s'";
        asyncHttpClient.get(String.format(url, uname, pwd), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                onResult(new String(responseBody), statusCallback);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                onResult(null, statusCallback);
            }
        });

    }

    public void onResult(String result, StatusCallback statusCallback) {
        Status status = new Status();
        if (result == null) {
            status.status = Status.ERROR_UNAME;
            status.msg = "Error making login";
            statusCallback.onResult(status);
            return;
        }

        status.status = Status.SUCCESS_LOGIN;
        status.msg = "Successfully logged in";
        statusCallback.onResult(status);

    }
}
