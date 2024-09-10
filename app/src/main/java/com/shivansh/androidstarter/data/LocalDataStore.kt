package com.shivansh.androidstarter.data

import android.content.Context
import android.content.SharedPreferences
import com.shivansh.androidstarter.MyApplication.Companion.appContext

class LocalDataStore private constructor() {

    private lateinit var pref: SharedPreferences

    fun getString(key: String, default: String?): String? {
        return pref.getString(key, default)
    }

    fun setString(key: String, value: String?) {
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getLong(key: String, default: Long?): Long? {
        if (pref.contains(key)) {
            return pref.getLong(key, 0)
        }
        return default
    }

    fun setLong(key: String, value: Long?) {
        if (value == null) {
            remove(key)
            return
        }
        val editor = pref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun getInteger(key: String, default: Int?): Int? {
        if (pref.contains(key)) {
            return pref.getInt(key, 0)
        }
        return default
    }

    fun setInteger(key: String, value: Int?) {
        if (value == null) {
            remove(key)
            return
        }
        val editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getFloat(key: String, default: Float?): Float? {
        if (pref.contains(key)) {
            return pref.getFloat(key, 0f)
        }
        return default
    }

    fun setFloat(key: String, value: Float?) {
        if (value == null) {
            remove(key)
            return
        }
        val editor = pref.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getBoolean(key: String, default: Boolean?): Boolean? {
        if (pref.contains(key)) {
            return pref.getBoolean(key, false)
        }
        return default
    }

    fun setBoolean(key: String, value: Boolean?) {
        if (value == null) {
            remove(key)
            return
        }
        val editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun remove(key: String) {
        val editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }

    fun clear() {
        pref.edit().clear().apply()
    }

    companion object {
        private var _instance: LocalDataStore? = null
        val instance: LocalDataStore
            get() {
                initialize()
                return _instance!!
            }
        private fun initialize() {
            _instance = synchronized(this) {
                if (_instance != null) return
                LocalDataStore().apply {
                    pref = appContext.getSharedPreferences(
                        Config.SP_NAME,
                        Config.ACCESS_MODE
                    )
                }
            }
        }
    }

    private object Config {
        val SP_NAME = appContext.packageName.toString()
        const val ACCESS_MODE = Context.MODE_PRIVATE
    }
}