package com.project.aidoctor.data.remote.chat

interface ChatListener {
    abstract fun onFailure(message: String)
    abstract fun onStartSuccess(results: ChatStartResults)
    fun clearText()
    fun addChat(message: String)
    abstract fun onSendSuccess(results: ArrayList<ChatSendResults>)
    abstract fun onEmergencySuccess(message: String)


}