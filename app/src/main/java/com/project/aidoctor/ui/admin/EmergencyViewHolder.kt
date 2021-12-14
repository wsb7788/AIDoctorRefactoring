package com.project.aidoctor.ui.admin

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.data.remote.admin.EmUser
import com.project.aidoctor.data.remote.chat.EmergencyResponse
import com.project.aidoctor.databinding.LayoutRecyclerEmListBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class EmergencyViewHolder(val binding: LayoutRecyclerEmListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(emUser:EmUser){
        binding.tvName.text = emUser.USER_USERID
    }
}