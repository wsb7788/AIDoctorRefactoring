package com.project.aidoctor.ui.chat

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.aidoctor.databinding.LayoutRecyclerChatMeBinding
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerChatMeBinding
import com.project.faily.databinding.LayoutRecyclerChatYouBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import java.util.*

class ChatMeViewHolder(val binding: LayoutRecyclerChatMeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(chatModel: ChatModel){
        binding.text.text = chatModel.
}