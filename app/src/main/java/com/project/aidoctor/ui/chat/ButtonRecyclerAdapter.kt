package com.project.aidoctor.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerChatButtonBinding

class ButtonRecyclerAdapter:RecyclerView.Adapter<ButtonViewHolder>() {
    private var modelList=ArrayList<ButtonModel>()

    private lateinit var itemClickListener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val binding = LayoutRecyclerChatButtonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ButtonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        holder.bind(modelList[position])
        holder.binding.btn.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }


    fun submitList(modelList:ArrayList<ButtonModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
    fun clearList() {
        this.modelList.clear()
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    fun getItemValue(position:Int): String {
        return this.modelList[position].text
    }
}