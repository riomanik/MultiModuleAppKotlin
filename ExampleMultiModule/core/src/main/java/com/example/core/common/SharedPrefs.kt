package com.example.core.common

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs(context: Context, private val cryptoHelper: CryptoHelper) {
    private val sharedPreferences: SharedPreferences

    fun accessTokenIsNotEmpty(): Boolean {
        return get(PREF_SESSION_ACCESS_TOKEN, String::class.java).isNotEmpty()
    }

    var accessToken: String
        set(value) = put(
            PREF_SESSION_ACCESS_TOKEN,
            cryptoHelper.encrypt(PREF_SESSION_ACCESS_TOKEN, value)
        )
        get() = cryptoHelper.decrypt(
            PREF_SESSION_ACCESS_TOKEN,
            get(PREF_SESSION_ACCESS_TOKEN, String::class.java)
        )

    var expiredAt: String
        set(value) = put(PREF_SESSION_EXPIRED_AT, value)
        get() = get(PREF_SESSION_EXPIRED_AT, String::class.java)

    var userId: String
        set(value) = put(USER_ID, value)
        get() = get(USER_ID, String::class.java)

    var appHasBeenOpenedBefore: Boolean
        set(value) = put(PREF_APP_HAS_BEEN_OPENED_BEFORE, value)
        get() = get(PREF_APP_HAS_BEEN_OPENED_BEFORE, Boolean::class.java)

    init {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        cryptoHelper.registerKey(PREF_SESSION_ACCESS_TOKEN)
    }

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    private fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> sharedPreferences.getString(key, "USER ID NYA 20")
            Boolean::class.java -> sharedPreferences.getBoolean(key, false)
            Float::class.java -> sharedPreferences.getFloat(key, -1f)
            Double::class.java -> sharedPreferences.getFloat(key, -1f)
            Int::class.java -> sharedPreferences.getInt(key, -1)
            Long::class.java -> sharedPreferences.getLong(key, -1L)
            else -> null
        } as T

    private fun <T> put(key: String, data: T) {
        val editor = sharedPreferences.edit()
        when (data) {
            is String -> editor.putString(key, data)
            is Boolean -> editor.putBoolean(key, data)
            is Float -> editor.putFloat(key, data)
            is Double -> editor.putFloat(key, data.toFloat())
            is Int -> editor.putInt(key, data)
            is Long -> editor.putLong(key, data)
        }
        editor.apply()
    }

    fun clear() {
        sharedPreferences.edit().run {
            remove(PREF_SESSION_ACCESS_TOKEN)
            remove(PREF_SESSION_EXPIRED_AT)
            remove(PREF_APP_HAS_BEEN_OPENED_BEFORE)
        }.apply()
    }

    companion object {
        const val PREFS_NAME = "DriverSharedPreferences"
        private const val PREFIX = "driver_"
        private const val PREF_SESSION_ACCESS_TOKEN = PREFIX + "access_token2"
        private const val PREF_SESSION_EXPIRED_AT = PREFIX + "expired_at2"
        private const val PREF_APP_HAS_BEEN_OPENED_BEFORE = "app_has_been_opened_before"
        private const val USER_ID = "USER_ID"
    }
}
