package com.project.aidoctor.ui.notification





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.notification.NotificationListener
import com.project.aidoctor.data.repository.notification.NotificationRepository
import com.project.aidoctor.util.Coroutines
import com.project.aidoctor.util.SharedPreferencesManager

class NotificationViewModel(private val repository: NotificationRepository,private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var notificationListener: NotificationListener? = null


    fun loadNotification() {


        Coroutines.main {

            try {
                val id = sharedPreferencesManager.getId()
                val response = repository.trace(id)

                if (response.isSuccess){
                    notificationListener!!.onSuccess(response.results.results)
                    return@main
                }
                notificationListener!!.onFailure(response.message)
            }catch (e:Exception){

                notificationListener!!.onFailure(e.message!!)
            }
        }
    }
}