package com.example.tryjackpackcompose.ui.main

import android.accounts.Account
import androidx.databinding.ObservableField
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.tryjackpackcompose.application_preferences.AccountPreferences
import com.example.tryjackpackcompose.base.BaseViewModel
import com.example.tryjackpackcompose.entity.UserToken
import com.example.tryjackpackcompose.enums.LoginPageLiveDataType
import com.example.tryjackpackcompose.extension.disposedBy
import com.example.tryjackpackcompose.models.dialog.DialogModel
import com.example.tryjackpackcompose.retrofit.TryJackpackComposeService
import com.example.tryjackpackcompose.ui.inspection.InspectionActivity
import com.example.tryjackpackcompose.utils.safeLet
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class MainViewModel: BaseViewModel() {
    private var ldLoginEmail = MutableLiveData("")
    private var ldLoginPassword = MutableLiveData("")
    private var ldWrongPasswordTitle = MutableLiveData("")

    private var ldShowError = MutableLiveData(false)
    private var ldIsSubmittable = MediatorLiveData<Boolean>()

    var ldRememberLoginEmail = MutableLiveData(false)
    var ldRememberLoginEmailTitle = MutableLiveData("REMEMBER ME")

    val onForgetPasswordPressed = PublishSubject.create<Unit>()

    val ldOnShowSignUpAccountDialog = MutableLiveData<DialogModel>()

    val onProjectLoaded = PublishSubject.create<Any>()

    init {
        ldIsSubmittable.addSource(ldLoginEmail) { ldIsSubmittable.value = validateLoginInfo() }
        // should get from shared preference for ldRememberLoginEmail
    }

    fun getStringLiveData(type: LoginPageLiveDataType): MutableLiveData<String> {
        return when (type) {
            LoginPageLiveDataType.LOGIN_EMAIL -> ldLoginEmail
            LoginPageLiveDataType.LOGIN_PASSWORD -> ldLoginPassword
            LoginPageLiveDataType.WRONG_PASSWORD -> ldWrongPasswordTitle
        }
    }

    fun getLdShowError(): MutableLiveData<Boolean> {
        return ldShowError
    }

    private fun validateLoginInfo(): Boolean {
        return safeLet(ldLoginEmail.value, ldLoginPassword.value) { loginEmail, loginPassword ->
            loginEmail.isNotEmpty() && loginPassword.isNotEmpty()
        } ?: false
    }

    fun onLoginClicked() {
//        ldShowError.value = true
//        ldWrongPasswordTitle.value = "Wrong Password!"
        login().doOnNext {
            ldShowError.value = true
            ldWrongPasswordTitle.value = it.accessToken
        }.subscribe({
            print("ascsacsacsa")
        }, {

        }).disposedBy(disposeBag)
    }

    private fun login(): Observable<UserToken> {
        return safeLet(ldLoginEmail.value, ldLoginPassword.value) { acc, pw ->
            if (acc.isNotEmpty() && pw.isNotEmpty()) {
                TryJackpackComposeService.AUTH.login(acc, pw)
                    .doOnError {
                        it.message?.let { message ->
//                        if (message.contains("密码错误")) {
//                            ldShowError.value = true
//                        }
                            ldShowError.value = true
                            ldWrongPasswordTitle.value = message
                        }
                    }
            } else {
                Observable.empty()
            }
        } ?: Observable.empty()
    }

    fun onForgotPasswordClicked() {
//        onForgetPasswordPressed.onNext(Unit)
        TryJackpackComposeService.PROJECT.getProjectBriefDelta().doOnError {
            AccountPreferences.token = null
            ldShowError.value = true
            ldWrongPasswordTitle.value = it.message ?: ""
        }.doOnNext { response ->
            AccountPreferences.projectIds = response.projects.map { it.id }
            onProjectLoaded.onNext(response)
        }.subscribe({},{}).disposedBy(disposeBag)
    }


    fun onSignUpAccountClicked() {
        ldOnShowSignUpAccountDialog.value = DialogModel(title = "Warning", message = "Sign up is not supported", confirmTitle = "Confirm", dismissTitle = "Cancel",
            onConfirmAction = { ldOnShowSignUpAccountDialog.value = null },
            onDismissAction = { ldOnShowSignUpAccountDialog.value = null })
    }


}

