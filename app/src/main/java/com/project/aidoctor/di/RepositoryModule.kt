package com.project.aidoctor.di

import com.project.aidoctor.data.repository.login.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { LoginRepository(get()) }

}