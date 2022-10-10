package com.dargoz.core.usecase;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class SingleRxUseCase<T, Param> {

    private DisposableSingleObserver<T> disposable;

    public interface RxScheduler {
        Scheduler subscribeOnScheduler();
        Scheduler observeOnScheduler();
    }

    public RxScheduler rxScheduler;

    protected abstract Single<T> buildUseCase(Param param);

    public SingleRxUseCase<T, Param> setRxScheduler(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
        return this;
    }

    public void execute(Param param, DisposableSingleObserver<T> consumer) {
        if (rxScheduler == null) throw new NullPointerException("Don't forget to setRxScheduler()");
        disposable = consumer;
        buildUseCase(param)
                .subscribeOn(rxScheduler.subscribeOnScheduler())
                .observeOn(rxScheduler.observeOnScheduler())
                .subscribe(consumer);
    }


    public void dispose() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}

