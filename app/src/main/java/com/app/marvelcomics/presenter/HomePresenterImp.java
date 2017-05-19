package com.app.marvelcomics.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.app.marvelcomics.App;
import com.app.marvelcomics.R;
import com.app.marvelcomics.networking.MarvelRepository;
import com.app.marvelcomics.networking.NetworkRequestAndroid;
import com.app.marvelcomics.ui.view.HomeView;
import com.app.marvelcomics.utils.Constants;
import com.app.marvelcomics.utils.HashGenerator;
import com.app.marvelcomics.utils.Utils;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.Subscriptions;


public class HomePresenterImp implements HomePresenter {

    @Inject
    MarvelRepository mApi;

    @Inject
    ConnectivityManager mConnectivity;

    private HomeView mView;
    private Subscription mSubscription = Subscriptions.empty();


    public HomePresenterImp(Context context) {
        ((App)context).getAppComponent().inject(this);
    }

    @Override
    public void getCommics(Long aTimeStamp) {

        NetworkInfo lNetworkInfo = mConnectivity.getActiveNetworkInfo();

        if(Utils.isNetworkAvailable(lNetworkInfo)){

            mView.showProgress();

            String lHash = HashGenerator.generate(aTimeStamp, Constants.PRIVATE_KEY, Constants.PUBLIC_KEY);

            mSubscription = NetworkRequestAndroid.performAsyncRequest(mApi.getComics(Constants.THOR_ID, Constants.PUBLIC_KEY,
                    lHash, aTimeStamp.toString()),
                    (aResponse) -> {
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
                    });
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
