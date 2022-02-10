package com.example.tryjackpackcompose.retrofit.interceptor

import com.example.tryjackpackcompose.application_preferences.AccountPreferences
import okhttp3.*
import java.io.IOException

class NetInterceptor: BaseInterceptor() {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestOld = chain.request()
        val builder = requestOld.newBuilder()

        // append parameter v to every get request, prevent caching
//        val url = preventCacheForGet(requestOld)
        val url = requestOld.url()

        setHeader(builder, url.toString())

        // build a new request
        val requestNew = builder
            .url(url)
            .build()

        return chain.proceed(requestNew)
    }

    private fun setHeader(builder: Request.Builder, url: String?) {
        // add header for every request
        AccountPreferences.token?.let {
            builder.header("Authorization", "bearer $it")
        }
    }

    fun preventCacheForGet(request: Request): HttpUrl {
        if (request.method().equals("GET", true)) {
            return request.url()
        }

        return request.url()
    }
}