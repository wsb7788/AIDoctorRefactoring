package com.project.aidoctor.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerChatMeBinding
import com.project.faily.databinding.LayoutRecyclerChatYouBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding

class ChatRecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var modelList=ArrayList<ChatModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0){
            val binding = LayoutRecyclerChatYouBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatYouViewHolder(binding)
        }else{
            val binding = LayoutRecyclerChatMeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatMeViewHolder(binding)
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ChatYouViewHolder -> holder.bind(modelList[position])
            is ChatMeViewHolder -> holder.bind(modelList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(modelList[position].isMe){
            return 1
        }
        return 0
    }

    fun submitList(modelList:ArrayList<ChatModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}