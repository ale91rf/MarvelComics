package com.app.marvelcomics.interactor;


import com.app.marvelcomics.model.ComicResponse;
import com.app.marvelcomics.networking.MarvelRepository;
import com.app.marvelcomics.utils.Constants;
import com.app.marvelcomics.utils.HashGenerator;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetComicsInteractor {


    private MarvelRepository mApi;

    @Inject
    public GetComicsInteractor(MarvelRepository aApi){
        mApi = aApi;

    }

    public Observable<ComicResponse> getComics(Long aTimeStamp, String aCharacterId){

        String lHash = HashGenerator.generate(aTimeStamp, Constants.PRIVATE_KEY, Constants.PUBLIC_KEY);

        Observable<ComicResponse> lObservable =  mApi.getComics(aCharacterId, Constants.PUBLIC_KEY, lHash, aTimeStamp.toString());

        return lObservable.subscribeOn(Schedulers.io())
                // Observe result in the main thread to be able to update UI
                .observeOn(AndroidSchedulers.mainThread());
    }
}
