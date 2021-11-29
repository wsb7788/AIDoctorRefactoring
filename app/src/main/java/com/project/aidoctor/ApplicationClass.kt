package com.project.aidoctor

import android.app.Application
import com.project.aidoctor.di.repositoryModule
import com.project.aidoctor.di.utilityModule
import com.project.aidoctor.di.viewModelModule
import com.project.faily.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    companion object {
        lateinit var instance: ApplicationClass
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            /*if (DEBUG) {
                androidLogger()
            } else {*/
            androidLogger()
//        }
            androidContext(this@ApplicationClass)
            modules(
                utilityModule,
                viewModelModule,
                networkModule,
                repositoryModule
            )
        }
    }
}