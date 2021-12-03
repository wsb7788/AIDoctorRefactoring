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


}