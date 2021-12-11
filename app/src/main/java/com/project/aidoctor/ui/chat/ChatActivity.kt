package com.project.aidoctor.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationBarView
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.chat.ChatStartResults
import com.project.aidoctor.databinding.ActivityChatBinding
import com.project.aidoctor.databinding.ActivityMainBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.HomeFragment
import com.project.aidoctor.ui.profile.ProfileFragment
import com.project.aidoctor.util.hideKeyboard
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity(), ChatListener {

    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModel()


    lateinit var chatRecyclerAdapter: ChatRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.chatListener = this

        recyclerInit()
        viewModel.start()


        binding.btnSend.setOnClickListener(this)
        binding.btnEmergency.setOnClickListener(this)
    }

    private fun recyclerInit() {
        chatRecyclerAdapter = ChatRecyclerAdapter()

        binding.rcvChat.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = chatRecyclerAdapter
        }

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSend -> sendMessage()
            binding.btnEmergency -> {}
        }
    }

    private fun sendMessage() {
        binding.root.hideKeyboard()
        viewModel.send()
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onStartSuccess(results: ChatStartResults) {
        val model = ArrayList<ChatModel>()

        model.add(ChatModel(thumbnail = results.thumbnail))
        model.add(ChatModel(text = results.title, listItem = results.listItem))

        chatRecyclerAdapter.submitList(model)
        chatRecyclerAdapter.notifyDataSetChanged()

    }

    override fun clearText() {
        binding.tvTitle.text = ""
    }


}