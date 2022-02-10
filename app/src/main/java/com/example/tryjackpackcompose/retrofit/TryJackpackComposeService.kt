package com.example.tryjackpackcompose.retrofit

import com.example.tryjackpackcompose.BuildConfig
import com.example.tryjackpackcompose.application_preferences.AccountPreferences
import com.example.tryjackpackcompose.entity.UserToken
import com.example.tryjackpackcompose.extension.retryWhenNotForbidden
import com.example.tryjackpackcompose.extension.runInBackground
import com.example.tryjackpackcompose.retrofit.api_model.TryJackpackComposeServiceModel
import com.example.tryjackpackcompose.retrofit.interceptor.LoggingInterceptor
import com.example.tryjackpackcompose.retrofit.interceptor.NetInterceptor
import com.example.tryjackpackcompose.retrofit.response.project.ProjectDetailResponse
import com.example.tryjackpackcompose.retrofit.response.project.ProjectSummaryResponse
import com.example.tryjackpackcompose.utils.JSONBuilder
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Proxy
import java.util.*
import java.util.concurrent.TimeUnit

class TryJackpackComposeService {
    companion object {
        const val TAG = "TryJackpackComposeService"

        private const val TIMEOUT_CONNECTION = 120L
        private const val TIMEOUT_READ = 120L

        var currentBaseUrl: String = ""

        private var mInstance: TryJackpackComposeService? = null

        val instance: TryJackpackComposeService
            get() {
                return mInstance ?: TryJackpackComposeService()
            }

        private val mDomainUrl: String
            get() {
//                return BuildConfig.APP_ENTRANCE_URL.split(";").first()
//                return "https://sit-xtrack.infotronic-tech.com/"
                return "https://dev-xtrack.infotronic-tech.com/"
            }

        private val gson = Gson()
    }

    private lateinit var client: OkHttpClient

    private lateinit var mServiceModel: TryJackpackComposeServiceModel

    init {
        mInstance = this

        client = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .addInterceptor(NetInterceptor())
            .addInterceptor(LoggingInterceptor())
            .build()

//        noHeaderClient = OkHttpClient.Builder()
//            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
//            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
//            .addInterceptor(LoggingInterceptor())
//            .build()

        setBaseUrl(mDomainUrl)
    }

    @Synchronized
    fun setBaseUrl(base: String) {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mServiceModel = retrofit.create(TryJackpackComposeServiceModel::class.java)

//        val retrofit2 = Retrofit.Builder()
//            .client(noHeaderClient)
//            .baseUrl(base)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()

//        mNoHeaderServiceModel = retrofit2.create(TurkeyNoHeaderServiceModel::class.java)

        currentBaseUrl = base
    }

    object AUTH {

        fun login(acc: String, password: String): Observable<UserToken> {
            val map = mapOf("grant_type" to "password", "scope" to "api", "username" to acc, "password" to password)
            return instance.mServiceModel.getUserInfo(map).runInBackground().doOnNext {
                AccountPreferences.token = it.accessToken
            }
        }

//        fun logout(userId: String): Observable<Response<Any>> {
//            return instance.mServiceModel.logout(userId).runInBackground()
//        }
    }

    object PROJECT {
        fun getProjectBriefDelta(lastUpdateTime: String = "2000-01-01T00:00:00.000+08:00"): Observable<ProjectSummaryResponse> {
            val body = JSONBuilder().append("lastUpdateDatetime", lastUpdateTime).buildRequestBody()
            return instance.mServiceModel.getProjectBriefDelta(body).runInBackground()
        }

        fun getFullProjectData(projectId: String, lastUpdateTime: String = "2000-01-01T00:00:00.000+08:00"): Observable<ProjectDetailResponse> {
            val body = JSONBuilder().append("lastUpdateDatetime", lastUpdateTime)
                .append("projectId", projectId).buildRequestBody()
            return instance.mServiceModel.getFullProjectData(body).runInBackground().retryWhenNotForbidden()
        }
    }


}