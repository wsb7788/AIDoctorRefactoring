package com.project.aidoctor.ui.chat





import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.repository.chat.ChatRepository
import com.project.aidoctor.util.Coroutines
import com.project.aidoctor.util.SharedPreferencesManager

class ChatViewModel(private val repository: ChatRepository,private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    var chatListener:ChatListener? = null



    fun send(text:String="") {

        Coroutines.main {
            val e:String = if(text.isNullOrEmpty()){
                message.value.toString()
            }else
                text
            val cvsID = sharedPreferencesManager.getCvsID()
            try {
                chatListener!!.clearText()
                chatListener!!.addChat(e)
                val response = repository.chatSend(e,cvsID)

                if(response.isSuccess){

                    chatListener!!.onSendSuccess(response.results)

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
                    sharedPreferencesManager.saveCvsID(response.results.cvsID)
                    Log.e("scvID",sharedPreferencesManager.getCvsID())
                    return@main
                }
                chatListener!!.onFailure(response.message)

            }catch (e:Exception){
                chatListener!!.onFailure(e.message!!)
            }
        }
    }
}