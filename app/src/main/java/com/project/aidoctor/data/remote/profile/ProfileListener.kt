package com.project.aidoctor.data.remote.profile

import android.text.SpannableStringBuilder

interface ProfileListener {
    abstract fun onFailure(message: String)
    fun onSuccess()

}