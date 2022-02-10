package com.example.tryjackpackcompose.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection

/**
 *   Useful Extensions for RxJava
 **/

/**
 * An extension for the clumsy background & main thread
 */
fun <T> Observable<T>.runInBackground(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .onTerminateDetach()
}

fun <T> Observable<T>.onMainThread(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
}

//fun <T> Observable<T>.runInBackground(): Observable<T> {
//    return this.logoutIfExpired().runInBackground()
//}

fun <T> Observable<T>.logoutIfExpired(): Observable<T> {
    return this.doOnError { t ->
        if (t.isForbidden()) {
//            TurkeyApplication.LOGOUT_SUBJECT.onNext(true)
        }
    }
}

fun <T> Observable<T>.retryWhenNotForbidden(times: Long = 3): Observable<T> {
    return this.retry(times) { t ->
        !t.isForbidden()
    }
}

private fun Throwable.isForbidden(): Boolean {
    return this is HttpException && this.code() == HttpURLConnection.HTTP_FORBIDDEN
}