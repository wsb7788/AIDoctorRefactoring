package com.project.aidoctor.data.repository.login

import com.project.aidoctor.data.entities.User

import com.project.aidoctor.data.login.LoginResponse
import com.project.aidoctor.data.login.LoginService
import com.project.aidoctor.data.repository.BaseRepository

class LoginRepository(private val loginService: LoginService) : BaseRepository() {
    suspend fun login(user: User): LoginResponse {
        return apiRequest { loginService.login(user) }
    }
}
