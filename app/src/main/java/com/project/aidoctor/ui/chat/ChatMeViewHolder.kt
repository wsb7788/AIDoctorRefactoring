package com.project.aidoctor.ui.chat

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerChatMeBinding

class ChatMeViewHolder(val binding: LayoutRecyclerChatMeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(chatModel: ChatModel){

        binding.text.text = chatModel.text

    }
}