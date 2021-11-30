package com.project.aidoctor.di

import com.project.aidoctor.ui.chat.ChatViewModel
import com.project.aidoctor.ui.login.LoginViewModel
import com.project.aidoctor.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { LoginViewModel(get(), get()) }
    viewModel { MainViewModel() }
    viewModel { ChatViewModel() }
}