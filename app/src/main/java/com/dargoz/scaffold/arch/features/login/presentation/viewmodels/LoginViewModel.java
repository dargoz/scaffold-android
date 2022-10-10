package com.dargoz.scaffold.arch.features.login.presentation.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dargoz.core.models.Result;
import com.dargoz.core.usecase.SingleRxUseCase;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthEntity;
import com.dargoz.scaffold.arch.features.login.domain.entities.AuthFormEntity;
import com.dargoz.scaffold.arch.features.login.domain.usecases.RequestAuthUseCase;
import com.dargoz.scaffold.arch.features.login.presentation.mappers.AuthPresenterMappers;
import com.dargoz.scaffold.arch.features.login.presentation.models.LoginModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import lombok.SneakyThrows;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private final RequestAuthUseCase requestAuthUseCase;
    private final MutableLiveData<Result<LoginModel>> state = new MutableLiveData<>();

    public LiveData<Result<LoginModel>> getState() {
        return state;
    }

    @Inject
    public LoginViewModel(RequestAuthUseCase requestAuthUseCase) {
        this.requestAuthUseCase = requestAuthUseCase;
    }

    public void requestAuth(String username, String password) {
        Log.d("DRG", "request ..." + username + " :: " + password);
        requestAuthUseCase.setRxScheduler(new SingleRxUseCase.RxScheduler() {
            @Override
            public Scheduler subscribeOnScheduler() {
                return Schedulers.io();
            }

            @Override
            public Scheduler observeOnScheduler() {
                return AndroidSchedulers.mainThread();
            }
        });
        requestAuthUseCase.execute(new AuthFormEntity(username, password), new DisposableSingleObserver<Result<AuthEntity>>() {
            @SneakyThrows
            @Override
            public void onSuccess(Result<AuthEntity> authEntityResult) {
                state.postValue(authEntityResult.map(AuthPresenterMappers::mapToModel));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("DRG","onError : " + e.getMessage());
            }
        });
    }
}
