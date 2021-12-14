package com.project.aidoctor.ui.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.data.remote.notification.NotiList
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import com.project.aidoctor.databinding.LayoutRecyclerNotificationBinding

class NotificationRecyclerAdapter:RecyclerView.Adapter<NotificationViewHolder>() {
    private var modelList=ArrayList<NotiList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = LayoutRecyclerNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<NotiList>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
    fun clearList() {
        this.modelList.clear()
    }



    fun getItemContent(position: Int): NotiList {
        return this.modelList[position]
    }

}