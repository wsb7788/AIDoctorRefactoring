package com.project.aidoctor.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.profile.ProfileListener
import com.project.aidoctor.databinding.ActivityProfileBinding
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.splash.SplashActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity: BaseActivity(),ProfileListener {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModel()


    private lateinit var view: DialogLogoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.profileListener = this

        binding.btnLogout.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v){
            binding.btnLogout -> logoutDialog()
        }
    }

    private fun logoutDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        view = DialogLogoutBinding.inflate(layoutInflater)
        dialogBuilder.setView(view.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
        }
        view.btnOk.setOnClickListener {
            viewModel.logout()
        }

    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onSuccess() {
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
    }


}