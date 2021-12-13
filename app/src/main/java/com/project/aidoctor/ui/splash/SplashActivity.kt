package com.project.aidoctor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.login.LoginListener
import com.project.aidoctor.data.remote.splash.SplashListener
import com.project.aidoctor.databinding.ActivityLoginBinding
import com.project.aidoctor.databinding.ActivitySplashBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.admin.AdminActivity
import com.project.aidoctor.ui.login.LoginActivity
import com.project.aidoctor.ui.main.MainActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : BaseActivity(),SplashListener {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModel()

    lateinit var intentt:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.splashListener = this

        viewModel.isLogin()


    }



    override fun onStartLogin() {
        intentt = Intent(applicationContext, LoginActivity::class.java)
        activityStart()
    }


    private fun activityStart() {
        val anim_in = AnimationUtils.loadAnimation(this,R.anim.splash_out)
        anim_in.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
            }
            override fun onAnimationEnd(animation: Animation?) {
                binding.iv1.visibility = View.INVISIBLE
                binding.iv2.visibility = View.INVISIBLE
                startActivity(intentt)
                overridePendingTransition(android.R.anim.fade_in,R.anim.splash_in)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
        binding.iv1.startAnimation(anim_in)
        binding.iv2.startAnimation(anim_in)
    }

    override fun onStartAdmin() {
        intentt = Intent(applicationContext, AdminActivity::class.java)
        activityStart()
    }

    override fun onStartMain() {
        intentt = Intent(applicationContext, MainActivity::class.java)
        activityStart()
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
        onStartLogin()
    }

}