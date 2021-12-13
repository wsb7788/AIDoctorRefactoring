package com.project.aidoctor.ui.splash





import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.login.LoginListener
import com.project.aidoctor.data.remote.splash.SplashListener
import com.project.aidoctor.data.repository.login.LoginRepository
import com.project.aidoctor.util.Coroutines
import com.project.aidoctor.util.SharedPreferencesManager
import java.util.regex.Pattern

class SplashViewModel(private val repository: LoginRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var splashListener: SplashListener? = null


    fun isLogin() {
        if(sharedPreferencesManager.getId()==9999){
            splashListener!!.onStartLogin()
            return
        }
        Coroutines.main {

            try {
                val email = sharedPreferencesManager.getEmail()
                val pw = sharedPreferencesManager.getPw()

                val loginResponse = repository.login(User(userName = email, password = pw))

                if(loginResponse.isSuccess){
                    setToken()
                    sharedPreferencesManager.saveId(loginResponse.user.USER_ID)
                    if(loginResponse.user.USER_ISADMIN == 1){
                        splashListener!!.onStartAdmin()
                    }else
                        splashListener!!.onStartMain()
                    return@main
                }
                splashListener!!.onFailure(loginResponse.message)

            }catch (e:Exception){
                splashListener!!.onFailure(e.message!!)
            }
        }
    }
    private fun setToken() {

        Coroutines.main {

            try {
                val Id = sharedPreferencesManager.getId()
                val token = sharedPreferencesManager.getToken()

                val loginResponse = repository.setToken(Id,token)

                if(loginResponse.isSuccess){
                    return@main
                }
                splashListener!!.onFailure(loginResponse.message)

            }catch (e:Exception){
                splashListener!!.onFailure(e.message!!)
            }
        }
    }
}