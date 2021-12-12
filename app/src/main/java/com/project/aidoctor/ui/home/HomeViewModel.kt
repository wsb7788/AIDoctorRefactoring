package com.project.aidoctor.ui.home





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.data.repository.home.HomeRepository
import com.project.aidoctor.util.Coroutines
import java.lang.Exception

class HomeViewModel(private val repository: HomeRepository): ViewModel(){
    var homeListener: HomeListener? = null

    val disease: MutableLiveData<ArrayList<Disease>> by lazy {
        MutableLiveData<ArrayList<Disease>>().apply {
        }
    }

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

    fun loadHospital(xPos: Float?, yPos: Float?) {
        Coroutines.main {

            try {
                val response = repository.hospital(xPos!!,yPos!!,1)

                if(response.isSuccess){
                    homeListener!!.onHospitalLoad(response.results)
                    return@main
                }
                homeListener!!.onFailure(response.message)
            }catch(e:Exception){
                homeListener!!.onFailure(e.message!!)
            }
        }
    }

    fun getDiseaseItem(name: String): Disease {
        for(i in 0 until disease.value!!.size){
            if(disease.value!![i].DIS_NAME == name)
                return disease.value!![i]
        }
        return Disease(1,"","","","","","","")
    }
}
