package com.example.tryjackpackcompose.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.tryjackpackcompose.models.dialog.DialogModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel() {
    val disposeBag = CompositeDisposable()

    open fun onActivityStart(){}
    open fun onActivityDestroy(){
        disposeBag.dispose()
    }
}