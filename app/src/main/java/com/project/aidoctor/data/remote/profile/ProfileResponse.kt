package com.project.aidoctor.data.remote.profile




data class LogoutResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String)


data class DeleteTokenResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String)


