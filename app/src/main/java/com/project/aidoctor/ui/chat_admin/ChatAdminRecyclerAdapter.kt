package com.project.aidoctor.ui.chat_admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerChatMeBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class ChatAdminRecyclerAdapter:RecyclerView.Adapter<ChatAdminViewHolder>() {
    private var modelList=ArrayList<ChatAdminModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdminViewHolder {
        val binding = LayoutRecyclerChatMeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChatAdminViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatAdminViewHolder, position: Int) {
        holder.bind(modelList[position])

    }

    fun submitList(modelList:ArrayList<ChatAdminModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
    fun clearList() {
        this.modelList.clear()
    }


}