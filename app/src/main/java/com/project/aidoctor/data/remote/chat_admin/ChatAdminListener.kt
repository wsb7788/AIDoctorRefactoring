package com.project.aidoctor.data.remote.chat_admin

interface ChatAdminListener {
    abstract fun onFailure(message: String)
    fun clearText()
    fun addChat(message: String)


}