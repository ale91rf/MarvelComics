package com.app.marvelcomics.presenter;



public interface BasePresenter<T> {

    void bind(T view);

    void unbind();

}