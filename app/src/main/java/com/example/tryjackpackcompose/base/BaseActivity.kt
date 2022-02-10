package com.example.tryjackpackcompose.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.tryjackpackcompose.models.dialog.DialogModel
import com.example.tryjackpackcompose.ui.dialog.showBaseDialog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseActivity<T: BaseViewModel>: AppCompatActivity() {
    protected open val disposeBag = CompositeDisposable()

    /**
     * the method of creating viewModel
     */
    // hilt dependency injection
    protected abstract val viewModel: T


    /**
     * do the rx / listener operation here
     */
    protected open fun observeViewModel() {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeViewModel()
    }

    override fun onStart() {
        super.onStart()
        viewModel.onActivityStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeBag.dispose()
        viewModel.onActivityDestroy()
    }

    @Composable
    protected open fun showDialog(dialogModel: DialogModel) {
        showBaseDialog(dialogModel = dialogModel)
    }
}