package com.project.aidoctor.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class FileRecyclerAdapter:RecyclerView.Adapter<FileViewHolder>() {
    private var modelList=ArrayList<FileModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val binding = LayoutRecyclerFileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<FileModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
    fun clearList() {
        this.modelList.clear()
    }
}