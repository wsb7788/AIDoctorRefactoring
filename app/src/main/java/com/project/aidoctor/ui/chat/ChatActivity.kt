package com.project.aidoctor.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityChatBinding
import com.project.aidoctor.databinding.ActivityMainBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.HomeFragment
import com.project.aidoctor.ui.profile.ProfileFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity() {

    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


    }



}