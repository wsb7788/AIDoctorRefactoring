package com.project.aidoctor.ui.admin

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.admin.EmUser
import com.project.aidoctor.data.remote.chat.EmergencyResponse
import com.project.aidoctor.databinding.LayoutRecyclerEmListBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import java.text.SimpleDateFormat
import java.util.*

class EmergencyViewHolder(val binding: LayoutRecyclerEmListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(emUser:EmUser){
        binding.tvName.text = emUser.USER_USERID
        Glide.with(ApplicationClass.instance).load(R.drawable.no_profile).into(binding.iv)
        val time = Date(System.currentTimeMillis())
        val a = SimpleDateFormat("aa hh:mm")
        val aa  = a.format(time)
        binding.tvTime.text= aa


    }
}