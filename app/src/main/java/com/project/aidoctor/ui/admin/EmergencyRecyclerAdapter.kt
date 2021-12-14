package com.project.aidoctor.ui.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.aidoctor.data.remote.admin.EmUser
import com.project.aidoctor.databinding.LayoutRecyclerEmListBinding
import com.project.aidoctor.databinding.LayoutRecyclerFileBinding

class EmergencyRecyclerAdapter:RecyclerView.Adapter<EmergencyViewHolder>() {
    private var modelList=ArrayList<EmUser>()

    private lateinit var itemClickListener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyViewHolder {
        val binding = LayoutRecyclerEmListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmergencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmergencyViewHolder, position: Int) {
        holder.bind(modelList[position])
        holder.binding.cl.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    fun submitList(modelList:ArrayList<EmUser>){
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


    fun getItemContent(position: Int): EmUser {
        return this.modelList[position]
    }

}