package com.shivansh.androidstarter

import android.app.Application
import android.content.Context
import com.shivansh.androidstarter.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin {
            androidContext(appContext)
            modules(appModule)
        }
    }

    companion object {
        lateinit var appContext: Context
            private set
        val AppScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    }
}