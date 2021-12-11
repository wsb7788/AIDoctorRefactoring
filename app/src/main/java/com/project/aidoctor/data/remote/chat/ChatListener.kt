package com.project.aidoctor.data.remote.chat

import android.text.SpannableStringBuilder
import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital

interface ChatListener {
    abstract fun onFailure(message: String)
    abstract fun onStartSuccess(results: ArrayList<ChatStartResults>)
    fun clearText()


}