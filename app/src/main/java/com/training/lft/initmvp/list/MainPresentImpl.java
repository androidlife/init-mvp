package com.training.lft.initmvp.list;

import java.util.List;

/**
 * Created by laaptu on 3/24/16.
 */
public class MainPresentImpl implements MainPresenter, FindItemInteractor.OnFinishedListener {

    private MainView mainView;
    private FindItemInteractor findItemInteractor;

    public MainPresentImpl(MainView mainView) {
        this.mainView = mainView;
        findItemInteractor = new FindItemInteractorImpl();
    }

    @Override
    public void onResume() {
        findItemInteractor.findItems(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onFinished(List<String> items) {
        if (items.size() == 0) {
            mainView.showMessage("Unable to load any data items");
            mainView.showProgress(false);
            return;
        }
        mainView.setItems(items);

    }
}
