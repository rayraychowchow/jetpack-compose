package com.example.tryjackpackcompose.application_preferences

import android.content.Context
import android.content.SharedPreferences

class AccountPreferences private constructor(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
    private lateinit var mContext: Context

    private var _userId: Int
        get() = preferences.getInt(USER_ID_KEY, -1)
        set(it) {
            val editor = preferences.edit()
            editor.putInt(USER_ID_KEY, it)
            editor.apply()
        }

    private var _token: String?
        get() = preferences.getString(TOKEN_KEY, null)
        set(it) {
            val editor = preferences.edit()
            editor.putString(TOKEN_KEY, it)
            editor.apply()
        }

    init {
        fetchPreferenceData()
    }

    private fun fetchPreferenceData() {
        userId = if (_userId == -1) {
            null
        } else {
            _userId
        }
        token = _token
    }

    private fun clearPreferenceData() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

    // can write a fun to handle given objects and save to preference
    fun functionForSavingFromResponse() {

    }

    companion object {
        const val PREFERENCES_FILE = "account"

        // KEY
        private const val USER_ID_KEY = "userId"
        private const val TOKEN_KEY = "token"

        var userId: Int? = null
        var token: String? = null

        var applicationTargetVersion: String = ""
        var isNewAppAvailable = false
        var isAppForceUpdate = false
        var applicationChangeLog: String = ""
        var APP_DOWNLOAD_LINK: String = ""

        var projectIds: List<String> = listOf()

        private var instance: AccountPreferences? = null

        fun initialize(context: Context) {
            getInstance(context)
        }

        fun getInstance(context: Context): AccountPreferences {
            if (instance == null) {
                instance = AccountPreferences(context)
            }

            return instance as AccountPreferences
        }

//        fun setIsUpdateAvailable(target: String) {
//            isNewAppAvailable = AppUpdateUtil.isNeedUpdate(target)
//        }

        fun setAppChangeLog(changeLog: Array<String>) {
            var output = ""
            changeLog.forEach { output = output+it+"\n" }
            applicationChangeLog = output
        }

        // can define response values here for saving info
    }

//    fun storeSessionResponse(response: Session) {
//        userId = response.userId
//        _userId = response.userId
//        token = response.token
//        _token = response.token
//
//    }

    /**
     *  Clear when logout or token expire
     */
    fun clear() {
        userId = null
        token = null

        clearPreferenceData()
    }
}