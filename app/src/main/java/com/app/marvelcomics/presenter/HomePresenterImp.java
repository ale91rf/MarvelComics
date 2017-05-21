package com.app.marvelcomics.presenter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.app.marvelcomics.R;
import com.app.marvelcomics.interactor.GetComicsInteractor;
import com.app.marvelcomics.ui.view.HomeView;
import com.app.marvelcomics.utils.Constants;
import com.app.marvelcomics.utils.Utils;


import rx.Subscription;
import rx.subscriptions.Subscriptions;


public class HomePresenterImp implements HomePresenter {


    private GetComicsInteractor mInteractor;
    private ConnectivityManager mConnectivity;


    private HomeView mView;
    private Subscription mSubscription = Subscriptions.empty();


    public HomePresenterImp(GetComicsInteractor aInteractor, ConnectivityManager aConnectivity) {
        mInteractor = aInteractor;
        mConnectivity = aConnectivity;

    }

    /*(aResponse) -> {
        mView.hideProgress();
        if (aResponse == null || aResponse.getmData() == null || aResponse.getmData().getmComics() == null){
            mView.showMessage(mView.getContext().getString(R.string.server_problems));
        }else if (aResponse.getmData().getmComics().size() == 0){
            mView.showMessage(mView.getContext().getString(R.string.no_comics));
        }else {
            mView.displayComics(aResponse.getmData().getmComics());
        }

    }, (aError) -> {
        mView.hideProgress();
        mView.showMessage(mView.getContext().getString(R.string.server_problems));
    });*/

    @Override
    public void getCommics(Long aTimeStamp) {

        NetworkInfo lNetworkInfo = mConnectivity.getActiveNetworkInfo();

        if(Utils.isNetworkAvailable(lNetworkInfo)){

            mView.showProgress();


            mSubscription = mInteractor.getComics(aTimeStamp, Constants.THOR_ID)
                    .doOnNext(aResponse -> {
                        mView.hideProgress();
                        if (aResponse == null || aResponse.getmData() == null || aResponse.getmData().getmComics() == null){
                            mView.showMessage(mView.getContext().getString(R.string.server_problems));
                        }else if (aResponse.getmData().getmComics().size() == 0){
                            mView.showMessage(mView.getContext().getString(R.string.no_comics));
                        }else {
                            mView.displayComics(aResponse.getmData().getmComics());
                        }
                    })
                    .doOnError(aError -> {
                        mView.hideProgress();
                        mView.showMessage(mView.getContext().getString(R.string.server_problems));
                    })
                    .subscribe();


        }else {
            mView.showMessage(mView.getContext().getString(R.string.no_internet));

        }





    }


    @Override
    public void bind(HomeView view) {
        mView = view;
    }

    @Override
    public void unbind() {
        if (mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();

        mView = null;
    }
}
