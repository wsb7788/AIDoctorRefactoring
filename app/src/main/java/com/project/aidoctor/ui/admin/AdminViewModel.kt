package com.project.aidoctor.ui.admin





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.admin.AdminListener
import com.project.aidoctor.data.repository.admin.AdminRepository
import com.project.aidoctor.util.Coroutines

class AdminViewModel(private val repository: AdminRepository): ViewModel(){

    var adminListener:AdminListener? = null


    fun emListLoad() {
        Coroutines.main {


            try {
                val response= repository.emList()

                if(response.isSuccess){

                    adminListener!!.onSuccess(response.results.results)

                    return@main
                }
                adminListener!!.onFailure(response.message)

            }catch (e:Exception){
                adminListener!!.onFailure(e.message!!)

            }
        }
    }


}