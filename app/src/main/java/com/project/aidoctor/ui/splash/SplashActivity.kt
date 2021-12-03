package com.project.aidoctor.ui.splash

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.login.LoginListener
import com.project.aidoctor.data.remote.splash.SplashListener
import com.project.aidoctor.databinding.ActivityLoginBinding
import com.project.aidoctor.databinding.ActivitySplashBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.main.MainActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : BaseActivity(),SplashListener {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.splashListener = this



    }

}