package com.example.tryjackpackcompose

import android.app.Application
import android.content.Intent
import androidx.multidex.MultiDexApplication
import com.example.tryjackpackcompose.application_preferences.AccountPreferences
import com.example.tryjackpackcompose.ui.main.MainActivity
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class TryJackPackComposeApplication: MultiDexApplication() {
    companion object {
        var APP_VERSION: String = System.getenv("APP_VERSION") ?: "0.0.1"
        // true: forced logout, false: user logout
        val LOGOUT_SUBJECT = PublishSubject.create<Boolean>()

        var PUSHY_TOKEN: String = ""
    }

    override fun onCreate() {
        super.onCreate()

        AccountPreferences.initialize(applicationContext)

        val d = LOGOUT_SUBJECT.debounce(300, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { forced -> logout(forced) }

        // register pushy

//        if (!Pushy.isRegistered(this)) {
//            RegisterForPushNotificationsAsync(this).run()
//        } else {
//            PUSHY_TOKEN =
//                Pushy.getDeviceCredentials(this).token
//        }

        // Pushy
//        Pushy.listen(this)
    }

    /**
     * logout and show dialog if forced logout
     */
    @Synchronized
    private fun logout(forced: Boolean) {
        AccountPreferences.token?.let {
            AccountPreferences.getInstance(applicationContext).clear()
        }

        // go to login page
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.putExtra("logout", forced)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}