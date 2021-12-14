package com.project.aidoctor.data.remote.notification

import android.text.SpannableStringBuilder

interface NotificationListener {
    abstract fun onFailure(message: String)
    abstract fun onSuccess(results: ArrayList<NotiList>)

}