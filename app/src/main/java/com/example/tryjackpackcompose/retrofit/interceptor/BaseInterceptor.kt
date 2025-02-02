package com.example.tryjackpackcompose.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

open class BaseInterceptor: Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}