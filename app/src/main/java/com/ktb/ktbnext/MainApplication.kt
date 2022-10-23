package com.ktb.ktbnext

import android.app.Application
import android.content.Context
import com.ktb.ktbnext.data.di.createAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    init { INSTANCE = this }

    companion object {
        lateinit var INSTANCE: MainApplication
            private set

        val applicationContext: Context get() { return INSTANCE.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MainApplication)
            modules(createAppModule())
        }
    }
}