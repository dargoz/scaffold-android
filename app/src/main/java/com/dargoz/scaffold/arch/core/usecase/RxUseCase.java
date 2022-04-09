package com.dargoz.scaffold.arch.core.usecase;


import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.DisposableSubscriber;

public abstract class RxUseCase<T, Param> {

    private Disposable disposable;

    public interface RxScheduler {
        Scheduler subscribeOnScheduler();
        Scheduler observeOnScheduler();
    }

    public RxScheduler rxScheduler;

    protected abstract Flowable<T> buildUseCase(Param param);

    public RxUseCase<T, Param> setRxScheduler(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
        return this;
    }

    public void execute(Param param, DisposableSubscriber<T> consumer) {
        if (rxScheduler == null) throw new NullPointerException("Don't forget to setRxScheduler()");
        disposable = consumer;
        buildUseCase(param)
                .subscribeOn(rxScheduler.subscribeOnScheduler())
                .observeOn(rxScheduler.observeOnScheduler())
                .subscribe(consumer);
    }

    public void execute(Param param, Consumer<? super T> consumer) {
        if (rxScheduler == null) throw new NullPointerException("Don't forget to setRxScheduler()");
        disposable = buildUseCase(param)
                .subscribeOn(rxScheduler.subscribeOnScheduler())
                .observeOn(rxScheduler.subscribeOnScheduler())
                .subscribe(consumer);
    }

    public void dispose() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
