package com.project.aidoctor.ui.chat





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.data.repository.chat.ChatRepository
import com.project.aidoctor.util.Coroutines

class ChatViewModel(private val repository: ChatRepository): ViewModel(){

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    var chatListener:ChatListener? = null



    fun send() {

        val message = message.value.toString()
        Coroutines.main {

            try {

                val response = repository.chatSend(message)

                if(response.isSuccess){
                    chatListener!!.clearText()

                    return@main
                }
                chatListener!!.onFailure(response.message)

            }catch (e:Exception){
                chatListener!!.onFailure(e.message!!)
            }
        }
    }

    fun start() {

        Coroutines.main {

            try {

                val response = repository.chatStart()

                if(response.isSuccess){
                    chatListener!!.onStartSuccess(response.results)
                    return@main
                }
                chatListener!!.onFailure(response.message)

            }catch (e:Exception){
                chatListener!!.onFailure(e.message!!)
            }
        }
    }
}