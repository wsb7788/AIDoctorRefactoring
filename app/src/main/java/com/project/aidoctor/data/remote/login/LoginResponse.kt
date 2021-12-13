package com.project.aidoctor.data.remote.login

import com.project.aidoctor.data.entities.User


data class LoginResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val user:UserResponse)

data class UserResponse(
    val USER_ID:Int,
    val USER_USERID:String,
    val USER_ISADMIN:Int)




data class SetTokenResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String)
