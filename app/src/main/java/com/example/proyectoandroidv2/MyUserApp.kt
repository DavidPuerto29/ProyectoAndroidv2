package com.example.proyectoandroidv2

import android.app.Application
import com.example.proyectoandroidv2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyUserApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyUserApp)
            modules(appModule)
        }
    }
}