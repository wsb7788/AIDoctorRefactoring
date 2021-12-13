package com.project.aidoctor.ui.chat

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.chat.ChatListener
import com.project.aidoctor.data.remote.chat.ChatSendResults
import com.project.aidoctor.data.remote.chat.ChatStartResults
import com.project.aidoctor.databinding.ActivityChatBinding
import com.project.aidoctor.databinding.DialogEmergencyBinding
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.util.hideKeyboard
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity(), ChatListener {

    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModel()


    lateinit var chatRecyclerAdapter: ChatRecyclerAdapter
    private lateinit var view: DialogEmergencyBinding
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
        binding.btnReset.setOnClickListener(this)
    }

    private fun recyclerInit() {
        chatRecyclerAdapter = ChatRecyclerAdapter(viewModel)

        binding.rcvChat.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = chatRecyclerAdapter
        }

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSend -> sendMessage()
            binding.btnEmergency -> emergencyDialog()
            binding.btnReset -> viewModel.send("초기화")
        }
    }

    private fun emergencyDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        view = DialogEmergencyBinding.inflate(layoutInflater)
        dialogBuilder.setView(view.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
        }
        view.btnOk.setOnClickListener {
            viewModel.emergency()
            alertDialog.dismiss()
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
        binding.etMessage.text = null
    }

    override fun addChat(message: String) {
        val model = ArrayList<ChatModel>()
        model.add(ChatModel(isMe = true,text = message))
        chatRecyclerAdapter.submitList(model)
        chatRecyclerAdapter.notifyDataSetChanged()
        binding.rcvChat.scrollToPosition(chatRecyclerAdapter.itemCount-1)
    }

    override fun onSendSuccess(results: ArrayList<ChatSendResults>) {
        val model = ArrayList<ChatModel>()
        for(i in 0 until results.size) {
            if (results[i].type == "TEXT") {
                if(results[i].message.title.contains("http")){
                    val img = results[i].message.title.split("\"")
                    model.add(ChatModel(thumbnail = img[1]))
                }else
                    model.add(ChatModel(text = results[i].message.title))
            }
            else{
                model.add(ChatModel(text = results[i].message.title, listItem = results[i].message.listItem))
            }
        }
        chatRecyclerAdapter.submitList(model)
        chatRecyclerAdapter.notifyDataSetChanged()
        binding.rcvChat.scrollToPosition(chatRecyclerAdapter.itemCount-1)

    }

    override fun onEmergencySuccess(message: String) {
        applicationContext.toast(message)
    }


}