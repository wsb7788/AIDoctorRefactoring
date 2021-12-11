package com.project.aidoctor.ui.profile





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.profile.ProfileListener
import com.project.aidoctor.data.repository.profile.ProfileRepository
import com.project.aidoctor.util.Coroutines

class ProfileViewModel(private val repository: ProfileRepository): ViewModel(){

    var profileListener: ProfileListener? = null


    fun logout() {


        Coroutines.main {
            try {

                val response = repository.logout()

                if(response.isSuccess){
                    profileListener!!.onSuccess()
                    return@main
                }
                profileListener!!.onFailure(response.message)
            }catch (e:Exception){
                profileListener!!.onFailure(e.message!!)
            }
        }
    }

}