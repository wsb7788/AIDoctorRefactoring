package com.project.aidoctor.data.remote.splash

import android.text.SpannableStringBuilder

interface SplashListener {
    fun onStartLogin()
    fun onStartAdmin()
    fun onStartMain()
    abstract fun onFailure(message: String)

}