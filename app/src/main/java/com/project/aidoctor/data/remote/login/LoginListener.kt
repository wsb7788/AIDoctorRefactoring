package com.project.aidoctor.data.remote.login

import android.text.SpannableStringBuilder

interface LoginListener {
    fun clearEmail(editable: SpannableStringBuilder)
    fun onCheckUserFailure( message: String)
    fun onLoginFailure(message: String)
    fun onLoginSuccess()
    fun onStartMain()
}