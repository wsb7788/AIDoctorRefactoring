package com.project.aidoctor.data.repository.login

import com.project.aidoctor.data.entities.User

import com.project.aidoctor.data.remote.login.LoginResponse
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.remote.login.SetTokenResponse
import com.project.aidoctor.data.repository.BaseRepository

class LoginRepository(private val loginService: LoginService) : BaseRepository() {
    suspend fun login(user: User): LoginResponse {
        return apiRequest { loginService.login(user) }
    }
    suspend fun setToken(userId:Int, token:String,os:String): SetTokenResponse {
        return apiRequest { loginService.setToken(userId, token,os) }
    }
}
