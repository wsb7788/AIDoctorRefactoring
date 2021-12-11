package com.project.aidoctor.di

import com.project.aidoctor.data.repository.chat.ChatRepository
import com.project.aidoctor.data.repository.home.HomeRepository
import com.project.aidoctor.data.repository.login.LoginRepository
import com.project.aidoctor.data.repository.profile.ProfileRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { LoginRepository(get()) }
    single { HomeRepository(get()) }
    single { ChatRepository(get()) }
    single { ProfileRepository(get()) }

}