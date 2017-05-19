package com.app.marvelcomics.networking;


import com.app.marvelcomics.model.ComicResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface MarvelRepository {

    String CHARACTER_ID = "characterId";
    String API_KEY      = "apikey";
    String HASH         = "hash";
    String TIMESTAMP    = "ts";

    @GET("/v1/public/characters/{characterId}/comics")
    Observable<ComicResponse> getComics(
            @Path(CHARACTER_ID) String characterId,
            @Query(API_KEY) String publicKey,
            @Query(HASH) String hash,
            @Query(TIMESTAMP) String timestamp);


}
