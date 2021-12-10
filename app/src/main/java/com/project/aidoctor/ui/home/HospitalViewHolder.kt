package com.project.aidoctor.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import com.project.aidoctor.databinding.LayoutRecyclerHospitalBinding

class HospitalViewHolder(val binding: LayoutRecyclerHospitalBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(hospitalModel: HospitalModel){

        binding.tvTitle.text = hospitalModel.title
        binding.tvName.text = hospitalModel.name
        binding.tvLocation.text = hospitalModel.location
    }
}