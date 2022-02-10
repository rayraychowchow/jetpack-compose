package com.example.tryjackpackcompose.ui.launch

import com.example.tryjackpackcompose.base.BaseViewModel
import com.example.tryjackpackcompose.extension.disposedBy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class LaunchViewModel: BaseViewModel() {
    val onInitialTimerEnd = PublishSubject.create<Unit>()

    override fun onActivityStart() {
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                this.onInitialTimerEnd.onNext(Unit)
            }.subscribe().disposedBy(disposeBag)
    }
}