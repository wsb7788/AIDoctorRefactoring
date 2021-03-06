package com.project.aidoctor.ui.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.admin.AdminListener
import com.project.aidoctor.data.remote.admin.EmUser
import com.project.aidoctor.databinding.ActivityAdminBinding

import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.chat_admin.ChatAdminActivity
import com.project.aidoctor.ui.profile.ProfileActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class AdminActivity : BaseActivity(),AdminListener,EmergencyRecyclerAdapter.OnItemClickListener {
    private lateinit var binding: ActivityAdminBinding
    private val viewModel: AdminViewModel by viewModel()

    lateinit var emergencyRecyclerAdapter: EmergencyRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.adminListener = this


        recyclerInit()
        viewModel.emListLoad()
        binding.btnSetting.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSetting -> startSetting()
        }
    }

    private fun startSetting() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)

    }

    private fun recyclerInit() {
        emergencyRecyclerAdapter = EmergencyRecyclerAdapter()

        binding.rcvChatroom.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = emergencyRecyclerAdapter
        }

        emergencyRecyclerAdapter.setItemClickListener(this)
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onSuccess(results: ArrayList<EmUser>) {

        emergencyRecyclerAdapter.clearList()
        emergencyRecyclerAdapter.submitList(results)
        emergencyRecyclerAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View, position: Int) {

        val item = emergencyRecyclerAdapter.getItemContent(position)
        val intent = Intent(this, ChatAdminActivity::class.java)
        intent.putExtra("item",item)
        startActivity(intent)
    }
}