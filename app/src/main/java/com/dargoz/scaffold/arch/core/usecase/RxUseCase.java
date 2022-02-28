package com.dargoz.scaffold.arch.core.usecase;


import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.DisposableSubscriber;

public abstract class RxUseCase<T, Param> {

    private Disposable disposable;

    public abstract Scheduler getScheduler();
    public abstract Flowable<T> buildUseCase(Param param);

    public void execute(Param param, DisposableSubscriber<T> consumer) {
        disposable = consumer;
        buildUseCase(param)
                .subscribeOn(getScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public void execute(Param param, Consumer<? super T> consumer) {
        disposable = buildUseCase(param)
                .subscribeOn(getScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public void dispose() {
        disposable.dispose();
    }
}
