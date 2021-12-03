package com.project.aidoctor.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.login.LoginListener
import com.project.aidoctor.databinding.ActivityLoginBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.main.MainActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : BaseActivity(), LoginListener {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loginListener = this

        idObserve()
        pwShowObserve()
        binding.ivPassword.setOnClickListener(this)
        binding.ivEmail.setOnClickListener(this)
        binding.button.setOnClickListener(this)

    }

    private fun idObserve() {
        viewModel.email.observe(this,{
            if(viewModel.email.value.isNullOrEmpty()){
                binding.ivEmail.setImageResource(R.drawable.ic_email_delete_off)
                binding.clEmail.setBackgroundResource(R.drawable.login_border)
                return@observe
            }
            binding.ivEmail.setImageResource(R.drawable.ic_email_delete_on)
            binding.clEmail.setBackgroundResource(R.drawable.login_border_active)
        })
    }

    private fun pwShowObserve() {
        viewModel.showPw.observe(this, {
            if(viewModel.showPw.value!!){
                binding.ivPassword.setImageResource(R.drawable.ic_password_see_on)
                binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                return@observe
            }
            binding.ivPassword.setImageResource(R.drawable.ic_password_see_off)
            binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT

        })
        viewModel.pw.observe(this,{
            if(viewModel.pw.value.isNullOrEmpty()){
                binding.clPassword.setBackgroundResource(R.drawable.login_border)
                return@observe
            }
            binding.clPassword.setBackgroundResource(R.drawable.login_border_active)
        })

    }

    override fun onClick(v: View?) {
        when(v){
            binding.ivPassword-> viewModel.showPw()
            binding.ivEmail -> viewModel.emailBlankCheck()
            binding.button -> startMain()

        }
    }

    private fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun clearEmail(editable: SpannableStringBuilder) {
        binding.etEmail.text = editable
    }

    override fun onCheckUserFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onLoginFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onLoginSuccess() {

    }

    override fun onStartMain() {
   /*     val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()*/
    }
    override fun onStartTutorial() {
        /*val intent = Intent(this, TutorialActivity::class.java)
        startActivity(intent)
        finish()*/
    }
}