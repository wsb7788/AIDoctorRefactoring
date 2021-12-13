package com.project.aidoctor.ui.profile





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.profile.ProfileListener
import com.project.aidoctor.data.repository.profile.ProfileRepository
import com.project.aidoctor.util.Coroutines
import com.project.aidoctor.util.SharedPreferencesManager

class ProfileViewModel(private val repository: ProfileRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    var profileListener: ProfileListener? = null


    fun logout() {


        Coroutines.main {
            try {

                val Id = sharedPreferencesManager.getId()
                val response = repository.deleteToken(Id)

                if(response.isSuccess){
                    sharedPreferencesManager.removeAll()
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