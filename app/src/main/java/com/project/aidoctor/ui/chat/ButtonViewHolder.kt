package com.project.aidoctor.ui.chat

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerChatButtonBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ButtonViewHolder(val binding: LayoutRecyclerChatButtonBinding): RecyclerView.ViewHolder(binding.root){


    fun bind(buttonModel: ButtonModel){
        binding.btn.text = buttonModel.text


    }
}