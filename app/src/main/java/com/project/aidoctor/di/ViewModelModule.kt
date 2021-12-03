package com.project.aidoctor.di

import com.project.aidoctor.ui.chat.ChatViewModel
import com.project.aidoctor.ui.home.HomeViewModel
import com.project.aidoctor.ui.login.LoginViewModel
import com.project.aidoctor.ui.main.MainViewModel
import com.project.aidoctor.ui.profile.ProfileViewModel
import com.project.aidoctor.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { LoginViewModel(get(), get()) }
    viewModel { MainViewModel() }
    viewModel { ChatViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { SplashViewModel(get(),get()) }
}