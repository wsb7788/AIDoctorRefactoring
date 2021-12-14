package com.project.aidoctor.ui.notification

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.R
import com.project.aidoctor.data.remote.notification.NotiList
import com.project.aidoctor.data.remote.notification.NotificationListener
import com.project.aidoctor.data.remote.profile.ProfileListener
import com.project.aidoctor.databinding.ActivityNotificationBinding
import com.project.aidoctor.databinding.ActivityProfileBinding
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.splash.SplashActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationActivity: BaseActivity(),NotificationListener {

    private lateinit var binding: ActivityNotificationBinding
    private val viewModel: NotificationViewModel by viewModel()


    lateinit var notificationRecyclerAdapter: NotificationRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.notificationListener = this


        recyclerInit()
        viewModel.loadNotification()
    }

    private fun recyclerInit() {
        notificationRecyclerAdapter = NotificationRecyclerAdapter()

        binding.rcvNotification.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            adapter = notificationRecyclerAdapter
        }

    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }



    override fun onSuccess(results: ArrayList<NotiList>) {
        notificationRecyclerAdapter.clearList()
        notificationRecyclerAdapter.submitList(results)
        notificationRecyclerAdapter.notifyDataSetChanged()

    }


}