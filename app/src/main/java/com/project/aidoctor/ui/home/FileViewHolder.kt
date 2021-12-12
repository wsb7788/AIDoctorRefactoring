package com.project.aidoctor.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class FileViewHolder(val binding: LayoutRecyclerFileBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(fileModel: FileModel){
        binding.tvTitle.text = fileModel.name
        binding.tvContent.text = fileModel.summary

    }
}