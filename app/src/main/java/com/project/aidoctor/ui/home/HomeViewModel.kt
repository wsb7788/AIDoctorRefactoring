package com.project.aidoctor.ui.home





import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.data.repository.home.HomeRepository
import com.project.aidoctor.util.Coroutines
import java.lang.Exception

class HomeViewModel(private val repository: HomeRepository): ViewModel(){
    var homeListener: HomeListener? = null

    fun loadDisease() {

        Coroutines.main {

            try {
                val response = repository.disease()

                if(response.isSuccess){
                    homeListener!!.onDiseaseLoad(response.results)
                    return@main
                }
                homeListener!!.onFailure(response.message)
            }catch(e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }

    fun loadCovid() {

        Coroutines.main {

            try {
                val response = repository.covid()

                if(response.isSuccess){
                    homeListener!!.onCovidLoad(response.results)
                    return@main
                }
                homeListener!!.onFailure(response.message)
            }catch(e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }
}
