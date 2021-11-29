package com.project.aidoctor.di

import com.project.aidoctor.util.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilityModule = module {
    single { SharedPreferencesManager(androidContext()) }
}