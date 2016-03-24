package com.training.lft.initmvp.list;

/**
 */
public class FindItemInteractorImpl implements FindItemInteractor {

    private OnFinishedListener listener;

    public FindItemInteractorImpl() {

    }

    @Override
    public void findItems(OnFinishedListener listener) {
        fetchFromDb(listener);

    }

    private void fetchFromDb(OnFinishedListener listener) {
        DbFetcher.getInstance().fetchItems(listener);
    }

    private void fetchFromApi(OnFinishedListener listener) {
        ApiFetcher.getInstance().fetchFromApi(listener);
    }
}
