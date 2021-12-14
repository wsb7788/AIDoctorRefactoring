package com.project.aidoctor.ui.chat_admin





import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.chat_admin.ChatAdminListener
import com.project.aidoctor.data.repository.chat.ChatRepository
import com.project.aidoctor.data.repository.chat_admin.ChatAdminRepository
import com.project.aidoctor.util.Coroutines
import com.project.aidoctor.util.SharedPreferencesManager

class ChatAdminViewModel(private val repository: ChatAdminRepository): ViewModel(){

    val message: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val userId: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            postValue(9999)
        }
    }
    var chatAdminListener:ChatAdminListener? = null



    fun send(id:Int, text:String="") {
            Coroutines.main {
            val e:String = if(text.isNullOrEmpty()){
                message.value.toString()
            }else
                text

            try {
                chatAdminListener!!.clearText()
                chatAdminListener!!.addChat(e)
                val response = repository.sendFCM(id,e)

                if(response.isSuccess){

                    chatAdminListener!!.onFailure("보내기 성공")


                    return@main
                }
                chatAdminListener!!.onFailure(response.message)

            }catch (e:Exception){
                chatAdminListener!!.onFailure(e.message!!)
            }
        }
    }

}