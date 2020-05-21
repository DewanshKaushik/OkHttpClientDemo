package com.okhttpclientdemo.RxJava;

public class RxJava {

    public void getData(){

        CompositeDisposable disposables=new CompositeDisposable();

        disposables.add(
                Observable.just("Hello world!")
                        // Run on a background thread
                        .subscribeOn(Schedulers.io())
                        // Be notified on the main thread
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String value) {

                            }
                        })
        );

    }

}
