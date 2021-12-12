package com.project.aidoctor.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class FileRecyclerAdapter:RecyclerView.Adapter<FileViewHolder>() {
    private var modelList=ArrayList<FileModel>()

    private lateinit var itemClickListener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val binding = LayoutRecyclerFileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        holder.bind(modelList[position])
        holder.binding.btnMore.setOnClickListener {
            itemClickListener.onClickDisease(it,position)
        }
    }

    fun submitList(modelList:ArrayList<FileModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
    fun clearList() {
        this.modelList.clear()
    }
    interface OnItemClickListener {
        fun onClickDisease(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    fun getItemName(position: Int): String {
        return this.modelList[position].name
    }

    fun getItemContent(position: Int): FileModel {
        return this.modelList[position]
    }

}