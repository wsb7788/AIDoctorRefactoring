package com.project.aidoctor.ui.admin

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityAdminBinding

import com.project.aidoctor.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class AdminActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminBinding
    private val viewModel: AdminViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


    }
}