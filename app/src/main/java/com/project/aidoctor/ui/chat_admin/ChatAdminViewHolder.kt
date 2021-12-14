package com.project.aidoctor.ui.chat_admin

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerChatMeBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class ChatAdminViewHolder(val binding: LayoutRecyclerChatMeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(chatAdminModel: ChatAdminModel){
        binding.text.text= chatAdminModel.text

    }
}