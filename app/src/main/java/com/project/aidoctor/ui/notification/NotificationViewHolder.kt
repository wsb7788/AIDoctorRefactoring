package com.project.aidoctor.ui.notification

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.data.remote.notification.NotiList
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import com.project.aidoctor.databinding.LayoutRecyclerNotificationBinding

class NotificationViewHolder(val binding: LayoutRecyclerNotificationBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(notiList: NotiList){

        binding.tvTime.text = notiList.FCM_DATE
        binding.tvContent.text = notiList.FCM_CONTENT

    }
}