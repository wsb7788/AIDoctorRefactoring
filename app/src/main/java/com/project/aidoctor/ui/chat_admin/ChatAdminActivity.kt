package com.project.aidoctor.ui.chat_admin

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.admin.EmUser
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.chat.ChatSendResults
import com.project.aidoctor.data.remote.chat.ChatStartResults
import com.project.aidoctor.data.remote.chat_admin.ChatAdminListener
import com.project.aidoctor.databinding.ActivityAdminChatBinding
import com.project.aidoctor.databinding.ActivityChatBinding
import com.project.aidoctor.databinding.DialogEmergencyBinding
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.chat.ChatRecyclerAdapter
import com.project.aidoctor.util.hideKeyboard
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatAdminActivity : BaseActivity(), ChatAdminListener {

    private lateinit var binding: ActivityAdminChatBinding
    private val viewModel: ChatAdminViewModel by viewModel()


    lateinit var chatAdminRecyclerAdapter: ChatAdminRecyclerAdapter
    lateinit var item:EmUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin_chat)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.chatAdminListener = this



        recyclerInit()

        loadIntent()


        binding.btnSend.setOnClickListener(this)
    }

    private fun loadIntent() {
        item = intent.getSerializableExtra("item") as EmUser
        binding.tvTitle.text = item.USER_USERID
        viewModel.userId.value = item.USER_ID
    }

    private fun recyclerInit() {
        chatAdminRecyclerAdapter = ChatAdminRecyclerAdapter()

        binding.rcvChat.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = chatAdminRecyclerAdapter
        }

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSend -> sendMessage()
        }
    }

    private fun sendMessage() {
        binding.root.hideKeyboard()
        viewModel.send(item.USER_ID)
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }


    override fun clearText() {
        binding.etMessage.text = null
    }

    override fun addChat(message: String) {
        val model = ArrayList<ChatAdminModel>()
        model.add(ChatAdminModel(message))
        chatAdminRecyclerAdapter.submitList(model)
        chatAdminRecyclerAdapter.notifyDataSetChanged()
        binding.rcvChat.scrollToPosition(chatAdminRecyclerAdapter.itemCount-1)
    }


}