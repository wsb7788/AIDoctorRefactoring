package com.project.aidoctor.ui.chat

import android.text.Html
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.databinding.LayoutRecyclerChatYouBinding

class ChatYouViewHolder(val binding: LayoutRecyclerChatYouBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(chatModel: ChatModel) {
        if (chatModel.thumbnail.isNotEmpty()) {
            binding.iv.visibility = VISIBLE
            Glide.with(ApplicationClass.instance).load(chatModel.thumbnail).into(binding.iv)
            binding.textview.visibility = GONE
            binding.rcvButton.visibility = GONE
            return
        }

        binding.iv.visibility = GONE
        binding.textview.visibility = VISIBLE
        binding.rcvButton.visibility = VISIBLE

        binding.textview.text = Html.fromHtml(chatModel.text, Html.FROM_HTML_MODE_COMPACT)



    }
}