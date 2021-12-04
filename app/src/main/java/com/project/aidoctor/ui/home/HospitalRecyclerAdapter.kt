package com.project.aidoctor.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding
import com.project.aidoctor.databinding.LayoutRecyclerHospitalBinding

class HospitalRecyclerAdapter:RecyclerView.Adapter<HospitalViewHolder>() {
    private var modelList=ArrayList<HospitalModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding = LayoutRecyclerHospitalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HospitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<HospitalModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}