package com.project.aidoctor.ui.hospital

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityChatBinding
import com.project.aidoctor.databinding.ActivityHospitalBinding
import com.project.aidoctor.databinding.ActivityMainBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.HomeFragment
import com.project.aidoctor.ui.home.HospitalModel
import com.project.aidoctor.ui.profile.ProfileFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HospitalActivity : BaseActivity() {

    private lateinit var binding: ActivityHospitalBinding
    private val viewModel: HospitalViewModel by viewModel()

    lateinit var item:HospitalModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hospital)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        item = intent.getSerializableExtra("item") as HospitalModel

        setContent()
    }

    private fun setContent() {
        binding.tvName.text = item.name
        binding.tvCall.text = item.call
        binding.tvLocation.text = item.location
        if(item.url.isNullOrEmpty())
            binding.tvUrl.text = "정보없음"
        else
            binding.tvUrl.text = item.url

    }

    override fun onClick(v: View?) {
        when(v){

        }
    }


}